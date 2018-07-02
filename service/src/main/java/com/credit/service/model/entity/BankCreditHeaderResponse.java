package com.credit.service.model.entity;

public class BankCreditHeaderResponse {
    private Long id;

    private String appid;

    private String function;

    private String resptime;

    private String resptimezone;

    private String reqmsgid;

    private String signtype;

    private String inputcharset;

    private String version;

    private String reserve;

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
     * @return appId
     */
    public String getAppid() {
        return appid;
    }

    /**
     * @param appid
     */
    public void setAppid(String appid) {
        this.appid = appid;
    }

    /**
     * @return function
     */
    public String getFunction() {
        return function;
    }

    /**
     * @param function
     */
    public void setFunction(String function) {
        this.function = function;
    }

    /**
     * @return respTime
     */
    public String getResptime() {
        return resptime;
    }

    /**
     * @param resptime
     */
    public void setResptime(String resptime) {
        this.resptime = resptime;
    }

    /**
     * @return respTimeZone
     */
    public String getResptimezone() {
        return resptimezone;
    }

    /**
     * @param resptimezone
     */
    public void setResptimezone(String resptimezone) {
        this.resptimezone = resptimezone;
    }

    /**
     * @return reqMsgId
     */
    public String getReqmsgid() {
        return reqmsgid;
    }

    /**
     * @param reqmsgid
     */
    public void setReqmsgid(String reqmsgid) {
        this.reqmsgid = reqmsgid;
    }

    /**
     * @return signType
     */
    public String getSigntype() {
        return signtype;
    }

    /**
     * @param signtype
     */
    public void setSigntype(String signtype) {
        this.signtype = signtype;
    }

    /**
     * @return inputCharset
     */
    public String getInputcharset() {
        return inputcharset;
    }

    /**
     * @param inputcharset
     */
    public void setInputcharset(String inputcharset) {
        this.inputcharset = inputcharset;
    }

    /**
     * @return version
     */
    public String getVersion() {
        return version;
    }

    /**
     * @param version
     */
    public void setVersion(String version) {
        this.version = version;
    }

    /**
     * @return reserve
     */
    public String getReserve() {
        return reserve;
    }

    /**
     * @param reserve
     */
    public void setReserve(String reserve) {
        this.reserve = reserve;
    }
}