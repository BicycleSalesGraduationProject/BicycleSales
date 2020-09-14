package com.hlbrc.bicyclesales.mapper;

import com.hlbrc.bicyclesales.entity.PartMessage;
import com.hlbrc.bicyclesales.entity.PartMessageExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface IPartMessageMapper {
    long countByExample(PartMessageExample example);

    int deleteByExample(PartMessageExample example);

    int deleteByPrimaryKey(Integer partmessageid);

    int insert(PartMessage record);

    int insertSelective(PartMessage record);

    List<PartMessage> selectByExample(PartMessageExample example);

    PartMessage selectByPrimaryKey(Integer partmessageid);

    int updateByExampleSelective(@Param("record") PartMessage record, @Param("example") PartMessageExample example);

    int updateByExample(@Param("record") PartMessage record, @Param("example") PartMessageExample example);

    int updateByPrimaryKeySelective(PartMessage record);

    int updateByPrimaryKey(PartMessage record);
}