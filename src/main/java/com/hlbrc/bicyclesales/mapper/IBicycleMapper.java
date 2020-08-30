package com.hlbrc.bicyclesales.mapper;

import com.hlbrc.bicyclesales.entity.Bicycle;

public interface IBicycleMapper {
    int deleteByPrimaryKey(Integer bicycleid);

    int insert(Bicycle record);

    int insertSelective(Bicycle record);

    Bicycle selectByPrimaryKey(Integer bicycleid);

    int updateByPrimaryKeySelective(Bicycle record);

    int updateByPrimaryKey(Bicycle record);
}