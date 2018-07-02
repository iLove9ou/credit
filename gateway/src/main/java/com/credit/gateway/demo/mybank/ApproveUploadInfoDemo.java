/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package com.credit.gateway.demo.mybank;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alipay.sdk.domain.mybankext.AccumulationFund;
import com.alipay.sdk.domain.mybankext.ClientBaseInfo;
import com.alipay.sdk.domain.mybankext.CooperationBankApproveInfo;
import com.alipay.sdk.domain.mybankext.EducationBackground;
import com.alipay.sdk.domain.mybankext.Operator;
import com.alipay.sdk.domain.mybankext.SocialInsurance;
import com.alipay.sdk.domain.mybankext.StockCustomer;
import com.alipay.sdk.enums.ClientInfoDsEnum;
import com.alipay.sdk.enums.EducationEnum;
import com.alipay.sdk.enums.MarriageStatusEnum;
import com.alipay.sdk.enums.TelecomOperatorEnum;
import com.alipay.sdk.enums.WhetherEnum;


public class ApproveUploadInfoDemo {

    public static void main(String[] args) {

        CooperationBankApproveInfo cooperationBankApproveInfo = new CooperationBankApproveInfo();

        AccumulationFund accumulationFund = new AccumulationFund();
        accumulationFund.setHousingFundAcctOpeningDt(new Date());
        accumulationFund.setHousingFundMonthlyAmt(new BigDecimal(100000));
        accumulationFund.setHousingFundMonthlyAmtLmt(new BigDecimal(500000));
        accumulationFund.setHousingFundQueryDt(new Date());
        accumulationFund.setHousingFundQueryFlag(WhetherEnum.YES.getCode());
        accumulationFund.setHousingFundTotalAmt(new BigDecimal(20000000));
        accumulationFund.setHousingFundTotalAmtLast6m(new BigDecimal(600000));
        accumulationFund.setHousingFundTotalMonthCnt(120);
        accumulationFund.setHousingFundTotalMonthCntLast6m(6);

        cooperationBankApproveInfo.setAccumulationFund(accumulationFund);

        Map<String, double[]> bankEncryptedFeatures = new HashMap<String, double[]>();
        bankEncryptedFeatures.put("feature", new double[]{12.12});

        cooperationBankApproveInfo.setBankEncryptedFeatures(bankEncryptedFeatures);
        cooperationBankApproveInfo.setBankEncryptedMeta("������Ϣ");

        ClientBaseInfo clientBaseInfo = new ClientBaseInfo();
        clientBaseInfo.setBusinessOwnerDs(ClientInfoDsEnum.FILL_IN.getCode());
        clientBaseInfo.setBusinessOwnerIndicator(WhetherEnum.NO.getCode());
        clientBaseInfo.setCompanyName("���㼯�Źɷ����޹�˾");
        clientBaseInfo.setCompanyNameDs(ClientInfoDsEnum.FILL_IN.getCode());
        clientBaseInfo.setEmploymentPosition("employmentPosition");
        clientBaseInfo.setEmploymentPositionDs(ClientInfoDsEnum.FILL_IN.getCode());
        clientBaseInfo.setIndustry("��Ϣ����");
        clientBaseInfo.setIndustryDs(ClientInfoDsEnum.FILL_IN.getCode());
        clientBaseInfo.setMaritalStatus(MarriageStatusEnum.DIVORCED.getCode());
        clientBaseInfo.setMaritalStatusDs(ClientInfoDsEnum.FILL_IN.getCode());
        clientBaseInfo.setPersonalMonthlyIncome(new BigDecimal("2"));
        clientBaseInfo.setPersonalMonthlyIncomeDs(ClientInfoDsEnum.FILL_IN.getCode());
        clientBaseInfo.setWorkYears(10);
        clientBaseInfo.setWorkYearsDs(ClientInfoDsEnum.FILL_IN.getCode());

        cooperationBankApproveInfo.setClientBaseInfo(clientBaseInfo);

        cooperationBankApproveInfo.setComplaintInvolvedIndicator(WhetherEnum.NO.getCode());

        EducationBackground educationBackground = new EducationBackground();
        educationBackground.setEducationDegree(EducationEnum.BACHELOR.getCode());
        educationBackground.setEducationDegreeCategory("����ѧ");
        educationBackground.setEducationDegreeQueryFlag(WhetherEnum.NO.getCode());
        educationBackground.setSchoolEnrollmentYear(new Date());
        educationBackground.setSchoolName("������ѧ");

        cooperationBankApproveInfo.setEducationBackground(educationBackground);
        cooperationBankApproveInfo.setExternalBlacklistIndicator(WhetherEnum.NO.getCode());
        cooperationBankApproveInfo.setInternalBlacklistIndicator(WhetherEnum.NO.getCode());
        cooperationBankApproveInfo.setNciicVerifiedIndicator(WhetherEnum.NO.getCode());

        Operator operator = new Operator();
        operator.setPhoneRegisteredDayCnt(1000000);
        operator.setPhoneTotalBillAmtLast6m(new BigDecimal(1000));
        operator.setPhoneTotalCallDurationHourLast6m(1000);
        operator.setTelecomCarrierIndicator(TelecomOperatorEnum.CHINA_TELECON.getCode());
        operator.setTelecomCarrierQueryFlag(WhetherEnum.NO.getCode());

        cooperationBankApproveInfo.setOperator(operator);

        SocialInsurance socialInsurance = new SocialInsurance();
        socialInsurance.setMedicalInsAcctOpeningDt(new Date());
        socialInsurance.setMedicalInsMonthlyAmt(new BigDecimal(10000));
        socialInsurance.setMedicalInsTotalAmt(new BigDecimal(20000));
        socialInsurance.setMedicalInsTotalAmtLast6m(new BigDecimal(10000));
        socialInsurance.setMedicalInsTotalMonthCnt(100);
        socialInsurance.setMedicalInsTotalMonthCntLast6m(6);
        socialInsurance.setPensionFundAcctOpeningDt(new Date());
        socialInsurance.setPensionFundMonthlyAmt(new BigDecimal(10000));
        socialInsurance.setPensionFundTotalAmt(new BigDecimal(10000));
        socialInsurance.setPensionFundTotalAmtLast6m(new BigDecimal(10000));
        socialInsurance.setPensionFundTotalMonthCnt(100);
        socialInsurance.setPensionFundTotalMonthCntLast6m(100);
        socialInsurance.setSocialSecurityQueryDt(new Date());
        socialInsurance.setSocialSecurityQueryFlag(WhetherEnum.NO.getCode());

        cooperationBankApproveInfo.setSocialInsurance(socialInsurance);

        StockCustomer stockCustomer = new StockCustomer();
        stockCustomer.setBankStmtExpenseAmtLast3m(new BigDecimal(10000));
        stockCustomer.setBankStmtExpenseAmtLast6m(new BigDecimal(20000));
        stockCustomer.setBankStmtIncomeAmtLast3m(new BigDecimal(10000));
        stockCustomer.setBankStmtIncomeAmtLast6m(new BigDecimal(20000));
        stockCustomer.setBusinessLoanBal(new BigDecimal(20000));
        stockCustomer.setCarAssetAmt(new BigDecimal(20000));
        stockCustomer.setCarLoanBal(new BigDecimal(20000));
        stockCustomer.setCreditCardAmt(new BigDecimal(20000));
        stockCustomer.setCreditCardCustIndicator(WhetherEnum.NO.getCode());
        stockCustomer.setCreditCardOweAmt(new BigDecimal(20000));
        stockCustomer.setCustodyCustIndicator(WhetherEnum.NO.getCode());
        stockCustomer.setCustomerIndicator(WhetherEnum.NO.getCode());
        stockCustomer.setDebitCardAvgDailyBalLast3m(new BigDecimal(10000));
        stockCustomer.setDebitCardAvgDailyBalLast6m(new BigDecimal(20000));
        stockCustomer.setDebitCardBal(new BigDecimal(20000));
        stockCustomer.setDebitCardCustIndicator(WhetherEnum.NO.getCode());
        stockCustomer.setFinancingAvgDailyBallast6m(new BigDecimal(20000));
        stockCustomer.setFinancingBal(new BigDecimal(20000));
        stockCustomer.setFinancingCustIndicator(1);
        stockCustomer.setHousingAssetAmt(new BigDecimal(20000));
        stockCustomer.setInsuranceCustIndicator(WhetherEnum.NO.getCode());
        stockCustomer.setLifePaymentCustIndicator(WhetherEnum.YES.getCode());
        stockCustomer.setMortgageBal(new BigDecimal(20000));
        stockCustomer.setPersonalLoanBal(new BigDecimal(20000));
        stockCustomer.setPersonalLoanCustIndicator(WhetherEnum.NO.getCode());
        stockCustomer.setSalaryBizCustIndicator(WhetherEnum.NO.getCode());
        stockCustomer.setSecurityCustIndicator(WhetherEnum.NO.getCode());
        stockCustomer.setSocialSecurityCustIndicator(WhetherEnum.YES.getCode());

        cooperationBankApproveInfo.setStockCustomer(stockCustomer);

        JSON.DEFFAULT_DATE_FORMAT = "yyyy-MM-dd";//�������ڸ�ʽ
        String json = JSON.toJSONString(cooperationBankApproveInfo,
                                        SerializerFeature.DisableCircularReferenceDetect,
                                                SerializerFeature.WriteDateUseDateFormat);

        System.out.println("toJson:" + json);

        CooperationBankApproveInfo parseObject = JSON
                .parseObject(json, CooperationBankApproveInfo.class);
        System.out.println("toObject:" + parseObject);
    }

}
