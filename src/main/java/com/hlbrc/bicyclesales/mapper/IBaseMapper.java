package com.hlbrc.bicyclesales.mapper;

import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface IBaseMapper {
    /** 插入方法
     * @param map**/
    int insert(Map<String, Object> map);
    /** 更新方法 **/
    int update(Map<Object, Object> map);
    /** 通过id查找对应数据 **/
    Map<Object,Object> findById(@Param("tablename") String tableName, @Param("id") Integer id);
    /** 获取所有记录 **/
    List<Map<Object,Object>> findAll(@Param("tablename")String tableName,@Param("issoftdel")String isSoftDel);
    /** 硬删除，删除后数据库记录消失  **/
    int deleteById(@Param("tablename")String tableName,@Param("id")Integer id);
    /** 软删除，更新是否删除标记  **/
    int deleteSoftById(@Param("tablename")String tableName,@Param("id")Integer id);
    /** 通过条件查询数据，用于校验是否重复
     * @param params**/
    List<Map<Object,Object>> findByCondition(Map<String, String> params);
    /** 通过表名获取下一个id **/
    int findNextId(@Param("tablename")String tableName);
}
