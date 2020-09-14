package com.hlbrc.bicyclesales.mapper;

import com.hlbrc.bicyclesales.entity.Administrator;
import com.hlbrc.bicyclesales.entity.AdministratorExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface IAdministratorMapper {
    long countByExample(AdministratorExample example);

    int deleteByExample(AdministratorExample example);

    int deleteByPrimaryKey(Integer administratorid);

    int insert(Administrator record);

    int insertSelective(Administrator record);

    List<Administrator> selectByExample(AdministratorExample example);

    Administrator selectByPrimaryKey(Integer administratorid);

    int updateByExampleSelective(@Param("record") Administrator record, @Param("example") AdministratorExample example);

    int updateByExample(@Param("record") Administrator record, @Param("example") AdministratorExample example);

    int updateByPrimaryKeySelective(Administrator record);

    int updateByPrimaryKey(Administrator record);
}