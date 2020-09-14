package com.hlbrc.bicyclesales.mapper;

import com.hlbrc.bicyclesales.entity.BicyclePartCrr;
import com.hlbrc.bicyclesales.entity.BicyclePartCrrExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface IBicyclePartCrrMapper {
    long countByExample(BicyclePartCrrExample example);

    int deleteByExample(BicyclePartCrrExample example);

    int deleteByPrimaryKey(Integer bicyclepartcrrid);

    int insert(BicyclePartCrr record);

    int insertSelective(BicyclePartCrr record);

    List<BicyclePartCrr> selectByExample(BicyclePartCrrExample example);

    BicyclePartCrr selectByPrimaryKey(Integer bicyclepartcrrid);

    int updateByExampleSelective(@Param("record") BicyclePartCrr record, @Param("example") BicyclePartCrrExample example);

    int updateByExample(@Param("record") BicyclePartCrr record, @Param("example") BicyclePartCrrExample example);

    int updateByPrimaryKeySelective(BicyclePartCrr record);

    int updateByPrimaryKey(BicyclePartCrr record);
}