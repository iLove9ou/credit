package com.credit.service.impl;

import com.credit.service.manager.BankCreditManager;
import common.credit.dubbo.CreditBankLoanService;
import common.credit.enums.BizErrorCode;
import common.credit.format.Document;
import common.credit.format.DocumentInput;
import common.credit.format.ResultInfo;
import org.springframework.beans.factory.annotation.Autowired;

@com.alibaba.dubbo.config.annotation.Service(version = "1.0.0")
public class CreditBankLoanServiceImpl implements CreditBankLoanService {

    @Autowired
    private BankCreditManager manager;

    /*
     * 初审通知请求，网商银行-银行机构
     */
    @Override
    public Document applyNotify(DocumentInput documentInput) {
        String requestId = documentInput.getRequest().getHead().getReqMsgId();
        String appId = documentInput.getRequest().getHead().getAppId();
        String funcKey = documentInput.getRequest().getHead().getFunction();
        String sign = "sign";
        ResultInfo info = new ResultInfo();
        info.setResultCode(BizErrorCode.INVLID_SIGN.getCode());
        info.setResultMsg(BizErrorCode.INVLID_SIGN.getMessage());
        manager.addDocument(documentInput);
        return manager.getDocuemnt(requestId, appId, funcKey, sign, info);
    }

    /*
     * 初审数据上传，银行机构-网商银行
     */
    @Override
    public Document approveUpload(DocumentInput documentInput) {

        String requestId = documentInput.getRequest().getHead().getReqMsgId();
        String appId = documentInput.getRequest().getHead().getAppId();
        String funcKey = documentInput.getRequest().getHead().getFunction();
        String sign = "sign";
        ResultInfo info = new ResultInfo();
        info.setResultCode(BizErrorCode.SUCCESS.getCode());
        info.setResultMsg(BizErrorCode.SUCCESS.getMessage());
        return manager.getDocuemnt(requestId, appId, funcKey, sign, info);
    }

    /*
     * 终审通知，网商银行-银行机构
     */
    @Override
    public Document finalNotify(DocumentInput documentInput) {

        String requestId = documentInput.getRequest().getHead().getReqMsgId();
        String appId = documentInput.getRequest().getHead().getAppId();
        String funcKey = documentInput.getRequest().getHead().getFunction();
        String sign = "sign";
        ResultInfo info = new ResultInfo();
        info.setResultCode(BizErrorCode.NOT_RECOGNIZE_KEY_ITEM.getCode());
        info.setResultMsg(BizErrorCode.NOT_RECOGNIZE_KEY_ITEM.getMessage());
        return manager.getDocuemnt(requestId, appId, funcKey, sign, info);
    }

    /*
     * 终审确认，银行机构-网商银行
     */
    @Override
    public Document finalConfirm(DocumentInput documentInput) {

        String requestId = documentInput.getRequest().getHead().getReqMsgId();
        String appId = documentInput.getRequest().getHead().getAppId();
        String funcKey = documentInput.getRequest().getHead().getFunction();
        String sign = "sign";
        ResultInfo info = new ResultInfo();
        info.setResultCode(BizErrorCode.PARAMS_ERROR.getCode());
        info.setResultMsg(BizErrorCode.PARAMS_ERROR.getMessage());
        return manager.getDocuemnt(requestId, appId, funcKey, sign, info);
    }

    @Override
    public Document finalConfirm(com.alipay.sdk.request.MybankCreditLoanApproveackConfirmRequest request,
                                 com.alipay.sdk.response.MybankCreditLoanApproveackConfirmResponse response) {
        return null;
    }

    @Override
    public Document finalNotify(com.alipay.sdk.request.MybankCreditLoanApproveackNotifyRequest request,
                                com.alipay.sdk.response.MybankCreditLoanApproveackNotifyResponse response) {
        return null;
    }

    @Override
    public Document approveUpload(com.alipay.sdk.request.MybankCreditLoanApproveUploadRequest request,
                                  com.alipay.sdk.response.MybankCreditLoanApproveUploadResponse response) {
        return null;
    }

    @Override
    public Document applyNotify(com.alipay.sdk.request.MybankCreditLoanApplyNotifyRequest request,
                                com.alipay.sdk.response.MybankCreditLoanApplyNotifyResponse response) {
        return null;
    }

}
