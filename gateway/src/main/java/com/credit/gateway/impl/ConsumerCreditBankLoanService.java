package com.credit.gateway.impl;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alipay.sdk.AlipayHeader;
import com.alipay.sdk.domain.MybankCreditLoanApplyNotifyDomain;
import com.alipay.sdk.domain.MybankCreditLoanApproveackNotifyDomain;
import com.alipay.sdk.response.MybankCreditLoanApplyNotifyResponse;
import com.alipay.sdk.response.MybankCreditLoanApproveUploadResponse;
import com.alipay.sdk.response.MybankCreditLoanApproveackConfirmResponse;
import com.alipay.sdk.response.MybankCreditLoanApproveackNotifyResponse;
import common.credit.dubbo.CreditBankLoanService;
import common.credit.request.CustMybankCreditLoanApproveUploadRequest;
import common.credit.request.CustMybankCreditLoanApproveackConfirmRequest;
import common.credit.result.ResponseResult;
import org.springframework.stereotype.Component;

@Component
public class ConsumerCreditBankLoanService {

    @Reference(version = "1.0.0")
    private CreditBankLoanService creditBankLoanService;

    /*
     * 初审通知请求，网商银行-银行机构
     * 网商银行发起，银行机构接收
     */
    public ResponseResult applyNotify(AlipayHeader head,
                                      MybankCreditLoanApplyNotifyDomain domain,
                                      MybankCreditLoanApplyNotifyResponse response) {
        return creditBankLoanService.applyNotify(head, domain, response);
    }

    /*
     * 初审通知请求，网商银行-银行机构
     * 网商银行发起，银行机构接收
     */
    public ResponseResult approveUpload(AlipayHeader head,
                                        MybankCreditLoanApproveUploadResponse body,
                                        CustMybankCreditLoanApproveUploadRequest request) {
        return creditBankLoanService.approveUpload(head, body, request);
    }

    /*
     * 初审通知请求，网商银行-银行机构
     * 网商银行发起，银行机构接收
     */
    public ResponseResult finalNotify(AlipayHeader header,
                                      MybankCreditLoanApproveackNotifyDomain domain,
                                      MybankCreditLoanApproveackNotifyResponse response) {
        return creditBankLoanService.finalNotify(header, domain, response);
    }

    /*
     * 初审通知请求，网商银行-银行机构
     * 网商银行发起，银行机构接收
     */
    public ResponseResult finalConfirm(AlipayHeader header,
                                       MybankCreditLoanApproveackConfirmResponse response,
                                       CustMybankCreditLoanApproveackConfirmRequest request) {
        return creditBankLoanService.finalConfirm(header, response, request);
    }
}
