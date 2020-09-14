package com.hlbrc.bicyclesales.mapper;

import com.hlbrc.bicyclesales.entity.Photo;
import com.hlbrc.bicyclesales.entity.PhotoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface IPhotoMapper {
    long countByExample(PhotoExample example);

    int deleteByExample(PhotoExample example);

    int deleteByPrimaryKey(Integer photoid);

    int insert(Photo record);

    int insertSelective(Photo record);

    List<Photo> selectByExample(PhotoExample example);

    Photo selectByPrimaryKey(Integer photoid);

    int updateByExampleSelective(@Param("record") Photo record, @Param("example") PhotoExample example);

    int updateByExample(@Param("record") Photo record, @Param("example") PhotoExample example);

    int updateByPrimaryKeySelective(Photo record);

    int updateByPrimaryKey(Photo record);
}