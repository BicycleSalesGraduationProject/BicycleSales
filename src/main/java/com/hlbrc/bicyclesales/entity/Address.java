package com.hlbrc.bicyclesales.entity;

import java.util.Date;

public class Address {
    private Integer adsid;

    private Integer userid;

    private String name;

    private String tel;

    private String privince;

    private String city;

    private String district;

    private String adsdetails;

    private String adsdefault;

    private String adslabel;

    private String delstate;

    private Date createtime;

    private Date updatetime;

    public Integer getAdsid() {
        return adsid;
    }

    public void setAdsid(Integer adsid) {
        this.adsid = adsid;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel == null ? null : tel.trim();
    }

    public String getPrivince() {
        return privince;
    }

    public void setPrivince(String privince) {
        this.privince = privince == null ? null : privince.trim();
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city == null ? null : city.trim();
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district == null ? null : district.trim();
    }

    public String getAdsdetails() {
        return adsdetails;
    }

    public void setAdsdetails(String adsdetails) {
        this.adsdetails = adsdetails == null ? null : adsdetails.trim();
    }

    public String getAdsdefault() {
        return adsdefault;
    }

    public void setAdsdefault(String adsdefault) {
        this.adsdefault = adsdefault == null ? null : adsdefault.trim();
    }

    public String getAdslabel() {
        return adslabel;
    }

    public void setAdslabel(String adslabel) {
        this.adslabel = adslabel == null ? null : adslabel.trim();
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