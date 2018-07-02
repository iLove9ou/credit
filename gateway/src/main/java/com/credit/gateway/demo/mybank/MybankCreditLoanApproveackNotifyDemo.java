/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package com.credit.gateway.demo.mybank;

import com.alipay.sdk.*;
import com.alipay.sdk.domain.MybankCreditLoanApproveackNotifyDomain;
import com.alipay.sdk.enums.BooleanEnum;
import com.alipay.sdk.request.MybankCreditLoanApproveackNotifyRequest;
import com.alipay.sdk.response.MybankCreditLoanApproveackNotifyResponse;
import com.alipay.sdk.response.ResultInfo;
import com.credit.gateway.demo.KeyConstants;

/**
 * ���̴�-������������֪ͨ-DEMO
 * 
 * @author azheng
 * @version $Id: MybankCreditLoanApplyNotifyDemo.java, v 0.1 2018��04��09�� azheng Exp $
 */
public class MybankCreditLoanApproveackNotifyDemo {

    public static void main(String[] args) throws Exception {
        //����XML����
        String requestBody = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><document> <request><head><version>1.0.0</version><appId>MYBANK</appId><function>com.mybank.credit.cooperation.approveack.notify</function><reqTime>20180420174101</reqTime><reqTimeZone>UTC+8</reqTimeZone><reqMsgId>4b98aab0-219f-47cc-ba1c-a9c47ca025111524</reqMsgId><reserve></reserve><signType>RSA</signType><inputCharset>UTF-8</inputCharset></head><body><requestId>226610000051903570072_279e9669f60a55018a9dqq325b3a133f11A</requestId><applyNo>2018041912153220311105551876B</applyNo><certNo>610323196802125512</certNo><certName>Ҷ����</certName><certType>100</certType><platformAccess>Y</platformAccess><platformAdmit>18000000</platformAdmit><platformRateLimit>0.18</platformRateLimit><platformRateBottom>0.108</platformRateBottom><businessModel>MYBK_CREDIT_LOAN</businessModel><extInfo><![CDATA[{\"AUTH_FIN_LAST_3M_CNT\":2,\"OVD_ORDER_CNT_6M\":2,\"HAVE_FANG_FLAG\":1,\"ALI_LAST_6M_TRADE_TOTAL\":5,\"HAVE_CAR_FLAG\":1,\"OVD_ORDER_AMT_6M\":2,\"LAST_6M_AVG_ASSET_TOTAL\":2,\"XFDC_INDEX\":2,\"IS_ZM_ATTENTION_FLAG\":\"Y\",\"ZM_SCORE\":720,\"TOT_PAY_AMT_6M\":2,\"RISK_SEG\":\"A\",\"IS_ZM_FRAUD_FLAG\":\"Y\",\"POSITIVE_BIZ_CNT_1Y\":2,\"REPAYMENT_SEG\":\"B\",\"MOBILE_FIXED_DAYS\":2,\"PERSONAL_CREDIT_REPORT\":{\"creditDebList\":[{\"acType\":\"CNY\",\"assureCode\":\"d\",\"ccy\":\"RMB\",\"closeOffDt\":\"2018-06-01\",\"creditIssueDt\":\"2018-06-01\",\"creditLmt\":120000,\"curOvdAmt\":120000,\"curOvdTerms\":12,\"debCode\":\"���ǿ�\",\"debitDate\":\"2018-06-01\",\"issueOrg\":\"��������\",\"lastPaiedDate\":\"2018-06-01\",\"ovdMfourAmt\":120000,\"repayEndDt\":\"2018-06-01\",\"repayStartDt\":\"2018-06-01\",\"shareAmtLimit\":120000,\"sixmAvgUsed\":120000,\"status\":\"1\",\"status01\":\"Y\",\"status02\":\"Y\",\"status03\":\"Y\",\"status04\":\"Y\",\"status05\":\"Y\",\"status06\":\"Y\",\"status07\":\"Y\",\"status08\":\"Y\",\"status09\":\"Y\",\"status10\":\"Y\",\"status11\":\"Y\",\"status12\":\"Y\",\"status13\":\"Y\",\"status14\":\"Y\",\"status15\":\"Y\",\"status16\":\"Y\",\"status17\":\"Y\",\"status18\":\"Y\",\"status19\":\"Y\",\"status20\":\"Y\",\"status21\":\"Y\",\"status22\":\"Y\",\"status23\":\"Y\",\"status24\":\"Y\",\"thisMonPaied\":120000,\"thisMonSudpay\":120000,\"updateDt\":\"2018-06-01\",\"usedAmt\":120000,\"usedAmtMax\":120000},{\"acType\":\"USD\",\"assureCode\":\"d\",\"ccy\":\"DOLLAR\",\"closeOffDt\":\"2018-06-01\",\"creditIssueDt\":\"2018-06-01\",\"creditLmt\":120000,\"curOvdAmt\":120000,\"curOvdTerms\":12,\"debCode\":\"���ǿ�\",\"debitDate\":\"2018-06-01\",\"issueOrg\":\"��������\",\"lastPaiedDate\":\"2018-06-01\",\"ovdMfourAmt\":120000,\"repayEndDt\":\"2018-06-01\",\"repayStartDt\":\"2018-06-01\",\"shareAmtLimit\":120000,\"sixmAvgUsed\":120000,\"status\":\"1\",\"status01\":\"Y\",\"status02\":\"Y\",\"status03\":\"Y\",\"status04\":\"Y\",\"status05\":\"Y\",\"status06\":\"Y\",\"status07\":\"Y\",\"status08\":\"Y\",\"status09\":\"Y\",\"status10\":\"Y\",\"status11\":\"Y\",\"status12\":\"Y\",\"status13\":\"Y\",\"status14\":\"Y\",\"status15\":\"Y\",\"status16\":\"Y\",\"status17\":\"Y\",\"status18\":\"Y\",\"status19\":\"Y\",\"status20\":\"Y\",\"status21\":\"Y\",\"status22\":\"Y\",\"status23\":\"Y\",\"status24\":\"Y\",\"thisMonPaied\":120000,\"thisMonSudpay\":120000,\"updateDt\":\"2018-06-01\",\"usedAmt\":120000,\"usedAmtMax\":120000}],\"creditResult\":{\"applyId\":\"789456\",\"certNo\":\"411381199209044411\",\"idCode\":\"15\",\"name\":\"��ٻ\",\"orgCode\":\"1234\",\"queryDate\":\"2018-06-01\",\"reportDate\":\"2018-06-01\",\"reportId\":\"123\"},\"creditResum\":{\"cardMaxOvdBal\":120000,\"cardMaxOvdMonth\":12,\"cardOvdAcCnt\":12,\"cardOvdMonth\":12,\"creditQueryCnt\":6,\"creditQueryOrgs\":2,\"loanMaxOvdMonth\":6,\"loanOvdCnt\":6,\"loanOvdMaxBal\":120000,\"loanOvdMonths\":12,\"loanQueryCnt\":2,\"loanQueryOrgs\":12,\"preCardMaxOvdBal\":120000,\"preCardMaxOvdMonth\":12,\"preCardOvdAcCnt\":6,\"preCardOvdMonth\":6,\"yearAfloanManage\":6,\"yearAssureAppro\":6,\"yearNameAppro\":6},\"endowmentInfo\":{\"companyName\":\"��·\",\"curPayAmt\":120000,\"dataUpdateDt\":\"2018-06-01\",\"joinArea\":\"����\",\"monthTotal\":12,\"openDt\":\"2018-06-01\",\"personPayBase\":120000,\"startWorkDate\":\"2018-06-01\",\"status\":\"NORMAL\",\"stopReason\":\"δ֪\"},\"entityDebInfoList\":[{\"amt\":120000,\"assetClass\":\"A\",\"assuAmt\":120000,\"assureCode\":\"COMPOSE_EXCLUDE\",\"bal\":120000,\"ccy\":\"RMB\",\"curOvdTerms\":66,\"dataUpdateDt\":\"2018-06-01\",\"debCode\":\"2\",\"debExpireDt\":\"2018-06-01\",\"debOrgName\":\"����\",\"debPred\":36,\"debStartDt\":\"2018-06-01\",\"debUseCode\":\"COLLEGE_FUND\",\"lastPaiedDt\":\"2018-06-01\",\"leftPayTerms\":12,\"ovdAmt1\":120000,\"ovdAmt2\":120000,\"ovdAmt3\":120000,\"ovdAmt4\":120000,\"ovdAmt5\":120000,\"payCode\":\"HALF_YEAR\",\"payValueAmt\":120000,\"repayEndDt\":\"2018-06-01\",\"repayStartDt\":\"2018-06-01\",\"seq\":6055,\"settleDt\":\"2018-06-01\",\"shouldPayDt\":\"2018-06-01\",\"status\":\"2\",\"status01\":\"Y\",\"status02\":\"Y\",\"status03\":\"Y\",\"status04\":\"Y\",\"status05\":\"Y\",\"status06\":\"Y\",\"status07\":\"Y\",\"status08\":\"Y\",\"status09\":\"Y\",\"status10\":\"Y\",\"status11\":\"Y\",\"status12\":\"Y\",\"status13\":\"Y\",\"status14\":\"Y\",\"status15\":\"Y\",\"status16\":\"Y\",\"status17\":\"Y\",\"status18\":\"Y\",\"status19\":\"Y\",\"status20\":\"Y\",\"status21\":\"Y\",\"status22\":\"Y\",\"status23\":\"Y\",\"status24\":\"Y\",\"thisMonPaied\":120000,\"thisMonSudPay\":120000},{\"amt\":120000,\"assetClass\":\"B\",\"assuAmt\":120000,\"assureCode\":\"COMPOSE_INCLUDE\",\"bal\":120000,\"ccy\":\"DOLLAR\",\"curOvdTerms\":7,\"dataUpdateDt\":\"2018-06-01\",\"debCode\":\"8\",\"debExpireDt\":\"2018-06-01\",\"debOrgName\":\"֧����\",\"debPred\":36,\"debStartDt\":\"2018-06-01\",\"debUseCode\":\"COMSUMPTION_LOAN\",\"lastPaiedDt\":\"2018-06-01\",\"leftPayTerms\":12,\"ovdAmt1\":120000,\"ovdAmt2\":120000,\"ovdAmt3\":120000,\"ovdAmt4\":120000,\"ovdAmt5\":120000,\"payCode\":\"HALF_YEAR\",\"payValueAmt\":120000,\"repayEndDt\":\"2018-06-01\",\"repayStartDt\":\"2018-06-01\",\"seq\":1024,\"settleDt\":\"2018-06-01\",\"shouldPayDt\":\"2018-06-01\",\"status\":\"2\",\"status01\":\"Y\",\"status02\":\"Y\",\"status03\":\"Y\",\"status04\":\"Y\",\"status05\":\"Y\",\"status06\":\"Y\",\"status07\":\"Y\",\"status08\":\"Y\",\"status09\":\"Y\",\"status10\":\"Y\",\"status11\":\"Y\",\"status12\":\"Y\",\"status13\":\"Y\",\"status14\":\"Y\",\"status15\":\"Y\",\"status16\":\"Y\",\"status17\":\"Y\",\"status18\":\"Y\",\"status19\":\"Y\",\"status20\":\"Y\",\"status21\":\"Y\",\"status22\":\"Y\",\"status23\":\"Y\",\"status24\":\"Y\",\"thisMonPaied\":120000,\"thisMonSudPay\":120000}],\"entityDebResList\":[{\"avgRepayAmt\":120000,\"bal\":120000,\"cnt\":6,\"debCode\":\"����\",\"issueOrgCnt\":6,\"maxLmtPerOrg\":170000,\"minLmtPerOrg\":170000,\"orgCnt\":6,\"totalLmt\":170000,\"usedLmt\":170000},{\"avgRepayAmt\":160000,\"bal\":160000,\"cnt\":7,\"debCode\":\"δ�������\",\"issueOrgCnt\":6,\"maxLmtPerOrg\":120000,\"minLmtPerOrg\":120000,\"orgCnt\":8,\"totalLmt\":120000,\"usedLmt\":120000}],\"houseInfo\":{\"companyName\":\"����Ͱ�\",\"companyPayPer\":120000,\"firstPayMonth\":\"6\",\"joinArea\":\"�㽭\",\"monthPayAmt\":120000,\"openDate\":\"2018-06-01\",\"personPayPer\":120000,\"status\":\"2\",\"toPayMonth\":\"12\"},\"person\":{\"genderCode\":\"MALE\",\"highestEduCode\":\"MASTER_ABOVE\",\"maritalStCode\":\"MARRIED\"},\"reportLogDetailList\":[{\"queryCause\":\"01\",\"queryDt\":\"2018-06-01\"},{\"queryCause\":\"02\",\"queryDt\":\"2018-06-01\"}],\"workInfoList\":[{\"occpCode\":\"��ʦ\",\"trdCode\":\"����\"},{\"occpCode\":\"����Ա\",\"trdCode\":\"����\"}]},\"AUTH_FIN_LAST_1M_CNT\":2,\"AUTH_FIN_LAST_6M_CNT\":2,\"ADR_STABILITY_DAYS\":2}]]></extInfo></body></request>    <signature>Vx2UBJpOAF6v+O1iedwV8GlmdlKzLlQrPvHVspUWIzOH5EidBlqLPk2XHrU97LUvY+jnK5pwIJPn1OpclIkddLVPTj9HGgkN9/I4H/FrfMEbbAjIBbPd9AxXDoUa6RqfpJcMSeEqQuSflRrBQeYyf5Xwkzx8py/cX7Qt2vwVVR8H5wZs7W9CEtpVG7jrVtOWLv8aNUhm2jAUb/CnkQJrpZbyA6YnZTEIkiYP2GCKcOqU5P8Hy7czAbOWbxg556R7rnBmop4aAUTRWgtWRftOtIp7MudyWYLVfCr+z4YiMLn0oXyVVO0w32Mg0naTWG8VV8mOSrJ8Y5NpTQ2O7aoNfg==</signature></document>";

        //���Ĵ���ģ��(appId,����˽Կ,���̹�Կ)
        AlipayTemplate template = new DefaultAlipayTemplate("MYBANK85", KeyConstants.privateKey,
            KeyConstants.alipayPublicKey);

        //���ͱ������󲢻�ȡ��ִ����
        String respXml = template.execute(requestBody,
            MybankCreditLoanApproveackNotifyRequest.class,
            new AlipayCallback<MybankCreditLoanApproveackNotifyDomain, MybankCreditLoanApproveackNotifyResponse>() {
                public MybankCreditLoanApproveackNotifyResponse process(ParametersHolder<MybankCreditLoanApproveackNotifyDomain> parametersHolder,
                                                                        AlipayApiException e) {
                    //1.ҵ���������
                    MybankCreditLoanApproveackNotifyDomain mybankCreditLoanApproveackNotifyDomain = parametersHolder
                        .getBody();
                    System.out.println(mybankCreditLoanApproveackNotifyDomain);

                    //2.��װ��ִ���Ķ���
                    MybankCreditLoanApproveackNotifyResponse response = new MybankCreditLoanApproveackNotifyResponse();
                    response.setApplyNo(mybankCreditLoanApproveackNotifyDomain.getApplyNo());
                    response.setRequestId(mybankCreditLoanApproveackNotifyDomain.getRequestId());
                    ResultInfo resultInfo = new ResultInfo();

                    //3.�����쳣
                    if (e != null) {

                        //LOGGER.error(e.getErrMsg(), e);
                        e.printStackTrace();

                        if (AlipayErrorCode.ILLEGAL_SIGN.getCode().equals(e.getErrCode())) {
                            //��ǩ����
                            resultInfo.setResultCode("0007");
                            resultInfo.setRetry(BooleanEnum.FALSE.getCode());
                        } else if (AlipayErrorCode.ILLEGAL_ARGUMENT.getCode()
                            .equals(e.getErrCode())) {
                            //�Ƿ�����
                            resultInfo.setResultCode("0011");
                            resultInfo.setRetry(BooleanEnum.FALSE.getCode());
                        } else if (AlipayErrorCode.DATA_INVALID.getCode().equals(e.getErrCode())) {
                            //����У��ʧ��
                            resultInfo.setResultCode("0011");
                            resultInfo.setRetry(BooleanEnum.FALSE.getCode());
                        } else {
                            //Ĭ��
                            resultInfo.setResultCode("9000");
                        }
                        resultInfo.setResultMsg(e.getErrMsg());
                    }

                    //TODO
                    //4.����ҵ���� Begin
                    //some business process
                    //����ҵ���� END

                    resultInfo.setResultCode("0000");
                    resultInfo.setResultMsg("����ɹ�");
                    response.setResultInfo(resultInfo);

                    return response;
                }
            });

        System.out.println(respXml);
    }
}
