package com.hlbrc.bicyclesales.entity;

public class BicyclePartCrr {
    private Integer bicyclepartcrrid;

    private Integer bicycleid;

    private Integer partmessageid;

    private String orderno;

    public Integer getBicyclepartcrrid() {
        return bicyclepartcrrid;
    }

    public void setBicyclepartcrrid(Integer bicyclepartcrrid) {
        this.bicyclepartcrrid = bicyclepartcrrid;
    }

    public Integer getBicycleid() {
        return bicycleid;
    }

    public void setBicycleid(Integer bicycleid) {
        this.bicycleid = bicycleid;
    }

    public Integer getPartmessageid() {
        return partmessageid;
    }

    public void setPartmessageid(Integer partmessageid) {
        this.partmessageid = partmessageid;
    }

    public String getOrderno() {
        return orderno;
    }

    public void setOrderno(String orderno) {
        this.orderno = orderno == null ? null : orderno.trim();
    }
}