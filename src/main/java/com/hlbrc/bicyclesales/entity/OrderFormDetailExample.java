package com.hlbrc.bicyclesales.entity;

import java.util.ArrayList;
import java.util.List;

public class OrderFormDetailExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public OrderFormDetailExample() {
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

        public Criteria andOrderformdetailidIsNull() {
            addCriterion("orderFormDetailId is null");
            return (Criteria) this;
        }

        public Criteria andOrderformdetailidIsNotNull() {
            addCriterion("orderFormDetailId is not null");
            return (Criteria) this;
        }

        public Criteria andOrderformdetailidEqualTo(Integer value) {
            addCriterion("orderFormDetailId =", value, "orderformdetailid");
            return (Criteria) this;
        }

        public Criteria andOrderformdetailidNotEqualTo(Integer value) {
            addCriterion("orderFormDetailId <>", value, "orderformdetailid");
            return (Criteria) this;
        }

        public Criteria andOrderformdetailidGreaterThan(Integer value) {
            addCriterion("orderFormDetailId >", value, "orderformdetailid");
            return (Criteria) this;
        }

        public Criteria andOrderformdetailidGreaterThanOrEqualTo(Integer value) {
            addCriterion("orderFormDetailId >=", value, "orderformdetailid");
            return (Criteria) this;
        }

        public Criteria andOrderformdetailidLessThan(Integer value) {
            addCriterion("orderFormDetailId <", value, "orderformdetailid");
            return (Criteria) this;
        }

        public Criteria andOrderformdetailidLessThanOrEqualTo(Integer value) {
            addCriterion("orderFormDetailId <=", value, "orderformdetailid");
            return (Criteria) this;
        }

        public Criteria andOrderformdetailidIn(List<Integer> values) {
            addCriterion("orderFormDetailId in", values, "orderformdetailid");
            return (Criteria) this;
        }

        public Criteria andOrderformdetailidNotIn(List<Integer> values) {
            addCriterion("orderFormDetailId not in", values, "orderformdetailid");
            return (Criteria) this;
        }

        public Criteria andOrderformdetailidBetween(Integer value1, Integer value2) {
            addCriterion("orderFormDetailId between", value1, value2, "orderformdetailid");
            return (Criteria) this;
        }

        public Criteria andOrderformdetailidNotBetween(Integer value1, Integer value2) {
            addCriterion("orderFormDetailId not between", value1, value2, "orderformdetailid");
            return (Criteria) this;
        }

        public Criteria andOrderformidIsNull() {
            addCriterion("orderFormId is null");
            return (Criteria) this;
        }

        public Criteria andOrderformidIsNotNull() {
            addCriterion("orderFormId is not null");
            return (Criteria) this;
        }

        public Criteria andOrderformidEqualTo(Integer value) {
            addCriterion("orderFormId =", value, "orderformid");
            return (Criteria) this;
        }

        public Criteria andOrderformidNotEqualTo(Integer value) {
            addCriterion("orderFormId <>", value, "orderformid");
            return (Criteria) this;
        }

        public Criteria andOrderformidGreaterThan(Integer value) {
            addCriterion("orderFormId >", value, "orderformid");
            return (Criteria) this;
        }

        public Criteria andOrderformidGreaterThanOrEqualTo(Integer value) {
            addCriterion("orderFormId >=", value, "orderformid");
            return (Criteria) this;
        }

        public Criteria andOrderformidLessThan(Integer value) {
            addCriterion("orderFormId <", value, "orderformid");
            return (Criteria) this;
        }

        public Criteria andOrderformidLessThanOrEqualTo(Integer value) {
            addCriterion("orderFormId <=", value, "orderformid");
            return (Criteria) this;
        }

        public Criteria andOrderformidIn(List<Integer> values) {
            addCriterion("orderFormId in", values, "orderformid");
            return (Criteria) this;
        }

        public Criteria andOrderformidNotIn(List<Integer> values) {
            addCriterion("orderFormId not in", values, "orderformid");
            return (Criteria) this;
        }

        public Criteria andOrderformidBetween(Integer value1, Integer value2) {
            addCriterion("orderFormId between", value1, value2, "orderformid");
            return (Criteria) this;
        }

        public Criteria andOrderformidNotBetween(Integer value1, Integer value2) {
            addCriterion("orderFormId not between", value1, value2, "orderformid");
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

        public Criteria andNumIsNull() {
            addCriterion("num is null");
            return (Criteria) this;
        }

        public Criteria andNumIsNotNull() {
            addCriterion("num is not null");
            return (Criteria) this;
        }

        public Criteria andNumEqualTo(Double value) {
            addCriterion("num =", value, "num");
            return (Criteria) this;
        }

        public Criteria andNumNotEqualTo(Double value) {
            addCriterion("num <>", value, "num");
            return (Criteria) this;
        }

        public Criteria andNumGreaterThan(Double value) {
            addCriterion("num >", value, "num");
            return (Criteria) this;
        }

        public Criteria andNumGreaterThanOrEqualTo(Double value) {
            addCriterion("num >=", value, "num");
            return (Criteria) this;
        }

        public Criteria andNumLessThan(Double value) {
            addCriterion("num <", value, "num");
            return (Criteria) this;
        }

        public Criteria andNumLessThanOrEqualTo(Double value) {
            addCriterion("num <=", value, "num");
            return (Criteria) this;
        }

        public Criteria andNumIn(List<Double> values) {
            addCriterion("num in", values, "num");
            return (Criteria) this;
        }

        public Criteria andNumNotIn(List<Double> values) {
            addCriterion("num not in", values, "num");
            return (Criteria) this;
        }

        public Criteria andNumBetween(Double value1, Double value2) {
            addCriterion("num between", value1, value2, "num");
            return (Criteria) this;
        }

        public Criteria andNumNotBetween(Double value1, Double value2) {
            addCriterion("num not between", value1, value2, "num");
            return (Criteria) this;
        }

        public Criteria andMoneyIsNull() {
            addCriterion("money is null");
            return (Criteria) this;
        }

        public Criteria andMoneyIsNotNull() {
            addCriterion("money is not null");
            return (Criteria) this;
        }

        public Criteria andMoneyEqualTo(Double value) {
            addCriterion("money =", value, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyNotEqualTo(Double value) {
            addCriterion("money <>", value, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyGreaterThan(Double value) {
            addCriterion("money >", value, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyGreaterThanOrEqualTo(Double value) {
            addCriterion("money >=", value, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyLessThan(Double value) {
            addCriterion("money <", value, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyLessThanOrEqualTo(Double value) {
            addCriterion("money <=", value, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyIn(List<Double> values) {
            addCriterion("money in", values, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyNotIn(List<Double> values) {
            addCriterion("money not in", values, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyBetween(Double value1, Double value2) {
            addCriterion("money between", value1, value2, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyNotBetween(Double value1, Double value2) {
            addCriterion("money not between", value1, value2, "money");
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