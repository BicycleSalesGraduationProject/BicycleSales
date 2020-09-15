package com.hlbrc.bicyclesales.entity;

import java.util.List;

public class OrderFormDetail {
    private Integer orderformdetailid;

    private Integer orderformid;

    private Integer bicycleid;

    private Double num;

    private Double money;

    private String orderno;
    
    private Bicycle bicycle;
    
    private List<PartMessage> partmessage;

    public List<PartMessage> getPartmessage() {
		return partmessage;
	}

	public void setPartmessage(List<PartMessage> partmessage) {
		this.partmessage = partmessage;
	}

	public Bicycle getBicycle() {
		return bicycle;
	}

	public void setBicycle(Bicycle bicycle) {
		this.bicycle = bicycle;
	}

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

    public String getOrderno() {
        return orderno;
    }

    public void setOrderno(String orderno) {
        this.orderno = orderno == null ? null : orderno.trim();
    }
}