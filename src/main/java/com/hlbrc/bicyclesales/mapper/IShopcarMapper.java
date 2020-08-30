package com.hlbrc.bicyclesales.mapper;

import com.hlbrc.bicyclesales.entity.Shopcar;

public interface IShopcarMapper {
    int deleteByPrimaryKey(Integer shopcarid);

    int insert(Shopcar record);

    int insertSelective(Shopcar record);

    Shopcar selectByPrimaryKey(Integer shopcarid);

    int updateByPrimaryKeySelective(Shopcar record);

    int updateByPrimaryKey(Shopcar record);
}