package com.hlbrc.bicyclesales.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hlbrc.bicyclesales.enums.IMyEnums;
import com.hlbrc.bicyclesales.service.IUserService;
import com.hlbrc.bicyclesales.util.MD5;
import com.hlbrc.bicyclesales.util.MyLog;

import net.sf.json.JSONObject;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class UserController {
	@Autowired
	IUserService user_service;
    /**
     *  用户登录
     * @param message
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "userLogin")
    @ResponseBody
    public String userLogin(String message,HttpServletRequest request){
    	JSONObject obj = new JSONObject();
    	try {
    		System.err.println(message);
    		String jsonobj = user_service.userlogin(message, request.getSession());
    		return jsonobj;
    	}
    	catch (Exception e) {
    		MyLog.log.debug("登录失败："+e.getMessage());
    		obj.put("msg", IMyEnums.FAIL);
			return obj.toString();
		}
        
    }
    
    /**
     * 用户注册
     * @param message
     * @return
     */
    @RequestMapping(value = "userRegister")
    @ResponseBody
    public String userRegister(String message){
    	JSONObject obj = new JSONObject();
    	try {
    		System.err.println(message);
    		String jsonobj = "qweqwe";
    		return jsonobj;
    	}
    	catch (Exception e) {
    		MyLog.log.debug("注册失败："+e.getMessage());
    		obj.put("msg", IMyEnums.FAIL);
			return obj.toString();
		}
        
    }
    
    /**
     * 添加收藏
     * @param message
     * @return
     */
    @RequestMapping(value = "insertCollect")
    @ResponseBody
    public String insertCollect(String message){
    	JSONObject obj = new JSONObject();
    	try {
    		System.err.println(message);
    		String jsonobj = user_service.insertcollect(message);
    		return jsonobj;
    	}
    	catch (Exception e) {
//    		e.printStackTrace();
    		MyLog.log.debug("收藏添加失败："+e.getMessage());
    		obj.put("msg", IMyEnums.FAIL);
			return obj.toString();
		}
    
    }
    
    /**
     * 查询某个用户的收藏个数
     * @param message
     * @return
     */
    @RequestMapping(value = "queryCollectNum")
    @ResponseBody
    public String queryCollectNum(String message){
    	JSONObject obj = new JSONObject();
    	try {
    		System.err.println(message);
    		String jsonobj = user_service.querycollectnum(message);
    		return jsonobj;
    	}
    	catch (Exception e) {
//    		e.printStackTrace();
    		MyLog.log.debug("查询某个用户的收藏个数："+e.getMessage());
    		obj.put("msg", IMyEnums.FAIL);
			return obj.toString();
		}
    
    }
    
    /**
     * 查询某个用户的收藏个数
     * @param message
     * @return
     */
    @RequestMapping(value = "queryCollect")
    @ResponseBody
    public String queryCollect(String message){
    	JSONObject obj = new JSONObject();
    	try {
    		System.err.println(message);
    		String jsonobj = user_service.queryuserallcollect(message);
    		return jsonobj;
    	}
    	catch (Exception e) {
//    		e.printStackTrace();
    		MyLog.log.debug("查询某个用户的收藏失败："+e.getMessage());
    		obj.put("msg", IMyEnums.FAIL);
			return obj.toString();
		}
    
    }
    
    /**
     * 删除用户的收藏
     * @param message
     * @return
     */
    @RequestMapping(value = "delCollect")
    @ResponseBody
    public String delCollect(String message){
    	JSONObject obj = new JSONObject();
    	try {
    		System.err.println(message);
    		String jsonobj = user_service.deletecollect(message);
    		return jsonobj;
    	}
    	catch (Exception e) {
//    		e.printStackTrace();
    		MyLog.log.debug("删除用户的收藏失败："+e.getMessage());
    		obj.put("msg", IMyEnums.FAIL);
			return obj.toString();
		}
    }
    
    /**
     * 添加用户的地址
     * @param message
     * @return
     */
    @RequestMapping(value = "insertAddress")
    @ResponseBody
    public String insertAddress(String message){
    	JSONObject obj = new JSONObject();
    	try {
    		System.err.println(message);
    		String jsonobj = user_service.insertaddress(message);
    		return jsonobj;
    	}
    	catch (Exception e) {
//    		e.printStackTrace();
    		MyLog.log.debug("删除用户的收藏失败："+e.getMessage());
    		obj.put("msg", IMyEnums.FAIL);
			return obj.toString();
		}
    }
    
    /**
     * 查询用户的地址
     * @param message
     * @return
     */
    @RequestMapping(value = "queryAddress")
    @ResponseBody
    public String queryAddress(String message){
    	JSONObject obj = new JSONObject();
    	try {
    		System.err.println(message);
    		String jsonobj = user_service.queryuseralladdress(message);
    		return jsonobj;
    	}
    	catch (Exception e) {
    		e.printStackTrace();
    		MyLog.log.debug("查询用户的地址失败："+e.getMessage());
    		obj.put("msg", IMyEnums.FAIL);
			return obj.toString();
		}
    }
    
    /**
     * 将某个用户的指定地址设置位默认地址
     * @param message
     * @return
     */
    @RequestMapping(value = "setAddressDefault")
    @ResponseBody
    public String setAddressDefault(String message){
    	JSONObject obj = new JSONObject();
    	try {
    		System.err.println(message);
    		String jsonobj = user_service.setaddressdefaultstatus(message);
    		return jsonobj;
    	}
    	catch (Exception e) {
    		MyLog.log.debug("将某个用户的指定地址设置位默认地址失败："+e.getMessage());
    		obj.put("msg", IMyEnums.FAIL);
			return obj.toString();
		}
    }
    
    /**
     * 改变某个用户地址的状态
     * @param message
     * @return
     */
    @RequestMapping(value = "setAddressStatus")
    @ResponseBody
    public String setAddressStatus(String message){
    	JSONObject obj = new JSONObject();
    	try {
    		System.err.println(message);
    		String jsonobj = user_service.setaddressstatus(message);
    		return jsonobj;
    	}
    	catch (Exception e) {
    		MyLog.log.debug("改变某个用户地址的状态失败："+e.getMessage());
    		obj.put("msg", IMyEnums.FAIL);
			return obj.toString();
		}
    }
    
    /**
     * 修改用户个人信息
     * @param message
     * @return
     */
    @RequestMapping(value = "updateUserMessage")
    @ResponseBody
    public String updateUserMessage(String message,HttpSession session){
    	JSONObject obj = new JSONObject();
    	try {
    		System.err.println(message);
    		if(message!=null&&!"".equals(message)) {
    			JSONObject json = JSONObject.fromObject(message);
    			String code = (String) session.getAttribute("appEmailVerifyCode");
    			String email = (String) session.getAttribute("email");
    			if(json.getString("email")!=null&&!"".equals(json.getString("email"))) {
    				if(code!=null&&!"".equals(code)&&email!=null&&!"".equals(email)) {
    					if(email.equals(json.getString("email"))) {
    						System.out.println("code:"+code);
                			if(code.equals(json.getString("code"))) {
                				String jsonobj = user_service.updateuser(message);
                    			return jsonobj;
                			}
                			else {
                				obj.put("msg", IMyEnums.CODE_ERROR);
                			}
    					}
    					else {
    						obj.put("msg", IMyEnums.EMAIL_BEEN_CHANGED);
    						session.invalidate();
    					}
            		}
            		else {
            			obj.put("msg", IMyEnums.FAIL);
            		}
    			}
    			else if(json.getString("name")!=null&&!"".equals(json.getString("name"))){
    				String jsonobj = user_service.updateuser(message);
        			return jsonobj;
    			}
    			else {
    				obj.put("msg", IMyEnums.FAIL);
    			}
    		}
    		else {
    			obj.put("msg", IMyEnums.FAIL);
    		}
    		return obj.toString();
    	}
    	catch(IllegalStateException e) {
    		MyLog.log.debug("session值失效："+e.getMessage());
    		obj.put("msg", IMyEnums.CODE_LOSE_EFFICAAY);
			return obj.toString();
    	}
    	catch (Exception e) {
    		MyLog.log.debug("修改用户个人信息失败："+e.getMessage());
    		obj.put("msg", IMyEnums.FAIL);
			return obj.toString();
		}
    }
    
    /**
     * 修改用户密码
     * @param message
     * @return
     */
    @RequestMapping(value = "updateUserPassword")
    @ResponseBody
    public String updateUserPassword(String message){
    	JSONObject obj = new JSONObject();
    	try {
    		System.err.println(message);
    		String jsonobj = user_service.updateuserpassword(message);
    		return jsonobj;
    	}
    	catch (Exception e) {
    		MyLog.log.debug("修改用户密码失败："+e.getMessage());
    		obj.put("msg", IMyEnums.FAIL);
			return obj.toString();
		}
    }
}
