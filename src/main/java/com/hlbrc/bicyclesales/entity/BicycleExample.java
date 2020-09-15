package com.hlbrc.bicyclesales.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BicycleExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;
    private Integer pageIndex;
    private Integer pageSize;
     public Integer getPageIndex() {
         return pageIndex;
     }
     public void setPageIndex(Integer pageIndex) {
         this.pageIndex = pageIndex;
     }
     public Integer getPageSize() {
         return pageSize;
     }
     public void setPageSize(Integer pageSize) {
         this.pageSize = pageSize;
     }

    public BicycleExample() {
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

        public Criteria andBicycletypeidIsNull() {
            addCriterion("bicycleTypeId is null");
            return (Criteria) this;
        }

        public Criteria andBicycletypeidIsNotNull() {
            addCriterion("bicycleTypeId is not null");
            return (Criteria) this;
        }

        public Criteria andBicycletypeidEqualTo(Integer value) {
            addCriterion("bicycleTypeId =", value, "bicycletypeid");
            return (Criteria) this;
        }

        public Criteria andBicycletypeidNotEqualTo(Integer value) {
            addCriterion("bicycleTypeId <>", value, "bicycletypeid");
            return (Criteria) this;
        }

        public Criteria andBicycletypeidGreaterThan(Integer value) {
            addCriterion("bicycleTypeId >", value, "bicycletypeid");
            return (Criteria) this;
        }

        public Criteria andBicycletypeidGreaterThanOrEqualTo(Integer value) {
            addCriterion("bicycleTypeId >=", value, "bicycletypeid");
            return (Criteria) this;
        }

        public Criteria andBicycletypeidLessThan(Integer value) {
            addCriterion("bicycleTypeId <", value, "bicycletypeid");
            return (Criteria) this;
        }

        public Criteria andBicycletypeidLessThanOrEqualTo(Integer value) {
            addCriterion("bicycleTypeId <=", value, "bicycletypeid");
            return (Criteria) this;
        }

        public Criteria andBicycletypeidIn(List<Integer> values) {
            addCriterion("bicycleTypeId in", values, "bicycletypeid");
            return (Criteria) this;
        }

        public Criteria andBicycletypeidNotIn(List<Integer> values) {
            addCriterion("bicycleTypeId not in", values, "bicycletypeid");
            return (Criteria) this;
        }

        public Criteria andBicycletypeidBetween(Integer value1, Integer value2) {
            addCriterion("bicycleTypeId between", value1, value2, "bicycletypeid");
            return (Criteria) this;
        }

        public Criteria andBicycletypeidNotBetween(Integer value1, Integer value2) {
            addCriterion("bicycleTypeId not between", value1, value2, "bicycletypeid");
            return (Criteria) this;
        }

        public Criteria andNameIsNull() {
            addCriterion("name is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("name is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("name =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("name <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("name >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("name >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("name <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("name <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("name like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("name not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("name in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("name not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("name between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("name not between", value1, value2, "name");
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

        public Criteria andInventoryIsNull() {
            addCriterion("inventory is null");
            return (Criteria) this;
        }

        public Criteria andInventoryIsNotNull() {
            addCriterion("inventory is not null");
            return (Criteria) this;
        }

        public Criteria andInventoryEqualTo(Integer value) {
            addCriterion("inventory =", value, "inventory");
            return (Criteria) this;
        }

        public Criteria andInventoryNotEqualTo(Integer value) {
            addCriterion("inventory <>", value, "inventory");
            return (Criteria) this;
        }

        public Criteria andInventoryGreaterThan(Integer value) {
            addCriterion("inventory >", value, "inventory");
            return (Criteria) this;
        }

        public Criteria andInventoryGreaterThanOrEqualTo(Integer value) {
            addCriterion("inventory >=", value, "inventory");
            return (Criteria) this;
        }

        public Criteria andInventoryLessThan(Integer value) {
            addCriterion("inventory <", value, "inventory");
            return (Criteria) this;
        }

        public Criteria andInventoryLessThanOrEqualTo(Integer value) {
            addCriterion("inventory <=", value, "inventory");
            return (Criteria) this;
        }

        public Criteria andInventoryIn(List<Integer> values) {
            addCriterion("inventory in", values, "inventory");
            return (Criteria) this;
        }

        public Criteria andInventoryNotIn(List<Integer> values) {
            addCriterion("inventory not in", values, "inventory");
            return (Criteria) this;
        }

        public Criteria andInventoryBetween(Integer value1, Integer value2) {
            addCriterion("inventory between", value1, value2, "inventory");
            return (Criteria) this;
        }

        public Criteria andInventoryNotBetween(Integer value1, Integer value2) {
            addCriterion("inventory not between", value1, value2, "inventory");
            return (Criteria) this;
        }

        public Criteria andDelstateIsNull() {
            addCriterion("delstate is null");
            return (Criteria) this;
        }

        public Criteria andDelstateIsNotNull() {
            addCriterion("delstate is not null");
            return (Criteria) this;
        }

        public Criteria andDelstateEqualTo(String value) {
            addCriterion("delstate =", value, "delstate");
            return (Criteria) this;
        }

        public Criteria andDelstateNotEqualTo(String value) {
            addCriterion("delstate <>", value, "delstate");
            return (Criteria) this;
        }

        public Criteria andDelstateGreaterThan(String value) {
            addCriterion("delstate >", value, "delstate");
            return (Criteria) this;
        }

        public Criteria andDelstateGreaterThanOrEqualTo(String value) {
            addCriterion("delstate >=", value, "delstate");
            return (Criteria) this;
        }

        public Criteria andDelstateLessThan(String value) {
            addCriterion("delstate <", value, "delstate");
            return (Criteria) this;
        }

        public Criteria andDelstateLessThanOrEqualTo(String value) {
            addCriterion("delstate <=", value, "delstate");
            return (Criteria) this;
        }

        public Criteria andDelstateLike(String value) {
            addCriterion("delstate like", value, "delstate");
            return (Criteria) this;
        }

        public Criteria andDelstateNotLike(String value) {
            addCriterion("delstate not like", value, "delstate");
            return (Criteria) this;
        }

        public Criteria andDelstateIn(List<String> values) {
            addCriterion("delstate in", values, "delstate");
            return (Criteria) this;
        }

        public Criteria andDelstateNotIn(List<String> values) {
            addCriterion("delstate not in", values, "delstate");
            return (Criteria) this;
        }

        public Criteria andDelstateBetween(String value1, String value2) {
            addCriterion("delstate between", value1, value2, "delstate");
            return (Criteria) this;
        }

        public Criteria andDelstateNotBetween(String value1, String value2) {
            addCriterion("delstate not between", value1, value2, "delstate");
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

        public Criteria andUpdatetimeIsNull() {
            addCriterion("updateTime is null");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeIsNotNull() {
            addCriterion("updateTime is not null");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeEqualTo(Date value) {
            addCriterion("updateTime =", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeNotEqualTo(Date value) {
            addCriterion("updateTime <>", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeGreaterThan(Date value) {
            addCriterion("updateTime >", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("updateTime >=", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeLessThan(Date value) {
            addCriterion("updateTime <", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeLessThanOrEqualTo(Date value) {
            addCriterion("updateTime <=", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeIn(List<Date> values) {
            addCriterion("updateTime in", values, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeNotIn(List<Date> values) {
            addCriterion("updateTime not in", values, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeBetween(Date value1, Date value2) {
            addCriterion("updateTime between", value1, value2, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeNotBetween(Date value1, Date value2) {
            addCriterion("updateTime not between", value1, value2, "updatetime");
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