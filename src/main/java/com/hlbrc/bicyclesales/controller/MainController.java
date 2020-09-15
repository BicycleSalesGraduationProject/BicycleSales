package com.hlbrc.bicyclesales.controller;

import java.io.File;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.hlbrc.bicyclesales.enums.IMyEnums;
import com.hlbrc.bicyclesales.service.IMainService;
import com.hlbrc.bicyclesales.util.MyLog;

import net.sf.json.JSONObject;

@Controller
public class MainController {
	@Autowired
	IMainService main_service;
	/**
     *  显示所有自行车信息 根据自行车类别查询 分页
     * @param message
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "queryBicycle")
    @ResponseBody
    public String queryBicycle(String message,HttpServletRequest request,HttpServletResponse response){
    	try {
    		System.err.println(message);
    		String jsonobj = main_service.querybicycle(message);
    		return jsonobj;
    	}
    	catch (Exception e) {
    		MyLog.log.debug("自行车信息查询失败："+e.getMessage());
			return "{'msg','no'}";
		}
        
    }
    
    /**
     * 添加自行车信息 上传图片
     * @param message
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "insertBicycle")
    @ResponseBody
    public String insertBicycle(@RequestParam(value="suoluetu",required=false) MultipartFile[] suoluetu,
    							@RequestParam(value="chanpinzhutu",required=false) MultipartFile[] chanpinzhutu,
    							String message,
    							HttpServletRequest request,
    							HttpServletResponse response){
    	try {
    		System.err.println(message);
    		List<String> list = new ArrayList<String>(); 
    		try {
    			int i=0;
    			if(suoluetu!=null) {
    				for(MultipartFile f:suoluetu) {
    					String fileName = new Date().getTime() + i + "" + f.getOriginalFilename().substring(f.getOriginalFilename().lastIndexOf("."));
    					i++;
    					list.add(fileName);
    					File file = new File("F:/bicycle_pic/" + fileName);
    					//对文件进行上传
    					f.transferTo(file);
    				}
    			}
    			if(chanpinzhutu!=null) {
    				for(MultipartFile f:chanpinzhutu) {
    					String fileName = new Date().getTime() + i + "" + f.getOriginalFilename().substring(f.getOriginalFilename().lastIndexOf("."));
    					i++;
    					list.add(fileName);
    					File file = new File("F:/bicycle_pic/" + fileName);
    					//对文件进行上传
    					f.transferTo(file);
    				}
    			}
    		} catch (Exception e) {
    			e.printStackTrace();
    		} 
    		// 上传到数据库
    		String json = main_service.insertbicycle(message);
    		JSONObject jsonmessage = JSONObject.fromObject(message);
    		JSONObject jsonobj = JSONObject.fromObject(json);
    		JSONObject obj = new JSONObject();
    		if(IMyEnums.SUCCEED.equals(jsonobj.getString("msg"))) {
    			for(String fileName:list) {
    				obj.accumulate("bicycleid", jsonobj.getString("bid"));
        			obj.accumulate("path", fileName);
        			obj.accumulate("name", jsonmessage.getString("name"));
        			json = main_service.insertbicyclephoto(message);
    			}
    		}
    		return json;
    	}
    	catch (Exception e) {
    		MyLog.log.debug("自行车信息添加失败："+e.getMessage());
			return "{'msg','no'}";
		}
        
    }
}
