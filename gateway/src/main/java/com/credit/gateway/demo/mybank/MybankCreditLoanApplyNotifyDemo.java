/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package com.credit.gateway.demo.mybank;

import com.alipay.sdk.*;
import com.alipay.sdk.domain.MybankCreditLoanApplyNotifyDomain;
import com.alipay.sdk.enums.BooleanEnum;
import com.alipay.sdk.request.MybankCreditLoanApplyNotifyRequest;
import com.alipay.sdk.response.MybankCreditLoanApplyNotifyResponse;
import com.alipay.sdk.response.ResultInfo;
import com.credit.gateway.demo.KeyConstants;


public class MybankCreditLoanApplyNotifyDemo {

    public static void main(String[] args) throws Exception {

        String requestBody = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><document>    <request><head><version>1.0.0</version><appId>MYBANK</appId><function>com.mybank.credit.cooperation.apply.notify</function><reqTime>20180330175432</reqTime><reqTimeZone>UTC+8</reqTimeZone><reqMsgId>20180330110400030011041089471966</reqMsgId><reserve></reserve><signType>RSA</signType><inputCharset>UTF-8</inputCharset></head><body><requestId>226610000052162968501_4e7017f0c1484f34a83e89a7e21afc1d39A</requestId><applyNo>2018033010102500100008922239B</applyNo><certType>100</certType><certName>��������������</certName><certNo>610632198503148976</certNo><businessModel>MYBK_CREDIT_LOAN</businessModel><extInfo><![CDATA[{\"TARGET_JY_FLAG_3\":\"3\",\"TARGET_JY_FLAG_2\":\"2\",\"TARGET_JY_FLAG_1\":\"1\"}]]></extInfo></body></request>    <signature>uuM+0PhaNFgW7ExdkFOSSuEuP4HfKtdoOGC18Pq/x7trq0UXu6v02etz5wS5ICRvz/1ewfbo8nJXvV8kxikOSh0GqPXiRSYF8XgVuu+NKhhgMuqwKOXoSsz60toF/Nno443AxsjG2gFMUG7l2n7oBWJO2yLox7uz/Jlwh14GtwmTpR0FqlPrpQLRUvn7OWE5QsdJO6shM1m+bocZptMi4H3P9gk0QgLtXnI15hdhoNbBtsG1gzwCwLcGTMy01Zgw7+FBVuK7/HoROrMRWpVaI6nTPlsTf1+/ER4Q3qguQ9mMJLHu+g7Gb/5aWN3Pu31H8shhekuUOarvlmFc9XbklQ==</signature></document>";


        AlipayTemplate template = new DefaultAlipayTemplate("MYBANK85", KeyConstants.privateKey,
            KeyConstants.alipayPublicKey);


        String respXml = template.execute(requestBody, MybankCreditLoanApplyNotifyRequest.class,
            new AlipayCallback<MybankCreditLoanApplyNotifyDomain, MybankCreditLoanApplyNotifyResponse>() {
                public MybankCreditLoanApplyNotifyResponse process(ParametersHolder<MybankCreditLoanApplyNotifyDomain> parametersHolder,
                                                                   AlipayApiException e) {

                    MybankCreditLoanApplyNotifyDomain mybankCreditLoanApplyNotifyDomain = parametersHolder
                        .getBody();
                    System.out.println(mybankCreditLoanApplyNotifyDomain);

                    //2.��װ��ִ���Ķ���
                    MybankCreditLoanApplyNotifyResponse response = new MybankCreditLoanApplyNotifyResponse();
                    response.setApplyNo(mybankCreditLoanApplyNotifyDomain.getApplyNo());
                    response.setRequestId(mybankCreditLoanApplyNotifyDomain.getRequestId());

                    ResultInfo resultInfo = new ResultInfo();


                    if (e != null) {


                        e.printStackTrace();

                        if (AlipayErrorCode.ILLEGAL_SIGN.getCode().equals(e.getErrCode())) {

                            resultInfo.setResultCode("0007");
                            resultInfo.setRetry(BooleanEnum.FALSE.getCode());
                        } else if (AlipayErrorCode.ILLEGAL_ARGUMENT.getCode()
                            .equals(e.getErrCode())) {

                            resultInfo.setResultCode("0011");
                            resultInfo.setRetry(BooleanEnum.FALSE.getCode());
                        } else if (AlipayErrorCode.DATA_INVALID.getCode().equals(e.getErrCode())) {

                            resultInfo.setResultCode("0011");
                            resultInfo.setRetry(BooleanEnum.FALSE.getCode());
                        } else {

                            resultInfo.setResultCode("9000");
                        }
                        resultInfo.setResultMsg(e.getErrMsg());
                    }


                    resultInfo.setResultCode("0000");
                    resultInfo.setResultMsg("授信申请");
                    response.setResultInfo(resultInfo);

                    return response;
                }
            });

        System.out.println(respXml);
    }
}
