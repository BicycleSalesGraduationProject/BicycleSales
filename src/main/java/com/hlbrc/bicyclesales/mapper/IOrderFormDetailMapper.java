package com.hlbrc.bicyclesales.mapper;

import com.hlbrc.bicyclesales.entity.OrderFormDetail;
import com.hlbrc.bicyclesales.entity.OrderFormDetailExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface IOrderFormDetailMapper {
    long countByExample(OrderFormDetailExample example);

    int deleteByExample(OrderFormDetailExample example);

    int deleteByPrimaryKey(Integer orderformdetailid);

    int insert(OrderFormDetail record);

    int insertSelective(OrderFormDetail record);

    List<OrderFormDetail> selectByExample(OrderFormDetailExample example);

    OrderFormDetail selectByPrimaryKey(Integer orderformdetailid);

    int updateByExampleSelective(@Param("record") OrderFormDetail record, @Param("example") OrderFormDetailExample example);

    int updateByExample(@Param("record") OrderFormDetail record, @Param("example") OrderFormDetailExample example);

    int updateByPrimaryKeySelective(OrderFormDetail record);

    int updateByPrimaryKey(OrderFormDetail record);
}