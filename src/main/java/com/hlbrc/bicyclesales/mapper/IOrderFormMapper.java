package com.hlbrc.bicyclesales.mapper;

import com.hlbrc.bicyclesales.entity.OrderForm;
import com.hlbrc.bicyclesales.entity.OrderFormExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface IOrderFormMapper {
    long countByExample(OrderFormExample example);

    int deleteByExample(OrderFormExample example);

    int deleteByPrimaryKey(Integer orderformid);

    int insert(OrderForm record);

    int insertSelective(OrderForm record);

    List<OrderForm> selectByExample(OrderFormExample example);

    OrderForm selectByPrimaryKey(Integer orderformid);

    int updateByExampleSelective(@Param("record") OrderForm record, @Param("example") OrderFormExample example);

    int updateByExample(@Param("record") OrderForm record, @Param("example") OrderFormExample example);

    int updateByPrimaryKeySelective(OrderForm record);

    int updateByPrimaryKey(OrderForm record);
}