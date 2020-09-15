package com.hlbrc.bicyclesales.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hlbrc.bicyclesales.service.IUserService;
import com.hlbrc.bicyclesales.util.CookieUtils;
import com.hlbrc.bicyclesales.util.MyLog;

import java.net.URLEncoder;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
    public String userLogin(String message,HttpServletRequest request,HttpServletResponse response){
    	try {
    		System.err.println(message);
    		String jsonobj = user_service.userlogin(message, request.getSession());
    		return jsonobj;
    	}
    	catch (Exception e) {
    		MyLog.log.debug("登录失败："+e.getMessage());
			return "{'msg','no'}";
		}
        
    }
    @RequestMapping(value = "userRegister")
    @ResponseBody
    public String userRegister(String message,HttpServletRequest request){
    	try {
    		System.err.println(message);
    		String jsonobj = "qweqwe";
    		return jsonobj;
    	}
    	catch (Exception e) {
    		MyLog.log.debug("登录失败："+e.getMessage());
			return "{'msg','no'}";
		}
        
    }
}
