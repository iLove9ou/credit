package com.credit.service.model.entity;

public class BankCreditApproveackNotifyRequest {

    private Long id;

    private String requestid;

    private String applyno;

    private String certno;

    private String certname;

    private String certtype;

    private String platformaccess;

    private String platformadmit;

    private String platformratelimit;

    private String platformratebottom;

    private String businessmodel;

    private String extinfo;

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
     * @return certType
     */
    public String getCerttype() {
        return certtype;
    }

    /**
     * @param certtype
     */
    public void setCerttype(String certtype) {
        this.certtype = certtype;
    }

    /**
     * @return platformAccess
     */
    public String getPlatformaccess() {
        return platformaccess;
    }

    /**
     * @param platformaccess
     */
    public void setPlatformaccess(String platformaccess) {
        this.platformaccess = platformaccess;
    }

    /**
     * @return platformAdmit
     */
    public String getPlatformadmit() {
        return platformadmit;
    }

    /**
     * @param platformadmit
     */
    public void setPlatformadmit(String platformadmit) {
        this.platformadmit = platformadmit;
    }

    /**
     * @return platformRateLimit
     */
    public String getPlatformratelimit() {
        return platformratelimit;
    }

    /**
     * @param platformratelimit
     */
    public void setPlatformratelimit(String platformratelimit) {
        this.platformratelimit = platformratelimit;
    }

    /**
     * @return platformRateBottom
     */
    public String getPlatformratebottom() {
        return platformratebottom;
    }

    /**
     * @param platformratebottom
     */
    public void setPlatformratebottom(String platformratebottom) {
        this.platformratebottom = platformratebottom;
    }

    /**
     * @return businessModel
     */
    public String getBusinessmodel() {
        return businessmodel;
    }

    /**
     * @param businessmodel
     */
    public void setBusinessmodel(String businessmodel) {
        this.businessmodel = businessmodel;
    }

    /**
     * @return extInfo
     */
    public String getExtinfo() {
        return extinfo;
    }

    /**
     * @param extinfo
     */
    public void setExtinfo(String extinfo) {
        this.extinfo = extinfo;
    }
}