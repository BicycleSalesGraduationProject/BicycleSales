package com.hlbrc.bicyclesales.mapper;

import com.hlbrc.bicyclesales.entity.Partmessage;

public interface IPartmessageMapper {
    int deleteByPrimaryKey(Integer partmessageid);

    int insert(Partmessage record);

    int insertSelective(Partmessage record);

    Partmessage selectByPrimaryKey(Integer partmessageid);

    int updateByPrimaryKeySelective(Partmessage record);

    int updateByPrimaryKey(Partmessage record);
}