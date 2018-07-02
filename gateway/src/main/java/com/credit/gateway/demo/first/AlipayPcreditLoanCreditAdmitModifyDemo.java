/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package com.credit.gateway.demo.first;


import com.alipay.sdk.AlipayTemplate;
import com.alipay.sdk.DefaultAlipayTemplate;
import com.alipay.sdk.ParametersHolder;
import com.alipay.sdk.domain.AlipayPcreditLoanCreditAdmitModifyDomain;
import com.alipay.sdk.request.AlipayPcreditLoanCreditAdmitModifyRequest;
import com.alipay.sdk.response.AlipayPcreditLoanCreditResultResponse;
import com.credit.gateway.demo.KeyConstants;

import java.math.BigDecimal;

/**
 * һ�ڣ�  ���Ż������������׼���û�������ʵı���
 * 
 * @author wb-hys361553
 * @version $Id: AlipayPcreditLoanCreditAdmitModifyDemo.java, v 0.1 2018��2��12�� ����2:39:07 wb-hys361553 Exp $
 */
public class AlipayPcreditLoanCreditAdmitModifyDemo {

    /**
     * 
     * @param args
     * @throws AlipayApiException 
     * @throws
     */
    public static void main(String[] args) throws Exception {
       
        AlipayTemplate template = new DefaultAlipayTemplate("GCB99", KeyConstants.privateKey,
            KeyConstants.alipayPublicKey);

        AlipayPcreditLoanCreditAdmitModifyRequest request = new AlipayPcreditLoanCreditAdmitModifyRequest();
        AlipayPcreditLoanCreditAdmitModifyDomain domain= new AlipayPcreditLoanCreditAdmitModifyDomain();
        
        domain.setOperateNo(String.valueOf(System.currentTimeMillis()));
        domain.setApplyNo("201606120000000135A");
        domain.setCertNo("342401199910010022");
        domain.setCreditNo("13223456543");
        domain.setOperate("03");
        domain.setModifyReason("������");
        domain.setRiskRate(new BigDecimal(0.0005));
        domain.setCreditAmt(100000L);
        request.setBizModel(domain);
        ParametersHolder<AlipayPcreditLoanCreditResultResponse> ph = template.execute("http://supergw.rz00b.alipay.net/GCB99/creditResult.htm", request);
        System.out.println(ph.getBody());
    }

}
