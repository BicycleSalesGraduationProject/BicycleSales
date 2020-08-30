package com.hlbrc.bicyclesales.entity;

import java.util.Date;

public class Partmessage {
    private Integer partmessageid;

    private Integer parttypeid;

    private String name;

    private String specification;

    private String money;

    private Date createtime;

    private Date updatetime;

    public Integer getPartmessageid() {
        return partmessageid;
    }

    public void setPartmessageid(Integer partmessageid) {
        this.partmessageid = partmessageid;
    }

    public Integer getParttypeid() {
        return parttypeid;
    }

    public void setParttypeid(Integer parttypeid) {
        this.parttypeid = parttypeid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getSpecification() {
        return specification;
    }

    public void setSpecification(String specification) {
        this.specification = specification == null ? null : specification.trim();
    }

    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money == null ? null : money.trim();
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