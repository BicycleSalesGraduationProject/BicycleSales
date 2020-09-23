package com.hlbrc.bicyclesales.service;

import javax.servlet.http.HttpServletRequest;

public interface IMainService {
	/**
	 * 添加购物车
	 * @param message
	 */
	public String insertshopcar(String message);
    /**
     * 删除购物车 批量删除
     * @param message
     */
	public String deleteshopcar(String message);
    /**
     * 购物车商品数量修改
     * @param message
     */
	public String updateshopcarnum(String message);
	/**
	 * 查看购物车
	 * @param message
	 */
	public String queryshopcar(String message);
	/**
	 * 添加订单
	 * @param message
	 */
	public String insertorder(String message,HttpServletRequest request);
	/**
	 * 查看订单详情
	 * @param message
	 */
	public String queryorderdetail(String message);
    /**
     * 修改订单状态订单
     * @param message
     */
	public String updateorderstatus(String message);
    /**
     * 自行车添加上传
     * @param message
     */
	public String insertbicycle(String message);
    /**
     * 自行车信息修改
     * @param message
     */
	public String updatebicycle(String message);
	 /**
     * 自行车图片添加
     * @param message
     */
	public String insertbicyclephoto(String message);
    /**
     * 自行车图片修改
     * @param message
     */
	public String updatebicyclephotostatus(String message);
	/**
	 * 自行车状态修改
	 * @param message
	 */
	public String updatebicyclestatus(String message);
	/**
	 * 自行车状态批量修改
	 * @param message
	 */
	public String updatebicycleliststatus(String message);
    /**
     * 自行车删除
     * @param message
     */
	public String deletebicycle(String message);
	/**
	 * 自行车批量删除
	 * @param message
	 */
	public String deletelistbicycle(String message);
    /**
     * 自行车类别添加
     * @param message
     */
	public String insertbicycletype(String message);
    /**
     * 自行车类别删除
     * @param message
     */
	public String deletebicycletype(String message);
	/**
	 * 自行车类别批量删除
	 * @param message
	 */
	public String deletelistbicycletype(String message);
	/**
	 * 自行车类别状态修改
	 * @param message
	 */
	public String updatebicycletypestatus(String message);
	/**
	 * 自行车类别批量状态修改
	 * @param message
	 */
	public String updatebicycletypeliststatus(String message);
    /**
     * 自行车类别查看
     * @param message
     */
	public String querybicycletype(String message);
    /**
     * 自行车类别修改
     * @param message
     */
	public String updatebicycletype(String message);
    /**
     * 自行车颜色添加
     * @param message
     */
	public String insertcolour(String message);
	/**
	 * 显示所有自行车颜色
	 * @param message
	 */
	public String queryallcolour(String message);
	/**
	 * 自行车颜色状态修改
	 * @param message
	 */
	public String updatecolourstatus(String message);
	/**
	 * 自行车颜色状态批量修改
	 * @param message
	 */
	public String updatecolourliststatus(String message);
    /**
     * 自行车零件信息添加
     * @param message
     */
	public String insertpartmessage(String message);
    /**
     * 自行车零件信息修改
     * @param message
     */
	public String updatepartmessage(String message);
    /**
     * 自行车零件信息查看
     * @param message
     */
	public String querypartmessage(String message);
    /**
     * 自行车零件信息删除
     * @param message
     */
	public String deletepartmessage(String message);
	/**
	 * 自行车零件信息批量删除
	 * @param message
	 */
	public String deletelistpartmessage(String message);
    /**
     * 自行车零件类别添加
     * @param message
     */
	public String insertparttype(String message);
    /**
     * 自行车零件类别修改
     * @param message
     */
	public String updateparttype(String message);
    /**
     * 自行车零件类别查看
     * @param message
     */
	public String queryparttype(String message);
    /**
     * 自行车零件类别删除
     * @param message
     */
	public String deleteparttype(String message);
	/**
     * 显示所有自行车信息 根据自行车类别查询 分页
     * @param message
     */
	public String querybicycle(String message);
	/**
     * 显示所有自行车信息 分页
     * @param message
     */
	public String queryallbicycle(String message);
	/**
     * 通过自行车id查看自行车信息
     * @param message
     */
	public String querybicycleById(String message);
	/**
     * 显示某个状态的6辆自行车信息
     * @param message
     */
	public String querydelstatebicycle(String message);
	/**
	 * 通过用户id查询购物车数量
	 * @param message
	 * @return
	 */
	public String queryshopcarnum(String message);
}
