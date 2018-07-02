/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package com.credit.gateway.demo.first;

import com.alipay.sdk.AlipayApiException;
import com.alipay.sdk.AlipayTemplate;
import com.alipay.sdk.DefaultAlipayTemplate;
import com.alipay.sdk.ParametersHolder;
import com.alipay.sdk.domain.AlipayPcreditLoanCreditResultDomain;
import com.alipay.sdk.request.AlipayPcreditLoanCreditResultRequest;
import com.alipay.sdk.response.AlipayPcreditLoanCreditResultResponse;
import com.credit.gateway.demo.KeyConstants;

import java.math.BigDecimal;


public class AlipayPcreditLoanCreditResultDemo {

    /**
     * 
     * @param args
     * @throws AlipayApiException 
     * @throws IllegalAccessException 
     */
    public static void main(String[] args) throws IllegalAccessException, AlipayApiException {
        AlipayTemplate template = new DefaultAlipayTemplate("GCB99", KeyConstants.privateKey,
            KeyConstants.alipayPublicKey);

        AlipayPcreditLoanCreditResultRequest request = new AlipayPcreditLoanCreditResultRequest();
        AlipayPcreditLoanCreditResultDomain domain = new AlipayPcreditLoanCreditResultDomain();
        domain.setApplyNo("201606120000000135A");
        domain.setCertNo("342401199910010022");
        domain.setResult("S");
        domain.setCreditAmt(1000000L);
        domain.setRiskRate(new BigDecimal(0.0005));
        domain.setCreditNo("13223456543");
        domain.setCreditResultCode("0000");
        domain.setCreditResultMsg("�ۺ���������");
        
        request.setBizModel(domain);
        request.setApiVersion("2.0.0");
        ParametersHolder<AlipayPcreditLoanCreditResultResponse> ph = template.execute("http://supergw.rz00b.alipay.net/GCB99/creditResult.htm", request);
        System.out.println(ph.getBody());
    
    }

}
