package com.hlbrc.bicyclesales.enums;

public interface IMyEnums {
    /**
     * 状态
     */
    public final static String DELETE = "0";//已删除
    public final static String NORMAL = "1";//正常
    /**
     * 用户状态
     */
    public final static String USER_ON_lINE = "1";//在线
    public final static String USER_OFF_LINE = "2";//离线
    public final static String USER_NORMAL = "3";//正常
    public final static String USER_LIMIT_LOGIN = "4";//限制登录
    /**
     * 订单状态
     */
    public final static String ORDER_CANCEL = "0";//取消
    public final static String ORDER_NON_PAYMENT = "1";//未支付
    public final static String ORDER_PAID = "2";//已支付
    public final static String ORDER_NOT_SHIPPED = "3";//未发货
    public final static String ORDER_SHIPPED = "4";//已发货
    public final static String ORDER_REFUND = "5";//退货
    public final static String ORDER_FINISHED = "6";//完成
    /**
     * 用户地址是否默认
     */
    public final static String USER_DEFAULT = "1";//用户默认
    public final static String USER_NOT_DEFAULT = "2";//用户非默认
    /**
     * 地址标签
     */
    public final static String ADDRES_LABRL_HONE = "1";//家
    public final static String ADDRES_LABRL_COMPANY = "2";//公司
    public final static String ADDRES_LABRL_SCHOOL = "3";//学校
    public final static String ADDRES_LABRL_CUSTOM = "4";//自定义
}
