package com.hlbrc.bicyclesales.entity;

import java.util.ArrayList;
import java.util.List;

public class BicyclePartCrrExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BicyclePartCrrExample() {
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

        public Criteria andBicyclepartcrridIsNull() {
            addCriterion("bicyclePartCrrId is null");
            return (Criteria) this;
        }

        public Criteria andBicyclepartcrridIsNotNull() {
            addCriterion("bicyclePartCrrId is not null");
            return (Criteria) this;
        }

        public Criteria andBicyclepartcrridEqualTo(Integer value) {
            addCriterion("bicyclePartCrrId =", value, "bicyclepartcrrid");
            return (Criteria) this;
        }

        public Criteria andBicyclepartcrridNotEqualTo(Integer value) {
            addCriterion("bicyclePartCrrId <>", value, "bicyclepartcrrid");
            return (Criteria) this;
        }

        public Criteria andBicyclepartcrridGreaterThan(Integer value) {
            addCriterion("bicyclePartCrrId >", value, "bicyclepartcrrid");
            return (Criteria) this;
        }

        public Criteria andBicyclepartcrridGreaterThanOrEqualTo(Integer value) {
            addCriterion("bicyclePartCrrId >=", value, "bicyclepartcrrid");
            return (Criteria) this;
        }

        public Criteria andBicyclepartcrridLessThan(Integer value) {
            addCriterion("bicyclePartCrrId <", value, "bicyclepartcrrid");
            return (Criteria) this;
        }

        public Criteria andBicyclepartcrridLessThanOrEqualTo(Integer value) {
            addCriterion("bicyclePartCrrId <=", value, "bicyclepartcrrid");
            return (Criteria) this;
        }

        public Criteria andBicyclepartcrridIn(List<Integer> values) {
            addCriterion("bicyclePartCrrId in", values, "bicyclepartcrrid");
            return (Criteria) this;
        }

        public Criteria andBicyclepartcrridNotIn(List<Integer> values) {
            addCriterion("bicyclePartCrrId not in", values, "bicyclepartcrrid");
            return (Criteria) this;
        }

        public Criteria andBicyclepartcrridBetween(Integer value1, Integer value2) {
            addCriterion("bicyclePartCrrId between", value1, value2, "bicyclepartcrrid");
            return (Criteria) this;
        }

        public Criteria andBicyclepartcrridNotBetween(Integer value1, Integer value2) {
            addCriterion("bicyclePartCrrId not between", value1, value2, "bicyclepartcrrid");
            return (Criteria) this;
        }

        public Criteria andBicycleidIsNull() {
            addCriterion("bicycleId is null");
            return (Criteria) this;
        }

        public Criteria andBicycleidIsNotNull() {
            addCriterion("bicycleId is not null");
            return (Criteria) this;
        }

        public Criteria andBicycleidEqualTo(Integer value) {
            addCriterion("bicycleId =", value, "bicycleid");
            return (Criteria) this;
        }

        public Criteria andBicycleidNotEqualTo(Integer value) {
            addCriterion("bicycleId <>", value, "bicycleid");
            return (Criteria) this;
        }

        public Criteria andBicycleidGreaterThan(Integer value) {
            addCriterion("bicycleId >", value, "bicycleid");
            return (Criteria) this;
        }

        public Criteria andBicycleidGreaterThanOrEqualTo(Integer value) {
            addCriterion("bicycleId >=", value, "bicycleid");
            return (Criteria) this;
        }

        public Criteria andBicycleidLessThan(Integer value) {
            addCriterion("bicycleId <", value, "bicycleid");
            return (Criteria) this;
        }

        public Criteria andBicycleidLessThanOrEqualTo(Integer value) {
            addCriterion("bicycleId <=", value, "bicycleid");
            return (Criteria) this;
        }

        public Criteria andBicycleidIn(List<Integer> values) {
            addCriterion("bicycleId in", values, "bicycleid");
            return (Criteria) this;
        }

        public Criteria andBicycleidNotIn(List<Integer> values) {
            addCriterion("bicycleId not in", values, "bicycleid");
            return (Criteria) this;
        }

        public Criteria andBicycleidBetween(Integer value1, Integer value2) {
            addCriterion("bicycleId between", value1, value2, "bicycleid");
            return (Criteria) this;
        }

        public Criteria andBicycleidNotBetween(Integer value1, Integer value2) {
            addCriterion("bicycleId not between", value1, value2, "bicycleid");
            return (Criteria) this;
        }

        public Criteria andPartmessageidIsNull() {
            addCriterion("partMessageId is null");
            return (Criteria) this;
        }

        public Criteria andPartmessageidIsNotNull() {
            addCriterion("partMessageId is not null");
            return (Criteria) this;
        }

        public Criteria andPartmessageidEqualTo(Integer value) {
            addCriterion("partMessageId =", value, "partmessageid");
            return (Criteria) this;
        }

        public Criteria andPartmessageidNotEqualTo(Integer value) {
            addCriterion("partMessageId <>", value, "partmessageid");
            return (Criteria) this;
        }

        public Criteria andPartmessageidGreaterThan(Integer value) {
            addCriterion("partMessageId >", value, "partmessageid");
            return (Criteria) this;
        }

        public Criteria andPartmessageidGreaterThanOrEqualTo(Integer value) {
            addCriterion("partMessageId >=", value, "partmessageid");
            return (Criteria) this;
        }

        public Criteria andPartmessageidLessThan(Integer value) {
            addCriterion("partMessageId <", value, "partmessageid");
            return (Criteria) this;
        }

        public Criteria andPartmessageidLessThanOrEqualTo(Integer value) {
            addCriterion("partMessageId <=", value, "partmessageid");
            return (Criteria) this;
        }

        public Criteria andPartmessageidIn(List<Integer> values) {
            addCriterion("partMessageId in", values, "partmessageid");
            return (Criteria) this;
        }

        public Criteria andPartmessageidNotIn(List<Integer> values) {
            addCriterion("partMessageId not in", values, "partmessageid");
            return (Criteria) this;
        }

        public Criteria andPartmessageidBetween(Integer value1, Integer value2) {
            addCriterion("partMessageId between", value1, value2, "partmessageid");
            return (Criteria) this;
        }

        public Criteria andPartmessageidNotBetween(Integer value1, Integer value2) {
            addCriterion("partMessageId not between", value1, value2, "partmessageid");
            return (Criteria) this;
        }

        public Criteria andOrdernoIsNull() {
            addCriterion("orderno is null");
            return (Criteria) this;
        }

        public Criteria andOrdernoIsNotNull() {
            addCriterion("orderno is not null");
            return (Criteria) this;
        }

        public Criteria andOrdernoEqualTo(String value) {
            addCriterion("orderno =", value, "orderno");
            return (Criteria) this;
        }

        public Criteria andOrdernoNotEqualTo(String value) {
            addCriterion("orderno <>", value, "orderno");
            return (Criteria) this;
        }

        public Criteria andOrdernoGreaterThan(String value) {
            addCriterion("orderno >", value, "orderno");
            return (Criteria) this;
        }

        public Criteria andOrdernoGreaterThanOrEqualTo(String value) {
            addCriterion("orderno >=", value, "orderno");
            return (Criteria) this;
        }

        public Criteria andOrdernoLessThan(String value) {
            addCriterion("orderno <", value, "orderno");
            return (Criteria) this;
        }

        public Criteria andOrdernoLessThanOrEqualTo(String value) {
            addCriterion("orderno <=", value, "orderno");
            return (Criteria) this;
        }

        public Criteria andOrdernoLike(String value) {
            addCriterion("orderno like", value, "orderno");
            return (Criteria) this;
        }

        public Criteria andOrdernoNotLike(String value) {
            addCriterion("orderno not like", value, "orderno");
            return (Criteria) this;
        }

        public Criteria andOrdernoIn(List<String> values) {
            addCriterion("orderno in", values, "orderno");
            return (Criteria) this;
        }

        public Criteria andOrdernoNotIn(List<String> values) {
            addCriterion("orderno not in", values, "orderno");
            return (Criteria) this;
        }

        public Criteria andOrdernoBetween(String value1, String value2) {
            addCriterion("orderno between", value1, value2, "orderno");
            return (Criteria) this;
        }

        public Criteria andOrdernoNotBetween(String value1, String value2) {
            addCriterion("orderno not between", value1, value2, "orderno");
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