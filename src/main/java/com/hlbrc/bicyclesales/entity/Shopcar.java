package com.hlbrc.bicyclesales.entity;

import java.util.Date;

public class Shopcar {
    private Integer shopcarid;

    private Integer userid;

    private Integer bicycleid;

    private Integer num;

    private Double total;

    private Date createtime;
    
    private Bicycle bicycle;

    public Bicycle getBicycle() {
		return bicycle;
	}

	public void setBicycle(Bicycle bicycle) {
		this.bicycle = bicycle;
	}

	public Integer getShopcarid() {
        return shopcarid;
    }

    public void setShopcarid(Integer shopcarid) {
        this.shopcarid = shopcarid;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Integer getBicycleid() {
        return bicycleid;
    }

    public void setBicycleid(Integer bicycleid) {
        this.bicycleid = bicycleid;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }
}