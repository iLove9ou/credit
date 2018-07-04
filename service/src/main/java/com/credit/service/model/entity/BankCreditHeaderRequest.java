package com.credit.service.model.entity;

public class BankCreditHeaderRequest {
    private Long id;

    private String appId;

    private String function;

    private String reqTime;

    private String reqTimeZone;

    private String reqMsgId;

    private String signType;

    private String inputCharset;

    private String version;

    private String reserve;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getFunction() {
        return function;
    }

    public void setFunction(String function) {
        this.function = function;
    }

    public String getReqTime() {
        return reqTime;
    }

    public void setReqTime(String reqTime) {
        this.reqTime = reqTime;
    }



    public String getReqMsgId() {
        return reqMsgId;
    }

    public String getReqTimeZone() {
        return reqTimeZone;
    }

    public void setReqTimeZone(String reqTimeZone) {
        this.reqTimeZone = reqTimeZone;
    }

    public void setReqMsgId(String reqMsgId) {
        this.reqMsgId = reqMsgId;
    }

    public String getSignType() {
        return signType;
    }

    public void setSignType(String signType) {
        this.signType = signType;
    }

    public String getInputCharset() {
        return inputCharset;
    }

    public void setInputCharset(String inputCharset) {
        this.inputCharset = inputCharset;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getReserve() {
        return reserve;
    }

    public void setReserve(String reserve) {
        this.reserve = reserve;
    }


}