package com.hlbrc.bicyclesales.service;

import javax.servlet.http.HttpSession;

public interface IUserService {
	/**
	 * 用户登录
	 * @param message
	 * @param session
	 * @return
	 */
	public String userlogin(String message,HttpSession session);
	/**
	 * 注册（用户添加）需要校验邮箱是否重复
	 * @param message
	 * @return
	 */
	public String userregister(String message);
	/**
	 * 添加用户地址
	 * @param message
	 * @return
	 */
	public String insertaddress(String message);
	/**
	 * 用户地址修改
	 * @param message
	 * @return
	 */
	public String updateaddress(String message);
	/**
	 * 用户地址状态改变
	 * @param message
	 * @return
	 */
	public String setaddressstatus(String message);
	/**
	 * 用户设置默认地址
	 * @param message
	 * @return
	 */
	public String setaddressdefaultstatus(String message);
	/**
	 * 显示用户所有地址
	 * @param message
	 * @return
	 */
	public String queryuseralladdress(String message);
	/**
	 * 用户收藏添加
	 * @param message
	 * @return
	 */
	public String insertcollect(String message);
	/**
	 * 显示所有用户收藏 分页
	 * @param message
	 * @return
	 */
	public String queryuserallcollect(String message);
	/**
	 * 用户收藏删除
	 * @param message
	 * @return
	 */
	public String deletecollect(String message);
	/**
	 * 用户收藏批量删除
	 * @param message
	 * @return
	 */
	public String deletelistcollect(String message);
	/**
	 * 用户反馈
	 * @param message
	 * @return
	 */
	public String insertfeedback(String message);
    /**
             * 查看所有用户反馈 分页
     * @param message
     * @return
     */
	public String queryuserallfeedback(String message);
    /**
             * 用户反馈删除
     * @param message
     * @return
     */
	public String deletefeedback(String message);
	/**
	 * 用户反馈批量删除
	 * @param message
	 * @return
	 */
	public String deletelistfeedback(String message);
    /**
              * 用户信息修改
     * @param message
     * @return
     */
	public String updateuser(String message);
    /**
             * 用户密码修改
     * @param message
     * @return
     */
	public String updateuserpassword(String message);
    /**
              * 用户个人信息查看 通过用户id查看个人信息
     * @param message
     * @return
     */
	public String queryuserById(String message);
	/**
	 * 查看所有用户信息 模糊查询（用户名） 分页
	 * @param message
	 * @return
	 */
	public String queryalluser(String message);
    /**
              * 用户状态改变 如：封号 是否在线 假删除
     * @param message
     * @return
     */
	public String setuserstatus(String message);
	/**
	 * 用户状态批量改变
	 * @param message
	 * @return
	 */
	public String setuserliststatus(String message);
    /**
              * 用户删除
     * @param message
     * @return
     */
	public String deleteuser(String message);
	/**
	 * 用户批量删除
	 * @param message
	 * @return
	 */
	public String deletelistuser(String message);
	/**
	 * 通过邮箱查询用户信息
	 * @param message
	 * @return
	 */
	public String queryuserByEmail(String message);
}
