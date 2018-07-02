/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package com.credit.gateway.demo.first;

import com.alipay.sdk.*;
import com.alipay.sdk.domain.AlipayPcreditLoanCreditV1ApplyDomain;
import com.alipay.sdk.internal.util.AlipayLogger;
import com.alipay.sdk.request.AlipayPcreditLoanCreditV1ApplyRequest;
import com.alipay.sdk.response.AlipayPcreditLoanCreditV1ApplyResponse;
import com.alipay.sdk.response.ResultInfo;
import com.credit.gateway.demo.KeyConstants;

/**
 * һ����������
 * @author wb-hys361553
 * @version $Id: AlipayPcreditLoanCreditV1ApplyDemo.java, v 0.1 2018��2��11�� ����1:52:39 wb-hys361553 Exp $
 */
public class AlipayPcreditLoanCreditV1ApplyDemo {

    /**
     * 
     * @param args
     * @throws AlipayApiException 
     * @throws IllegalAccessException 
     */
    public static void main(String[] args) throws IllegalAccessException, AlipayApiException {
        AlipayLogger.setJDKDebugEnabled(false);
        
        String requestBody = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>"
                +"<document>"
                 +"<request>"
                     +"<head>"
                         +"<version>1.0.0</version>"
                         +"<appId>ALIPAY</appId>"
                         +"<function>ant.jiebei.institution.credit.apply</function>"
                         +"<reqTime>20170517104552</reqTime>"
                        +"<reqTimeZone>UTC+8</reqTimeZone>"
                        +"<reqMsgId>20170517110400030001701058431001</reqMsgId>"
                        +"<reserve></reserve>"
                        +"<signType>RSA</signType>"
                        +"<inputCharset>UTF-8</inputCharset>"
                    +"</head>"
                    +"<body>"
                        +"<applyNo>201711070063704874A</applyNo>"
                        +"<certType>01</certType>"
                        +"<certNo>340822199105180249</certNo>"
                        +"<certValidEndDate></certValidEndDate>"
                        +"<name>��С��</name>"
                        +"<mobileNo>13232324567</mobileNo>"
                        +"<zmAuthFlag>Y</zmAuthFlag>"
                        +"<hasJBAdmit>N</hasJBAdmit>"
                        +"<pbocInfo></pbocInfo>"
                +"<zmInfo><![CDATA[{\"CreditScore\":\"{\"success\":true,\"biz_no\":\"ZM201703013000000507200001538406\",\"zm_score\":\"550\"}\",\"DAS\":\"{\"success\":true,\"biz_no\":\"ZM201703063000000304900697778194\",\"vars\":[{\"key\":\"occupation\",\"value\":\"����Ա��(ģ��Ԥ��)\"},{\"key\":\"company_name\",\"value\":\"����Ͱ�(�ⲿ����)\"},{\"key\":\"mobile_fixed_days\",\"value\":\"04\"},{\"key\":\"adr_stability_days\",\"value\":\"04\"},{\"key\":\"have_car_flag\",\"value\":\"02\"},{\"key\":\"have_fang_flag\",\"value\":\"03\"},{\"key\":\"last_6m_avg_asset_total\",\"value\":\"13\"},{\"key\":\"tot_pay_amt_6m\",\"value\":\"09\"},{\"key\":\"xfdc_index\",\"value\":\"07\"},{\"key\":\"auth_fin_last_6m_cnt\",\"value\":\"02\"},{\"key\":\"auth_fin_last_3m_cnt\",\"value\":\"02\"},{\"key\":\"auth_fin_last_1m_cnt\",\"value\":\"01\"},{\"key\":\"positive_biz_cnt_1y\",\"value\":\"04\"},{\"key\":\"ovd_order_cnt_6m\",\"value\":\"01\"},{\"key\":\"ovd_order_amt_6m\",\"value\":\"01\"}]}\",\"IVS\":\"{\"success\":true,\"biz_no\":\"ZM201703013000000397200001524618\",\"hit\":\"no\"}\",\"WatchListii\":\"{\"success\":true,\"biz_no\":\"ZM201703013000000817200001524617\",\"is_matched\":false}\"}]]></zmInfo>"
                +"<extInfo><![CDATA[{\"ADDRESS\":{\"address\":\"5LqR5p6r6KGX6YGT5byA5Y6/5LqR5p6r6KGX6YGT5bmz5qGlMuaUr+i3rzY05Y+3\r\n\",\"area\":\"����\",\"city\":\"������\",\"prov\":\"����\"}}]]></extInfo>"
                +"</body>"
                +"</request>"
                +"<signature>xRzPS5UmAgNo3DXL5poGpYfeW+1IFRVOhkjgi3UbW/10ett5z4yaIO8UBh3M2kX4Nv/rFwgXkewKSfadi4mTVs+e/hcTexYk3+wNTH9Qvx1SZxu6T5gLHH/P6yddPSH6Q9udDAbPjIOKzKwdHxkzeANHXXvV/bn6dkvmZaVwZtlP54687uBQyeXAytpicDXvzoIQO/Wc+eT0oz0/YocrNX2KKZ9WfgnEV/d6eB7prh+atyYLWl1VS4f2DXZilvJuK1KDhg5UoAElsPPeaFUKPhBB7qYsG9ycOSmnGo/cy/ESjyw7OZCz99s22qdtr9AKPqLWutJZXWbsdkzgB0UUnA==</signature>"
                +"</document>";

        AlipayTemplate template = new DefaultAlipayTemplate("GYB99", KeyConstants.privateKey, KeyConstants.alipayPublicKey);
        String responseXml = template.execute(requestBody, AlipayPcreditLoanCreditV1ApplyRequest.class, new AlipayCallback<AlipayPcreditLoanCreditV1ApplyDomain, AlipayPcreditLoanCreditV1ApplyResponse>() {

            public AlipayPcreditLoanCreditV1ApplyResponse process(ParametersHolder<AlipayPcreditLoanCreditV1ApplyDomain> parametersHolder, AlipayApiException e) {
                System.out.println("����requestBody��"+parametersHolder.getBody());
                AlipayPcreditLoanCreditV1ApplyResponse response = new AlipayPcreditLoanCreditV1ApplyResponse();
                response.setApplyNo("aaaaaaaaaa");
                ResultInfo resultInfo = new ResultInfo();
                resultInfo.setResultCode("0000");
                resultInfo.setResultMsg("ok");
                response.setResultInfo(resultInfo);
                return response;
            }
        });
        System.out.println("��ӦresponseXml��"+responseXml);
    }

}
