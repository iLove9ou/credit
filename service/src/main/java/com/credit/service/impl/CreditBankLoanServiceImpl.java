package com.credit.service.impl;

import com.credit.service.manager.BankCreditManager;
import common.credit.dubbo.CreditBankLoanService;
import common.credit.enums.BizErrorCode;
import common.credit.format.Document;
import common.credit.format.DocumentInput;
import common.credit.format.ResultInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreditBankLoanServiceImpl implements CreditBankLoanService {

    @Autowired
    private BankCreditManager manager;
    /*
     * 初审通知请求，网商银行-银行机构
     */
    @Override
    public Document applyNotify(DocumentInput document) {

        // TODO 发送请求
        String appId = "app";
        String funcKey = "funcKey";
        String sign = "sign";
        ResultInfo info = new ResultInfo();
        info.setResultCode(BizErrorCode.INVLID_SIGN.getCode());
        info.setResultMsg(BizErrorCode.INVLID_SIGN.getMessage());
        return manager.getDocuemnt(appId, funcKey, sign, info);
    }

    /*
     * 初审数据上传，银行机构-网商银行
     */
    @Override
    public Document approveUpload(DocumentInput document) {

        // TODO 发送请求
        String appId = "app";
        String funcKey = "funcKey";
        String sign = "sign";
        ResultInfo info = new ResultInfo();
        info.setResultCode(BizErrorCode.SUCCESS.getCode());
        info.setResultMsg(BizErrorCode.SUCCESS.getMessage());
        return manager.getDocuemnt(appId, funcKey, sign, info);
    }

    /*
     * 终审通知，网商银行-银行机构
     */
    @Override
    public Document finalNotify(DocumentInput document) {

        // TODO 发送请求
        String appId = "app";
        String funcKey = "funcKey";
        String sign = "sign";
        ResultInfo info = new ResultInfo();
        info.setResultCode(BizErrorCode.NOT_RECOGNIZE_KEY_ITEM.getCode());
        info.setResultMsg(BizErrorCode.NOT_RECOGNIZE_KEY_ITEM.getMessage());
        return manager.getDocuemnt(appId, funcKey, sign, info);
    }

    /*
     * 终审确认，银行机构-网商银行
     */
    @Override
    public Document finalConfirm(DocumentInput document) {

        // TODO 发送请求
        String appId = "app";
        String funcKey = "funcKey";
        String sign = "sign";
        ResultInfo info = new ResultInfo();
        info.setResultCode(BizErrorCode.PARAMS_ERROR.getCode());
        info.setResultMsg(BizErrorCode.PARAMS_ERROR.getMessage());
        return manager.getDocuemnt(appId, funcKey, sign, info);
    }

}
