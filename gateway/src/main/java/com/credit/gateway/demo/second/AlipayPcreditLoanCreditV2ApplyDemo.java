/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package com.credit.gateway.demo.second;

import com.alipay.sdk.*;
import com.alipay.sdk.domain.AlipayPcreditLoanCreditV2ApplyDomain;
import com.alipay.sdk.request.AlipayPcreditLoanCreditV2ApplyRequest;
import com.alipay.sdk.response.AlipayPcreditLoanCreditV2ApplyResponse;
import com.alipay.sdk.response.ResultInfo;
import com.credit.gateway.demo.KeyConstants;


/**
 *���ڳ���
 * @author jiangchen
 * @version $Id: CreditApplyDemo.java, v 0.1 2018��02��07�� 18:12 jiangchen Exp $
 */
public class AlipayPcreditLoanCreditV2ApplyDemo {

   

    public static void main(String[] args) throws Exception{
        String requestBody = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><document><request>";
         requestBody += "<head><version>1.0.0</version><appId>ALIPAY</appId><function>ant.jiebei.institution.cooperation.credit"
                 + ".apply</function><reqTime>20180323114013</reqTime><reqTimeZone>UTC+8</reqTimeZone><reqMsgId"
                 + ">20180323110400030003690018497549</reqMsgId><reserve></reserve><signType>RSA</signType><inputCharset>UTF-8"
                 + "</inputCharset></head><body><applyNo>201803230000264649A</applyNo><certType>01</certType><certNo>513323198005116927"
                 + "</certNo><certValidEndDate>20180701</certValidEndDate><name>άά</name><mobileNo>15616030104</mobileNo><zmAuthFlag>Y"
                 + "</zmAuthFlag><hasJBAdmit>Y</hasJBAdmit><pbocInfo></pbocInfo><zmInfo><![CDATA[{\"IVS\":\"{\\\"success\\\":true,"
                 + "\\\"biz_no\\\":\\\"ZM201803233000000538400003654516\\\","
                 + "\\\"hit\\\":\\\"no\\\"}\"}]]></zmInfo><extInfo><![CDATA[{\"ADDRESS\":{\"address"
                 + "\":\"6bOM6Ziz6ZWH5Lic5Yy65a6e6aqM5bm85YS/5Zut\",\"area\":\"������\",\"city\":\"������\",\"prov\":\"����ʡ\"}}]]></extInfo></body>"
                + "</request><signature>m3b32PS7mwWL4SxRUJDaIuxnysdCvKFqlSMpVnI4aXQEODmz+L3Ko04jCa3Ake059DUDen0TFpkJBaPFucqDpLb6vU0esRGdix28wXW71pmyk4sviov6XGXgxEZgp4+2g390siJuHXCgwDYcAbL1ToE+ZvxwC0Ehzb9DEN1yU9jKbo8RLb9e6jC7QMzcxy+/x4lTSvynrN0G/fwwQJCVDTKU4LkDltTp8cC+tVlN6q3+6j7DPbzt1kmv1onrIUIokUzPun9Fowt1nM48sW7AuzVoDpL0aJGc8XTAJWnqGo5nOG+Kf+jX6NGwxo2HLDZsmWac251s/3fCfgHHXZJXjw==</signature></document>";
        AlipayTemplate template = new DefaultAlipayTemplate("UBCHN99", KeyConstants.privateKey, KeyConstants.alipayPublicKey);
        String respXml = template.execute(requestBody, AlipayPcreditLoanCreditV2ApplyRequest.class, new AlipayCallback<AlipayPcreditLoanCreditV2ApplyDomain,AlipayPcreditLoanCreditV2ApplyResponse>() {
            public AlipayPcreditLoanCreditV2ApplyResponse process(ParametersHolder<AlipayPcreditLoanCreditV2ApplyDomain> parametersHolder, AlipayApiException e) {
                System.out.println(parametersHolder.getBody());

                AlipayPcreditLoanCreditV2ApplyResponse response =  new AlipayPcreditLoanCreditV2ApplyResponse();
                response.setApplyNo("aaaaaaaaaa");
                ResultInfo resultInfo = new ResultInfo();
                resultInfo.setResultCode("0000");
                resultInfo.setResultMsg("ok");
                response.setResultInfo(resultInfo);
                return response;
            }
        });

        System.out.println(respXml);
    }
}