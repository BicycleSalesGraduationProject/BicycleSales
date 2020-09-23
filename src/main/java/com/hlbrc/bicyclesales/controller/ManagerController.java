package com.hlbrc.bicyclesales.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hlbrc.bicyclesales.enums.IMyEnums;
import com.hlbrc.bicyclesales.service.IManagerService;
import com.hlbrc.bicyclesales.util.MyLog;

import net.sf.json.JSONObject;

@Controller
public class ManagerController {
	@Autowired
	IManagerService manager_service;
	
	 /**
     *  管理员登录
     * @param message
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "managerLogin")
    @ResponseBody
    public String managerLogin(String message,HttpServletRequest request){
    	JSONObject obj = new JSONObject();
    	try {
    		System.err.println(message);
    		String jsonobj = manager_service.managerlogin(message, request.getSession());
    		return jsonobj;
    	}
    	catch (Exception e) {
    		MyLog.log.debug("管理员登录失败："+e.getMessage());
    		obj.put("msg", IMyEnums.FAIL);
			return obj.toString();
		}
        
    }
	
    /**
     * 管理员修改密码
     * @param message
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "updateManagerPassword")
    @ResponseBody
    public String updateManagerPassword(String message,HttpServletRequest reques){
    	JSONObject obj = new JSONObject();
    	try {
    		System.err.println(message);
    		String jsonobj = manager_service.updatemanagerpassword(message);
    		return jsonobj;
    	}
    	catch (Exception e) {
    		MyLog.log.debug("管理员修改密码失败："+e.getMessage());
    		obj.put("msg", IMyEnums.FAIL);
			return obj.toString();
		}
        
    }
}
