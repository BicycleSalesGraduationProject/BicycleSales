package com.hlbrc.bicyclesales.mapper;

import com.hlbrc.bicyclesales.entity.Administrator;

public interface IAdministratorMapper {
    int deleteByPrimaryKey(Integer administratorid);

    int insert(Administrator record);

    int insertSelective(Administrator record);

    Administrator selectByPrimaryKey(Integer administratorid);

    int updateByPrimaryKeySelective(Administrator record);

    int updateByPrimaryKey(Administrator record);
}