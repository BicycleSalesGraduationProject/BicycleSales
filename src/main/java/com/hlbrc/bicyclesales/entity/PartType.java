package com.hlbrc.bicyclesales.entity;

import java.util.Date;

public class PartType {
    private Integer parttypeid;

    private String name;

    private Date createtime;

    private Date uapdatetime;

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

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Date getUapdatetime() {
        return uapdatetime;
    }

    public void setUapdatetime(Date uapdatetime) {
        this.uapdatetime = uapdatetime;
    }
}