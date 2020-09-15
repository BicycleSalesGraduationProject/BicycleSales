package com.hlbrc.bicyclesales.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OrderFormExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public OrderFormExample() {
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

        public Criteria andAdsidIsNull() {
            addCriterion("adsId is null");
            return (Criteria) this;
        }

        public Criteria andAdsidIsNotNull() {
            addCriterion("adsId is not null");
            return (Criteria) this;
        }

        public Criteria andAdsidEqualTo(Integer value) {
            addCriterion("adsId =", value, "adsid");
            return (Criteria) this;
        }

        public Criteria andAdsidNotEqualTo(Integer value) {
            addCriterion("adsId <>", value, "adsid");
            return (Criteria) this;
        }

        public Criteria andAdsidGreaterThan(Integer value) {
            addCriterion("adsId >", value, "adsid");
            return (Criteria) this;
        }

        public Criteria andAdsidGreaterThanOrEqualTo(Integer value) {
            addCriterion("adsId >=", value, "adsid");
            return (Criteria) this;
        }

        public Criteria andAdsidLessThan(Integer value) {
            addCriterion("adsId <", value, "adsid");
            return (Criteria) this;
        }

        public Criteria andAdsidLessThanOrEqualTo(Integer value) {
            addCriterion("adsId <=", value, "adsid");
            return (Criteria) this;
        }

        public Criteria andAdsidIn(List<Integer> values) {
            addCriterion("adsId in", values, "adsid");
            return (Criteria) this;
        }

        public Criteria andAdsidNotIn(List<Integer> values) {
            addCriterion("adsId not in", values, "adsid");
            return (Criteria) this;
        }

        public Criteria andAdsidBetween(Integer value1, Integer value2) {
            addCriterion("adsId between", value1, value2, "adsid");
            return (Criteria) this;
        }

        public Criteria andAdsidNotBetween(Integer value1, Integer value2) {
            addCriterion("adsId not between", value1, value2, "adsid");
            return (Criteria) this;
        }

        public Criteria andTotalnumIsNull() {
            addCriterion("totalNum is null");
            return (Criteria) this;
        }

        public Criteria andTotalnumIsNotNull() {
            addCriterion("totalNum is not null");
            return (Criteria) this;
        }

        public Criteria andTotalnumEqualTo(Integer value) {
            addCriterion("totalNum =", value, "totalnum");
            return (Criteria) this;
        }

        public Criteria andTotalnumNotEqualTo(Integer value) {
            addCriterion("totalNum <>", value, "totalnum");
            return (Criteria) this;
        }

        public Criteria andTotalnumGreaterThan(Integer value) {
            addCriterion("totalNum >", value, "totalnum");
            return (Criteria) this;
        }

        public Criteria andTotalnumGreaterThanOrEqualTo(Integer value) {
            addCriterion("totalNum >=", value, "totalnum");
            return (Criteria) this;
        }

        public Criteria andTotalnumLessThan(Integer value) {
            addCriterion("totalNum <", value, "totalnum");
            return (Criteria) this;
        }

        public Criteria andTotalnumLessThanOrEqualTo(Integer value) {
            addCriterion("totalNum <=", value, "totalnum");
            return (Criteria) this;
        }

        public Criteria andTotalnumIn(List<Integer> values) {
            addCriterion("totalNum in", values, "totalnum");
            return (Criteria) this;
        }

        public Criteria andTotalnumNotIn(List<Integer> values) {
            addCriterion("totalNum not in", values, "totalnum");
            return (Criteria) this;
        }

        public Criteria andTotalnumBetween(Integer value1, Integer value2) {
            addCriterion("totalNum between", value1, value2, "totalnum");
            return (Criteria) this;
        }

        public Criteria andTotalnumNotBetween(Integer value1, Integer value2) {
            addCriterion("totalNum not between", value1, value2, "totalnum");
            return (Criteria) this;
        }

        public Criteria andTotalmoneyIsNull() {
            addCriterion("totalMoney is null");
            return (Criteria) this;
        }

        public Criteria andTotalmoneyIsNotNull() {
            addCriterion("totalMoney is not null");
            return (Criteria) this;
        }

        public Criteria andTotalmoneyEqualTo(Double value) {
            addCriterion("totalMoney =", value, "totalmoney");
            return (Criteria) this;
        }

        public Criteria andTotalmoneyNotEqualTo(Double value) {
            addCriterion("totalMoney <>", value, "totalmoney");
            return (Criteria) this;
        }

        public Criteria andTotalmoneyGreaterThan(Double value) {
            addCriterion("totalMoney >", value, "totalmoney");
            return (Criteria) this;
        }

        public Criteria andTotalmoneyGreaterThanOrEqualTo(Double value) {
            addCriterion("totalMoney >=", value, "totalmoney");
            return (Criteria) this;
        }

        public Criteria andTotalmoneyLessThan(Double value) {
            addCriterion("totalMoney <", value, "totalmoney");
            return (Criteria) this;
        }

        public Criteria andTotalmoneyLessThanOrEqualTo(Double value) {
            addCriterion("totalMoney <=", value, "totalmoney");
            return (Criteria) this;
        }

        public Criteria andTotalmoneyIn(List<Double> values) {
            addCriterion("totalMoney in", values, "totalmoney");
            return (Criteria) this;
        }

        public Criteria andTotalmoneyNotIn(List<Double> values) {
            addCriterion("totalMoney not in", values, "totalmoney");
            return (Criteria) this;
        }

        public Criteria andTotalmoneyBetween(Double value1, Double value2) {
            addCriterion("totalMoney between", value1, value2, "totalmoney");
            return (Criteria) this;
        }

        public Criteria andTotalmoneyNotBetween(Double value1, Double value2) {
            addCriterion("totalMoney not between", value1, value2, "totalmoney");
            return (Criteria) this;
        }

        public Criteria andOrderformstateIsNull() {
            addCriterion("orderFormState is null");
            return (Criteria) this;
        }

        public Criteria andOrderformstateIsNotNull() {
            addCriterion("orderFormState is not null");
            return (Criteria) this;
        }

        public Criteria andOrderformstateEqualTo(String value) {
            addCriterion("orderFormState =", value, "orderformstate");
            return (Criteria) this;
        }

        public Criteria andOrderformstateNotEqualTo(String value) {
            addCriterion("orderFormState <>", value, "orderformstate");
            return (Criteria) this;
        }

        public Criteria andOrderformstateGreaterThan(String value) {
            addCriterion("orderFormState >", value, "orderformstate");
            return (Criteria) this;
        }

        public Criteria andOrderformstateGreaterThanOrEqualTo(String value) {
            addCriterion("orderFormState >=", value, "orderformstate");
            return (Criteria) this;
        }

        public Criteria andOrderformstateLessThan(String value) {
            addCriterion("orderFormState <", value, "orderformstate");
            return (Criteria) this;
        }

        public Criteria andOrderformstateLessThanOrEqualTo(String value) {
            addCriterion("orderFormState <=", value, "orderformstate");
            return (Criteria) this;
        }

        public Criteria andOrderformstateLike(String value) {
            addCriterion("orderFormState like", value, "orderformstate");
            return (Criteria) this;
        }

        public Criteria andOrderformstateNotLike(String value) {
            addCriterion("orderFormState not like", value, "orderformstate");
            return (Criteria) this;
        }

        public Criteria andOrderformstateIn(List<String> values) {
            addCriterion("orderFormState in", values, "orderformstate");
            return (Criteria) this;
        }

        public Criteria andOrderformstateNotIn(List<String> values) {
            addCriterion("orderFormState not in", values, "orderformstate");
            return (Criteria) this;
        }

        public Criteria andOrderformstateBetween(String value1, String value2) {
            addCriterion("orderFormState between", value1, value2, "orderformstate");
            return (Criteria) this;
        }

        public Criteria andOrderformstateNotBetween(String value1, String value2) {
            addCriterion("orderFormState not between", value1, value2, "orderformstate");
            return (Criteria) this;
        }

        public Criteria andPaymoneystateIsNull() {
            addCriterion("payMoneyState is null");
            return (Criteria) this;
        }

        public Criteria andPaymoneystateIsNotNull() {
            addCriterion("payMoneyState is not null");
            return (Criteria) this;
        }

        public Criteria andPaymoneystateEqualTo(String value) {
            addCriterion("payMoneyState =", value, "paymoneystate");
            return (Criteria) this;
        }

        public Criteria andPaymoneystateNotEqualTo(String value) {
            addCriterion("payMoneyState <>", value, "paymoneystate");
            return (Criteria) this;
        }

        public Criteria andPaymoneystateGreaterThan(String value) {
            addCriterion("payMoneyState >", value, "paymoneystate");
            return (Criteria) this;
        }

        public Criteria andPaymoneystateGreaterThanOrEqualTo(String value) {
            addCriterion("payMoneyState >=", value, "paymoneystate");
            return (Criteria) this;
        }

        public Criteria andPaymoneystateLessThan(String value) {
            addCriterion("payMoneyState <", value, "paymoneystate");
            return (Criteria) this;
        }

        public Criteria andPaymoneystateLessThanOrEqualTo(String value) {
            addCriterion("payMoneyState <=", value, "paymoneystate");
            return (Criteria) this;
        }

        public Criteria andPaymoneystateLike(String value) {
            addCriterion("payMoneyState like", value, "paymoneystate");
            return (Criteria) this;
        }

        public Criteria andPaymoneystateNotLike(String value) {
            addCriterion("payMoneyState not like", value, "paymoneystate");
            return (Criteria) this;
        }

        public Criteria andPaymoneystateIn(List<String> values) {
            addCriterion("payMoneyState in", values, "paymoneystate");
            return (Criteria) this;
        }

        public Criteria andPaymoneystateNotIn(List<String> values) {
            addCriterion("payMoneyState not in", values, "paymoneystate");
            return (Criteria) this;
        }

        public Criteria andPaymoneystateBetween(String value1, String value2) {
            addCriterion("payMoneyState between", value1, value2, "paymoneystate");
            return (Criteria) this;
        }

        public Criteria andPaymoneystateNotBetween(String value1, String value2) {
            addCriterion("payMoneyState not between", value1, value2, "paymoneystate");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIsNull() {
            addCriterion("createTime is null");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIsNotNull() {
            addCriterion("createTime is not null");
            return (Criteria) this;
        }

        public Criteria andCreatetimeEqualTo(Date value) {
            addCriterion("createTime =", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotEqualTo(Date value) {
            addCriterion("createTime <>", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeGreaterThan(Date value) {
            addCriterion("createTime >", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("createTime >=", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeLessThan(Date value) {
            addCriterion("createTime <", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeLessThanOrEqualTo(Date value) {
            addCriterion("createTime <=", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIn(List<Date> values) {
            addCriterion("createTime in", values, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotIn(List<Date> values) {
            addCriterion("createTime not in", values, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeBetween(Date value1, Date value2) {
            addCriterion("createTime between", value1, value2, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotBetween(Date value1, Date value2) {
            addCriterion("createTime not between", value1, value2, "createtime");
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