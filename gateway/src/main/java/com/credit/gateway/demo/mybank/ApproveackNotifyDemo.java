/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package com.credit.gateway.demo.mybank;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alipay.sdk.domain.mybankext.creditdata.CreditDeb;
import com.alipay.sdk.domain.mybankext.creditdata.CreditResult;
import com.alipay.sdk.domain.mybankext.creditdata.CreditResum;
import com.alipay.sdk.domain.mybankext.creditdata.EndowmentInfo;
import com.alipay.sdk.domain.mybankext.creditdata.EntityDebInfo;
import com.alipay.sdk.domain.mybankext.creditdata.EntityDebRes;
import com.alipay.sdk.domain.mybankext.creditdata.HouseInfo;
import com.alipay.sdk.domain.mybankext.creditdata.Person;
import com.alipay.sdk.domain.mybankext.creditdata.PersonalCreditReport;
import com.alipay.sdk.domain.mybankext.creditdata.ReportLogDetail;
import com.alipay.sdk.domain.mybankext.creditdata.WorkInfo;
import com.alipay.sdk.enums.AssureCodeEnum;
import com.alipay.sdk.enums.DebUseCodeEnum;
import com.alipay.sdk.enums.EndowmentStatusEnum;
import com.alipay.sdk.enums.PayCodeEnum;
import com.alipay.sdk.enums.StatusEnum;
import com.alipay.sdk.enums.WhetherEnum;


public class ApproveackNotifyDemo {

    public static void main(String[] args) {

        CreditResult creditResult = new CreditResult();
        creditResult.setApplyId("789456");
        creditResult.setCertNo("411381199209044411");
        creditResult.setIdCode("15");
        creditResult.setName(" 我的家乡 ");
        creditResult.setOrgCode("1234");
        creditResult.setQueryDate(new Date());
        creditResult.setReportDate(new Date());
        creditResult.setReportId("123");

        CreditResum creditResum = new CreditResum();
        creditResum.setCardMaxOvdBal(new BigDecimal(120000));
        creditResum.setCardMaxOvdMonth(12);
        creditResum.setCardOvdAcCnt(12);
        creditResum.setCreditQueryCnt(6);
        creditResum.setCardOvdMonth(12);
        creditResum.setCreditQueryOrgs(2);
        creditResum.setLoanMaxOvdMonth(6);
        creditResum.setLoanOvdCnt(6);
        creditResum.setLoanOvdMaxBal(new BigDecimal(120000));
        creditResum.setLoanOvdMonths(12);
        creditResum.setLoanQueryCnt(2);
        creditResum.setLoanQueryOrgs(12);
        creditResum.setPreCardMaxOvdBal(new BigDecimal(120000));
        creditResum.setPreCardMaxOvdMonth(12);
        creditResum.setPreCardOvdAcCnt(6);
        creditResum.setPreCardOvdMonth(6);
        creditResum.setYearAfloanManage(6);
        creditResum.setYearAssureAppro(6);
        creditResum.setYearNameAppro(6);

        HouseInfo houseInfo = new HouseInfo();
        houseInfo.setCompanyName("新浪杭州");
        houseInfo.setCompanyPayPer(new BigDecimal(120000));
        houseInfo.setFirstPayMonth("6");
        houseInfo.setJoinArea("新浪");
        houseInfo.setMonthPayAmt(new BigDecimal(120000));
        houseInfo.setOpenDate(new Date());
        houseInfo.setPersonPayPer(new BigDecimal(120000));
        houseInfo.setStatus(StatusEnum.UNACTIVE.getCode());
        houseInfo.setToPayMonth("12");

        EndowmentInfo endowmentInfo = new EndowmentInfo();
        endowmentInfo.setCompanyName(" code ");
        endowmentInfo.setDataUpdateDt(new Date());
        endowmentInfo.setCurPayAmt(new BigDecimal(120000));
        endowmentInfo.setJoinArea(" code ");
        endowmentInfo.setMonthTotal(12);
        endowmentInfo.setOpenDt(new Date());
        endowmentInfo.setPersonPayBase(new BigDecimal(120000));
        endowmentInfo.setStartWorkDate(new Date());
        endowmentInfo.setStatus(EndowmentStatusEnum.NORMAL.getCode());
        endowmentInfo.setStopReason("δ֪");

        List<EntityDebRes> entityDebResList = new ArrayList<EntityDebRes>();
        EntityDebRes entityDebRes = new EntityDebRes();
        entityDebRes.setAvgRepayAmt(new BigDecimal(120000));
        entityDebRes.setBal(new BigDecimal(120000));
        entityDebRes.setCnt(6);
        entityDebRes.setDebCode(" code ");
        entityDebRes.setIssueOrgCnt(6);
        entityDebRes.setMaxLmtPerOrg(new BigDecimal(170000));
        entityDebRes.setMinLmtPerOrg(new BigDecimal(170000));
        entityDebRes.setOrgCnt(6);
        entityDebRes.setTotalLmt(new BigDecimal(170000));
        entityDebRes.setUsedLmt(new BigDecimal(170000));
        entityDebResList.add(entityDebRes);

        EntityDebRes entityDebRes2 = new EntityDebRes();
        entityDebRes2.setAvgRepayAmt(new BigDecimal(160000));
        entityDebRes2.setBal(new BigDecimal(160000));
        entityDebRes2.setCnt(7);
        entityDebRes2.setDebCode(" code ");
        entityDebRes2.setIssueOrgCnt(6);
        entityDebRes2.setMaxLmtPerOrg(new BigDecimal(120000));
        entityDebRes2.setMinLmtPerOrg(new BigDecimal(120000));
        entityDebRes2.setOrgCnt(8);
        entityDebRes2.setTotalLmt(new BigDecimal(120000));
        entityDebRes2.setUsedLmt(new BigDecimal(120000));
        entityDebResList.add(entityDebRes2);

        List<CreditDeb> creditDebList = new ArrayList<CreditDeb>();

        CreditDeb creditDeb = new CreditDeb();
        creditDeb.setAcType("CNY");
        creditDeb.setAssureCode("d");
        creditDeb.setCcy("RMB");
        creditDeb.setCloseOffDt(new Date());
        creditDeb.setCreditIssueDt(new Date());
        creditDeb.setCreditLmt(new BigDecimal(120000));
        creditDeb.setCurOvdAmt(new BigDecimal(120000));
        creditDeb.setLastPaiedDate(new Date());
        creditDeb.setCurOvdTerms(12);
        creditDeb.setDebCode(" ");
        creditDeb.setDebitDate(new Date());
        creditDeb.setIssueOrg(" ");
        creditDeb.setOvdMfourAmt(new BigDecimal(120000));
        creditDeb.setRepayEndDt(new Date());
        creditDeb.setRepayStartDt(new Date());
        creditDeb.setShareAmtLimit(new BigDecimal(120000));
        creditDeb.setSixmAvgUsed(new BigDecimal(120000));
        creditDeb.setStatus(StatusEnum.ACTIVE.getCode());
        creditDeb.setThisMonPaied(new BigDecimal(120000));
        creditDeb.setThisMonSudpay(new BigDecimal(120000));
        creditDeb.setUpdateDt(new Date());
        creditDeb.setUsedAmt(new BigDecimal(120000));
        creditDeb.setUsedAmtMax(new BigDecimal(120000));
        creditDeb.setStatus01(WhetherEnum.YES.getFlag());
        creditDeb.setStatus02(WhetherEnum.YES.getFlag());
        creditDeb.setStatus03(WhetherEnum.YES.getFlag());
        creditDeb.setStatus04(WhetherEnum.YES.getFlag());
        creditDeb.setStatus05(WhetherEnum.YES.getFlag());
        creditDeb.setStatus06(WhetherEnum.YES.getFlag());
        creditDeb.setStatus07(WhetherEnum.YES.getFlag());
        creditDeb.setStatus08(WhetherEnum.YES.getFlag());
        creditDeb.setStatus09(WhetherEnum.YES.getFlag());
        creditDeb.setStatus10(WhetherEnum.YES.getFlag());
        creditDeb.setStatus11(WhetherEnum.YES.getFlag());
        creditDeb.setStatus12(WhetherEnum.YES.getFlag());
        creditDeb.setStatus13(WhetherEnum.YES.getFlag());
        creditDeb.setStatus14(WhetherEnum.YES.getFlag());
        creditDeb.setStatus15(WhetherEnum.YES.getFlag());
        creditDeb.setStatus16(WhetherEnum.YES.getFlag());
        creditDeb.setStatus17(WhetherEnum.YES.getFlag());
        creditDeb.setStatus18(WhetherEnum.YES.getFlag());
        creditDeb.setStatus19(WhetherEnum.YES.getFlag());
        creditDeb.setStatus20(WhetherEnum.YES.getFlag());
        creditDeb.setStatus21(WhetherEnum.YES.getFlag());
        creditDeb.setStatus22(WhetherEnum.YES.getFlag());
        creditDeb.setStatus23(WhetherEnum.YES.getFlag());
        creditDeb.setStatus24(WhetherEnum.YES.getFlag());
        creditDebList.add(creditDeb);

        CreditDeb creditDeb2 = new CreditDeb();
        creditDeb2.setAcType("USD");
        creditDeb2.setAssureCode("d");
        creditDeb2.setCcy("DOLLAR");
        creditDeb2.setCloseOffDt(new Date());
        creditDeb2.setCreditIssueDt(new Date());
        creditDeb2.setCreditLmt(new BigDecimal(120000));
        creditDeb2.setCurOvdAmt(new BigDecimal(120000));
        creditDeb2.setLastPaiedDate(new Date());
        creditDeb2.setCurOvdTerms(12);
        creditDeb2.setDebCode(" deb code ");
        creditDeb2.setDebitDate(new Date());
        creditDeb2.setIssueOrg(" ");
        creditDeb2.setOvdMfourAmt(new BigDecimal(120000));
        creditDeb2.setRepayEndDt(new Date());
        creditDeb2.setRepayStartDt(new Date());
        creditDeb2.setShareAmtLimit(new BigDecimal(120000));
        creditDeb2.setSixmAvgUsed(new BigDecimal(120000));
        creditDeb2.setStatus(StatusEnum.ACTIVE.getCode());
        creditDeb2.setThisMonPaied(new BigDecimal(120000));
        creditDeb2.setThisMonSudpay(new BigDecimal(120000));
        creditDeb2.setUpdateDt(new Date());
        creditDeb2.setUsedAmt(new BigDecimal(120000));
        creditDeb2.setUsedAmtMax(new BigDecimal(120000));
        creditDeb2.setStatus01(WhetherEnum.YES.getFlag());
        creditDeb2.setStatus02(WhetherEnum.YES.getFlag());
        creditDeb2.setStatus03(WhetherEnum.YES.getFlag());
        creditDeb2.setStatus04(WhetherEnum.YES.getFlag());
        creditDeb2.setStatus05(WhetherEnum.YES.getFlag());
        creditDeb2.setStatus06(WhetherEnum.YES.getFlag());
        creditDeb2.setStatus07(WhetherEnum.YES.getFlag());
        creditDeb2.setStatus08(WhetherEnum.YES.getFlag());
        creditDeb2.setStatus09(WhetherEnum.YES.getFlag());
        creditDeb2.setStatus10(WhetherEnum.YES.getFlag());
        creditDeb2.setStatus11(WhetherEnum.YES.getFlag());
        creditDeb2.setStatus12(WhetherEnum.YES.getFlag());
        creditDeb2.setStatus13(WhetherEnum.YES.getFlag());
        creditDeb2.setStatus14(WhetherEnum.YES.getFlag());
        creditDeb2.setStatus15(WhetherEnum.YES.getFlag());
        creditDeb2.setStatus16(WhetherEnum.YES.getFlag());
        creditDeb2.setStatus17(WhetherEnum.YES.getFlag());
        creditDeb2.setStatus18(WhetherEnum.YES.getFlag());
        creditDeb2.setStatus19(WhetherEnum.YES.getFlag());
        creditDeb2.setStatus20(WhetherEnum.YES.getFlag());
        creditDeb2.setStatus21(WhetherEnum.YES.getFlag());
        creditDeb2.setStatus22(WhetherEnum.YES.getFlag());
        creditDeb2.setStatus23(WhetherEnum.YES.getFlag());
        creditDeb2.setStatus24(WhetherEnum.YES.getFlag());
        creditDebList.add(creditDeb2);

        List<EntityDebInfo> entityDebInfoList = new ArrayList<EntityDebInfo>();

        EntityDebInfo entityDebInfo = new EntityDebInfo();
        entityDebInfo.setAmt(new BigDecimal(120000));
        entityDebInfo.setAssetClass("A");
        entityDebInfo.setAssuAmt(new BigDecimal(120000));
        entityDebInfo.setAssureCode(AssureCodeEnum.COMPOSE_EXCLUDE.getCode());
        entityDebInfo.setBal(new BigDecimal(120000));
        entityDebInfo.setCcy("RMB");
        entityDebInfo.setPayCode(PayCodeEnum.HALF_YEAR.getCode());
        entityDebInfo.setCurOvdTerms(66);
        entityDebInfo.setDataUpdateDt(new Date());
        entityDebInfo.setDebUseCode(DebUseCodeEnum.COLLEGE_FUND.getCode());
        entityDebInfo.setDebCode("2");
        entityDebInfo.setDebExpireDt(new Date());
        entityDebInfo.setDebOrgName(" ");
        entityDebInfo.setDebPred(36);
        entityDebInfo.setDebStartDt(new Date());
        entityDebInfo.setLastPaiedDt(new Date());
        entityDebInfo.setLeftPayTerms(12);
        entityDebInfo.setOvdAmt1(new BigDecimal(120000));
        entityDebInfo.setOvdAmt2(new BigDecimal(120000));
        entityDebInfo.setOvdAmt3(new BigDecimal(120000));
        entityDebInfo.setOvdAmt4(new BigDecimal(120000));
        entityDebInfo.setOvdAmt5(new BigDecimal(120000));
        entityDebInfo.setPayValueAmt(new BigDecimal(120000));
        entityDebInfo.setRepayEndDt(new Date());
        entityDebInfo.setRepayStartDt(new Date());
        entityDebInfo.setSeq(6055L);
        entityDebInfo.setSettleDt(new Date());
        entityDebInfo.setShouldPayDt(new Date());
        entityDebInfo.setStatus(StatusEnum.UNACTIVE.getCode());
        entityDebInfo.setThisMonPaied(new BigDecimal(120000));
        entityDebInfo.setThisMonSudPay(new BigDecimal(120000));
        entityDebInfo.setStatus01(WhetherEnum.YES.getFlag());
        entityDebInfo.setStatus02(WhetherEnum.YES.getFlag());
        entityDebInfo.setStatus03(WhetherEnum.YES.getFlag());
        entityDebInfo.setStatus04(WhetherEnum.YES.getFlag());
        entityDebInfo.setStatus05(WhetherEnum.YES.getFlag());
        entityDebInfo.setStatus06(WhetherEnum.YES.getFlag());
        entityDebInfo.setStatus07(WhetherEnum.YES.getFlag());
        entityDebInfo.setStatus08(WhetherEnum.YES.getFlag());
        entityDebInfo.setStatus09(WhetherEnum.YES.getFlag());
        entityDebInfo.setStatus10(WhetherEnum.YES.getFlag());
        entityDebInfo.setStatus11(WhetherEnum.YES.getFlag());
        entityDebInfo.setStatus12(WhetherEnum.YES.getFlag());
        entityDebInfo.setStatus13(WhetherEnum.YES.getFlag());
        entityDebInfo.setStatus14(WhetherEnum.YES.getFlag());
        entityDebInfo.setStatus15(WhetherEnum.YES.getFlag());
        entityDebInfo.setStatus16(WhetherEnum.YES.getFlag());
        entityDebInfo.setStatus17(WhetherEnum.YES.getFlag());
        entityDebInfo.setStatus18(WhetherEnum.YES.getFlag());
        entityDebInfo.setStatus19(WhetherEnum.YES.getFlag());
        entityDebInfo.setStatus20(WhetherEnum.YES.getFlag());
        entityDebInfo.setStatus21(WhetherEnum.YES.getFlag());
        entityDebInfo.setStatus22(WhetherEnum.YES.getFlag());
        entityDebInfo.setStatus23(WhetherEnum.YES.getFlag());
        entityDebInfo.setStatus24(WhetherEnum.YES.getFlag());
        entityDebInfoList.add(entityDebInfo);

        EntityDebInfo entityDebInfo2 = new EntityDebInfo();
        entityDebInfo2.setAmt(new BigDecimal(120000));
        entityDebInfo2.setAssetClass("B");
        entityDebInfo2.setAssuAmt(new BigDecimal(120000));
        entityDebInfo2.setAssureCode(AssureCodeEnum.COMPOSE_INCLUDE.getCode());
        entityDebInfo2.setBal(new BigDecimal(120000));
        entityDebInfo2.setCcy("DOLLAR");
        entityDebInfo2.setPayCode(PayCodeEnum.HALF_YEAR.getCode());
        entityDebInfo2.setCurOvdTerms(7);
        entityDebInfo2.setDataUpdateDt(new Date());
        entityDebInfo2.setDebUseCode(DebUseCodeEnum.COMSUMPTION_LOAN.getCode());
        entityDebInfo2.setDebCode("8");
        entityDebInfo2.setDebExpireDt(new Date());
        entityDebInfo2.setDebOrgName(" 新浪杭州 ");
        entityDebInfo2.setDebPred(36);
        entityDebInfo2.setDebStartDt(new Date());
        entityDebInfo2.setLastPaiedDt(new Date());
        entityDebInfo2.setLeftPayTerms(12);
        entityDebInfo2.setOvdAmt1(new BigDecimal(120000));
        entityDebInfo2.setOvdAmt2(new BigDecimal(120000));
        entityDebInfo2.setOvdAmt3(new BigDecimal(120000));
        entityDebInfo2.setOvdAmt4(new BigDecimal(120000));
        entityDebInfo2.setOvdAmt5(new BigDecimal(120000));
        entityDebInfo2.setPayValueAmt(new BigDecimal(120000));
        entityDebInfo2.setRepayEndDt(new Date());
        entityDebInfo2.setRepayStartDt(new Date());
        entityDebInfo2.setSeq(1024L);
        entityDebInfo2.setSettleDt(new Date());
        entityDebInfo2.setShouldPayDt(new Date());
        entityDebInfo2.setStatus(StatusEnum.UNACTIVE.getCode());
        entityDebInfo2.setThisMonPaied(new BigDecimal(120000));
        entityDebInfo2.setThisMonSudPay(new BigDecimal(120000));
        entityDebInfo2.setStatus01(WhetherEnum.YES.getFlag());
        entityDebInfo2.setStatus02(WhetherEnum.YES.getFlag());
        entityDebInfo2.setStatus03(WhetherEnum.YES.getFlag());
        entityDebInfo2.setStatus04(WhetherEnum.YES.getFlag());
        entityDebInfo2.setStatus05(WhetherEnum.YES.getFlag());
        entityDebInfo2.setStatus06(WhetherEnum.YES.getFlag());
        entityDebInfo2.setStatus07(WhetherEnum.YES.getFlag());
        entityDebInfo2.setStatus08(WhetherEnum.YES.getFlag());
        entityDebInfo2.setStatus09(WhetherEnum.YES.getFlag());
        entityDebInfo2.setStatus10(WhetherEnum.YES.getFlag());
        entityDebInfo2.setStatus11(WhetherEnum.YES.getFlag());
        entityDebInfo2.setStatus12(WhetherEnum.YES.getFlag());
        entityDebInfo2.setStatus13(WhetherEnum.YES.getFlag());
        entityDebInfo2.setStatus14(WhetherEnum.YES.getFlag());
        entityDebInfo2.setStatus15(WhetherEnum.YES.getFlag());
        entityDebInfo2.setStatus16(WhetherEnum.YES.getFlag());
        entityDebInfo2.setStatus17(WhetherEnum.YES.getFlag());
        entityDebInfo2.setStatus18(WhetherEnum.YES.getFlag());
        entityDebInfo2.setStatus19(WhetherEnum.YES.getFlag());
        entityDebInfo2.setStatus20(WhetherEnum.YES.getFlag());
        entityDebInfo2.setStatus21(WhetherEnum.YES.getFlag());
        entityDebInfo2.setStatus22(WhetherEnum.YES.getFlag());
        entityDebInfo2.setStatus23(WhetherEnum.YES.getFlag());
        entityDebInfo2.setStatus24(WhetherEnum.YES.getFlag());
        entityDebInfoList.add(entityDebInfo2);

        Person person = new Person();
        person.setGenderCode("MALE");
        person.setHighestEduCode("MASTER_ABOVE");
        person.setMaritalStCode("MARRIED");

        List<WorkInfo> workInfoList = new ArrayList<WorkInfo>();
        WorkInfo workInfo = new WorkInfo();
        workInfo.setOccpCode(" ");
        workInfo.setTrdCode(" ");
        workInfoList.add(workInfo);

        WorkInfo workInfo2 = new WorkInfo();
        workInfo2.setOccpCode(" ");
        workInfo2.setTrdCode(" ");
        workInfoList.add(workInfo2);

        List<ReportLogDetail> reportLogDetailList = new ArrayList<ReportLogDetail>();
        ReportLogDetail reportLogDetail = new ReportLogDetail();
        reportLogDetail.setQueryCause("01");
        reportLogDetail.setQueryDt(new Date());
        reportLogDetailList.add(reportLogDetail);

        ReportLogDetail reportLogDetail2 = new ReportLogDetail();
        reportLogDetail2.setQueryCause("02");
        reportLogDetail2.setQueryDt(new Date());
        reportLogDetailList.add(reportLogDetail2);

        PersonalCreditReport personalCreditReport = new PersonalCreditReport();
        personalCreditReport.setCreditDebList(creditDebList);
        personalCreditReport.setCreditResult(creditResult);
        personalCreditReport.setCreditResum(creditResum);
        personalCreditReport.setEndowmentInfo(endowmentInfo);
        personalCreditReport.setEntityDebInfoList(entityDebInfoList);
        personalCreditReport.setEntityDebResList(entityDebResList);
        personalCreditReport.setHouseInfo(houseInfo);
        personalCreditReport.setPerson(person);
        personalCreditReport.setReportLogDetailList(reportLogDetailList);
        personalCreditReport.setWorkInfoList(workInfoList);

        Map<String, Object> extInfo = new HashMap<String, Object>();
        extInfo.put("RISK_SEG", "A");
        extInfo.put("REPAYMENT_SEG", "B");
        extInfo.put("ALI_LAST_6M_TRADE_TOTAL", 5);
        extInfo.put("ZM_SCORE", new BigDecimal(720));
        extInfo.put("IS_ZM_ATTENTION_FLAG", WhetherEnum.YES.getFlag());
        extInfo.put("IS_ZM_FRAUD_FLAG", WhetherEnum.YES.getFlag());
        extInfo.put("HAVE_CAR_FLAG", 1);
        extInfo.put("HAVE_FANG_FLAG", 1);
        extInfo.put("AUTH_FIN_LAST_1M_CNT", 2);
        extInfo.put("AUTH_FIN_LAST_3M_CNT", 2);
        extInfo.put("AUTH_FIN_LAST_6M_CNT", 2);
        extInfo.put("OVD_ORDER_CNT_6M", 2);
        extInfo.put("OVD_ORDER_AMT_6M", 2);
        extInfo.put("MOBILE_FIXED_DAYS", 2);
        extInfo.put("ADR_STABILITY_DAYS", 2);
        extInfo.put("LAST_6M_AVG_ASSET_TOTAL", 2);
        extInfo.put("TOT_PAY_AMT_6M", 2);
        extInfo.put("XFDC_INDEX", 2);
        extInfo.put("POSITIVE_BIZ_CNT_1Y", 2);
        extInfo.put("PERSONAL_CREDIT_REPORT", personalCreditReport);

        JSON.DEFFAULT_DATE_FORMAT = "yyyy-MM-dd";
        String json = JSON.toJSONString(extInfo, SerializerFeature.DisableCircularReferenceDetect,
                                        SerializerFeature.WriteDateUseDateFormat);

        System.out.println("toJson:" + json);

        HashMap<String, Object> approveackNotifyObject = (HashMap<String, Object>) JSON
                .parseObject(json, Map.class);

        System.out.println("toObject:" + approveackNotifyObject);
    }
}
