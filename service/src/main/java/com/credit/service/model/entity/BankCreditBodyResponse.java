package com.credit.service.model.entity;

public class BankCreditBodyResponse {

    private Long id;

    private String requestid;

    private String resultcode;

    private String resultmsg;

    private String resultstatus;

    private Integer retry;

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
     * @return resultCode
     */
    public String getResultcode() {
        return resultcode;
    }

    /**
     * @param resultcode
     */
    public void setResultcode(String resultcode) {
        this.resultcode = resultcode;
    }

    /**
     * @return resultMsg
     */
    public String getResultmsg() {
        return resultmsg;
    }

    /**
     * @param resultmsg
     */
    public void setResultmsg(String resultmsg) {
        this.resultmsg = resultmsg;
    }

    /**
     * @return resultStatus
     */
    public String getResultstatus() {
        return resultstatus;
    }

    /**
     * @param resultstatus
     */
    public void setResultstatus(String resultstatus) {
        this.resultstatus = resultstatus;
    }

    /**
     * @return retry
     */
    public Integer getRetry() {
        return retry;
    }

    /**
     * @param retry
     */
    public void setRetry(Integer retry) {
        this.retry = retry;
    }
}