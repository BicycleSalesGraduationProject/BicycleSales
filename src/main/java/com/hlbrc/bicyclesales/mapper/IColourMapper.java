package com.hlbrc.bicyclesales.mapper;

import com.hlbrc.bicyclesales.entity.Colour;

public interface IColourMapper {
    int deleteByPrimaryKey(Integer colourid);

    int insert(Colour record);

    int insertSelective(Colour record);

    Colour selectByPrimaryKey(Integer colourid);

    int updateByPrimaryKeySelective(Colour record);

    int updateByPrimaryKey(Colour record);
}