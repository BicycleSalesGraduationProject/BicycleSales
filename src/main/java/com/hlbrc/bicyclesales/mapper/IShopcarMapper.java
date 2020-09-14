package com.hlbrc.bicyclesales.mapper;

import com.hlbrc.bicyclesales.entity.Shopcar;
import com.hlbrc.bicyclesales.entity.ShopcarExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface IShopcarMapper {
    long countByExample(ShopcarExample example);

    int deleteByExample(ShopcarExample example);

    int deleteByPrimaryKey(Integer shopcarid);

    int insert(Shopcar record);

    int insertSelective(Shopcar record);

    List<Shopcar> selectByExample(ShopcarExample example);

    Shopcar selectByPrimaryKey(Integer shopcarid);

    int updateByExampleSelective(@Param("record") Shopcar record, @Param("example") ShopcarExample example);

    int updateByExample(@Param("record") Shopcar record, @Param("example") ShopcarExample example);

    int updateByPrimaryKeySelective(Shopcar record);

    int updateByPrimaryKey(Shopcar record);
}