package com.credit.service.model.entity;

public class BankCreditApproveackNotifyRequest {

    private Long id;

    private String requestId;

    private String applyNo;

    private String certNo;

    private String certName;

    private String certType;

    private String platformAccess;

    private String platformAdmit;

    private String platformRateLimit;

    private String platformRateBottom;

    private String businessModel;

    private String extInfo;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public String getApplyNo() {
        return applyNo;
    }

    public void setApplyNo(String applyNo) {
        this.applyNo = applyNo;
    }

    public String getCertNo() {
        return certNo;
    }

    public void setCertNo(String certNo) {
        this.certNo = certNo;
    }

    public String getCertName() {
        return certName;
    }

    public void setCertName(String certName) {
        this.certName = certName;
    }

    public String getCertType() {
        return certType;
    }

    public void setCertType(String certType) {
        this.certType = certType;
    }

    public String getPlatformAccess() {
        return platformAccess;
    }

    public void setPlatformAccess(String platformAccess) {
        this.platformAccess = platformAccess;
    }

    public String getPlatformAdmit() {
        return platformAdmit;
    }

    public void setPlatformAdmit(String platformAdmit) {
        this.platformAdmit = platformAdmit;
    }

    public String getPlatformRateLimit() {
        return platformRateLimit;
    }

    public void setPlatformRateLimit(String platformRateLimit) {
        this.platformRateLimit = platformRateLimit;
    }

    public String getPlatformRateBottom() {
        return platformRateBottom;
    }

    public void setPlatformRateBottom(String platformRateBottom) {
        this.platformRateBottom = platformRateBottom;
    }

    public String getBusinessModel() {
        return businessModel;
    }

    public void setBusinessModel(String businessModel) {
        this.businessModel = businessModel;
    }

    public String getExtInfo() {
        return extInfo;
    }

    public void setExtInfo(String extInfo) {
        this.extInfo = extInfo;
    }
}