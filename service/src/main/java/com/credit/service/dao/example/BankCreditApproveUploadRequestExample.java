package com.credit.service.dao.example;

import java.util.ArrayList;
import java.util.List;

public class BankCreditApproveUploadRequestExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BankCreditApproveUploadRequestExample() {
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

        public Criteria andApplynoIsNull() {
            addCriterion("applyNo is null");
            return (Criteria) this;
        }

        public Criteria andApplynoIsNotNull() {
            addCriterion("applyNo is not null");
            return (Criteria) this;
        }

        public Criteria andApplynoEqualTo(String value) {
            addCriterion("applyNo =", value, "applyno");
            return (Criteria) this;
        }

        public Criteria andApplynoNotEqualTo(String value) {
            addCriterion("applyNo <>", value, "applyno");
            return (Criteria) this;
        }

        public Criteria andApplynoGreaterThan(String value) {
            addCriterion("applyNo >", value, "applyno");
            return (Criteria) this;
        }

        public Criteria andApplynoGreaterThanOrEqualTo(String value) {
            addCriterion("applyNo >=", value, "applyno");
            return (Criteria) this;
        }

        public Criteria andApplynoLessThan(String value) {
            addCriterion("applyNo <", value, "applyno");
            return (Criteria) this;
        }

        public Criteria andApplynoLessThanOrEqualTo(String value) {
            addCriterion("applyNo <=", value, "applyno");
            return (Criteria) this;
        }

        public Criteria andApplynoLike(String value) {
            addCriterion("applyNo like", value, "applyno");
            return (Criteria) this;
        }

        public Criteria andApplynoNotLike(String value) {
            addCriterion("applyNo not like", value, "applyno");
            return (Criteria) this;
        }

        public Criteria andApplynoIn(List<String> values) {
            addCriterion("applyNo in", values, "applyno");
            return (Criteria) this;
        }

        public Criteria andApplynoNotIn(List<String> values) {
            addCriterion("applyNo not in", values, "applyno");
            return (Criteria) this;
        }

        public Criteria andApplynoBetween(String value1, String value2) {
            addCriterion("applyNo between", value1, value2, "applyno");
            return (Criteria) this;
        }

        public Criteria andApplynoNotBetween(String value1, String value2) {
            addCriterion("applyNo not between", value1, value2, "applyno");
            return (Criteria) this;
        }

        public Criteria andCategoryIsNull() {
            addCriterion("category is null");
            return (Criteria) this;
        }

        public Criteria andCategoryIsNotNull() {
            addCriterion("category is not null");
            return (Criteria) this;
        }

        public Criteria andCategoryEqualTo(String value) {
            addCriterion("category =", value, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryNotEqualTo(String value) {
            addCriterion("category <>", value, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryGreaterThan(String value) {
            addCriterion("category >", value, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryGreaterThanOrEqualTo(String value) {
            addCriterion("category >=", value, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryLessThan(String value) {
            addCriterion("category <", value, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryLessThanOrEqualTo(String value) {
            addCriterion("category <=", value, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryLike(String value) {
            addCriterion("category like", value, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryNotLike(String value) {
            addCriterion("category not like", value, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryIn(List<String> values) {
            addCriterion("category in", values, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryNotIn(List<String> values) {
            addCriterion("category not in", values, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryBetween(String value1, String value2) {
            addCriterion("category between", value1, value2, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryNotBetween(String value1, String value2) {
            addCriterion("category not between", value1, value2, "category");
            return (Criteria) this;
        }

        public Criteria andCertnameIsNull() {
            addCriterion("certName is null");
            return (Criteria) this;
        }

        public Criteria andCertnameIsNotNull() {
            addCriterion("certName is not null");
            return (Criteria) this;
        }

        public Criteria andCertnameEqualTo(String value) {
            addCriterion("certName =", value, "certname");
            return (Criteria) this;
        }

        public Criteria andCertnameNotEqualTo(String value) {
            addCriterion("certName <>", value, "certname");
            return (Criteria) this;
        }

        public Criteria andCertnameGreaterThan(String value) {
            addCriterion("certName >", value, "certname");
            return (Criteria) this;
        }

        public Criteria andCertnameGreaterThanOrEqualTo(String value) {
            addCriterion("certName >=", value, "certname");
            return (Criteria) this;
        }

        public Criteria andCertnameLessThan(String value) {
            addCriterion("certName <", value, "certname");
            return (Criteria) this;
        }

        public Criteria andCertnameLessThanOrEqualTo(String value) {
            addCriterion("certName <=", value, "certname");
            return (Criteria) this;
        }

        public Criteria andCertnameLike(String value) {
            addCriterion("certName like", value, "certname");
            return (Criteria) this;
        }

        public Criteria andCertnameNotLike(String value) {
            addCriterion("certName not like", value, "certname");
            return (Criteria) this;
        }

        public Criteria andCertnameIn(List<String> values) {
            addCriterion("certName in", values, "certname");
            return (Criteria) this;
        }

        public Criteria andCertnameNotIn(List<String> values) {
            addCriterion("certName not in", values, "certname");
            return (Criteria) this;
        }

        public Criteria andCertnameBetween(String value1, String value2) {
            addCriterion("certName between", value1, value2, "certname");
            return (Criteria) this;
        }

        public Criteria andCertnameNotBetween(String value1, String value2) {
            addCriterion("certName not between", value1, value2, "certname");
            return (Criteria) this;
        }

        public Criteria andCertnoIsNull() {
            addCriterion("certNo is null");
            return (Criteria) this;
        }

        public Criteria andCertnoIsNotNull() {
            addCriterion("certNo is not null");
            return (Criteria) this;
        }

        public Criteria andCertnoEqualTo(String value) {
            addCriterion("certNo =", value, "certno");
            return (Criteria) this;
        }

        public Criteria andCertnoNotEqualTo(String value) {
            addCriterion("certNo <>", value, "certno");
            return (Criteria) this;
        }

        public Criteria andCertnoGreaterThan(String value) {
            addCriterion("certNo >", value, "certno");
            return (Criteria) this;
        }

        public Criteria andCertnoGreaterThanOrEqualTo(String value) {
            addCriterion("certNo >=", value, "certno");
            return (Criteria) this;
        }

        public Criteria andCertnoLessThan(String value) {
            addCriterion("certNo <", value, "certno");
            return (Criteria) this;
        }

        public Criteria andCertnoLessThanOrEqualTo(String value) {
            addCriterion("certNo <=", value, "certno");
            return (Criteria) this;
        }

        public Criteria andCertnoLike(String value) {
            addCriterion("certNo like", value, "certno");
            return (Criteria) this;
        }

        public Criteria andCertnoNotLike(String value) {
            addCriterion("certNo not like", value, "certno");
            return (Criteria) this;
        }

        public Criteria andCertnoIn(List<String> values) {
            addCriterion("certNo in", values, "certno");
            return (Criteria) this;
        }

        public Criteria andCertnoNotIn(List<String> values) {
            addCriterion("certNo not in", values, "certno");
            return (Criteria) this;
        }

        public Criteria andCertnoBetween(String value1, String value2) {
            addCriterion("certNo between", value1, value2, "certno");
            return (Criteria) this;
        }

        public Criteria andCertnoNotBetween(String value1, String value2) {
            addCriterion("certNo not between", value1, value2, "certno");
            return (Criteria) this;
        }

        public Criteria andObjectcontentIsNull() {
            addCriterion("objectContent is null");
            return (Criteria) this;
        }

        public Criteria andObjectcontentIsNotNull() {
            addCriterion("objectContent is not null");
            return (Criteria) this;
        }

        public Criteria andObjectcontentEqualTo(String value) {
            addCriterion("objectContent =", value, "objectcontent");
            return (Criteria) this;
        }

        public Criteria andObjectcontentNotEqualTo(String value) {
            addCriterion("objectContent <>", value, "objectcontent");
            return (Criteria) this;
        }

        public Criteria andObjectcontentGreaterThan(String value) {
            addCriterion("objectContent >", value, "objectcontent");
            return (Criteria) this;
        }

        public Criteria andObjectcontentGreaterThanOrEqualTo(String value) {
            addCriterion("objectContent >=", value, "objectcontent");
            return (Criteria) this;
        }

        public Criteria andObjectcontentLessThan(String value) {
            addCriterion("objectContent <", value, "objectcontent");
            return (Criteria) this;
        }

        public Criteria andObjectcontentLessThanOrEqualTo(String value) {
            addCriterion("objectContent <=", value, "objectcontent");
            return (Criteria) this;
        }

        public Criteria andObjectcontentLike(String value) {
            addCriterion("objectContent like", value, "objectcontent");
            return (Criteria) this;
        }

        public Criteria andObjectcontentNotLike(String value) {
            addCriterion("objectContent not like", value, "objectcontent");
            return (Criteria) this;
        }

        public Criteria andObjectcontentIn(List<String> values) {
            addCriterion("objectContent in", values, "objectcontent");
            return (Criteria) this;
        }

        public Criteria andObjectcontentNotIn(List<String> values) {
            addCriterion("objectContent not in", values, "objectcontent");
            return (Criteria) this;
        }

        public Criteria andObjectcontentBetween(String value1, String value2) {
            addCriterion("objectContent between", value1, value2, "objectcontent");
            return (Criteria) this;
        }

        public Criteria andObjectcontentNotBetween(String value1, String value2) {
            addCriterion("objectContent not between", value1, value2, "objectcontent");
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