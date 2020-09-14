package com.hlbrc.bicyclesales.service;

public interface IMainService {
	/**
	 * 添加购物车
	 * @param message
	 */
	public void insertshopcar(String message);
    /**
     * 删除购物车 批量删除
     * @param message
     */
	public void deleteshopcar(String message);
    /**
     * 购物车商品数量修改
     * @param message
     */
	public void updateshopcarnum(String message);
	/**
	 * 查看购物车
	 * @param message
	 */
	public void queryshopcar(String message);
	/**
	 * 添加订单
	 * @param message
	 */
	public void insertorder(String message);
	/**
	 * 查看订单详情
	 * @param message
	 */
	public void queryorderdetail(String message);
    /**
     * 修改订单状态订单
     * @param message
     */
	public void updateorderstatus(String message);
    /**
     * 自行车添加上传
     * @param message
     */
	public void insertbicycle(String message);
    /**
     * 自行车信息修改
     * @param message
     */
	public void updatebicycle(String message);
    /**
     * 自行车图片修改
     * @param message
     */
	public void updatebicyclephoto(String message);
	/**
	 * 自行车状态修改
	 * @param message
	 */
	public void updatebicyclestatus(String message);
	/**
	 * 自行车状态批量修改
	 * @param message
	 */
	public void updatebicycleliststatus(String message);
    /**
     * 自行车删除
     * @param message
     */
	public void deletebicycle(String message);
	/**
	 * 自行车批量删除
	 * @param message
	 */
	public void deletelistbicycle(String message);
    /**
     * 自行车类别添加
     * @param message
     */
	public void insertbicycletype(String message);
    /**
     * 自行车类别删除
     * @param message
     */
	public void deletebicycletype(String message);
	/**
	 * 自行车类别批量删除
	 * @param message
	 */
	public void deletelistbicycletype(String message);
	/**
	 * 自行车类别状态修改
	 * @param message
	 */
	public void updatebicycletypestatus(String message);
	/**
	 * 自行车类别批量状态修改
	 * @param message
	 */
	public void updatebicycletypeliststatus(String message);
    /**
     * 自行车类别查看
     * @param message
     */
	public void querybicycletype(String message);
    /**
     * 自行车类别修改
     * @param message
     */
	public void updatebicycletype(String message);
    /**
     * 自行车颜色添加
     * @param message
     */
	public void insertcolour(String message);
	/**
	 * 显示所有自行车颜色 根据自行车id判断
	 * @param message
	 */
	public void queryallcolour(String message);
	/**
	 * 自行车颜色状态修改
	 * @param message
	 */
	public void updatecolourstatus(String message);
	/**
	 * 自行车颜色状态批量修改
	 * @param message
	 */
	public void updatecolourliststatus(String message);
    /**
     * 自行车零件信息添加
     * @param message
     */
	public void insertpartmessage(String message);
    /**
     * 自行车零件信息修改
     * @param message
     */
	public void upartmessage(String message);
    /**
     * 自行车零件信息查看
     * @param message
     */
	public void querypartmessage(String message);
    /**
     * 自行车零件信息删除
     * @param message
     */
	public void deletepartmessage(String message);
	/**
	 * 自行车零件信息批量删除
	 * @param message
	 */
	public void deletelistpartmessage(String message);
    /**
     * 自行车零件类别添加
     * @param message
     */
	public void insertparttype(String message);
    /**
     * 自行车零件类别修改
     * @param message
     */
	public void updateparttype(String message);
    /**
     * 自行车零件类别查看
     * @param message
     */
	public void queryparttype(String message);
    /**
     * 自行车零件类别删除
     * @param message
     */
	public void deleteparttype(String message);
}
