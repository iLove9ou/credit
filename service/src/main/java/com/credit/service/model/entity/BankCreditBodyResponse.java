package com.credit.service.model.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "bank_credit_body_response")
public class BankCreditBodyResponse {
    @Id
    private Long id;

    @Column(name = "requestId")
    private String requestid;

    @Column(name = "resultCode")
    private String resultcode;

    @Column(name = "resultMsg")
    private String resultmsg;

    @Column(name = "resultStatus")
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