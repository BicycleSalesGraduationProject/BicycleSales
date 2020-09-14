package com.hlbrc.bicyclesales.mapper;

import com.hlbrc.bicyclesales.entity.PartType;
import com.hlbrc.bicyclesales.entity.PartTypeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface IPartTypeMapper {
    long countByExample(PartTypeExample example);

    int deleteByExample(PartTypeExample example);

    int deleteByPrimaryKey(Integer parttypeid);

    int insert(PartType record);

    int insertSelective(PartType record);

    List<PartType> selectByExample(PartTypeExample example);

    PartType selectByPrimaryKey(Integer parttypeid);

    int updateByExampleSelective(@Param("record") PartType record, @Param("example") PartTypeExample example);

    int updateByExample(@Param("record") PartType record, @Param("example") PartTypeExample example);

    int updateByPrimaryKeySelective(PartType record);

    int updateByPrimaryKey(PartType record);
}