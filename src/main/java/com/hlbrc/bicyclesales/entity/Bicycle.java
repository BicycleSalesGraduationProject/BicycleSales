package com.hlbrc.bicyclesales.entity;

import java.util.Date;

public class Bicycle {
    private Integer bicycleid;

    private Integer bicycletypeid;

    private String name;

    private Double money;

    private Integer inventory;

    private String delstate;

    private Date createtime;

    private Date updatetime;

    public Integer getBicycleid() {
        return bicycleid;
    }

    public void setBicycleid(Integer bicycleid) {
        this.bicycleid = bicycleid;
    }

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

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    public Integer getInventory() {
        return inventory;
    }

    public void setInventory(Integer inventory) {
        this.inventory = inventory;
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

    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }
}