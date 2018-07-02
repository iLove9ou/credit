/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package com.credit.gateway.demo.second;

import com.alipay.sdk.AlipayTemplate;
import com.alipay.sdk.DefaultAlipayTemplate;
import com.alipay.sdk.domain.AlipayPcreditLoanCreditApprovalInfoDomain;
import com.alipay.sdk.request.AlipayPcreditLoanCreditApprovalInfoRequest;
import com.credit.gateway.demo.KeyConstants;

import java.math.BigDecimal;

/**
 *���ڳ�������������
 * @author jiangchen
 * @version $Id: AlipayPcreditLoanApprovalInfoDemo.java, v 0.1 2018��02��06�� 14:40 jiangchen Exp $
 */
public class AlipayPcreditLoanApprovalInfoDemo {


    public static void main(String[] args) throws Exception {

        AlipayTemplate template = new DefaultAlipayTemplate("UBCHN99", KeyConstants.privateKey, KeyConstants.alipayPublicKey);

        AlipayPcreditLoanCreditApprovalInfoRequest request = new AlipayPcreditLoanCreditApprovalInfoRequest();

        AlipayPcreditLoanCreditApprovalInfoDomain bizMode = new AlipayPcreditLoanCreditApprovalInfoDomain();

        bizMode.setApplyNo("201802090119096452A");
        bizMode.setAdmit("Y");
        bizMode.setCertNo("342401198802216534");
        bizMode.setCreditNo("11201802090000021827");
        bizMode.setCreditAmt(new Long(10000));
        bizMode.setCreditRate(new BigDecimal(0.00040));
        bizMode.setBankInfo("{\"bank_encrypted_meta\":\"{\\\"sdk_version\\\":\\\"2.0\\\"}");
        bizMode.setRefuseCode(null);
        bizMode.setRefuseMsg("");

        request.setBizModel(bizMode);

        System.out.println(template.execute("http://supergw.rz00b.alipay.net/UBCHN99/postbankApprovalInfo.htm", request).getBody());
    }

}