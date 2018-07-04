package com.credit.gateway.controller;

import com.alipay.sdk.*;
import com.alipay.sdk.domain.MybankCreditLoanApplyNotifyDomain;
import com.alipay.sdk.domain.MybankCreditLoanApproveUploadDomain;
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
import com.credit.gateway.utils.ParserUtil;
import common.credit.constants.Constants;
import common.credit.enums.BizErrorCode;
import common.credit.result.BaseService;
import common.credit.result.ResponseResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class CreditLoanController extends BaseService {

    private final static Logger logger = LoggerFactory.getLogger(CreditLoanController.class);

    @Autowired
    private ConsumerCreditBankLoanService creditBankLoanService;


    /*
     * 初审通知请求，网商银行-银行机构
     * 网商银行发起，银行机构接收
     */
    @PostMapping(value = "/apply_notify", consumes = "application/xml")
    @Sign
    public ResponseResult applyNotify(@RequestBody String request) {

        logger.info("apply_notify request: ", request);

        // TODO 数据格式校验
        // TODO 查看当前记录是否已存在，当前状态校验

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
                            AlipayHeader head = parametersHolder.getHeader();
                            MybankCreditLoanApplyNotifyResponse response = new MybankCreditLoanApplyNotifyResponse();
                            response.setResultInfo(resultInfo);
                            response.setRequestId(domain.getRequestId());
                            response.setApplyNo(domain.getApplyNo());

                            ResponseResult result = creditBankLoanService.applyNotify(head, domain, response);

                            logger.info("apply_notify result=", result);
                            return response;
                        }
                    });

            logger.info("apply_notify excute ok: ", respXml);
        } catch (AlipayApiException e) {
            logger.error("apply_notify excute error: ", e);

            return error(e.getErrCode(), e.getMessage());

        } catch (Exception e) {

            logger.error("apply_notify excute error: ", e);
            return error(BizErrorCode.UNKNOW_SYSTEM_ERROR.getCode(), BizErrorCode.UNKNOW_SYSTEM_ERROR.getMessage());
        }

        return success();
    }

    /*
     * 初审数据上传，银行机构-网商银行
     * 银行机构发起，网商银行接收
     */
    @PostMapping(value = "/approve_upload", consumes = "application/xml", produces = MediaType.APPLICATION_XML_VALUE)
    @Sign
    public ParametersHolder approveUpload(@RequestBody String requestXml) {
        // TODO 需要组装来源数据，调用第三方接口？
        // TODO 检查记录是否存在，基于之前有网商银行发起的初审请求

        ParametersHolder<MybankCreditLoanApproveUploadResponse> response = new ParametersHolder<MybankCreditLoanApproveUploadResponse>();
        MybankCreditLoanApproveUploadRequest request = new MybankCreditLoanApproveUploadRequest();
        try {

            ParametersHolder holder = ParserUtil.parse(requestXml, MybankCreditLoanApproveUploadRequest.class);
            MybankCreditLoanApproveUploadDomain bizMode = (MybankCreditLoanApproveUploadDomain) holder.getBody();

            String url = Constants.REQUEST_URL;
            AlipayTemplate template = new DefaultAlipayTemplate(Constants.APP_ID,
                    Constants.PRIVATE_KEY,
                    Constants.alipayPublicKey);

            request.setBizModel(bizMode);

            response = template.execute(url, request);

            logger.info("approve_upload excute ok: ", response);
        } catch (AlipayApiException e) {
            logger.error("approve_upload excute error: ", e);

            if (AlipayErrorCode.ILLEGAL_SIGN.getCode().equals(e.getErrCode())) {
                ResultInfo resultInfo = new ResultInfo();
                resultInfo.setResultCode(BizErrorCode.INVLID_SIGN.getCode());
                resultInfo.setResultMsg(BizErrorCode.INVLID_SIGN.getMessage());

                MybankCreditLoanApproveUploadResponse approveUploadResponse = response.getBody();
                approveUploadResponse.setResultInfo(resultInfo);
                response.setBody(approveUploadResponse);

            } else if (AlipayErrorCode.ILLEGAL_ARGUMENT.getCode().equals(e.getErrCode())) {

                ResultInfo resultInfo = new ResultInfo();
                resultInfo.setResultCode(BizErrorCode.PARAMS_ERROR.getCode());
                resultInfo.setResultMsg(BizErrorCode.PARAMS_ERROR.getMessage());

                MybankCreditLoanApproveUploadResponse approveUploadResponse = response.getBody();
                approveUploadResponse.setResultInfo(resultInfo);
                response.setBody(approveUploadResponse);

            } else if (AlipayErrorCode.DATA_INVALID.getCode().equals(e.getErrCode())) {
                ResultInfo resultInfo = new ResultInfo();
                resultInfo.setResultCode(BizErrorCode.ITEM_FORMAT_ERROR.getCode());
                resultInfo.setResultMsg(BizErrorCode.ITEM_FORMAT_ERROR.getMessage());

                MybankCreditLoanApproveUploadResponse approveUploadResponse = response.getBody();
                approveUploadResponse.setResultInfo(resultInfo);
                response.setBody(approveUploadResponse);

            } else if (AlipayErrorCode.SGW_ERROR.getCode().equals(e.getErrCode())) {
                ResultInfo resultInfo = new ResultInfo();
                resultInfo.setResultCode(BizErrorCode.CALL_GATEWAY_HANDLE_ERROR.getCode());
                resultInfo.setResultMsg(BizErrorCode.CALL_GATEWAY_HANDLE_ERROR.getMessage());

                MybankCreditLoanApproveUploadResponse approveUploadResponse = response.getBody();
                approveUploadResponse.setResultInfo(resultInfo);
                response.setBody(approveUploadResponse);

            } else {
                ResultInfo resultInfo = new ResultInfo();
                resultInfo.setResultCode(BizErrorCode.UNKNOW_SYSTEM_ERROR.getCode());
                resultInfo.setResultMsg(BizErrorCode.UNKNOW_SYSTEM_ERROR.getMessage());

                MybankCreditLoanApproveUploadResponse approveUploadResponse = response.getBody();
                approveUploadResponse.setResultInfo(resultInfo);
                response.setBody(approveUploadResponse);
            }
        } catch (Exception e) {
            logger.error("approve_upload excute error: ", e);

            ResultInfo resultInfo = new ResultInfo();
            resultInfo.setResultCode(BizErrorCode.UNKNOW_SYSTEM_ERROR.getCode());
            resultInfo.setResultMsg(BizErrorCode.UNKNOW_SYSTEM_ERROR.getMessage());

            MybankCreditLoanApproveUploadResponse approveUploadResponse = new MybankCreditLoanApproveUploadResponse();
            if (response.getBody() != null) {
                approveUploadResponse = response.getBody();
            }

            approveUploadResponse.setResultInfo(resultInfo);
            response.setBody(approveUploadResponse);

        }

        AlipayHeader head = response.getHeader();
        MybankCreditLoanApproveUploadResponse body = response.getBody();
        ResponseResult result = creditBankLoanService.approveUpload(head, body, request);
        logger.info("approve_upload result=", result);
        return response;

    }

    /*
     * 终审通知，网商银行-银行机构
     * 网商银行发起，银行机构接收
     */
    @PostMapping(value = "/approveack_notify", consumes = "application/xml", produces = MediaType.APPLICATION_XML_VALUE)
    @Sign
    public String approveackNotify(@RequestBody String request) {

        // TODO 检查记录是否存在
        // TODO 检查当前状态
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

                            creditBankLoanService.finalNotify(parametersHolder, response);
                            return response;
                        }
                    });

            logger.info("approveack_notify excute ok: ", respXml);
        } catch (AlipayApiException e) {
            logger.error("approveack_notify excute error: ", e);
        } catch (Exception e) {
            logger.error("approveack_notify excute error: ", e);

            ResultInfo resultInfo = new ResultInfo();
            resultInfo.setResultCode(BizErrorCode.UNKNOW_SYSTEM_ERROR.getCode());
            resultInfo.setResultMsg(BizErrorCode.UNKNOW_SYSTEM_ERROR.getMessage());

//            MybankCreditLoanApproveUploadResponse approveUploadResponse = response.getBody();
//            approveUploadResponse.setResultInfo(resultInfo);
//            response.setBody(approveUploadResponse);

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

        ParametersHolder<MybankCreditLoanApproveackConfirmResponse> holder = new ParametersHolder<MybankCreditLoanApproveackConfirmResponse>();
        MybankCreditLoanApproveackConfirmRequest request = new MybankCreditLoanApproveackConfirmRequest();
        try {
            String url = Constants.REQUEST_URL;
            AlipayTemplate template = new DefaultAlipayTemplate(Constants.APP_ID, Constants.PRIVATE_KEY, Constants.alipayPublicKey);

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

            MybankCreditLoanApproveackConfirmResponse approveackConfirmResponse = holder.getBody();
            approveackConfirmResponse.setResultInfo(resultInfo);
            holder.setBody(approveackConfirmResponse);

            creditBankLoanService.finalConfirm(request, holder);
            return holder;
        }

        return holder;
    }
}
