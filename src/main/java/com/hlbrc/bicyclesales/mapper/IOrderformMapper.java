package com.hlbrc.bicyclesales.mapper;

import com.hlbrc.bicyclesales.entity.Orderform;

public interface IOrderformMapper {
    int deleteByPrimaryKey(Integer orderformid);

    int insert(Orderform record);

    int insertSelective(Orderform record);

    Orderform selectByPrimaryKey(Integer orderformid);

    int updateByPrimaryKeySelective(Orderform record);

    int updateByPrimaryKey(Orderform record);
}