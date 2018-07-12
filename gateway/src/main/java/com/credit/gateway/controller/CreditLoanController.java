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
import common.credit.request.CustMybankCreditLoanApproveUploadRequest;
import common.credit.request.CustMybankCreditLoanApproveackConfirmRequest;
import common.credit.result.BaseComponent;
import common.credit.result.ResponseResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class CreditLoanController extends BaseComponent {

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

        logger.info("apply_notify request: ", request);

        // TODO 数据格式校验
        // TODO 查看当前记录是否已存在，当前状态校验

        String requestBody = request;
        AlipayTemplate template = new DefaultAlipayTemplate(Constants.APP_ID,
                Constants.privateKey,
                Constants.alipayPublicKey);

        String respXml = "";
        ParametersHolder reqHolder = new ParametersHolder();
        try {
            reqHolder = ParserUtil.parse(requestBody, MybankCreditLoanApplyNotifyRequest.class);
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
            ParametersHolder respHolder = new ParametersHolder();
            respHolder.setHeader(reqHolder.getHeader());
            MybankCreditLoanApplyNotifyResponse respBody = new MybankCreditLoanApplyNotifyResponse();
            ResultInfo resultInfo = new ResultInfo();
            resultInfo.setResultCode(BizErrorCode.CALL_GATEWAY_HANDLE_ERROR.getCode());
            resultInfo.setResultMsg(BizErrorCode.CALL_GATEWAY_HANDLE_ERROR.getMessage());
            respBody.setResultInfo(resultInfo);
            respHolder.setBody(respBody);
            return ParserUtil.toxml(respHolder);

        } catch (Exception e) {

            logger.error("apply_notify excute error: ", e);

            ParametersHolder respHolder = new ParametersHolder();
            respHolder.setHeader(reqHolder.getHeader());
            MybankCreditLoanApplyNotifyResponse respBody = new MybankCreditLoanApplyNotifyResponse();

            MybankCreditLoanApplyNotifyDomain domain = (MybankCreditLoanApplyNotifyDomain) reqHolder.getBody();

            ResultInfo resultInfo = new ResultInfo();
            resultInfo.setResultCode(BizErrorCode.UNKNOW_SYSTEM_ERROR.getCode());
            resultInfo.setResultMsg(BizErrorCode.UNKNOW_SYSTEM_ERROR.getMessage());
            respBody.setResultInfo(resultInfo);
            respBody.setRequestId(domain.getRequestId());
            respBody.setApplyNo(domain.getApplyNo());
            respHolder.setBody(respBody);
            return ParserUtil.toxml(respHolder);
        }

        return ParserUtil.toxml(reqHolder);

    }

    /*
     * 初审数据上传，银行机构-网商银行
     * 银行机构发起，网商银行接收
     */
    @PostMapping(value = "/approve_upload", consumes = "application/xml", produces = MediaType.APPLICATION_XML_VALUE)
    @Sign
    public String approveUpload(@RequestBody String requestXml) {
        // TODO 需要组装来源数据，调用第三方接口？
        // TODO 检查记录是否存在，基于之前有网商银行发起的初审请求

        ParametersHolder reqHolder = new ParametersHolder();
        ParametersHolder<MybankCreditLoanApproveUploadResponse> respHolder = new ParametersHolder<MybankCreditLoanApproveUploadResponse>();
        MybankCreditLoanApproveUploadRequest request = new MybankCreditLoanApproveUploadRequest();
        try {
            reqHolder = ParserUtil.parse(requestXml, MybankCreditLoanApproveUploadRequest.class);
            MybankCreditLoanApproveUploadDomain bizMode = (MybankCreditLoanApproveUploadDomain) reqHolder.getBody();

            String url = Constants.REQUEST_URL;
            AlipayTemplate template = new DefaultAlipayTemplate(Constants.APP_ID,
                    Constants.PRIVATE_KEY,
                    Constants.alipayPublicKey);

            request.setBizModel(bizMode);

            respHolder = template.execute(url, request);

            logger.info("approve_upload excute ok: ", respHolder);
        } catch (AlipayApiException e) {
            logger.error("approve_upload excute error: ", e);

            if (AlipayErrorCode.ILLEGAL_SIGN.getCode().equals(e.getErrCode())) {
                ResultInfo resultInfo = new ResultInfo();
                resultInfo.setResultCode(BizErrorCode.INVLID_SIGN.getCode());
                resultInfo.setResultMsg(BizErrorCode.INVLID_SIGN.getMessage());

                MybankCreditLoanApproveUploadResponse approveUploadResponse = respHolder.getBody();
                approveUploadResponse.setResultInfo(resultInfo);
                respHolder.setBody(approveUploadResponse);

            } else if (AlipayErrorCode.ILLEGAL_ARGUMENT.getCode().equals(e.getErrCode())) {

                ResultInfo resultInfo = new ResultInfo();
                resultInfo.setResultCode(BizErrorCode.PARAMS_ERROR.getCode());
                resultInfo.setResultMsg(BizErrorCode.PARAMS_ERROR.getMessage());

                MybankCreditLoanApproveUploadResponse approveUploadResponse = respHolder.getBody();
                approveUploadResponse.setResultInfo(resultInfo);
                respHolder.setBody(approveUploadResponse);

            } else if (AlipayErrorCode.DATA_INVALID.getCode().equals(e.getErrCode())) {
                ResultInfo resultInfo = new ResultInfo();
                resultInfo.setResultCode(BizErrorCode.ITEM_FORMAT_ERROR.getCode());
                resultInfo.setResultMsg(BizErrorCode.ITEM_FORMAT_ERROR.getMessage());

                MybankCreditLoanApproveUploadResponse approveUploadResponse = respHolder.getBody();
                approveUploadResponse.setResultInfo(resultInfo);
                respHolder.setBody(approveUploadResponse);

            } else if (AlipayErrorCode.SGW_ERROR.getCode().equals(e.getErrCode())) {
                ResultInfo resultInfo = new ResultInfo();
                resultInfo.setResultCode(BizErrorCode.CALL_GATEWAY_HANDLE_ERROR.getCode());
                resultInfo.setResultMsg(BizErrorCode.CALL_GATEWAY_HANDLE_ERROR.getMessage());

                MybankCreditLoanApproveUploadResponse approveUploadResponse = respHolder.getBody();
                approveUploadResponse.setResultInfo(resultInfo);
                respHolder.setBody(approveUploadResponse);

            } else {
                ResultInfo resultInfo = new ResultInfo();
                resultInfo.setResultCode(BizErrorCode.UNKNOW_SYSTEM_ERROR.getCode());
                resultInfo.setResultMsg(BizErrorCode.UNKNOW_SYSTEM_ERROR.getMessage());

                MybankCreditLoanApproveUploadResponse approveUploadResponse = respHolder.getBody();
                approveUploadResponse.setResultInfo(resultInfo);
                respHolder.setBody(approveUploadResponse);
            }
        } catch (Exception e) {
            logger.error("approve_upload excute error: ", e);
            ResultInfo resultInfo = new ResultInfo();
            resultInfo.setResultCode(BizErrorCode.UNKNOW_SYSTEM_ERROR.getCode());
            resultInfo.setResultMsg(BizErrorCode.UNKNOW_SYSTEM_ERROR.getMessage());

            MybankCreditLoanApproveUploadResponse approveUploadResponse = new MybankCreditLoanApproveUploadResponse();

            approveUploadResponse.setResultInfo(resultInfo);
            respHolder.setBody(approveUploadResponse);
            respHolder.setHeader(reqHolder.getHeader());

            return ParserUtil.toxml(respHolder);
        }

        AlipayHeader head = respHolder.getHeader();
        MybankCreditLoanApproveUploadResponse body = respHolder.getBody();
        CustMybankCreditLoanApproveUploadRequest custRequest = new CustMybankCreditLoanApproveUploadRequest();
        BeanUtils.copyProperties(request, custRequest);
        ResponseResult result = creditBankLoanService.approveUpload(head, body, custRequest);
        logger.info("approve_upload result=", result);
        return ParserUtil.toxml(reqHolder);

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
        ParametersHolder reqHolder = new ParametersHolder();
        try {
            reqHolder = ParserUtil.parse(requestBody, MybankCreditLoanApproveackNotifyRequest.class);
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

                            AlipayHeader header = parametersHolder.getHeader();

                            creditBankLoanService.finalNotify(header, notifyDomain, response);
                            return response;
                        }
                    });

            logger.info("approveack_notify excute ok: ", respXml);

        } catch (AlipayApiException e) {

            logger.error("approveack_notify excute error: ", e);
            ParametersHolder respHolder = new ParametersHolder<MybankCreditLoanApproveUploadResponse>();

            logger.error("approveack_notify excute error: ", e);

            ResultInfo resultInfo = new ResultInfo();
            resultInfo.setResultCode(BizErrorCode.UNKNOW_SYSTEM_ERROR.getCode());
            resultInfo.setResultMsg(BizErrorCode.UNKNOW_SYSTEM_ERROR.getMessage());
            MybankCreditLoanApproveUploadResponse body = new MybankCreditLoanApproveUploadResponse();
            body.setResultInfo(resultInfo);
            respHolder.setBody(body);
            respHolder.setHeader(reqHolder.getHeader());

            return ParserUtil.toxml(respHolder);

        } catch (Exception e) {

            logger.error("approveack_notify excute error: ", e);

            ParametersHolder respHolder = new ParametersHolder<MybankCreditLoanApproveUploadResponse>();

            ResultInfo resultInfo = new ResultInfo();
            resultInfo.setResultCode(BizErrorCode.UNKNOW_SYSTEM_ERROR.getCode());
            resultInfo.setResultMsg(BizErrorCode.UNKNOW_SYSTEM_ERROR.getMessage());
            MybankCreditLoanApproveUploadResponse body = new MybankCreditLoanApproveUploadResponse();
            body.setResultInfo(resultInfo);
            respHolder.setBody(body);
            respHolder.setHeader(reqHolder.getHeader());

            return ParserUtil.toxml(respHolder);
        }

        return respXml;
    }

    /*
     * 终审确认，银行机构-网商银行
     * 银行机构发起，网商银行接收
     */
    @PostMapping(value = "/approveack_confirm", consumes = "application/xml", produces = MediaType.APPLICATION_XML_VALUE)
    @Sign
    public String approveackConfirm(@RequestBody String request) {

        ParametersHolder<MybankCreditLoanApproveackConfirmResponse> holder = new ParametersHolder<MybankCreditLoanApproveackConfirmResponse>();
        MybankCreditLoanApproveackConfirmRequest body = new MybankCreditLoanApproveackConfirmRequest();
        ParametersHolder reqHolder = new ParametersHolder();
        try {
            reqHolder = ParserUtil.parse(request, MybankCreditLoanApproveackConfirmRequest.class);
            String url = Constants.REQUEST_URL;
            AlipayTemplate template = new DefaultAlipayTemplate(Constants.APP_ID, Constants.PRIVATE_KEY, Constants.alipayPublicKey);

            MybankCreditLoanApproveackConfirmDomain bizMode = new MybankCreditLoanApproveackConfirmDomain();
//            bizMode.setRequestId(reqHolder.getBody().getRequestId());
//
//            bizMode.setApplyNo(reqHolder.getBody().getApplyNo());
//            bizMode.setCertName(reqHolder.getBody().getCertName());
//            bizMode.setCertNo(reqHolder.getBody().getCertNo());
//            bizMode.setExtInfo(reqHolder.getBody().getExtInfo());
            body.setBizModel(bizMode);

            holder = template.execute(url, body);

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

            AlipayHeader header = holder.getHeader();

            CustMybankCreditLoanApproveackConfirmRequest confirmRequest = new CustMybankCreditLoanApproveackConfirmRequest();
            BeanUtils.copyProperties(request, confirmRequest);
            creditBankLoanService.finalConfirm(header, approveackConfirmResponse, confirmRequest);
        } catch (Exception e) {

            ParametersHolder respHolder = new ParametersHolder<MybankCreditLoanApproveUploadResponse>();

            ResultInfo resultInfo = new ResultInfo();
            resultInfo.setResultCode(BizErrorCode.UNKNOW_SYSTEM_ERROR.getCode());
            resultInfo.setResultMsg(BizErrorCode.UNKNOW_SYSTEM_ERROR.getMessage());
            MybankCreditLoanApproveUploadResponse respBody = new MybankCreditLoanApproveUploadResponse();
            respBody.setResultInfo(resultInfo);
            respHolder.setBody(respBody);
            respHolder.setHeader(reqHolder.getHeader());
            return ParserUtil.toxml(respHolder);
        }

        return ParserUtil.toxml(holder);
    }
}
