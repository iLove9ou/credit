package com.credit.gateway.controller;

import com.alipay.sdk.*;
import com.alipay.sdk.domain.MybankCreditLoanApplyNotifyDomain;
import com.alipay.sdk.domain.MybankCreditLoanApproveackConfirmDomain;
import com.alipay.sdk.domain.MybankCreditLoanApproveackNotifyDomain;
import com.alipay.sdk.enums.BooleanEnum;
import com.alipay.sdk.request.MybankCreditLoanApplyNotifyRequest;
import com.alipay.sdk.request.MybankCreditLoanApproveUploadRequest;
import com.alipay.sdk.request.MybankCreditLoanApproveackConfirmRequest;
import com.alipay.sdk.request.MybankCreditLoanApproveackNotifyRequest;
import com.alipay.sdk.response.*;
import com.credit.gateway.annotation.Sign;
import com.credit.gateway.impl.ConsumerCreditBankLoanService;
import common.credit.constants.Constants;
import common.credit.enums.BizErrorCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class CreditLoanController {

    private final static Logger logger = LoggerFactory.getLogger(CreditLoanController.class);

    @Autowired
    private ConsumerCreditBankLoanService creditBankLoanService;


    /*
     * 初审通知请求，网商银行-银行机构
     * 网商银行发起，银行机构接收
     */
    @PostMapping(value = "/apply_notify", consumes = "application/xml", produces = MediaType.APPLICATION_XML_VALUE)
    @Sign
    public String applyNotify(@RequestBody String request) {

        String requestBody = request;
        AlipayTemplate template = new DefaultAlipayTemplate(Constants.APP_ID,
                Constants.PRIVATE_KEY,
                Constants.alipayPublicKey);
        String respXml = "";
        try {
             respXml = template.execute(requestBody, MybankCreditLoanApplyNotifyRequest.class, new
                    AlipayCallback<MybankCreditLoanApplyNotifyDomain, MybankCreditLoanApplyNotifyResponse>() {

                        @Override
                        public MybankCreditLoanApplyNotifyResponse process(ParametersHolder<MybankCreditLoanApplyNotifyDomain> parametersHolder, AlipayApiException e) {

                            ResultInfo resultInfo = new ResultInfo();

                            if (e != null) {
                                logger.error("apply_notify error :", e);

                                resultInfo.setResultCode(e.getErrCode());
                                resultInfo.setResultMsg(e.getErrMsg());
                                resultInfo.setRetry(BooleanEnum.FALSE.getCode());
                            } else {
                                resultInfo.setResultCode(BizErrorCode.SUCCESS.getCode());
                                resultInfo.setResultMsg(BizErrorCode.SUCCESS.getMessage());
                                resultInfo.setRetry(BooleanEnum.FALSE.getCode());
                            }

                            MybankCreditLoanApplyNotifyDomain domain = parametersHolder.getBody();
                            MybankCreditLoanApplyNotifyResponse response = new MybankCreditLoanApplyNotifyResponse();
                            response.setResultInfo(resultInfo);
                            response.setRequestId(domain.getRequestId());
                            response.setApplyNo(domain.getApplyNo());

                            return response;
                        }
                    });

            logger.info("apply_notify excute ok: ", respXml);
        } catch (AlipayApiException e) {
            logger.error("apply_notify excute error: ", e);
        }

        return respXml;
    }

    /*
     * 初审数据上传，银行机构-网商银行
     * 银行机构发起，网商银行接收
     */
    @PostMapping(value = "/approve_upload", consumes = "application/xml", produces = MediaType.APPLICATION_XML_VALUE)
    @Sign
    public ParametersHolder approveUpload(@RequestBody MybankCreditLoanApplyNotifyDomain domain) {
        // TODO 检查记录是否存在，基于之前有网商银行发起的初审请求

        ParametersHolder response = new ParametersHolder();
        try {
            String url = Constants.REQUEST_URL;
            AlipayTemplate template = new DefaultAlipayTemplate(Constants.APP_ID,
                    Constants.PRIVATE_KEY,
                    Constants.alipayPublicKey);
            MybankCreditLoanApproveUploadRequest request = new MybankCreditLoanApproveUploadRequest();
            MybankCreditLoanApplyNotifyDomain bizMode = new MybankCreditLoanApplyNotifyDomain();
            bizMode.setRequestId(domain.getRequestId());

            bizMode.setApplyNo(domain.getApplyNo());
            bizMode.setCertName(domain.getCertName());
            bizMode.setCertNo(domain.getCertNo());
            bizMode.setCertType(domain.getCertType());
            bizMode.setExtInfo(domain.getExtInfo());
            request.setBizModel(bizMode);

            response = template.execute(url, request);

            logger.info("approve_upload excute ok: ", response);
        } catch (AlipayApiException e) {
            logger.error("approve_upload excute error: ", e);

            if (AlipayErrorCode.ILLEGAL_SIGN.getCode().equals(e.getErrCode())) {
                ResultInfo resultInfo = new ResultInfo();
                resultInfo.setResultCode(BizErrorCode.INVLID_SIGN.getCode());
                resultInfo.setResultMsg(BizErrorCode.INVLID_SIGN.getMessage());

                MybankCreditLoanApproveUploadResponse approveUploadResponse = (MybankCreditLoanApproveUploadResponse) response.getBody();
                approveUploadResponse.setResultInfo(resultInfo);
                response.setBody(approveUploadResponse);
                return response;
            } else if (AlipayErrorCode.ILLEGAL_ARGUMENT.getCode().equals(e.getErrCode())) {

                ResultInfo resultInfo = new ResultInfo();
                resultInfo.setResultCode(BizErrorCode.PARAMS_ERROR.getCode());
                resultInfo.setResultMsg(BizErrorCode.PARAMS_ERROR.getMessage());

                MybankCreditLoanApproveUploadResponse approveUploadResponse = (MybankCreditLoanApproveUploadResponse) response.getBody();
                approveUploadResponse.setResultInfo(resultInfo);
                response.setBody(approveUploadResponse);
                return response;

            } else if (AlipayErrorCode.DATA_INVALID.getCode().equals(e.getErrCode())) {
                ResultInfo resultInfo = new ResultInfo();
                resultInfo.setResultCode(BizErrorCode.ITEM_FORMAT_ERROR.getCode());
                resultInfo.setResultMsg(BizErrorCode.ITEM_FORMAT_ERROR.getMessage());

                MybankCreditLoanApproveUploadResponse approveUploadResponse = (MybankCreditLoanApproveUploadResponse) response.getBody();
                approveUploadResponse.setResultInfo(resultInfo);
                response.setBody(approveUploadResponse);
                return response;

            } else if (AlipayErrorCode.SGW_ERROR.getCode().equals(e.getErrCode())) {
                ResultInfo resultInfo = new ResultInfo();
                resultInfo.setResultCode(BizErrorCode.CALL_GATEWAY_HANDLE_ERROR.getCode());
                resultInfo.setResultMsg(BizErrorCode.CALL_GATEWAY_HANDLE_ERROR.getMessage());

                MybankCreditLoanApproveUploadResponse approveUploadResponse = (MybankCreditLoanApproveUploadResponse) response.getBody();
                approveUploadResponse.setResultInfo(resultInfo);
                response.setBody(approveUploadResponse);
                return response;
            } else {
                ResultInfo resultInfo = new ResultInfo();
                resultInfo.setResultCode(BizErrorCode.UNKNOW_SYSTEM_ERROR.getCode());
                resultInfo.setResultMsg(BizErrorCode.UNKNOW_SYSTEM_ERROR.getMessage());

                MybankCreditLoanApproveUploadResponse approveUploadResponse = (MybankCreditLoanApproveUploadResponse) response.getBody();
                approveUploadResponse.setResultInfo(resultInfo);
                response.setBody(approveUploadResponse);
                return response;
            }
        }

        return response;

    }

    /*
     * 终审通知，网商银行-银行机构
     * 网商银行发起，银行机构接收
     */
    @PostMapping(value = "/approveack_notify", consumes = "application/xml", produces = MediaType.APPLICATION_XML_VALUE)
    @Sign
    public String approveackNotify(@RequestBody String request) {

        String requestBody = request;
        AlipayTemplate template = new DefaultAlipayTemplate(Constants.APP_ID,
                Constants.PRIVATE_KEY,
                Constants.alipayPublicKey);
        String respXml = "";
        try {
            respXml = template.execute(requestBody, MybankCreditLoanApproveackNotifyRequest.class, new
                    AlipayCallback<MybankCreditLoanApproveackNotifyDomain, MybankCreditLoanApproveackNotifyResponse>() {

                        @Override
                        public MybankCreditLoanApproveackNotifyResponse process(ParametersHolder<MybankCreditLoanApproveackNotifyDomain> parametersHolder, AlipayApiException e) {
                            MybankCreditLoanApproveackNotifyResponse response = new MybankCreditLoanApproveackNotifyResponse();

                            ResultInfo resultInfo = new ResultInfo();

                            if (e != null) {
                                logger.error("approveack_notify error :", e);

                                resultInfo.setResultCode(e.getErrCode());
                                resultInfo.setResultMsg(e.getErrMsg());
                                resultInfo.setRetry(BooleanEnum.FALSE.getCode());
                            } else {
                                resultInfo.setResultCode(BizErrorCode.SUCCESS.getCode());
                                resultInfo.setResultMsg(BizErrorCode.SUCCESS.getMessage());
                                resultInfo.setRetry(BooleanEnum.FALSE.getCode());
                            }

                            MybankCreditLoanApproveackNotifyDomain notifyDomain =  parametersHolder.getBody();

                            response.setApplyNo(notifyDomain.getApplyNo());
                            response.setRequestId(notifyDomain.getRequestId());
                            response.setResultInfo(resultInfo);

                            return response;
                        }
                    });

            logger.info("apply_notify excute ok: ", respXml);
        } catch (AlipayApiException e) {
            logger.error("apply_notify excute error: ", e);
        }

        return respXml;
    }

    /*
     * 终审确认，银行机构-网商银行
     * 银行机构发起，网商银行接收
     */
    @PostMapping(value = "/approveack_confirm", consumes = "application/xml", produces = MediaType.APPLICATION_XML_VALUE)
    @Sign
    public ParametersHolder approveackConfirm(@RequestBody MybankCreditLoanApproveackConfirmDomain domain) {

        ParametersHolder holder = new ParametersHolder();
        try {
            String url = Constants.REQUEST_URL;
            AlipayTemplate template = new DefaultAlipayTemplate(Constants.APP_ID, Constants.PRIVATE_KEY, Constants.alipayPublicKey);
            MybankCreditLoanApproveackConfirmRequest request = new MybankCreditLoanApproveackConfirmRequest();
            MybankCreditLoanApproveackConfirmDomain bizMode = new MybankCreditLoanApproveackConfirmDomain();
            bizMode.setRequestId(domain.getRequestId());

            bizMode.setApplyNo(domain.getApplyNo());
            bizMode.setCertName(domain.getCertName());
            bizMode.setCertNo(domain.getCertNo());
            bizMode.setExtInfo(domain.getExtInfo());
            request.setBizModel(bizMode);

            holder = template.execute(url, request);

        } catch (AlipayApiException e) {
            logger.error("approve_upload excute error: ", e);

            ResultInfo resultInfo = new ResultInfo();
            if (AlipayErrorCode.ILLEGAL_SIGN.getCode().equals(e.getErrCode())) {
                resultInfo.setResultCode(BizErrorCode.INVLID_SIGN.getCode());
                resultInfo.setResultMsg(BizErrorCode.INVLID_SIGN.getMessage());
            } else if (AlipayErrorCode.ILLEGAL_ARGUMENT.getCode().equals(e.getErrCode())) {
                resultInfo.setResultCode(BizErrorCode.PARAMS_ERROR.getCode());
                resultInfo.setResultMsg(BizErrorCode.PARAMS_ERROR.getMessage());
            } else if (AlipayErrorCode.SGW_ERROR.getCode().equals(e.getErrCode())) {
                resultInfo.setResultCode(BizErrorCode.CALL_GATEWAY_HANDLE_ERROR.getCode());
                resultInfo.setResultMsg(BizErrorCode.CALL_GATEWAY_HANDLE_ERROR.getMessage());
            } else {
                resultInfo.setResultCode(BizErrorCode.UNKNOW_SYSTEM_ERROR.getCode());
                resultInfo.setResultMsg(BizErrorCode.UNKNOW_SYSTEM_ERROR.getMessage());
            }
            resultInfo.setRetry(BooleanEnum.FALSE.getCode());

            MybankCreditLoanApproveackConfirmResponse approveackConfirmResponse = (MybankCreditLoanApproveackConfirmResponse) holder.getBody();
            approveackConfirmResponse.setResultInfo(resultInfo);
            holder.setBody(approveackConfirmResponse);
            return holder;
        }

        return holder;
    }
}
