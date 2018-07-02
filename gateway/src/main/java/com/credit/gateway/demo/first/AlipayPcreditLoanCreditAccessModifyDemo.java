/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package com.credit.gateway.demo.first;

import com.alipay.sdk.AlipayApiException;
import com.alipay.sdk.AlipayTemplate;
import com.alipay.sdk.DefaultAlipayTemplate;
import com.alipay.sdk.ParametersHolder;
import com.alipay.sdk.domain.AlipayPcreditLoanCreditAccessModifyDomain;
import com.alipay.sdk.internal.util.AlipayLogger;
import com.alipay.sdk.request.AlipayPcreditLoanCreditAccessModifyRequest;
import com.alipay.sdk.response.AlipayPcreditLoanCreditResultResponse;
import com.credit.gateway.demo.KeyConstants;


public class AlipayPcreditLoanCreditAccessModifyDemo {

    static {
        AlipayLogger.setJDKDebugEnabled(false);
    }

    /**
     * 
     * @param args
     * @throws AlipayApiException 
     * @throws IllegalAccessException 
     */
    public static void main(String[] args) throws IllegalAccessException, AlipayApiException {
       
        AlipayTemplate template = new DefaultAlipayTemplate("GCB99", KeyConstants.privateKey,
            KeyConstants.alipayPublicKey);

        AlipayPcreditLoanCreditAccessModifyRequest request = new AlipayPcreditLoanCreditAccessModifyRequest();
        AlipayPcreditLoanCreditAccessModifyDomain domain= new AlipayPcreditLoanCreditAccessModifyDomain();
        
        domain.setOperateNo(String.valueOf(System.currentTimeMillis()));
        domain.setApplyNo("201606120000000135A");
        domain.setCertNo("342401199910010022");
        domain.setCreditNo("13223456543");
        domain.setOperate("01");
        domain.setModifyReason("有逾期");
        
        request.setBizModel(domain);
        ParametersHolder<AlipayPcreditLoanCreditResultResponse> ph = template.execute("http://supergw.rz00b.alipay.net/GCB99/creditResult.htm", request);
        System.out.println(ph.getBody());
    }

}
