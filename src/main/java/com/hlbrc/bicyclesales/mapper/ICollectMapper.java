package com.hlbrc.bicyclesales.mapper;

import com.hlbrc.bicyclesales.entity.Collect;
import com.hlbrc.bicyclesales.entity.CollectExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ICollectMapper {
    long countByExample(CollectExample example);

    int deleteByExample(CollectExample example);

    int deleteByPrimaryKey(Integer collectid);

    int insert(Collect record);

    int insertSelective(Collect record);

    List<Collect> selectByExample(CollectExample example);

    Collect selectByPrimaryKey(Integer collectid);

    int updateByExampleSelective(@Param("record") Collect record, @Param("example") CollectExample example);

    int updateByExample(@Param("record") Collect record, @Param("example") CollectExample example);

    int updateByPrimaryKeySelective(Collect record);

    int updateByPrimaryKey(Collect record);
}