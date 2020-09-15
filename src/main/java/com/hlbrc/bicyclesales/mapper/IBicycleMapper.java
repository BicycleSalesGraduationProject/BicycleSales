package com.hlbrc.bicyclesales.mapper;

import com.hlbrc.bicyclesales.entity.Bicycle;
import com.hlbrc.bicyclesales.entity.BicycleExample;
import java.util.List;

import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;

public interface IBicycleMapper {
    long countByExample(BicycleExample example);

    int deleteByExample(BicycleExample example);

    int deleteByPrimaryKey(Integer bicycleid);

    int insert(Bicycle record);
    
    @Options(useGeneratedKeys = true)
    int insertSelective(Bicycle record);

    List<Bicycle> selectByExample(BicycleExample example);

    Bicycle selectByPrimaryKey(Integer bicycleid);

    int updateByExampleSelective(@Param("record") Bicycle record, @Param("example") BicycleExample example);

    int updateByExample(@Param("record") Bicycle record, @Param("example") BicycleExample example);

    int updateByPrimaryKeySelective(Bicycle record);

    int updateByPrimaryKey(Bicycle record);
}