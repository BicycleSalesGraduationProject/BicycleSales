package com.hlbrc.bicyclesales.mapper;

import com.hlbrc.bicyclesales.entity.Colour;
import com.hlbrc.bicyclesales.entity.ColourExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface IColourMapper {
    long countByExample(ColourExample example);

    int deleteByExample(ColourExample example);

    int deleteByPrimaryKey(Integer colourid);

    int insert(Colour record);

    int insertSelective(Colour record);

    List<Colour> selectByExample(ColourExample example);

    Colour selectByPrimaryKey(Integer colourid);

    int updateByExampleSelective(@Param("record") Colour record, @Param("example") ColourExample example);

    int updateByExample(@Param("record") Colour record, @Param("example") ColourExample example);

    int updateByPrimaryKeySelective(Colour record);

    int updateByPrimaryKey(Colour record);
}