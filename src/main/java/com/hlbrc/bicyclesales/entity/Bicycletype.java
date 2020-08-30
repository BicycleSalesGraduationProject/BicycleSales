package com.hlbrc.bicyclesales.entity;

import java.util.Date;

public class Bicycletype {
    private Integer bicycletypeid;

    private String name;

    private String state;

    private String delstate;

    private Date createtime;

    public Integer getBicycletypeid() {
        return bicycletypeid;
    }

    public void setBicycletypeid(Integer bicycletypeid) {
        this.bicycletypeid = bicycletypeid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state == null ? null : state.trim();
    }

    public String getDelstate() {
        return delstate;
    }

    public void setDelstate(String delstate) {
        this.delstate = delstate == null ? null : delstate.trim();
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }
}