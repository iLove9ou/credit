/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package com.credit.gateway.demo.second;

import com.alipay.sdk.*;
import com.alipay.sdk.domain.AlipayPcreditLoanCreditAckDomain;
import com.alipay.sdk.request.AlipayPcreditLoanCreditAckRequest;
import com.alipay.sdk.response.AlipayPcreditLoanCreditAckResponse;
import com.alipay.sdk.response.ResultInfo;
import com.credit.gateway.demo.KeyConstants;


public class AlipayPcreditLoanCreditAckDemo {


    public static void main(String[] args) throws Exception{
        String requestBody = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><document><request><head><version>1.0.0</version><appId>ALIPAY</appId><function>ant.jiebei.institution.cooperation.credit.ack</function><reqTime>20180211180733</reqTime><reqTimeZone>UTC+8</reqTimeZone><reqMsgId>982202e3-0371-46da-bf80-870fcceff42c1518</reqMsgId><reserve></reserve><signType>RSA</signType><inputCharset>UTF-8</inputCharset></head><body><applyNo>201702110004431MM5</applyNo><certType>01</certType><certNo>342401199010010042</certNo><name>ɳ�����</name><platformAccess>N</platformAccess><platformRefuseReason>org_black_list</platformRefuseReason><platformAdmit>100000</platformAdmit><platformRate>0.00005</platformRate><riskRating></riskRating><solvencyRatings></solvencyRatings><changeResultReason></changeResultReason><extInfo><![CDATA[]]></extInfo></body></request><signature>Q/u+c8TMp8Fq4UuhiHSYNqMFMK7klhX/9XMp9F9LPJvGm4OcTmgUqH9WY73swLpDpclo9GAABnULG7gZDQgvXTyhm1CR2HfNUWJTvgHbLffXbBpf9nTIOOGb91JJ1PJ4YDBFWh56ccrrOE1ALJlG7M1612q7EBA2sEdUXBrSWNQ1zWshAfmlk57xL0IsYzbWwkxbYDgpUxL2c4G7y6rtcQYULOHj9AKrunzbhRMl2dBCqTNhqOmAFWpaNs02fbOYnii/lfguCpPejY2Z8/GiyOJTL5pkFWYRORJ2TlN2QDVzPlkhOE0LUAsdH8GLXAT9UV60PaetNT77pmbVGNHYbA==</signature></document>";
        AlipayTemplate template = new DefaultAlipayTemplate("CZCB99", KeyConstants.privateKey, KeyConstants.alipayPublicKey);
        String respXml = template.execute(requestBody, AlipayPcreditLoanCreditAckRequest.class, new AlipayCallback<AlipayPcreditLoanCreditAckDomain,AlipayPcreditLoanCreditAckResponse>() {
            public AlipayPcreditLoanCreditAckResponse process(ParametersHolder<AlipayPcreditLoanCreditAckDomain> parametersHolder, AlipayApiException e) {
                System.out.println(parametersHolder.getBody());
                AlipayPcreditLoanCreditAckResponse response =  new AlipayPcreditLoanCreditAckResponse();
                response.setApplyNo("201702110004431MM5");
                ResultInfo resultInfo = new ResultInfo();
                resultInfo.setResultCode("0000");
                resultInfo.setResultMsg("ok");
                response.setAgree("Y");
                response.setResultInfo(resultInfo);
                return response;
            }
        });

        System.out.println(respXml);
    }
}
