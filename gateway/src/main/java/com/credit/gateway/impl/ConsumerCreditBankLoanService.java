package com.credit.gateway.impl;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alipay.sdk.ParametersHolder;
import com.alipay.sdk.domain.MybankCreditLoanApplyNotifyDomain;
import com.alipay.sdk.domain.MybankCreditLoanApproveackNotifyDomain;
import com.alipay.sdk.request.MybankCreditLoanApproveUploadRequest;
import com.alipay.sdk.request.MybankCreditLoanApproveackConfirmRequest;
import com.alipay.sdk.response.MybankCreditLoanApplyNotifyResponse;
import com.alipay.sdk.response.MybankCreditLoanApproveUploadResponse;
import com.alipay.sdk.response.MybankCreditLoanApproveackConfirmResponse;
import com.alipay.sdk.response.MybankCreditLoanApproveackNotifyResponse;
import common.credit.dubbo.CreditBankLoanService;
import common.credit.format.Document;
import org.springframework.stereotype.Component;

@Component
public class ConsumerCreditBankLoanService {

    @Reference(version = "1.0.0")
    private CreditBankLoanService creditBankLoanService;

    /*
     * 初审通知请求，网商银行-银行机构
     * 网商银行发起，银行机构接收
     */
    public Document applyNotify(ParametersHolder<MybankCreditLoanApplyNotifyDomain> parametersHolder, MybankCreditLoanApplyNotifyResponse response) {
        return creditBankLoanService.applyNotify(parametersHolder, response);
    }

    /*
     * 初审通知请求，网商银行-银行机构
     * 网商银行发起，银行机构接收
     */
    public Document approveUpload(MybankCreditLoanApproveUploadRequest request, ParametersHolder<MybankCreditLoanApproveUploadResponse> response) {
        return creditBankLoanService.approveUpload(request, response);
    }

    /*
     * 初审通知请求，网商银行-银行机构
     * 网商银行发起，银行机构接收
     */
    public Document finalNotify(ParametersHolder<MybankCreditLoanApproveackNotifyDomain> parametersHolder, MybankCreditLoanApproveackNotifyResponse response) {
        return creditBankLoanService.finalNotify(parametersHolder, response);
    }

    /*
     * 初审通知请求，网商银行-银行机构
     * 网商银行发起，银行机构接收
     */
    public Document finalConfirm(MybankCreditLoanApproveackConfirmRequest request, ParametersHolder<MybankCreditLoanApproveackConfirmResponse> response) {
        return creditBankLoanService.finalConfirm(request, response);
    }
}
