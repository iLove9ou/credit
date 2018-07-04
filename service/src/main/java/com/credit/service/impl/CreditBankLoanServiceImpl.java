package com.credit.service.impl;

import com.alipay.sdk.AlipayHeader;
import com.alipay.sdk.ParametersHolder;
import com.alipay.sdk.domain.MybankCreditLoanApplyNotifyDomain;
import com.alipay.sdk.domain.MybankCreditLoanApproveackNotifyDomain;
import com.alipay.sdk.request.MybankCreditLoanApproveUploadRequest;
import com.alipay.sdk.request.MybankCreditLoanApproveackConfirmRequest;
import com.alipay.sdk.response.MybankCreditLoanApplyNotifyResponse;
import com.alipay.sdk.response.MybankCreditLoanApproveUploadResponse;
import com.alipay.sdk.response.MybankCreditLoanApproveackConfirmResponse;
import com.alipay.sdk.response.MybankCreditLoanApproveackNotifyResponse;
import com.credit.service.manager.BankCreditManager;
import common.credit.dubbo.CreditBankLoanService;
import common.credit.enums.BizErrorCode;
import common.credit.format.Document;
import common.credit.format.DocumentInput;
import common.credit.format.ResultInfo;
import common.credit.result.BaseService;
import common.credit.result.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;

@com.alibaba.dubbo.config.annotation.Service(version = "1.0.0")
public class CreditBankLoanServiceImpl extends BaseService implements CreditBankLoanService {

    @Autowired
    private BankCreditManager manager;

    /*
     * 初审通知请求，网商银行-银行机构
     */
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
    public ResponseResult applyNotify(AlipayHeader head,
                                      MybankCreditLoanApplyNotifyDomain domain,
                                      MybankCreditLoanApplyNotifyResponse response) {


        manager.insertApplyNotify(head, domain, response);

        return success();
    }

    @Override
    public ResponseResult approveUpload(MybankCreditLoanApproveUploadRequest request,
                                  ParametersHolder<MybankCreditLoanApproveUploadResponse> response) {

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
