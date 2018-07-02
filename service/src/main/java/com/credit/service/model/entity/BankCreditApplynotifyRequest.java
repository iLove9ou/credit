package com.credit.service.model.entity;

import javax.persistence.Column;
import javax.persistence.Table;

@Table(name = "bank_credit_apply_notify_request")
public class BankCreditApplynotifyRequest {
    private Long id;

    @Column(name = "requestId")
    private String requestid;

    @Column(name = "applyNo")
    private String applyno;

    @Column(name = "certType")
    private String certtype;

    @Column(name = "certName")
    private String certname;

    @Column(name = "certNo")
    private String certno;

    @Column(name = "businessModel")
    private String businessmodel;

    @Column(name = "extInfo")
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