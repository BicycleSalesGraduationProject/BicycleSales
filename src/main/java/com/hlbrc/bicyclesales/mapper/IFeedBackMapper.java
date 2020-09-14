package com.hlbrc.bicyclesales.mapper;

import com.hlbrc.bicyclesales.entity.FeedBack;
import com.hlbrc.bicyclesales.entity.FeedBackExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface IFeedBackMapper {
    long countByExample(FeedBackExample example);

    int deleteByExample(FeedBackExample example);

    int deleteByPrimaryKey(Integer feedbackid);

    int insert(FeedBack record);

    int insertSelective(FeedBack record);

    List<FeedBack> selectByExample(FeedBackExample example);

    FeedBack selectByPrimaryKey(Integer feedbackid);

    int updateByExampleSelective(@Param("record") FeedBack record, @Param("example") FeedBackExample example);

    int updateByExample(@Param("record") FeedBack record, @Param("example") FeedBackExample example);

    int updateByPrimaryKeySelective(FeedBack record);

    int updateByPrimaryKey(FeedBack record);
}