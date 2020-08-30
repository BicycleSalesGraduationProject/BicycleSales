package com.hlbrc.bicyclesales.mapper;

import com.hlbrc.bicyclesales.entity.Photo;

public interface IPhotoMapper {
    int deleteByPrimaryKey(Integer photoid);

    int insert(Photo record);

    int insertSelective(Photo record);

    Photo selectByPrimaryKey(Integer photoid);

    int updateByPrimaryKeySelective(Photo record);

    int updateByPrimaryKey(Photo record);
}