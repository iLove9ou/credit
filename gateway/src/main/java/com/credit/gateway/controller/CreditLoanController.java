package com.credit.gateway.controller;

import com.alipay.sdk.*;
import com.alipay.sdk.domain.MybankCreditLoanApplyNotifyDomain;
import com.alipay.sdk.domain.MybankCreditLoanApproveUploadDomain;
import com.alipay.sdk.request.MybankCreditLoanApplyNotifyRequest;
import com.alipay.sdk.request.MybankCreditLoanApproveUploadRequest;
import com.alipay.sdk.response.MybankCreditLoanApproveUploadResponse;
import com.credit.gateway.annotation.Sign;
import com.credit.gateway.impl.ConsumerCreditBankLoanService;
import com.google.gson.Gson;
import common.credit.constants.Constants;
import common.credit.format.Document;
import common.credit.format.DocumentInput;
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


    @PostMapping(value = "/apply_notify", consumes = "application/xml", produces = MediaType.APPLICATION_XML_VALUE)
    @Sign
    public Document applyNotify(@RequestBody Document input) {

        String requestBody = "";
        AlipayTemplate template = new DefaultAlipayTemplate(Constants.APP_ID, Constants.PRIVATE_KEY, Constants.alipayPublicKey);
        try {
             String respXml = template.execute(requestBody, MybankCreditLoanApproveUploadRequest.class, new
                    AlipayCallback<MybankCreditLoanApproveUploadDomain, MybankCreditLoanApproveUploadResponse>() {

                        @Override
                        public MybankCreditLoanApproveUploadResponse process(ParametersHolder<MybankCreditLoanApproveUploadDomain> parametersHolder,
                                                                             AlipayApiException e) {
                            MybankCreditLoanApproveUploadResponse response =  new
                                    MybankCreditLoanApproveUploadResponse();
                            return response;
                        }
                    });

            logger.info("apply_notify excute ok: ", respXml);
        } catch (AlipayApiException e) {
            logger.error("apply_notify excute error: ", e);
        }

        return null;
    }

    @PostMapping(value = "/approve_upload", consumes = "application/xml", produces = MediaType.APPLICATION_XML_VALUE)
    @Sign
    public Document approveUpload(@RequestBody MybankCreditLoanApplyNotifyDomain domain) {
        try {
            String url = Constants.REQUEST_URL;
            AlipayTemplate template = new DefaultAlipayTemplate(Constants.APP_ID, Constants.PRIVATE_KEY, Constants.alipayPublicKey);
            MybankCreditLoanApplyNotifyRequest request = new MybankCreditLoanApplyNotifyRequest();
            MybankCreditLoanApplyNotifyDomain bizMode = new MybankCreditLoanApplyNotifyDomain();
            bizMode.setRequestId(domain.getRequestId());

            bizMode.setApplyNo(domain.getApplyNo());
            bizMode.setCertName(domain.getCertName());
            bizMode.setCertNo(domain.getCertNo());
            bizMode.setCertType(domain.getCertType());
            bizMode.setExtInfo(domain.getExtInfo());
            request.setBizModel(bizMode);
            template.execute(url, request);

        } catch (AlipayApiException e) {
            logger.error("approve_upload excute error: ", e);
        }

        return null;
    }

    @PostMapping(value = "/approveack_notify", consumes = "application/xml", produces = MediaType.APPLICATION_XML_VALUE)
    @Sign
    public Document approveackNotify(@RequestBody DocumentInput input) {
        logger.info("approveack_notify " + " request: " + new Gson().toJson(input));
        Document document = creditBankLoanService.finalNotify(input);
        logger.info("approveack_notify " + "response: " + new Gson().toJson(document));
        return document;
    }

    @PostMapping(value = "/approveack_confirm", consumes = "application/xml", produces = MediaType.APPLICATION_XML_VALUE)
    @Sign
    public Document approveackConfirm(@RequestBody DocumentInput input) {
        logger.info("approveack_confirm " + " request: " + new Gson().toJson(input));
        Document document = creditBankLoanService.finalConfirm(input);
        logger.info("approveack_confirm " + "response: " + new Gson().toJson(document));
        return document;
    }
}
