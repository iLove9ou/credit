package com.credit.gateway.utils;


import com.credit.gateway.request.*;
import org.springframework.beans.BeanUtils;

public class CovertUtil {

    public static MybankCreditLoanApplyNotifyRequest getRequest(MybankCreditLoanApplyNotifyExtRequest requestExt) {
        MybankCreditLoanApplyNotifyRequest request = new MybankCreditLoanApplyNotifyRequest();
        BeanUtils.copyProperties(requestExt, request);
        return request;
    }

    public static MybankCreditLoanApproveackConfirmRequest getRequest(MybankCreditLoanApproveackConfirmExtRequest requestExt) {
        MybankCreditLoanApproveackConfirmRequest request = new MybankCreditLoanApproveackConfirmRequest();
        BeanUtils.copyProperties(requestExt, request);
        return request;
    }

    public static MybankCreditLoanApproveackNotifyRequest getRequest(MybankCreditLoanApproveackNotifyExtRequest requestExt) {
        MybankCreditLoanApproveackNotifyRequest request = new MybankCreditLoanApproveackNotifyRequest();
        BeanUtils.copyProperties(requestExt, request);
        return request;
    }

    public static MybankCreditLoanApproveUploadRequest getRequest(MybankCreditLoanApproveUploadExtRequest requestExt) {
        MybankCreditLoanApproveUploadRequest request = new MybankCreditLoanApproveUploadRequest();
        BeanUtils.copyProperties(requestExt, request);
        return request;
    }
}
