package com.hlbrc.bicyclesales.mapper;

import com.hlbrc.bicyclesales.entity.Address;
import com.hlbrc.bicyclesales.entity.AddressExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface IAddressMapper {
    long countByExample(AddressExample example);

    int deleteByExample(AddressExample example);

    int deleteByPrimaryKey(Integer adsid);

    int insert(Address record);

    int insertSelective(Address record);

    List<Address> selectByExample(AddressExample example);

    Address selectByPrimaryKey(Integer adsid);

    int updateByExampleSelective(@Param("record") Address record, @Param("example") AddressExample example);

    int updateByExample(@Param("record") Address record, @Param("example") AddressExample example);

    int updateByPrimaryKeySelective(Address record);

    int updateByPrimaryKey(Address record);
}