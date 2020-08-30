package com.hlbrc.bicyclesales.mapper;

import com.hlbrc.bicyclesales.entity.Parttype;

public interface IParttypeMapper {
    int deleteByPrimaryKey(Integer parttypeid);

    int insert(Parttype record);

    int insertSelective(Parttype record);

    Parttype selectByPrimaryKey(Integer parttypeid);

    int updateByPrimaryKeySelective(Parttype record);

    int updateByPrimaryKey(Parttype record);
}