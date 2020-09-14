package com.hlbrc.bicyclesales.service;

import javax.servlet.http.HttpSession;

public interface IManagerService {
	/**
	 * 管理员登录
	 * @param message
	 */
	public String managerlogin(String message, HttpSession session);
	/**
	 * 管理员注册 校验管理员名称是否重复
	 * @param message
	 */
	public String managerregister(String message);
	/**
	 * 管理员修改信息
	 * @param message
	 */
	public String updatemanager(String message);
	/**
	 * 管理员修改密码
	 * @param message
	 */
	public String updatemanagerpassword(String message);
	/**
	 * 通过管理员id查询信息
	 * @param message
	 * @return
	 */
	public String querymanagerById(String message);
}
