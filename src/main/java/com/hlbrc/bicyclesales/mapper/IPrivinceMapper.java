package com.hlbrc.bicyclesales.mapper;

import com.hlbrc.bicyclesales.entity.Privince;
import com.hlbrc.bicyclesales.entity.PrivinceExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface IPrivinceMapper {
    long countByExample(PrivinceExample example);

    int deleteByExample(PrivinceExample example);

    int deleteByPrimaryKey(Integer proid);

    int insert(Privince record);

    int insertSelective(Privince record);

    List<Privince> selectByExample(PrivinceExample example);

    Privince selectByPrimaryKey(Integer proid);

    int updateByExampleSelective(@Param("record") Privince record, @Param("example") PrivinceExample example);

    int updateByExample(@Param("record") Privince record, @Param("example") PrivinceExample example);

    int updateByPrimaryKeySelective(Privince record);

    int updateByPrimaryKey(Privince record);
}