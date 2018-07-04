package com.credit.service.manager;


import com.alipay.sdk.AlipayHeader;
import com.alipay.sdk.domain.MybankCreditLoanApplyNotifyDomain;
import com.alipay.sdk.response.MybankCreditLoanApplyNotifyResponse;
import com.alipay.sdk.response.MybankCreditLoanApproveUploadResponse;
import com.credit.service.dao.*;
import com.credit.service.model.entity.BankCreditApproveUploadRequest;
import com.credit.service.model.entity.BankCreditBodyResponse;
import com.credit.service.model.entity.BankCreditHeaderRequest;
import com.credit.service.model.entity.BankCreditHeaderResponse;
import common.credit.request.CustMybankCreditLoanApproveUploadRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Component
public class BankCreditManager {

    private final static Logger logger = LoggerFactory.getLogger(BankCreditManager.class);

    @Resource
    private BankCreditApplyNotifyRequestMapper applynotifyRequestMapper;

    @Resource
    private BankCreditApproveUploadRequestMapper approveUploadRequestMapper;

    @Resource
    private BankCreditApproveackNotifyRequestMapper approveackNotifyRequestMapper;

    @Resource
    private BankCreditApproveackConfirmRequestMapper approveackConfirmRequestMapper;

    @Resource
    private BankCreditCodeMapper creditCodeMapper;

    @Resource
    private BankCreditHeaderRequestMapper headerRequestMapper;

    @Resource
    private BankCreditHeaderResponseMapper headerResponseMapper;

    @Resource
    private BankCreditBodyResponseMapper bodyResponseMapper;


    @Transactional
    public void insertApplyNotify(AlipayHeader head,
                                  MybankCreditLoanApplyNotifyDomain domain,
                                  MybankCreditLoanApplyNotifyResponse response) {

        BankCreditHeaderRequest headerRequest = new BankCreditHeaderRequest();
        MybankCreditLoanApplyNotifyDomain body = domain;
        AlipayHeader header = head;
        BeanUtils.copyProperties(header, headerRequest);

        headerRequestMapper.insertSelective(headerRequest);

        BankCreditHeaderResponse headerResponse = new BankCreditHeaderResponse();
        BeanUtils.copyProperties(header, headerResponse);
        headerResponseMapper.insertSelective(headerResponse);

        BankCreditBodyResponse bodyResponse = new BankCreditBodyResponse();

        bodyResponse.setApplyNo(response.getApplyNo());
        bodyResponse.setRequestId(response.getRequestId());
        bodyResponse.setResultCode(response.getResultInfo().getResultCode());
        bodyResponse.setResultMsg(response.getResultInfo().getResultMsg());
        bodyResponse.setRetry(response.getResultInfo().getRetry());
        bodyResponseMapper.insertSelective(bodyResponse);

    }

    @Transactional
    public void insertApproveUpload(AlipayHeader header,
                                    MybankCreditLoanApproveUploadResponse body,
                                    CustMybankCreditLoanApproveUploadRequest request) {

        BankCreditHeaderResponse headerResponse = new BankCreditHeaderResponse();
        BeanUtils.copyProperties(header, headerResponse);
        headerResponseMapper.insertSelective(headerResponse);

        BankCreditBodyResponse bodyResponse = new BankCreditBodyResponse();
        bodyResponse.setApplyNo(body.getApplyNo());
        bodyResponse.setRequestId(body.getRequestId());
        bodyResponse.setResultCode(body.getResultInfo().getResultCode());
        bodyResponse.setResultMsg(body.getResultInfo().getResultMsg());
        bodyResponse.setRetry(body.getResultInfo().getRetry());
        bodyResponseMapper.insertSelective(bodyResponse);

        BankCreditApproveUploadRequest custRequest = new BankCreditApproveUploadRequest();
        BeanUtils.copyProperties(request, custRequest);
        approveUploadRequestMapper.insertSelective(custRequest);
    }

    public void insertApproackNotify() {

    }

    public void insertApproveackConfirm() {

    }

}
