package com.hlbrc.bicyclesales.service.Impl;

import com.hlbrc.bicyclesales.mapper.IBaseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class BaseService {
    @Autowired
    private IBaseMapper mapper;
    /***
     *  插入方法
     * @param cls bean class
     * @param beanObj bean 对象
     * @param tableName 表名
     * @return int
     * @throws Exception 异常
     */
    public int insertSimple(Class cls, Object beanObj, String tableName){
        Map<String,Object> para = new HashMap<String,Object>();
        this.buildBeanAttrPara(cls, beanObj, para);
        para.put("tablename", tableName);
        return mapper.insert(para);
    }
    /***
     *  更新方法
     * @param cls bean class
     * @param fromObj bean 对象
     * @param toObj bean 对象
     * @param tableName 表名
     * @return int
     * @throws Exception 异常
     */
    public int updateSimple(Class cls, Object fromObj, Object toObj, String tableName, Object id) throws Exception {
        this.assignBeanAttrPara(cls, fromObj, toObj);
        Map para = new HashMap();
        para.put("id", id);
        this.buildBeanAttrPara(cls, toObj, para);
        para.put("tablename", tableName);
        return this.mapper.update(para);
    }
    /**
     *  通过Id 查找数据
     * @param tableName 表名
     * @param id id
     * @return map
     */
    public Map findById(String tableName,Integer id){
        return mapper.findById(tableName,id);
    }
    /**
     *  查找表中所有的数据
     * @param tableName 表名
     * @param isSoftDel 是否包含软删除，true:包含，false:不包含
     * @return list
     */
    public List<Map<Object, Object>> findAll(String tableName, boolean isSoftDel){
        return mapper.findAll(tableName,Boolean.toString(isSoftDel));
    }
    /**
     *  通过id删除数据
     * @param tableName 表名
     * @param id id
     * @param isSoftDel 是否是软删除
     * @return int
     */

    public int deleteById(String tableName,Integer id,boolean isSoftDel){
        if(isSoftDel){
            return mapper.deleteSoftById(tableName,id);
        }else{
            return mapper.deleteById(tableName,id);
        }
    }
    /***
     *  校验在table中是否存在重复记录
     * @param tableName 需要校验的记录表
     * @param condition 表字段
     * @param value 值
     * @param isSoftDel 是否校验软删除,true:包含软删除，false:不包含软删除
     * @return boolean ,true:重复，false：未重复
     */
    public boolean checkIsDuplicate(String tableName,String condition,String value,boolean isSoftDel){
        Map<String,String> map = new HashMap<String, String>();
        map.put("tablename",tableName);
        map.put("condition",condition);
        map.put("value",value);
        map.put("issoftdel",String.valueOf(isSoftDel));
        List<Map<Object, Object>> list = mapper.findByCondition(map);
        if(list.size() >0 ){
            return true;
        }else{
            return false;
        }
    }
    public int getId(String tableName){
        return mapper.findNextId(tableName);
    }
    /**
     * 将一个 Map 对象转化为一个 JavaBean
     * @param type 要转化的类型
     * @param map 包含属性值的 map
     * @return 转化出来的 JavaBean 对象
     * @throws IntrospectionException 如果分析类属性失败
     * @throws IllegalAccessException 如果实例化 JavaBean 失败
     * @throws InstantiationException 如果实例化 JavaBean 失败
     * @throws InvocationTargetException 如果调用属性的 setter 方法失败
     */
    @SuppressWarnings("rawtypes")
    public static Object convertFromMap(Class type, Map map)
            throws IntrospectionException, IllegalAccessException,
            InstantiationException, InvocationTargetException
    {
        BeanInfo beanInfo = Introspector.getBeanInfo(type);         // 获取类属性
        Object obj = type.newInstance();                            // 创建 JavaBean 对象
        // 给 JavaBean 对象的属性赋值
        PropertyDescriptor[] propertyDescriptors =  beanInfo.getPropertyDescriptors();
        for (int i = 0; i< propertyDescriptors.length; i++) {
            PropertyDescriptor descriptor = propertyDescriptors[i];
            String propertyName = descriptor.getName();
            Class propType = descriptor.getPropertyType();
            if (map.containsKey(propertyName.toLowerCase())) {
                // 下面一句可以 try 起来，这样当一个属性赋值失败的时候就不会影响其他属性赋值。
                Object value = map.get(propertyName.toLowerCase());
                if (value.equals(""))
                    continue;
                Class valType = value.getClass();
                if (valType.equals(BigDecimal.class) && (propType.equals(Integer.class) || propType.equals(int.class))) {
                    value = Integer.parseInt(value.toString());
                }
                if (valType.equals(String.class) && (propType.equals(Integer.class) || propType.equals(int.class))) {
                    value = Integer.parseInt(value.toString());
                }
                if (valType.equals(String.class) && (propType.equals(Double.class) || propType.equals(double.class))) {
                    value = Double.parseDouble(value.toString());
                }
                Object[] args = new Object[1];
                args[0] = value;
                descriptor.getWriteMethod().invoke(obj, args);
            }
        }
        return obj;
    }
    /***
     *  将bean转换成map，用于保存数据到数据库
     * @param cls bean class
     * @param obj bean 对象
     * @param para map
     * @throws Exception 异常
     */
    public void buildBeanAttrPara(Class cls, Object obj, Map para){
        Field[] fields = cls.getDeclaredFields();
        Field.setAccessible(fields, true);
        Map<String,Object> keyVal = new HashMap();
        Field[] var9 = fields;
        int var8 = fields.length;
        try {
            for(int var7 = 0; var7 < var8; ++var7) {
                Field field = var9[var7];
                keyVal.put(field.getName().toLowerCase(), field.get(obj));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        para.put("fields", keyVal);
    }
    public void assignBeanAttrPara(Class cls, Object from, Object to) throws Exception {
        Field[] fields = cls.getDeclaredFields();
        Field.setAccessible(fields, true);
        new HashMap();
        Field[] var9 = fields;
        int var8 = fields.length;
        for(int var7 = 0; var7 < var8; ++var7) {
            Field field = var9[var7];
            Object val = field.get(from);
            if (val != null) {
                field.set(to, val);
            }
        }
    }
}