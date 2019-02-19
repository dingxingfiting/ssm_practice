package com.igeek.crud.bean;

import java.util.ArrayList;
import java.util.List;

public class EmployeeExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public EmployeeExample() {
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

        public Criteria andEIdIsNull() {
            addCriterion("e_id is null");
            return (Criteria) this;
        }

        public Criteria andEIdIsNotNull() {
            addCriterion("e_id is not null");
            return (Criteria) this;
        }

        public Criteria andEIdEqualTo(Integer value) {
            addCriterion("e_id =", value, "eId");
            return (Criteria) this;
        }

        public Criteria andEIdNotEqualTo(Integer value) {
            addCriterion("e_id <>", value, "eId");
            return (Criteria) this;
        }

        public Criteria andEIdGreaterThan(Integer value) {
            addCriterion("e_id >", value, "eId");
            return (Criteria) this;
        }

        public Criteria andEIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("e_id >=", value, "eId");
            return (Criteria) this;
        }

        public Criteria andEIdLessThan(Integer value) {
            addCriterion("e_id <", value, "eId");
            return (Criteria) this;
        }

        public Criteria andEIdLessThanOrEqualTo(Integer value) {
            addCriterion("e_id <=", value, "eId");
            return (Criteria) this;
        }

        public Criteria andEIdIn(List<Integer> values) {
            addCriterion("e_id in", values, "eId");
            return (Criteria) this;
        }

        public Criteria andEIdNotIn(List<Integer> values) {
            addCriterion("e_id not in", values, "eId");
            return (Criteria) this;
        }

        public Criteria andEIdBetween(Integer value1, Integer value2) {
            addCriterion("e_id between", value1, value2, "eId");
            return (Criteria) this;
        }

        public Criteria andEIdNotBetween(Integer value1, Integer value2) {
            addCriterion("e_id not between", value1, value2, "eId");
            return (Criteria) this;
        }

        public Criteria andENameIsNull() {
            addCriterion("e_name is null");
            return (Criteria) this;
        }

        public Criteria andENameIsNotNull() {
            addCriterion("e_name is not null");
            return (Criteria) this;
        }

        public Criteria andENameEqualTo(String value) {
            addCriterion("e_name =", value, "eName");
            return (Criteria) this;
        }

        public Criteria andENameNotEqualTo(String value) {
            addCriterion("e_name <>", value, "eName");
            return (Criteria) this;
        }

        public Criteria andENameGreaterThan(String value) {
            addCriterion("e_name >", value, "eName");
            return (Criteria) this;
        }

        public Criteria andENameGreaterThanOrEqualTo(String value) {
            addCriterion("e_name >=", value, "eName");
            return (Criteria) this;
        }

        public Criteria andENameLessThan(String value) {
            addCriterion("e_name <", value, "eName");
            return (Criteria) this;
        }

        public Criteria andENameLessThanOrEqualTo(String value) {
            addCriterion("e_name <=", value, "eName");
            return (Criteria) this;
        }

        public Criteria andENameLike(String value) {
            addCriterion("e_name like", value, "eName");
            return (Criteria) this;
        }

        public Criteria andENameNotLike(String value) {
            addCriterion("e_name not like", value, "eName");
            return (Criteria) this;
        }

        public Criteria andENameIn(List<String> values) {
            addCriterion("e_name in", values, "eName");
            return (Criteria) this;
        }

        public Criteria andENameNotIn(List<String> values) {
            addCriterion("e_name not in", values, "eName");
            return (Criteria) this;
        }

        public Criteria andENameBetween(String value1, String value2) {
            addCriterion("e_name between", value1, value2, "eName");
            return (Criteria) this;
        }

        public Criteria andENameNotBetween(String value1, String value2) {
            addCriterion("e_name not between", value1, value2, "eName");
            return (Criteria) this;
        }

        public Criteria andEGenderIsNull() {
            addCriterion("e_gender is null");
            return (Criteria) this;
        }

        public Criteria andEGenderIsNotNull() {
            addCriterion("e_gender is not null");
            return (Criteria) this;
        }

        public Criteria andEGenderEqualTo(String value) {
            addCriterion("e_gender =", value, "eGender");
            return (Criteria) this;
        }

        public Criteria andEGenderNotEqualTo(String value) {
            addCriterion("e_gender <>", value, "eGender");
            return (Criteria) this;
        }

        public Criteria andEGenderGreaterThan(String value) {
            addCriterion("e_gender >", value, "eGender");
            return (Criteria) this;
        }

        public Criteria andEGenderGreaterThanOrEqualTo(String value) {
            addCriterion("e_gender >=", value, "eGender");
            return (Criteria) this;
        }

        public Criteria andEGenderLessThan(String value) {
            addCriterion("e_gender <", value, "eGender");
            return (Criteria) this;
        }

        public Criteria andEGenderLessThanOrEqualTo(String value) {
            addCriterion("e_gender <=", value, "eGender");
            return (Criteria) this;
        }

        public Criteria andEGenderLike(String value) {
            addCriterion("e_gender like", value, "eGender");
            return (Criteria) this;
        }

        public Criteria andEGenderNotLike(String value) {
            addCriterion("e_gender not like", value, "eGender");
            return (Criteria) this;
        }

        public Criteria andEGenderIn(List<String> values) {
            addCriterion("e_gender in", values, "eGender");
            return (Criteria) this;
        }

        public Criteria andEGenderNotIn(List<String> values) {
            addCriterion("e_gender not in", values, "eGender");
            return (Criteria) this;
        }

        public Criteria andEGenderBetween(String value1, String value2) {
            addCriterion("e_gender between", value1, value2, "eGender");
            return (Criteria) this;
        }

        public Criteria andEGenderNotBetween(String value1, String value2) {
            addCriterion("e_gender not between", value1, value2, "eGender");
            return (Criteria) this;
        }

        public Criteria andEEmailIsNull() {
            addCriterion("e_email is null");
            return (Criteria) this;
        }

        public Criteria andEEmailIsNotNull() {
            addCriterion("e_email is not null");
            return (Criteria) this;
        }

        public Criteria andEEmailEqualTo(String value) {
            addCriterion("e_email =", value, "eEmail");
            return (Criteria) this;
        }

        public Criteria andEEmailNotEqualTo(String value) {
            addCriterion("e_email <>", value, "eEmail");
            return (Criteria) this;
        }

        public Criteria andEEmailGreaterThan(String value) {
            addCriterion("e_email >", value, "eEmail");
            return (Criteria) this;
        }

        public Criteria andEEmailGreaterThanOrEqualTo(String value) {
            addCriterion("e_email >=", value, "eEmail");
            return (Criteria) this;
        }

        public Criteria andEEmailLessThan(String value) {
            addCriterion("e_email <", value, "eEmail");
            return (Criteria) this;
        }

        public Criteria andEEmailLessThanOrEqualTo(String value) {
            addCriterion("e_email <=", value, "eEmail");
            return (Criteria) this;
        }

        public Criteria andEEmailLike(String value) {
            addCriterion("e_email like", value, "eEmail");
            return (Criteria) this;
        }

        public Criteria andEEmailNotLike(String value) {
            addCriterion("e_email not like", value, "eEmail");
            return (Criteria) this;
        }

        public Criteria andEEmailIn(List<String> values) {
            addCriterion("e_email in", values, "eEmail");
            return (Criteria) this;
        }

        public Criteria andEEmailNotIn(List<String> values) {
            addCriterion("e_email not in", values, "eEmail");
            return (Criteria) this;
        }

        public Criteria andEEmailBetween(String value1, String value2) {
            addCriterion("e_email between", value1, value2, "eEmail");
            return (Criteria) this;
        }

        public Criteria andEEmailNotBetween(String value1, String value2) {
            addCriterion("e_email not between", value1, value2, "eEmail");
            return (Criteria) this;
        }

        public Criteria andDIdIsNull() {
            addCriterion("d_id is null");
            return (Criteria) this;
        }

        public Criteria andDIdIsNotNull() {
            addCriterion("d_id is not null");
            return (Criteria) this;
        }

        public Criteria andDIdEqualTo(Integer value) {
            addCriterion("d_id =", value, "dId");
            return (Criteria) this;
        }

        public Criteria andDIdNotEqualTo(Integer value) {
            addCriterion("d_id <>", value, "dId");
            return (Criteria) this;
        }

        public Criteria andDIdGreaterThan(Integer value) {
            addCriterion("d_id >", value, "dId");
            return (Criteria) this;
        }

        public Criteria andDIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("d_id >=", value, "dId");
            return (Criteria) this;
        }

        public Criteria andDIdLessThan(Integer value) {
            addCriterion("d_id <", value, "dId");
            return (Criteria) this;
        }

        public Criteria andDIdLessThanOrEqualTo(Integer value) {
            addCriterion("d_id <=", value, "dId");
            return (Criteria) this;
        }

        public Criteria andDIdIn(List<Integer> values) {
            addCriterion("d_id in", values, "dId");
            return (Criteria) this;
        }

        public Criteria andDIdNotIn(List<Integer> values) {
            addCriterion("d_id not in", values, "dId");
            return (Criteria) this;
        }

        public Criteria andDIdBetween(Integer value1, Integer value2) {
            addCriterion("d_id between", value1, value2, "dId");
            return (Criteria) this;
        }

        public Criteria andDIdNotBetween(Integer value1, Integer value2) {
            addCriterion("d_id not between", value1, value2, "dId");
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