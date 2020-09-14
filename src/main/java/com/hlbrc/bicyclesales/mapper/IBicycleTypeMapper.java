package com.hlbrc.bicyclesales.mapper;

import com.hlbrc.bicyclesales.entity.BicycleType;
import com.hlbrc.bicyclesales.entity.BicycleTypeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface IBicycleTypeMapper {
    long countByExample(BicycleTypeExample example);

    int deleteByExample(BicycleTypeExample example);

    int deleteByPrimaryKey(Integer bicycletypeid);

    int insert(BicycleType record);

    int insertSelective(BicycleType record);

    List<BicycleType> selectByExample(BicycleTypeExample example);

    BicycleType selectByPrimaryKey(Integer bicycletypeid);

    int updateByExampleSelective(@Param("record") BicycleType record, @Param("example") BicycleTypeExample example);

    int updateByExample(@Param("record") BicycleType record, @Param("example") BicycleTypeExample example);

    int updateByPrimaryKeySelective(BicycleType record);

    int updateByPrimaryKey(BicycleType record);
}