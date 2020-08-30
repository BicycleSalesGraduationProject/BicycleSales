package com.hlbrc.bicyclesales.entity;

import java.util.Date;

public class Orderform {
    private Integer orderformid;

    private Integer adsid;

    private Integer totalnum;

    private Double totalmoney;

    private String orderformstate;

    private String paymoneystate;

    private Date createtime;

    public Integer getOrderformid() {
        return orderformid;
    }

    public void setOrderformid(Integer orderformid) {
        this.orderformid = orderformid;
    }

    public Integer getAdsid() {
        return adsid;
    }

    public void setAdsid(Integer adsid) {
        this.adsid = adsid;
    }

    public Integer getTotalnum() {
        return totalnum;
    }

    public void setTotalnum(Integer totalnum) {
        this.totalnum = totalnum;
    }

    public Double getTotalmoney() {
        return totalmoney;
    }

    public void setTotalmoney(Double totalmoney) {
        this.totalmoney = totalmoney;
    }

    public String getOrderformstate() {
        return orderformstate;
    }

    public void setOrderformstate(String orderformstate) {
        this.orderformstate = orderformstate == null ? null : orderformstate.trim();
    }

    public String getPaymoneystate() {
        return paymoneystate;
    }

    public void setPaymoneystate(String paymoneystate) {
        this.paymoneystate = paymoneystate == null ? null : paymoneystate.trim();
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }
}