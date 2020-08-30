package com.hlbrc.bicyclesales.entity;

public class Orderformdetail {
    private Integer orderformdetailid;

    private Integer orderformid;

    private Integer bicycleid;

    private Double num;

    private Double money;

    public Integer getOrderformdetailid() {
        return orderformdetailid;
    }

    public void setOrderformdetailid(Integer orderformdetailid) {
        this.orderformdetailid = orderformdetailid;
    }

    public Integer getOrderformid() {
        return orderformid;
    }

    public void setOrderformid(Integer orderformid) {
        this.orderformid = orderformid;
    }

    public Integer getBicycleid() {
        return bicycleid;
    }

    public void setBicycleid(Integer bicycleid) {
        this.bicycleid = bicycleid;
    }

    public Double getNum() {
        return num;
    }

    public void setNum(Double num) {
        this.num = num;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }
}