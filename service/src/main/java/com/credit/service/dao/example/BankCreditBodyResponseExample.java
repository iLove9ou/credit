package com.credit.service.dao.example;

import java.util.ArrayList;
import java.util.List;

public class BankCreditBodyResponseExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BankCreditBodyResponseExample() {
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

        public Criteria andRequestidIsNull() {
            addCriterion("requestId is null");
            return (Criteria) this;
        }

        public Criteria andRequestidIsNotNull() {
            addCriterion("requestId is not null");
            return (Criteria) this;
        }

        public Criteria andRequestidEqualTo(String value) {
            addCriterion("requestId =", value, "requestid");
            return (Criteria) this;
        }

        public Criteria andRequestidNotEqualTo(String value) {
            addCriterion("requestId <>", value, "requestid");
            return (Criteria) this;
        }

        public Criteria andRequestidGreaterThan(String value) {
            addCriterion("requestId >", value, "requestid");
            return (Criteria) this;
        }

        public Criteria andRequestidGreaterThanOrEqualTo(String value) {
            addCriterion("requestId >=", value, "requestid");
            return (Criteria) this;
        }

        public Criteria andRequestidLessThan(String value) {
            addCriterion("requestId <", value, "requestid");
            return (Criteria) this;
        }

        public Criteria andRequestidLessThanOrEqualTo(String value) {
            addCriterion("requestId <=", value, "requestid");
            return (Criteria) this;
        }

        public Criteria andRequestidLike(String value) {
            addCriterion("requestId like", value, "requestid");
            return (Criteria) this;
        }

        public Criteria andRequestidNotLike(String value) {
            addCriterion("requestId not like", value, "requestid");
            return (Criteria) this;
        }

        public Criteria andRequestidIn(List<String> values) {
            addCriterion("requestId in", values, "requestid");
            return (Criteria) this;
        }

        public Criteria andRequestidNotIn(List<String> values) {
            addCriterion("requestId not in", values, "requestid");
            return (Criteria) this;
        }

        public Criteria andRequestidBetween(String value1, String value2) {
            addCriterion("requestId between", value1, value2, "requestid");
            return (Criteria) this;
        }

        public Criteria andRequestidNotBetween(String value1, String value2) {
            addCriterion("requestId not between", value1, value2, "requestid");
            return (Criteria) this;
        }

        public Criteria andResultcodeIsNull() {
            addCriterion("resultCode is null");
            return (Criteria) this;
        }

        public Criteria andResultcodeIsNotNull() {
            addCriterion("resultCode is not null");
            return (Criteria) this;
        }

        public Criteria andResultcodeEqualTo(String value) {
            addCriterion("resultCode =", value, "resultcode");
            return (Criteria) this;
        }

        public Criteria andResultcodeNotEqualTo(String value) {
            addCriterion("resultCode <>", value, "resultcode");
            return (Criteria) this;
        }

        public Criteria andResultcodeGreaterThan(String value) {
            addCriterion("resultCode >", value, "resultcode");
            return (Criteria) this;
        }

        public Criteria andResultcodeGreaterThanOrEqualTo(String value) {
            addCriterion("resultCode >=", value, "resultcode");
            return (Criteria) this;
        }

        public Criteria andResultcodeLessThan(String value) {
            addCriterion("resultCode <", value, "resultcode");
            return (Criteria) this;
        }

        public Criteria andResultcodeLessThanOrEqualTo(String value) {
            addCriterion("resultCode <=", value, "resultcode");
            return (Criteria) this;
        }

        public Criteria andResultcodeLike(String value) {
            addCriterion("resultCode like", value, "resultcode");
            return (Criteria) this;
        }

        public Criteria andResultcodeNotLike(String value) {
            addCriterion("resultCode not like", value, "resultcode");
            return (Criteria) this;
        }

        public Criteria andResultcodeIn(List<String> values) {
            addCriterion("resultCode in", values, "resultcode");
            return (Criteria) this;
        }

        public Criteria andResultcodeNotIn(List<String> values) {
            addCriterion("resultCode not in", values, "resultcode");
            return (Criteria) this;
        }

        public Criteria andResultcodeBetween(String value1, String value2) {
            addCriterion("resultCode between", value1, value2, "resultcode");
            return (Criteria) this;
        }

        public Criteria andResultcodeNotBetween(String value1, String value2) {
            addCriterion("resultCode not between", value1, value2, "resultcode");
            return (Criteria) this;
        }

        public Criteria andResultmsgIsNull() {
            addCriterion("resultMsg is null");
            return (Criteria) this;
        }

        public Criteria andResultmsgIsNotNull() {
            addCriterion("resultMsg is not null");
            return (Criteria) this;
        }

        public Criteria andResultmsgEqualTo(String value) {
            addCriterion("resultMsg =", value, "resultmsg");
            return (Criteria) this;
        }

        public Criteria andResultmsgNotEqualTo(String value) {
            addCriterion("resultMsg <>", value, "resultmsg");
            return (Criteria) this;
        }

        public Criteria andResultmsgGreaterThan(String value) {
            addCriterion("resultMsg >", value, "resultmsg");
            return (Criteria) this;
        }

        public Criteria andResultmsgGreaterThanOrEqualTo(String value) {
            addCriterion("resultMsg >=", value, "resultmsg");
            return (Criteria) this;
        }

        public Criteria andResultmsgLessThan(String value) {
            addCriterion("resultMsg <", value, "resultmsg");
            return (Criteria) this;
        }

        public Criteria andResultmsgLessThanOrEqualTo(String value) {
            addCriterion("resultMsg <=", value, "resultmsg");
            return (Criteria) this;
        }

        public Criteria andResultmsgLike(String value) {
            addCriterion("resultMsg like", value, "resultmsg");
            return (Criteria) this;
        }

        public Criteria andResultmsgNotLike(String value) {
            addCriterion("resultMsg not like", value, "resultmsg");
            return (Criteria) this;
        }

        public Criteria andResultmsgIn(List<String> values) {
            addCriterion("resultMsg in", values, "resultmsg");
            return (Criteria) this;
        }

        public Criteria andResultmsgNotIn(List<String> values) {
            addCriterion("resultMsg not in", values, "resultmsg");
            return (Criteria) this;
        }

        public Criteria andResultmsgBetween(String value1, String value2) {
            addCriterion("resultMsg between", value1, value2, "resultmsg");
            return (Criteria) this;
        }

        public Criteria andResultmsgNotBetween(String value1, String value2) {
            addCriterion("resultMsg not between", value1, value2, "resultmsg");
            return (Criteria) this;
        }

        public Criteria andResultstatusIsNull() {
            addCriterion("resultStatus is null");
            return (Criteria) this;
        }

        public Criteria andResultstatusIsNotNull() {
            addCriterion("resultStatus is not null");
            return (Criteria) this;
        }

        public Criteria andResultstatusEqualTo(String value) {
            addCriterion("resultStatus =", value, "resultstatus");
            return (Criteria) this;
        }

        public Criteria andResultstatusNotEqualTo(String value) {
            addCriterion("resultStatus <>", value, "resultstatus");
            return (Criteria) this;
        }

        public Criteria andResultstatusGreaterThan(String value) {
            addCriterion("resultStatus >", value, "resultstatus");
            return (Criteria) this;
        }

        public Criteria andResultstatusGreaterThanOrEqualTo(String value) {
            addCriterion("resultStatus >=", value, "resultstatus");
            return (Criteria) this;
        }

        public Criteria andResultstatusLessThan(String value) {
            addCriterion("resultStatus <", value, "resultstatus");
            return (Criteria) this;
        }

        public Criteria andResultstatusLessThanOrEqualTo(String value) {
            addCriterion("resultStatus <=", value, "resultstatus");
            return (Criteria) this;
        }

        public Criteria andResultstatusLike(String value) {
            addCriterion("resultStatus like", value, "resultstatus");
            return (Criteria) this;
        }

        public Criteria andResultstatusNotLike(String value) {
            addCriterion("resultStatus not like", value, "resultstatus");
            return (Criteria) this;
        }

        public Criteria andResultstatusIn(List<String> values) {
            addCriterion("resultStatus in", values, "resultstatus");
            return (Criteria) this;
        }

        public Criteria andResultstatusNotIn(List<String> values) {
            addCriterion("resultStatus not in", values, "resultstatus");
            return (Criteria) this;
        }

        public Criteria andResultstatusBetween(String value1, String value2) {
            addCriterion("resultStatus between", value1, value2, "resultstatus");
            return (Criteria) this;
        }

        public Criteria andResultstatusNotBetween(String value1, String value2) {
            addCriterion("resultStatus not between", value1, value2, "resultstatus");
            return (Criteria) this;
        }

        public Criteria andRetryIsNull() {
            addCriterion("retry is null");
            return (Criteria) this;
        }

        public Criteria andRetryIsNotNull() {
            addCriterion("retry is not null");
            return (Criteria) this;
        }

        public Criteria andRetryEqualTo(Integer value) {
            addCriterion("retry =", value, "retry");
            return (Criteria) this;
        }

        public Criteria andRetryNotEqualTo(Integer value) {
            addCriterion("retry <>", value, "retry");
            return (Criteria) this;
        }

        public Criteria andRetryGreaterThan(Integer value) {
            addCriterion("retry >", value, "retry");
            return (Criteria) this;
        }

        public Criteria andRetryGreaterThanOrEqualTo(Integer value) {
            addCriterion("retry >=", value, "retry");
            return (Criteria) this;
        }

        public Criteria andRetryLessThan(Integer value) {
            addCriterion("retry <", value, "retry");
            return (Criteria) this;
        }

        public Criteria andRetryLessThanOrEqualTo(Integer value) {
            addCriterion("retry <=", value, "retry");
            return (Criteria) this;
        }

        public Criteria andRetryIn(List<Integer> values) {
            addCriterion("retry in", values, "retry");
            return (Criteria) this;
        }

        public Criteria andRetryNotIn(List<Integer> values) {
            addCriterion("retry not in", values, "retry");
            return (Criteria) this;
        }

        public Criteria andRetryBetween(Integer value1, Integer value2) {
            addCriterion("retry between", value1, value2, "retry");
            return (Criteria) this;
        }

        public Criteria andRetryNotBetween(Integer value1, Integer value2) {
            addCriterion("retry not between", value1, value2, "retry");
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