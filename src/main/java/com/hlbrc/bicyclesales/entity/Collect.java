package com.hlbrc.bicyclesales.entity;

public class Collect {
    private Integer collectid;

    private Integer userid;

    private Integer bicycleid;
    
    private Bicycle bicycle;
    

    public Bicycle getBicycle() {
		return bicycle;
	}

	public void setBicycle(Bicycle bicycle) {
		this.bicycle = bicycle;
	}

	public Integer getCollectid() {
        return collectid;
    }

    public void setCollectid(Integer collectid) {
        this.collectid = collectid;
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
}