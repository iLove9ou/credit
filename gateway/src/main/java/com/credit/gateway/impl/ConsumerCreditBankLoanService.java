package com.credit.gateway.impl;

import com.alibaba.dubbo.config.annotation.Reference;
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
}
