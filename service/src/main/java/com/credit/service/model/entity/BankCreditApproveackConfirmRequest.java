package com.credit.service.model.entity;

public class BankCreditApproveackConfirmRequest {

    private Long id;

    private String requestid;

    private String applyno;

    private String certname;

    private String certno;

    private String isagree;

    private String refusecode;

    private String ackmsg;

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
     * @return isAgree
     */
    public String getIsagree() {
        return isagree;
    }

    /**
     * @param isagree
     */
    public void setIsagree(String isagree) {
        this.isagree = isagree;
    }

    /**
     * @return refuseCode
     */
    public String getRefusecode() {
        return refusecode;
    }

    /**
     * @param refusecode
     */
    public void setRefusecode(String refusecode) {
        this.refusecode = refusecode;
    }

    /**
     * @return ackMsg
     */
    public String getAckmsg() {
        return ackmsg;
    }

    /**
     * @param ackmsg
     */
    public void setAckmsg(String ackmsg) {
        this.ackmsg = ackmsg;
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