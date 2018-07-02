/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package com.credit.gateway.demo.mybank;

import com.alipay.sdk.*;
import com.alipay.sdk.domain.MybankCreditLoanApproveUploadDomain;
import com.alipay.sdk.request.MybankCreditLoanApproveUploadRequest;
import com.credit.gateway.demo.KeyConstants;

/**
 * ���̴�-���ų��������ϴ�
 *
 * @author azheng
 * @version $Id: MybankCreditLoanApproveUploadDemo.java, v 0.1 2018-04-09 azheng Exp $
 */
public class MybankCreditLoanApproveUploadDemo {

    public static void main(String[] args) throws Exception {

        //1.TODO ҵ����

        AlipayTemplate template = new DefaultAlipayTemplate("HNXT85", KeyConstants.privateKey,
            KeyConstants.alipayPublicKey);

        //2.���ñ��Ķ���
        MybankCreditLoanApproveUploadRequest request = new MybankCreditLoanApproveUploadRequest();
        MybankCreditLoanApproveUploadDomain bizMode = new MybankCreditLoanApproveUploadDomain();

        //3.���ñ�������
        bizMode.setRequestId("226610000060877649646_5eef12f75a2849768aba2dc71bfb017c26A");
        bizMode.setApplyNo("2018040910102500100370115426B");
        bizMode.setCertName("������");
        bizMode.setCertNo("412223197311033616");
        bizMode.setCategory("COOPERATION_BANK_APPROVE_INFO");//��������
        bizMode.setObjectContent(
            "{\"accumulationFund\":{\"housingFundAcctOpeningDt\":\"2018-10-10\",\"housingFundMonthlyAmt\":100000,\"housingFundMonthlyAmtLmt\":500000,\"housingFundQueryDt\":\"2017-10-01\",\"housingFundQueryFlag\":1,\"housingFundTotalAmt\":20000000,\"housingFundTotalAmtLast6m\":600000,\"housingFundTotalMonthCnt\":120,\"housingFundTotalMonthCntLast6m\":6},\"bankEncryptedFeatures\":{\"key2\":[0.3,0.4],\"key1\":[0.1,0.2]},\"bankEncryptedMeta\":\"������Ϣ\",\"clientBaseInfo\":{\"businessOwnerDs\":\"2\",\"businessOwnerIndicator\":\"1\",\"companyName\":\"���㼯�Źɷ����޹�˾\",\"companyNameDs\":\"2\",\"employmentPosition\":\"���ž���\",\"employmentPositionDs\":\"2\",\"industry\":\"��Ϣ����\",\"industryDs\":\"1\",\"maritalStatus\":\"2\",\"maritalStatusDs\":\"2\",\"personalMonthlyIncome\":100000000,\"personalMonthlyIncomeDs\":\"2\",\"workYears\":10,\"workYearsDs\":\"2\"},\"complaintInvolvedIndicator\":\"0\",\"educationBackground\":{\"educationDegree\":\"BACHELOR\",\"educationDegreeCategory\":\"����ѧ\",\"educationDegreeQueryFlag\":\"1\",\"schoolEnrollmentYear\":1520578724771,\"schoolName\":\"������ѧ\"},\"externalBlacklistIndicator\":\"0\",\"internalBlacklistIndicator\":\"0\",\"nciicVerifiedIndicator\":\"1\",\"operator\":{\"phoneRegisteredDayCnt\":1000000,\"phoneTotalBillAmtLast6m\":1000,\"phoneTotalCallDurationHourLast6m\":100000,\"telecomCarrierIndicator\":\"YIDONG\",\"telecomCarrierQueryFlag\":\"1\"},\"socialInsurance\":{\"medicalInsAcctOpeningDt\":\"2017-10-01\",\"medicalInsMonthlyAmt\":10000,\"medicalInsTotalAmt\":2000000,\"medicalInsTotalAmtLast6m\":100000,\"medicalInsTotalMonthCnt\":100,\"medicalInsTotalMonthCntLast6m\":6,\"pensionFundAcctOpeningDt\":\"2017-10-01\",\"pensionFundMonthlyAmt\":100000,\"pensionFundTotalAmt\":10000000,\"pensionFundTotalAmtLast6m\":600000,\"pensionFundTotalMonthCnt\":100},\"stockCustomer\":{\"bankStmtExpenseAmtLast3m\":1000000,\"bankStmtExpenseAmtLast6m\":2000000,\"bankStmtIncomeAmtLast3m\":1000000,\"bankStmtIncomeAmtLast6m\":1000000,\"businessLoanBal\":100000000,\"carAssetAmt\":10000000,\"carLoanBal\":1000000,\"creditCardAmt\":10000000,\"creditCardCustIndicator\":\"1\",\"creditCardOweAmt\":1000000,\"custodyCustIndicator\":0,\"customerIndicator\":1,\"debitCardAvgDailyBalLast3m\":10000000,\"debitCardAvgDailyBalLast6m\":15000000,\"debitCardBal\":10000000,\"debitCardCustIndicator\":\"1\",\"financingAvgDailyBallast6m\":10000000,\"financingBal\":10000000,\"financingCustIndicator\":1,\"housingAssetAmt\":100000000,\"insuranceCustIndicator\":\"1\",\"lifePaymentCustIndicator\":\"1\",\"mortgageBal\":10000000,\"personalLoanBal\":10000000,\"personalLoanCustIndicator\":\"1\",\"salaryBizCustIndicator\":\"1\",\"securityCustIndicator\":\"1\",\"socialSecurityCustIndicator\":\"1\"}}");
        request.setBizModel(bizMode);

        //3.ִ�з��ͱ���
        try {
            ParametersHolder execute = template
                .execute("http://supergwext-1-64.test.dl.alipaydev.com/HNXT85/HNXT8579142.htm", request);

            //LOGGER.info(execute.getBody());

        } catch (AlipayApiException e) {
            e.printStackTrace();
            if (AlipayErrorCode.ILLEGAL_SIGN.getCode().equals(e.getErrCode())) {
                //��ǩ���� ������
                //LOGGER.debug(result.getSignItem().getSign());
            } else if (AlipayErrorCode.ILLEGAL_ARGUMENT.getCode().equals(e.getErrCode())) {
                //�Ƿ�����
            } else if (AlipayErrorCode.DATA_INVALID.getCode().equals(e.getErrCode())) {
                //����У��ʧ��
                //} else if (..������Ҫ���⴦��Ĵ�����..) {
                //......
            } else {
                if (e.isRetry()) {
                    //�ط�
                }
            }
        }
    }

}