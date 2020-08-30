package com.hlbrc.bicyclesales.mapper;

import com.hlbrc.bicyclesales.entity.Address;

public interface IAddressMapper {
    int deleteByPrimaryKey(Integer adsid);

    int insert(Address record);

    int insertSelective(Address record);

    Address selectByPrimaryKey(Integer adsid);

    int updateByPrimaryKeySelective(Address record);

    int updateByPrimaryKey(Address record);
}