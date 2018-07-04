package com.credit.service.dao.example;

import java.util.ArrayList;
import java.util.List;

public class BankCreditHeaderRequestExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BankCreditHeaderRequestExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Long value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andAppidIsNull() {
            addCriterion("appId is null");
            return (Criteria) this;
        }

        public Criteria andAppidIsNotNull() {
            addCriterion("appId is not null");
            return (Criteria) this;
        }

        public Criteria andAppidEqualTo(String value) {
            addCriterion("appId =", value, "appid");
            return (Criteria) this;
        }

        public Criteria andAppidNotEqualTo(String value) {
            addCriterion("appId <>", value, "appid");
            return (Criteria) this;
        }

        public Criteria andAppidGreaterThan(String value) {
            addCriterion("appId >", value, "appid");
            return (Criteria) this;
        }

        public Criteria andAppidGreaterThanOrEqualTo(String value) {
            addCriterion("appId >=", value, "appid");
            return (Criteria) this;
        }

        public Criteria andAppidLessThan(String value) {
            addCriterion("appId <", value, "appid");
            return (Criteria) this;
        }

        public Criteria andAppidLessThanOrEqualTo(String value) {
            addCriterion("appId <=", value, "appid");
            return (Criteria) this;
        }

        public Criteria andAppidLike(String value) {
            addCriterion("appId like", value, "appid");
            return (Criteria) this;
        }

        public Criteria andAppidNotLike(String value) {
            addCriterion("appId not like", value, "appid");
            return (Criteria) this;
        }

        public Criteria andAppidIn(List<String> values) {
            addCriterion("appId in", values, "appid");
            return (Criteria) this;
        }

        public Criteria andAppidNotIn(List<String> values) {
            addCriterion("appId not in", values, "appid");
            return (Criteria) this;
        }

        public Criteria andAppidBetween(String value1, String value2) {
            addCriterion("appId between", value1, value2, "appid");
            return (Criteria) this;
        }

        public Criteria andAppidNotBetween(String value1, String value2) {
            addCriterion("appId not between", value1, value2, "appid");
            return (Criteria) this;
        }

        public Criteria andFunctionIsNull() {
            addCriterion("function is null");
            return (Criteria) this;
        }

        public Criteria andFunctionIsNotNull() {
            addCriterion("function is not null");
            return (Criteria) this;
        }

        public Criteria andFunctionEqualTo(String value) {
            addCriterion("function =", value, "function");
            return (Criteria) this;
        }

        public Criteria andFunctionNotEqualTo(String value) {
            addCriterion("function <>", value, "function");
            return (Criteria) this;
        }

        public Criteria andFunctionGreaterThan(String value) {
            addCriterion("function >", value, "function");
            return (Criteria) this;
        }

        public Criteria andFunctionGreaterThanOrEqualTo(String value) {
            addCriterion("function >=", value, "function");
            return (Criteria) this;
        }

        public Criteria andFunctionLessThan(String value) {
            addCriterion("function <", value, "function");
            return (Criteria) this;
        }

        public Criteria andFunctionLessThanOrEqualTo(String value) {
            addCriterion("function <=", value, "function");
            return (Criteria) this;
        }

        public Criteria andFunctionLike(String value) {
            addCriterion("function like", value, "function");
            return (Criteria) this;
        }

        public Criteria andFunctionNotLike(String value) {
            addCriterion("function not like", value, "function");
            return (Criteria) this;
        }

        public Criteria andFunctionIn(List<String> values) {
            addCriterion("function in", values, "function");
            return (Criteria) this;
        }

        public Criteria andFunctionNotIn(List<String> values) {
            addCriterion("function not in", values, "function");
            return (Criteria) this;
        }

        public Criteria andFunctionBetween(String value1, String value2) {
            addCriterion("function between", value1, value2, "function");
            return (Criteria) this;
        }

        public Criteria andFunctionNotBetween(String value1, String value2) {
            addCriterion("function not between", value1, value2, "function");
            return (Criteria) this;
        }

        public Criteria andReqtimeIsNull() {
            addCriterion("reqTime is null");
            return (Criteria) this;
        }

        public Criteria andReqtimeIsNotNull() {
            addCriterion("reqTime is not null");
            return (Criteria) this;
        }

        public Criteria andReqtimeEqualTo(String value) {
            addCriterion("reqTime =", value, "reqTime");
            return (Criteria) this;
        }

        public Criteria andReqtimeNotEqualTo(String value) {
            addCriterion("reqTime <>", value, "reqTime");
            return (Criteria) this;
        }

        public Criteria andReqtimeGreaterThan(String value) {
            addCriterion("reqTime >", value, "reqTime");
            return (Criteria) this;
        }

        public Criteria andReqtimeGreaterThanOrEqualTo(String value) {
            addCriterion("reqTime >=", value, "reqTime");
            return (Criteria) this;
        }

        public Criteria andReqtimeLessThan(String value) {
            addCriterion("reqTime <", value, "reqTime");
            return (Criteria) this;
        }

        public Criteria andReqtimeLessThanOrEqualTo(String value) {
            addCriterion("reqTime <=", value, "reqTime");
            return (Criteria) this;
        }

        public Criteria andReqtimeLike(String value) {
            addCriterion("reqTime like", value, "reqTime");
            return (Criteria) this;
        }

        public Criteria andReqtimeNotLike(String value) {
            addCriterion("reqTime not like", value, "reqTime");
            return (Criteria) this;
        }

        public Criteria andReqtimeIn(List<String> values) {
            addCriterion("reqTime in", values, "reqTime");
            return (Criteria) this;
        }

        public Criteria andReqtimeNotIn(List<String> values) {
            addCriterion("reqTime not in", values, "reqTime");
            return (Criteria) this;
        }

        public Criteria andReqtimeBetween(String value1, String value2) {
            addCriterion("reqTime between", value1, value2, "reqTime");
            return (Criteria) this;
        }

        public Criteria andReqtimeNotBetween(String value1, String value2) {
            addCriterion("reqTime not between", value1, value2, "reqTime");
            return (Criteria) this;
        }

        public Criteria andReqtimezoneIsNull() {
            addCriterion("reqTimeZone is null");
            return (Criteria) this;
        }

        public Criteria andReqtimezoneIsNotNull() {
            addCriterion("reqTimeZone is not null");
            return (Criteria) this;
        }

        public Criteria andReqtimezoneEqualTo(String value) {
            addCriterion("reqTimeZone =", value, "reqTimeZone");
            return (Criteria) this;
        }

        public Criteria andReqtimezoneNotEqualTo(String value) {
            addCriterion("reqTimeZone <>", value, "reqTimeZone");
            return (Criteria) this;
        }

        public Criteria andReqtimezoneGreaterThan(String value) {
            addCriterion("reqTimeZone >", value, "reqTimeZone");
            return (Criteria) this;
        }

        public Criteria andReqtimezoneGreaterThanOrEqualTo(String value) {
            addCriterion("reqTimeZone >=", value, "reqTimeZone");
            return (Criteria) this;
        }

        public Criteria andReqtimezoneLessThan(String value) {
            addCriterion("reqTimeZone <", value, "reqTimeZone");
            return (Criteria) this;
        }

        public Criteria andReqtimezoneLessThanOrEqualTo(String value) {
            addCriterion("reqTimeZone <=", value, "reqTimeZone");
            return (Criteria) this;
        }

        public Criteria andReqtimezoneLike(String value) {
            addCriterion("reqTimeZone like", value, "reqTimeZone");
            return (Criteria) this;
        }

        public Criteria andReqtimezoneNotLike(String value) {
            addCriterion("reqTimeZone not like", value, "reqTimeZone");
            return (Criteria) this;
        }

        public Criteria andReqtimezoneIn(List<String> values) {
            addCriterion("reqTimeZone in", values, "reqTimeZone");
            return (Criteria) this;
        }

        public Criteria andReqtimezoneNotIn(List<String> values) {
            addCriterion("reqTimeZone not in", values, "reqTimeZone");
            return (Criteria) this;
        }

        public Criteria andReqtimezoneBetween(String value1, String value2) {
            addCriterion("reqTimeZone between", value1, value2, "reqTimeZone");
            return (Criteria) this;
        }

        public Criteria andReqtimezoneNotBetween(String value1, String value2) {
            addCriterion("reqTimeZone not between", value1, value2, "reqTimeZone");
            return (Criteria) this;
        }

        public Criteria andReqmsgidIsNull() {
            addCriterion("reqMsgId is null");
            return (Criteria) this;
        }

        public Criteria andReqmsgidIsNotNull() {
            addCriterion("reqMsgId is not null");
            return (Criteria) this;
        }

        public Criteria andReqmsgidEqualTo(String value) {
            addCriterion("reqMsgId =", value, "reqMsgId");
            return (Criteria) this;
        }

        public Criteria andReqmsgidNotEqualTo(String value) {
            addCriterion("reqMsgId <>", value, "reqMsgId");
            return (Criteria) this;
        }

        public Criteria andReqmsgidGreaterThan(String value) {
            addCriterion("reqMsgId >", value, "reqMsgId");
            return (Criteria) this;
        }

        public Criteria andReqmsgidGreaterThanOrEqualTo(String value) {
            addCriterion("reqMsgId >=", value, "reqMsgId");
            return (Criteria) this;
        }

        public Criteria andReqmsgidLessThan(String value) {
            addCriterion("reqMsgId <", value, "reqMsgId");
            return (Criteria) this;
        }

        public Criteria andReqmsgidLessThanOrEqualTo(String value) {
            addCriterion("reqMsgId <=", value, "reqmsgid");
            return (Criteria) this;
        }

        public Criteria andReqmsgidLike(String value) {
            addCriterion("reqMsgId like", value, "reqMsgId");
            return (Criteria) this;
        }

        public Criteria andReqmsgidNotLike(String value) {
            addCriterion("reqMsgId not like", value, "reqMsgId");
            return (Criteria) this;
        }

        public Criteria andReqmsgidIn(List<String> values) {
            addCriterion("reqMsgId in", values, "reqMsgId");
            return (Criteria) this;
        }

        public Criteria andReqmsgidNotIn(List<String> values) {
            addCriterion("reqMsgId not in", values, "reqMsgId");
            return (Criteria) this;
        }

        public Criteria andReqmsgidBetween(String value1, String value2) {
            addCriterion("reqMsgId between", value1, value2, "reqMsgId");
            return (Criteria) this;
        }

        public Criteria andReqmsgidNotBetween(String value1, String value2) {
            addCriterion("reqMsgId not between", value1, value2, "reqMsgId");
            return (Criteria) this;
        }

        public Criteria andSigntypeIsNull() {
            addCriterion("signType is null");
            return (Criteria) this;
        }

        public Criteria andSigntypeIsNotNull() {
            addCriterion("signType is not null");
            return (Criteria) this;
        }

        public Criteria andSigntypeEqualTo(String value) {
            addCriterion("signType =", value, "signType");
            return (Criteria) this;
        }

        public Criteria andSigntypeNotEqualTo(String value) {
            addCriterion("signType <>", value, "signType");
            return (Criteria) this;
        }

        public Criteria andSigntypeGreaterThan(String value) {
            addCriterion("signType >", value, "signType");
            return (Criteria) this;
        }

        public Criteria andSigntypeGreaterThanOrEqualTo(String value) {
            addCriterion("signType >=", value, "signType");
            return (Criteria) this;
        }

        public Criteria andSigntypeLessThan(String value) {
            addCriterion("signType <", value, "signType");
            return (Criteria) this;
        }

        public Criteria andSigntypeLessThanOrEqualTo(String value) {
            addCriterion("signType <=", value, "signType");
            return (Criteria) this;
        }

        public Criteria andSigntypeLike(String value) {
            addCriterion("signType like", value, "signType");
            return (Criteria) this;
        }

        public Criteria andSigntypeNotLike(String value) {
            addCriterion("signType not like", value, "signType");
            return (Criteria) this;
        }

        public Criteria andSigntypeIn(List<String> values) {
            addCriterion("signType in", values, "signType");
            return (Criteria) this;
        }

        public Criteria andSigntypeNotIn(List<String> values) {
            addCriterion("signType not in", values, "signType");
            return (Criteria) this;
        }

        public Criteria andSigntypeBetween(String value1, String value2) {
            addCriterion("signType between", value1, value2, "signType");
            return (Criteria) this;
        }

        public Criteria andSigntypeNotBetween(String value1, String value2) {
            addCriterion("signType not between", value1, value2, "signType");
            return (Criteria) this;
        }

        public Criteria andInputcharsetIsNull() {
            addCriterion("inputCharset is null");
            return (Criteria) this;
        }

        public Criteria andInputcharsetIsNotNull() {
            addCriterion("inputCharset is not null");
            return (Criteria) this;
        }

        public Criteria andInputcharsetEqualTo(String value) {
            addCriterion("inputCharset =", value, "inputcharset");
            return (Criteria) this;
        }

        public Criteria andInputcharsetNotEqualTo(String value) {
            addCriterion("inputCharset <>", value, "inputcharset");
            return (Criteria) this;
        }

        public Criteria andInputcharsetGreaterThan(String value) {
            addCriterion("inputCharset >", value, "inputcharset");
            return (Criteria) this;
        }

        public Criteria andInputcharsetGreaterThanOrEqualTo(String value) {
            addCriterion("inputCharset >=", value, "inputcharset");
            return (Criteria) this;
        }

        public Criteria andInputcharsetLessThan(String value) {
            addCriterion("inputCharset <", value, "inputcharset");
            return (Criteria) this;
        }

        public Criteria andInputcharsetLessThanOrEqualTo(String value) {
            addCriterion("inputCharset <=", value, "inputcharset");
            return (Criteria) this;
        }

        public Criteria andInputcharsetLike(String value) {
            addCriterion("inputCharset like", value, "inputcharset");
            return (Criteria) this;
        }

        public Criteria andInputcharsetNotLike(String value) {
            addCriterion("inputCharset not like", value, "inputcharset");
            return (Criteria) this;
        }

        public Criteria andInputcharsetIn(List<String> values) {
            addCriterion("inputCharset in", values, "inputcharset");
            return (Criteria) this;
        }

        public Criteria andInputcharsetNotIn(List<String> values) {
            addCriterion("inputCharset not in", values, "inputcharset");
            return (Criteria) this;
        }

        public Criteria andInputcharsetBetween(String value1, String value2) {
            addCriterion("inputCharset between", value1, value2, "inputcharset");
            return (Criteria) this;
        }

        public Criteria andInputcharsetNotBetween(String value1, String value2) {
            addCriterion("inputCharset not between", value1, value2, "inputcharset");
            return (Criteria) this;
        }

        public Criteria andVersionIsNull() {
            addCriterion("version is null");
            return (Criteria) this;
        }

        public Criteria andVersionIsNotNull() {
            addCriterion("version is not null");
            return (Criteria) this;
        }

        public Criteria andVersionEqualTo(String value) {
            addCriterion("version =", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionNotEqualTo(String value) {
            addCriterion("version <>", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionGreaterThan(String value) {
            addCriterion("version >", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionGreaterThanOrEqualTo(String value) {
            addCriterion("version >=", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionLessThan(String value) {
            addCriterion("version <", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionLessThanOrEqualTo(String value) {
            addCriterion("version <=", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionLike(String value) {
            addCriterion("version like", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionNotLike(String value) {
            addCriterion("version not like", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionIn(List<String> values) {
            addCriterion("version in", values, "version");
            return (Criteria) this;
        }

        public Criteria andVersionNotIn(List<String> values) {
            addCriterion("version not in", values, "version");
            return (Criteria) this;
        }

        public Criteria andVersionBetween(String value1, String value2) {
            addCriterion("version between", value1, value2, "version");
            return (Criteria) this;
        }

        public Criteria andVersionNotBetween(String value1, String value2) {
            addCriterion("version not between", value1, value2, "version");
            return (Criteria) this;
        }

        public Criteria andReserveIsNull() {
            addCriterion("reserve is null");
            return (Criteria) this;
        }

        public Criteria andReserveIsNotNull() {
            addCriterion("reserve is not null");
            return (Criteria) this;
        }

        public Criteria andReserveEqualTo(String value) {
            addCriterion("reserve =", value, "reserve");
            return (Criteria) this;
        }

        public Criteria andReserveNotEqualTo(String value) {
            addCriterion("reserve <>", value, "reserve");
            return (Criteria) this;
        }

        public Criteria andReserveGreaterThan(String value) {
            addCriterion("reserve >", value, "reserve");
            return (Criteria) this;
        }

        public Criteria andReserveGreaterThanOrEqualTo(String value) {
            addCriterion("reserve >=", value, "reserve");
            return (Criteria) this;
        }

        public Criteria andReserveLessThan(String value) {
            addCriterion("reserve <", value, "reserve");
            return (Criteria) this;
        }

        public Criteria andReserveLessThanOrEqualTo(String value) {
            addCriterion("reserve <=", value, "reserve");
            return (Criteria) this;
        }

        public Criteria andReserveLike(String value) {
            addCriterion("reserve like", value, "reserve");
            return (Criteria) this;
        }

        public Criteria andReserveNotLike(String value) {
            addCriterion("reserve not like", value, "reserve");
            return (Criteria) this;
        }

        public Criteria andReserveIn(List<String> values) {
            addCriterion("reserve in", values, "reserve");
            return (Criteria) this;
        }

        public Criteria andReserveNotIn(List<String> values) {
            addCriterion("reserve not in", values, "reserve");
            return (Criteria) this;
        }

        public Criteria andReserveBetween(String value1, String value2) {
            addCriterion("reserve between", value1, value2, "reserve");
            return (Criteria) this;
        }

        public Criteria andReserveNotBetween(String value1, String value2) {
            addCriterion("reserve not between", value1, value2, "reserve");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}