package com.credit.service.impl;

import com.alipay.sdk.AlipayHeader;
import com.alipay.sdk.ParametersHolder;
import com.alipay.sdk.domain.MybankCreditLoanApplyNotifyDomain;
import com.alipay.sdk.domain.MybankCreditLoanApproveackNotifyDomain;
import com.alipay.sdk.request.MybankCreditLoanApproveackConfirmRequest;
import com.alipay.sdk.response.MybankCreditLoanApplyNotifyResponse;
import com.alipay.sdk.response.MybankCreditLoanApproveUploadResponse;
import com.alipay.sdk.response.MybankCreditLoanApproveackConfirmResponse;
import com.alipay.sdk.response.MybankCreditLoanApproveackNotifyResponse;
import com.credit.service.manager.BankCreditManager;
import common.credit.dubbo.CreditBankLoanService;
import common.credit.request.CustMybankCreditLoanApproveUploadRequest;
import common.credit.result.BaseComponent;
import common.credit.result.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;

@com.alibaba.dubbo.config.annotation.Service(version = "1.0.0")
public class CreditBankLoanServiceImpl extends BaseComponent implements CreditBankLoanService {

    @Autowired
    private BankCreditManager manager;


    @Override
    public ResponseResult applyNotify(AlipayHeader head,
                                      MybankCreditLoanApplyNotifyDomain domain,
                                      MybankCreditLoanApplyNotifyResponse response) {


        manager.insertApplyNotify(head, domain, response);

        return success();
    }

    @Override
    public ResponseResult approveUpload(AlipayHeader head,
                                        MybankCreditLoanApproveUploadResponse body,
                                        CustMybankCreditLoanApproveUploadRequest request) {

        manager.insertApproveUpload(head, body, request);

        return success();

    }

    @Override
    public ResponseResult finalNotify(ParametersHolder<MybankCreditLoanApproveackNotifyDomain> parametersHolder,
                                      MybankCreditLoanApproveackNotifyResponse response) {

        return success();
    }

    @Override
    public ResponseResult finalConfirm(MybankCreditLoanApproveackConfirmRequest request,
                                 ParametersHolder<MybankCreditLoanApproveackConfirmResponse> response) {

        return success();
    }

}
