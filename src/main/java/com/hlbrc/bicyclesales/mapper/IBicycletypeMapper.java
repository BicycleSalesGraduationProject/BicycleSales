package com.hlbrc.bicyclesales.mapper;

import com.hlbrc.bicyclesales.entity.Bicycletype;

public interface IBicycletypeMapper {
    int deleteByPrimaryKey(Integer bicycletypeid);

    int insert(Bicycletype record);

    int insertSelective(Bicycletype record);

    Bicycletype selectByPrimaryKey(Integer bicycletypeid);

    int updateByPrimaryKeySelective(Bicycletype record);

    int updateByPrimaryKey(Bicycletype record);
}