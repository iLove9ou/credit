package com.credit.service.model.entity;

public class BankCreditApproveUploadRequest {

    private Long id;

    private String requestid;

    private String applyno;

    private String category;

    private String certname;

    private String certno;

    private String objectcontent;

    /**
     * @return id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return requestId
     */
    public String getRequestid() {
        return requestid;
    }

    /**
     * @param requestid
     */
    public void setRequestid(String requestid) {
        this.requestid = requestid;
    }

    /**
     * @return applyNo
     */
    public String getApplyno() {
        return applyno;
    }

    /**
     * @param applyno
     */
    public void setApplyno(String applyno) {
        this.applyno = applyno;
    }

    /**
     * @return category
     */
    public String getCategory() {
        return category;
    }

    /**
     * @param category
     */
    public void setCategory(String category) {
        this.category = category;
    }

    /**
     * @return certName
     */
    public String getCertname() {
        return certname;
    }

    /**
     * @param certname
     */
    public void setCertname(String certname) {
        this.certname = certname;
    }

    /**
     * @return certNo
     */
    public String getCertno() {
        return certno;
    }

    /**
     * @param certno
     */
    public void setCertno(String certno) {
        this.certno = certno;
    }

    /**
     * @return objectContent
     */
    public String getObjectcontent() {
        return objectcontent;
    }

    /**
     * @param objectcontent
     */
    public void setObjectcontent(String objectcontent) {
        this.objectcontent = objectcontent;
    }
}