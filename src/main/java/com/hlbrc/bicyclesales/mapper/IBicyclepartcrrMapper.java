package com.hlbrc.bicyclesales.mapper;

import com.hlbrc.bicyclesales.entity.Bicyclepartcrr;

public interface IBicyclepartcrrMapper {
    int deleteByPrimaryKey(Integer bicyclepartcrrid);

    int insert(Bicyclepartcrr record);

    int insertSelective(Bicyclepartcrr record);

    Bicyclepartcrr selectByPrimaryKey(Integer bicyclepartcrrid);

    int updateByPrimaryKeySelective(Bicyclepartcrr record);

    int updateByPrimaryKey(Bicyclepartcrr record);
}