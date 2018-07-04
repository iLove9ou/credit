package com.credit.service.model.entity;

public class BankCreditApproveUploadRequest {

    private Long id;

    private String requestId;

    private String applyNo;

    private String category;

    private String certName;

    private String certNo;

    private String objectContent;

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

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getCertName() {
        return certName;
    }

    public void setCertName(String certName) {
        this.certName = certName;
    }

    public String getCertNo() {
        return certNo;
    }

    public void setCertNo(String certNo) {
        this.certNo = certNo;
    }

    public String getObjectContent() {
        return objectContent;
    }

    public void setObjectContent(String objectContent) {
        this.objectContent = objectContent;
    }
}