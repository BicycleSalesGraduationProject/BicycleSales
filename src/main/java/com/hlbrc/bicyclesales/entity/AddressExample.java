package com.hlbrc.bicyclesales.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AddressExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public AddressExample() {
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

        public Criteria andUseridIsNull() {
            addCriterion("userId is null");
            return (Criteria) this;
        }

        public Criteria andUseridIsNotNull() {
            addCriterion("userId is not null");
            return (Criteria) this;
        }

        public Criteria andUseridEqualTo(Integer value) {
            addCriterion("userId =", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotEqualTo(Integer value) {
            addCriterion("userId <>", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridGreaterThan(Integer value) {
            addCriterion("userId >", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridGreaterThanOrEqualTo(Integer value) {
            addCriterion("userId >=", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridLessThan(Integer value) {
            addCriterion("userId <", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridLessThanOrEqualTo(Integer value) {
            addCriterion("userId <=", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridIn(List<Integer> values) {
            addCriterion("userId in", values, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotIn(List<Integer> values) {
            addCriterion("userId not in", values, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridBetween(Integer value1, Integer value2) {
            addCriterion("userId between", value1, value2, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotBetween(Integer value1, Integer value2) {
            addCriterion("userId not between", value1, value2, "userid");
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

        public Criteria andTelIsNull() {
            addCriterion("tel is null");
            return (Criteria) this;
        }

        public Criteria andTelIsNotNull() {
            addCriterion("tel is not null");
            return (Criteria) this;
        }

        public Criteria andTelEqualTo(String value) {
            addCriterion("tel =", value, "tel");
            return (Criteria) this;
        }

        public Criteria andTelNotEqualTo(String value) {
            addCriterion("tel <>", value, "tel");
            return (Criteria) this;
        }

        public Criteria andTelGreaterThan(String value) {
            addCriterion("tel >", value, "tel");
            return (Criteria) this;
        }

        public Criteria andTelGreaterThanOrEqualTo(String value) {
            addCriterion("tel >=", value, "tel");
            return (Criteria) this;
        }

        public Criteria andTelLessThan(String value) {
            addCriterion("tel <", value, "tel");
            return (Criteria) this;
        }

        public Criteria andTelLessThanOrEqualTo(String value) {
            addCriterion("tel <=", value, "tel");
            return (Criteria) this;
        }

        public Criteria andTelLike(String value) {
            addCriterion("tel like", value, "tel");
            return (Criteria) this;
        }

        public Criteria andTelNotLike(String value) {
            addCriterion("tel not like", value, "tel");
            return (Criteria) this;
        }

        public Criteria andTelIn(List<String> values) {
            addCriterion("tel in", values, "tel");
            return (Criteria) this;
        }

        public Criteria andTelNotIn(List<String> values) {
            addCriterion("tel not in", values, "tel");
            return (Criteria) this;
        }

        public Criteria andTelBetween(String value1, String value2) {
            addCriterion("tel between", value1, value2, "tel");
            return (Criteria) this;
        }

        public Criteria andTelNotBetween(String value1, String value2) {
            addCriterion("tel not between", value1, value2, "tel");
            return (Criteria) this;
        }

        public Criteria andPrivinceIsNull() {
            addCriterion("privince is null");
            return (Criteria) this;
        }

        public Criteria andPrivinceIsNotNull() {
            addCriterion("privince is not null");
            return (Criteria) this;
        }

        public Criteria andPrivinceEqualTo(String value) {
            addCriterion("privince =", value, "privince");
            return (Criteria) this;
        }

        public Criteria andPrivinceNotEqualTo(String value) {
            addCriterion("privince <>", value, "privince");
            return (Criteria) this;
        }

        public Criteria andPrivinceGreaterThan(String value) {
            addCriterion("privince >", value, "privince");
            return (Criteria) this;
        }

        public Criteria andPrivinceGreaterThanOrEqualTo(String value) {
            addCriterion("privince >=", value, "privince");
            return (Criteria) this;
        }

        public Criteria andPrivinceLessThan(String value) {
            addCriterion("privince <", value, "privince");
            return (Criteria) this;
        }

        public Criteria andPrivinceLessThanOrEqualTo(String value) {
            addCriterion("privince <=", value, "privince");
            return (Criteria) this;
        }

        public Criteria andPrivinceLike(String value) {
            addCriterion("privince like", value, "privince");
            return (Criteria) this;
        }

        public Criteria andPrivinceNotLike(String value) {
            addCriterion("privince not like", value, "privince");
            return (Criteria) this;
        }

        public Criteria andPrivinceIn(List<String> values) {
            addCriterion("privince in", values, "privince");
            return (Criteria) this;
        }

        public Criteria andPrivinceNotIn(List<String> values) {
            addCriterion("privince not in", values, "privince");
            return (Criteria) this;
        }

        public Criteria andPrivinceBetween(String value1, String value2) {
            addCriterion("privince between", value1, value2, "privince");
            return (Criteria) this;
        }

        public Criteria andPrivinceNotBetween(String value1, String value2) {
            addCriterion("privince not between", value1, value2, "privince");
            return (Criteria) this;
        }

        public Criteria andCityIsNull() {
            addCriterion("city is null");
            return (Criteria) this;
        }

        public Criteria andCityIsNotNull() {
            addCriterion("city is not null");
            return (Criteria) this;
        }

        public Criteria andCityEqualTo(String value) {
            addCriterion("city =", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityNotEqualTo(String value) {
            addCriterion("city <>", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityGreaterThan(String value) {
            addCriterion("city >", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityGreaterThanOrEqualTo(String value) {
            addCriterion("city >=", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityLessThan(String value) {
            addCriterion("city <", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityLessThanOrEqualTo(String value) {
            addCriterion("city <=", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityLike(String value) {
            addCriterion("city like", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityNotLike(String value) {
            addCriterion("city not like", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityIn(List<String> values) {
            addCriterion("city in", values, "city");
            return (Criteria) this;
        }

        public Criteria andCityNotIn(List<String> values) {
            addCriterion("city not in", values, "city");
            return (Criteria) this;
        }

        public Criteria andCityBetween(String value1, String value2) {
            addCriterion("city between", value1, value2, "city");
            return (Criteria) this;
        }

        public Criteria andCityNotBetween(String value1, String value2) {
            addCriterion("city not between", value1, value2, "city");
            return (Criteria) this;
        }

        public Criteria andDistrictIsNull() {
            addCriterion("district is null");
            return (Criteria) this;
        }

        public Criteria andDistrictIsNotNull() {
            addCriterion("district is not null");
            return (Criteria) this;
        }

        public Criteria andDistrictEqualTo(String value) {
            addCriterion("district =", value, "district");
            return (Criteria) this;
        }

        public Criteria andDistrictNotEqualTo(String value) {
            addCriterion("district <>", value, "district");
            return (Criteria) this;
        }

        public Criteria andDistrictGreaterThan(String value) {
            addCriterion("district >", value, "district");
            return (Criteria) this;
        }

        public Criteria andDistrictGreaterThanOrEqualTo(String value) {
            addCriterion("district >=", value, "district");
            return (Criteria) this;
        }

        public Criteria andDistrictLessThan(String value) {
            addCriterion("district <", value, "district");
            return (Criteria) this;
        }

        public Criteria andDistrictLessThanOrEqualTo(String value) {
            addCriterion("district <=", value, "district");
            return (Criteria) this;
        }

        public Criteria andDistrictLike(String value) {
            addCriterion("district like", value, "district");
            return (Criteria) this;
        }

        public Criteria andDistrictNotLike(String value) {
            addCriterion("district not like", value, "district");
            return (Criteria) this;
        }

        public Criteria andDistrictIn(List<String> values) {
            addCriterion("district in", values, "district");
            return (Criteria) this;
        }

        public Criteria andDistrictNotIn(List<String> values) {
            addCriterion("district not in", values, "district");
            return (Criteria) this;
        }

        public Criteria andDistrictBetween(String value1, String value2) {
            addCriterion("district between", value1, value2, "district");
            return (Criteria) this;
        }

        public Criteria andDistrictNotBetween(String value1, String value2) {
            addCriterion("district not between", value1, value2, "district");
            return (Criteria) this;
        }

        public Criteria andAdsdetailsIsNull() {
            addCriterion("adsDetails is null");
            return (Criteria) this;
        }

        public Criteria andAdsdetailsIsNotNull() {
            addCriterion("adsDetails is not null");
            return (Criteria) this;
        }

        public Criteria andAdsdetailsEqualTo(String value) {
            addCriterion("adsDetails =", value, "adsdetails");
            return (Criteria) this;
        }

        public Criteria andAdsdetailsNotEqualTo(String value) {
            addCriterion("adsDetails <>", value, "adsdetails");
            return (Criteria) this;
        }

        public Criteria andAdsdetailsGreaterThan(String value) {
            addCriterion("adsDetails >", value, "adsdetails");
            return (Criteria) this;
        }

        public Criteria andAdsdetailsGreaterThanOrEqualTo(String value) {
            addCriterion("adsDetails >=", value, "adsdetails");
            return (Criteria) this;
        }

        public Criteria andAdsdetailsLessThan(String value) {
            addCriterion("adsDetails <", value, "adsdetails");
            return (Criteria) this;
        }

        public Criteria andAdsdetailsLessThanOrEqualTo(String value) {
            addCriterion("adsDetails <=", value, "adsdetails");
            return (Criteria) this;
        }

        public Criteria andAdsdetailsLike(String value) {
            addCriterion("adsDetails like", value, "adsdetails");
            return (Criteria) this;
        }

        public Criteria andAdsdetailsNotLike(String value) {
            addCriterion("adsDetails not like", value, "adsdetails");
            return (Criteria) this;
        }

        public Criteria andAdsdetailsIn(List<String> values) {
            addCriterion("adsDetails in", values, "adsdetails");
            return (Criteria) this;
        }

        public Criteria andAdsdetailsNotIn(List<String> values) {
            addCriterion("adsDetails not in", values, "adsdetails");
            return (Criteria) this;
        }

        public Criteria andAdsdetailsBetween(String value1, String value2) {
            addCriterion("adsDetails between", value1, value2, "adsdetails");
            return (Criteria) this;
        }

        public Criteria andAdsdetailsNotBetween(String value1, String value2) {
            addCriterion("adsDetails not between", value1, value2, "adsdetails");
            return (Criteria) this;
        }

        public Criteria andAdsdefaultIsNull() {
            addCriterion("adsDefault is null");
            return (Criteria) this;
        }

        public Criteria andAdsdefaultIsNotNull() {
            addCriterion("adsDefault is not null");
            return (Criteria) this;
        }

        public Criteria andAdsdefaultEqualTo(String value) {
            addCriterion("adsDefault =", value, "adsdefault");
            return (Criteria) this;
        }

        public Criteria andAdsdefaultNotEqualTo(String value) {
            addCriterion("adsDefault <>", value, "adsdefault");
            return (Criteria) this;
        }

        public Criteria andAdsdefaultGreaterThan(String value) {
            addCriterion("adsDefault >", value, "adsdefault");
            return (Criteria) this;
        }

        public Criteria andAdsdefaultGreaterThanOrEqualTo(String value) {
            addCriterion("adsDefault >=", value, "adsdefault");
            return (Criteria) this;
        }

        public Criteria andAdsdefaultLessThan(String value) {
            addCriterion("adsDefault <", value, "adsdefault");
            return (Criteria) this;
        }

        public Criteria andAdsdefaultLessThanOrEqualTo(String value) {
            addCriterion("adsDefault <=", value, "adsdefault");
            return (Criteria) this;
        }

        public Criteria andAdsdefaultLike(String value) {
            addCriterion("adsDefault like", value, "adsdefault");
            return (Criteria) this;
        }

        public Criteria andAdsdefaultNotLike(String value) {
            addCriterion("adsDefault not like", value, "adsdefault");
            return (Criteria) this;
        }

        public Criteria andAdsdefaultIn(List<String> values) {
            addCriterion("adsDefault in", values, "adsdefault");
            return (Criteria) this;
        }

        public Criteria andAdsdefaultNotIn(List<String> values) {
            addCriterion("adsDefault not in", values, "adsdefault");
            return (Criteria) this;
        }

        public Criteria andAdsdefaultBetween(String value1, String value2) {
            addCriterion("adsDefault between", value1, value2, "adsdefault");
            return (Criteria) this;
        }

        public Criteria andAdsdefaultNotBetween(String value1, String value2) {
            addCriterion("adsDefault not between", value1, value2, "adsdefault");
            return (Criteria) this;
        }

        public Criteria andAdslabelIsNull() {
            addCriterion("adsLabel is null");
            return (Criteria) this;
        }

        public Criteria andAdslabelIsNotNull() {
            addCriterion("adsLabel is not null");
            return (Criteria) this;
        }

        public Criteria andAdslabelEqualTo(String value) {
            addCriterion("adsLabel =", value, "adslabel");
            return (Criteria) this;
        }

        public Criteria andAdslabelNotEqualTo(String value) {
            addCriterion("adsLabel <>", value, "adslabel");
            return (Criteria) this;
        }

        public Criteria andAdslabelGreaterThan(String value) {
            addCriterion("adsLabel >", value, "adslabel");
            return (Criteria) this;
        }

        public Criteria andAdslabelGreaterThanOrEqualTo(String value) {
            addCriterion("adsLabel >=", value, "adslabel");
            return (Criteria) this;
        }

        public Criteria andAdslabelLessThan(String value) {
            addCriterion("adsLabel <", value, "adslabel");
            return (Criteria) this;
        }

        public Criteria andAdslabelLessThanOrEqualTo(String value) {
            addCriterion("adsLabel <=", value, "adslabel");
            return (Criteria) this;
        }

        public Criteria andAdslabelLike(String value) {
            addCriterion("adsLabel like", value, "adslabel");
            return (Criteria) this;
        }

        public Criteria andAdslabelNotLike(String value) {
            addCriterion("adsLabel not like", value, "adslabel");
            return (Criteria) this;
        }

        public Criteria andAdslabelIn(List<String> values) {
            addCriterion("adsLabel in", values, "adslabel");
            return (Criteria) this;
        }

        public Criteria andAdslabelNotIn(List<String> values) {
            addCriterion("adsLabel not in", values, "adslabel");
            return (Criteria) this;
        }

        public Criteria andAdslabelBetween(String value1, String value2) {
            addCriterion("adsLabel between", value1, value2, "adslabel");
            return (Criteria) this;
        }

        public Criteria andAdslabelNotBetween(String value1, String value2) {
            addCriterion("adsLabel not between", value1, value2, "adslabel");
            return (Criteria) this;
        }

        public Criteria andDelstateIsNull() {
            addCriterion("delState is null");
            return (Criteria) this;
        }

        public Criteria andDelstateIsNotNull() {
            addCriterion("delState is not null");
            return (Criteria) this;
        }

        public Criteria andDelstateEqualTo(String value) {
            addCriterion("delState =", value, "delstate");
            return (Criteria) this;
        }

        public Criteria andDelstateNotEqualTo(String value) {
            addCriterion("delState <>", value, "delstate");
            return (Criteria) this;
        }

        public Criteria andDelstateGreaterThan(String value) {
            addCriterion("delState >", value, "delstate");
            return (Criteria) this;
        }

        public Criteria andDelstateGreaterThanOrEqualTo(String value) {
            addCriterion("delState >=", value, "delstate");
            return (Criteria) this;
        }

        public Criteria andDelstateLessThan(String value) {
            addCriterion("delState <", value, "delstate");
            return (Criteria) this;
        }

        public Criteria andDelstateLessThanOrEqualTo(String value) {
            addCriterion("delState <=", value, "delstate");
            return (Criteria) this;
        }

        public Criteria andDelstateLike(String value) {
            addCriterion("delState like", value, "delstate");
            return (Criteria) this;
        }

        public Criteria andDelstateNotLike(String value) {
            addCriterion("delState not like", value, "delstate");
            return (Criteria) this;
        }

        public Criteria andDelstateIn(List<String> values) {
            addCriterion("delState in", values, "delstate");
            return (Criteria) this;
        }

        public Criteria andDelstateNotIn(List<String> values) {
            addCriterion("delState not in", values, "delstate");
            return (Criteria) this;
        }

        public Criteria andDelstateBetween(String value1, String value2) {
            addCriterion("delState between", value1, value2, "delstate");
            return (Criteria) this;
        }

        public Criteria andDelstateNotBetween(String value1, String value2) {
            addCriterion("delState not between", value1, value2, "delstate");
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