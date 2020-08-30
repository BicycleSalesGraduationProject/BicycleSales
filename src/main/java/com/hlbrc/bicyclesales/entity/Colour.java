package com.hlbrc.bicyclesales.entity;

import java.util.Date;

public class Colour {
    private Integer colourid;

    private Integer bicycleid;

    private String name;

    private String code;

    private String state;

    private Date createtime;

    private Date updatetime;

    public Integer getColourid() {
        return colourid;
    }

    public void setColourid(Integer colourid) {
        this.colourid = colourid;
    }

    public Integer getBicycleid() {
        return bicycleid;
    }

    public void setBicycleid(Integer bicycleid) {
        this.bicycleid = bicycleid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state == null ? null : state.trim();
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }
}