package com.credit.gateway.impl;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alipay.sdk.request.MybankCreditLoanApplyNotifyRequest;
import com.alipay.sdk.request.MybankCreditLoanApproveUploadRequest;
import com.alipay.sdk.request.MybankCreditLoanApproveackConfirmRequest;
import com.alipay.sdk.request.MybankCreditLoanApproveackNotifyRequest;
import com.alipay.sdk.response.MybankCreditLoanApplyNotifyResponse;
import com.alipay.sdk.response.MybankCreditLoanApproveUploadResponse;
import com.alipay.sdk.response.MybankCreditLoanApproveackConfirmResponse;
import com.alipay.sdk.response.MybankCreditLoanApproveackNotifyResponse;
import common.credit.dubbo.CreditBankLoanService;
import common.credit.format.Document;
import common.credit.format.DocumentInput;
import org.springframework.stereotype.Component;

@Component
public class ConsumerCreditBankLoanService {

    @Reference(version = "1.0.0")
    private CreditBankLoanService creditBankLoanService;


    public Document applyNotify(DocumentInput document) {
        return creditBankLoanService.applyNotify(document);
    }


    public Document approveUpload(DocumentInput document) {
        return creditBankLoanService.approveUpload(document);
    }


    public Document finalNotify(DocumentInput document) {
        return creditBankLoanService.finalNotify(document);
    }


    public Document finalConfirm(DocumentInput document) {
        return creditBankLoanService.finalConfirm(document);
    }


    public Document applyNotify(MybankCreditLoanApplyNotifyRequest request, MybankCreditLoanApplyNotifyResponse response) {
        return creditBankLoanService.applyNotify(request, response);
    }


    public Document approveUpload(MybankCreditLoanApproveUploadRequest request, MybankCreditLoanApproveUploadResponse response) {
        return creditBankLoanService.approveUpload(request, response);
    }


    public Document finalNotify(MybankCreditLoanApproveackNotifyRequest request, MybankCreditLoanApproveackNotifyResponse response) {
        return creditBankLoanService.finalNotify(request, response);
    }


    public Document finalConfirm(MybankCreditLoanApproveackConfirmRequest request, MybankCreditLoanApproveackConfirmResponse response) {
        return creditBankLoanService.finalConfirm(request, response);
    }
}
