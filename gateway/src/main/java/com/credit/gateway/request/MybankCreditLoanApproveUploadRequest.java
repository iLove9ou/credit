package com.credit.gateway.request;

import java.io.Serializable;

public class MybankCreditLoanApproveUploadRequest implements Serializable {
    /*
     * 请求幂等ID
     */
    private String requestId;

    /*
     * 申请编码
     */
    private String applyNo;

    /*
     * 数据类型
     */
    private String category;

    /*
     * 证件名称
     */
    private String certName;

    /*
     * 证件号
     */
    private String certNo;

    /*
     * 扩展字段
     */
    private String objectContent;

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
