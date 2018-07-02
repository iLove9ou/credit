package com.credit.gateway.controller;

import com.alipay.sdk.*;
import com.alipay.sdk.domain.MybankCreditLoanApplyNotifyDomain;
import com.alipay.sdk.domain.MybankCreditLoanApproveackConfirmDomain;
import com.alipay.sdk.domain.MybankCreditLoanApproveackNotifyDomain;
import com.alipay.sdk.request.MybankCreditLoanApplyNotifyRequest;
import com.alipay.sdk.request.MybankCreditLoanApproveUploadRequest;
import com.alipay.sdk.request.MybankCreditLoanApproveackConfirmRequest;
import com.alipay.sdk.request.MybankCreditLoanApproveackNotifyRequest;
import com.alipay.sdk.response.MybankCreditLoanApplyNotifyResponse;
import com.alipay.sdk.response.MybankCreditLoanApproveackNotifyResponse;
import com.credit.gateway.annotation.Sign;
import com.credit.gateway.impl.ConsumerCreditBankLoanService;
import common.credit.constants.Constants;
import common.credit.format.Document;
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
    public Document applyNotify(@RequestBody String request) {

        String requestBody = request;
        AlipayTemplate template = new DefaultAlipayTemplate(Constants.APP_ID, Constants.PRIVATE_KEY, Constants.alipayPublicKey);
        try {
            String respXml = template.execute(requestBody, MybankCreditLoanApplyNotifyRequest.class, new
                    AlipayCallback<MybankCreditLoanApplyNotifyDomain, MybankCreditLoanApplyNotifyResponse>() {

                        @Override
                        public MybankCreditLoanApplyNotifyResponse process(ParametersHolder<MybankCreditLoanApplyNotifyDomain> parametersHolder, AlipayApiException e) {
                            return new MybankCreditLoanApplyNotifyResponse();
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
            MybankCreditLoanApproveUploadRequest request = new MybankCreditLoanApproveUploadRequest();
            MybankCreditLoanApplyNotifyDomain bizMode = new MybankCreditLoanApplyNotifyDomain();
            bizMode.setRequestId(domain.getRequestId());

            bizMode.setApplyNo(domain.getApplyNo());
            bizMode.setCertName(domain.getCertName());
            bizMode.setCertNo(domain.getCertNo());
            bizMode.setCertType(domain.getCertType());
            bizMode.setExtInfo(domain.getExtInfo());
            request.setBizModel(bizMode);

            ParametersHolder response = template.execute(url, request);

        } catch (AlipayApiException e) {
            logger.error("approve_upload excute error: ", e);
        }

        return null;

    }

    @PostMapping(value = "/approveack_notify", consumes = "application/xml", produces = MediaType.APPLICATION_XML_VALUE)
    @Sign
    public Document approveackNotify(@RequestBody String request) {

        String requestBody = request;
        AlipayTemplate template = new DefaultAlipayTemplate(Constants.APP_ID, Constants.PRIVATE_KEY, Constants.alipayPublicKey);
        try {
            String respXml = template.execute(requestBody, MybankCreditLoanApproveackNotifyRequest.class, new
                    AlipayCallback<MybankCreditLoanApproveackNotifyDomain, MybankCreditLoanApproveackNotifyResponse>() {

                        @Override
                        public MybankCreditLoanApproveackNotifyResponse process(ParametersHolder<MybankCreditLoanApproveackNotifyDomain> parametersHolder, AlipayApiException e) {
                            MybankCreditLoanApproveackNotifyResponse response = new MybankCreditLoanApproveackNotifyResponse();

                            return response;
                        }
                    });

            logger.info("apply_notify excute ok: ", respXml);
        } catch (AlipayApiException e) {
            logger.error("apply_notify excute error: ", e);
        }

        return null;
    }

    @PostMapping(value = "/approveack_confirm", consumes = "application/xml", produces = MediaType.APPLICATION_XML_VALUE)
    @Sign
    public Document approveackConfirm(@RequestBody MybankCreditLoanApproveackConfirmDomain domain) {

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
            template.execute(url, request);

        } catch (AlipayApiException e) {
            logger.error("approve_upload excute error: ", e);
        }

        return null;
    }
}
