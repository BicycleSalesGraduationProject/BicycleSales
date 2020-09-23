package com.hlbrc.bicyclesales.entity;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Bicycle {
    private Integer bicycleid;

    private Integer bicycletypeid;

    private String name;

    private Double money;

    private Integer inventory;

    private String delstate;

    private Date createtime;

    private Date updatetime;
    
    private Set<PartType> partType;
    
    private Map<PartType,List<PartMessage>> partmessage;
    
    private List<Photo> photo;
    
    private String firstphoto;
    
    private String secondphoto;
    
    private String partmessageids;

	public String getPartmessageids() {
		return partmessageids;
	}

	public void setPartmessageids(String partmessageids) {
		this.partmessageids = partmessageids;
	}

	public String getFirstphoto() {
		return firstphoto;
	}

	public void setFirstphoto(String firstphoto) {
		this.firstphoto = firstphoto;
	}

	public String getSecondphoto() {
		return secondphoto;
	}

	public void setSecondphoto(String secondphoto) {
		this.secondphoto = secondphoto;
	}

	public List<Photo> getPhoto() {
		return photo;
	}

	public void setPhoto(List<Photo> photo) {
		this.photo = photo;
	}

	public Set<PartType> getPartType() {
		return partType;
	}

	public void setPartType(Set<PartType> partType) {
		this.partType = partType;
	}

	public Map<PartType, List<PartMessage>> getPartmessage() {
		return partmessage;
	}

	public void setPartmessage(Map<PartType, List<PartMessage>> partmessage) {
		this.partmessage = partmessage;
	}

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