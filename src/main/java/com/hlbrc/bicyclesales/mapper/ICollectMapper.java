package com.hlbrc.bicyclesales.mapper;

import com.hlbrc.bicyclesales.entity.Collect;

public interface ICollectMapper {
    int deleteByPrimaryKey(Integer collectid);

    int insert(Collect record);

    int insertSelective(Collect record);

    Collect selectByPrimaryKey(Integer collectid);

    int updateByPrimaryKeySelective(Collect record);

    int updateByPrimaryKey(Collect record);
}