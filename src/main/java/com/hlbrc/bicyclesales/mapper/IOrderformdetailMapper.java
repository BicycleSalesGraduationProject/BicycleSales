package com.hlbrc.bicyclesales.mapper;

import com.hlbrc.bicyclesales.entity.Orderformdetail;

public interface IOrderformdetailMapper {
    int deleteByPrimaryKey(Integer orderformdetailid);

    int insert(Orderformdetail record);

    int insertSelective(Orderformdetail record);

    Orderformdetail selectByPrimaryKey(Integer orderformdetailid);

    int updateByPrimaryKeySelective(Orderformdetail record);

    int updateByPrimaryKey(Orderformdetail record);
}