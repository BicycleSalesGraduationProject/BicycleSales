package com.hlbrc.bicyclesales.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.hlbrc.bicyclesales.enums.IMyEnums;
import com.hlbrc.bicyclesales.service.IMainService;
import com.hlbrc.bicyclesales.service.IUserService;
import com.hlbrc.bicyclesales.util.MD5;
import com.hlbrc.bicyclesales.util.MyLog;
import com.hlbrc.bicyclesales.util.QqEmailSendMessage;

import net.sf.json.JSONObject;

@Controller
public class MainController {
	@Autowired
	IMainService main_service;
	@Autowired
	IUserService user_service;
	public static void main(String[] args) {
		String str="<table class=\"table table-bordered\">\r\n" + 
				"																<thead class=\"thead-light\">\r\n" + 
				"																	<tr>\r\n" + 
				"																		<th>编号</th>\r\n" + 
				"																		<th>姓名</th>\r\n" + 
				"																		<th>地址</th>\r\n" + 
				"																		<th>电话</th>\r\n" + 
				"																		<th>操作</th>\r\n" + 
				"																	</tr>\r\n" + 
				"																</thead>\r\n" + 
				"																<tbody>\r\n" + 
				"																	<tr>\r\n" + 
				"																		<td>1</td>\r\n" + 
				"																		<td><strong>Erik Jhonson</strong></td>\r\n" + 
				"																		<td>1355 Market St, Suite 900 <br> San Francisco, CA 94103</td>\r\n" + 
				"																		<td>Mobile: (123) 456-7890</td>\r\n" + 
				"																		<td><i class=\"fa fa-trash-o\"></i> <i class=\"fa fa-file-word-o\"></i></td>\r\n" + 
				"																	</tr>\r\n" + 
				"																</tbody>\r\n" + 
				"															</table>";
	}
	/**
     *  显示所有自行车信息 根据自行车类别查询 分页
     * @param message
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "queryBicycle")
    @ResponseBody
    public String queryBicycle(String message){
    	JSONObject obj = new JSONObject();
    	try {
    		System.err.println(message);
    		String jsonobj = main_service.querybicycle(message);
    		return jsonobj;
    	}
    	catch (Exception e) {
    		MyLog.log.debug("自行车信息查询失败："+e.getMessage());
    		obj.put("msg", IMyEnums.FAIL);
			return obj.toString();
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
    public String insertBicycle(@RequestParam(value="suoluetu",required=false)MultipartFile[] suoluetu,
    							@RequestParam(value="chanpinzhutu",required=false)MultipartFile[] chanpinzhutu,
    							String message){
    	JSONObject obj1 = new JSONObject();
    	try {
    		System.err.println("主："+suoluetu.length+" "+message+" 缩："+chanpinzhutu.length);
    		List<String> list = new ArrayList<String>(); 
			int i=0;
			if(suoluetu!=null) {
				for(MultipartFile f:suoluetu) {
					String fileName = new Date().getTime() + i + "" + f.getOriginalFilename().substring(f.getOriginalFilename().lastIndexOf("."));
					i++;
					list.add(fileName);
					File file = new File("F:/bicycle_pic/" + fileName);
					if(!file.exists()){
					    //先得到文件的上级目录,并创建上级目录,在创建文件
						if(!file.getParentFile().mkdir()) {
							file.getParentFile().getParentFile().mkdir();
						}
					    try {
					        //创建文件
					        file.createNewFile();
					    } catch (IOException e) {
					        e.printStackTrace();
					    }
					}
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
					if(!file.exists()){
					    //先得到文件的上级目录,并创建上级目录,在创建文件
						if(!file.getParentFile().mkdir()) {
							file.getParentFile().getParentFile().mkdir();
						}
					    try {
					        //创建文件
					        file.createNewFile();
					    } catch (IOException e) {
					        e.printStackTrace();
					    }
					}
					//对文件进行上传
					f.transferTo(file);
				}
			}
    		
    		// 上传到数据库
    		String json = main_service.insertbicycle(message);
    		JSONObject jsonmessage = JSONObject.fromObject(message);
    		JSONObject jsonobj = JSONObject.fromObject(json);
    		
    		if(IMyEnums.SUCCEED.equals(jsonobj.getString("msg"))) {
    			for(String fileName:list) {
    				JSONObject obj = new JSONObject();
    				obj.accumulate("bicycleid", jsonobj.getString("bid"));
        			obj.accumulate("path", fileName);
        			obj.accumulate("name", jsonmessage.getString("name"));
        			json = main_service.insertbicyclephoto(obj.toString());
    			}
    		}
    		return json;
    	}
    	catch (Exception e) {
    		MyLog.log.debug("自行车信息添加失败："+e.getMessage());
    		obj1.put("msg", IMyEnums.FAIL);
			return obj1.toString();
		}
    }
    
    /**
     * 通过自行车Id查询信息
     * @param message
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "queryBicycleById")
    @ResponseBody
    public String queryBicycleById(String message){
    	JSONObject obj = new JSONObject();
    	try {
    		System.err.println(message);
    		String jsonobj = main_service.querybicycleById(message);
    		return jsonobj;
    	}
    	catch (Exception e) {
    		MyLog.log.debug("通过自行车id，查询信息查询失败："+e.getMessage());
    		obj.put("msg", IMyEnums.FAIL);
			return obj.toString();
		}
    }
    
    /**
     * 通过自行车状态查询6辆自行车信息
     * @param message
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "queryDelstateBicycle")
    @ResponseBody
    public String queryDelstateBicycle(String message){
    	JSONObject obj = new JSONObject();
    	try {
    		System.err.println(message);
    		String jsonobj = main_service.querydelstatebicycle(message);
    		return jsonobj;
    	}
    	catch (Exception e) {
    		MyLog.log.debug("通过自行车状态6辆自行车信息查询失败："+e.getMessage());
    		obj.put("msg", IMyEnums.FAIL);
			return obj.toString();
		}
    }
    
    /**
     * 添加购物车
     * @param message
     * @return
     */
    @RequestMapping(value = "insertShopCar")
    @ResponseBody
    public String insertShopCar(String message){
    	JSONObject obj = new JSONObject();
    	try {
    		System.err.println(message);
    		String jsonobj = main_service.insertshopcar(message);
    		return jsonobj;
    	}
    	catch (Exception e) {
    		MyLog.log.debug("购物车添加失败："+e.getMessage());
    		obj.put("msg", IMyEnums.FAIL);
			return obj.toString();
		}
    
    }
    
    /**
     * 查询某个用户购物车数量
     * @param message
     * @return
     */
    @RequestMapping(value = "queryShopCarNum")
    @ResponseBody
    public String queryShopCarNum(String message){
    	JSONObject obj = new JSONObject();
    	try {
    		System.err.println(message);
    		String jsonobj = main_service.queryshopcarnum(message);
    		return jsonobj;
    	}
    	catch (Exception e) {
    		MyLog.log.debug("查询某个用户购物车数量失败："+e.getMessage());
    		obj.put("msg", IMyEnums.FAIL);
			return obj.toString();
		}
    
    }
    
    /**
     * 查询某个用户购物车
     * @param message
     * @return
     */
    @RequestMapping(value = "queryShopCar")
    @ResponseBody
    public String queryShopCar(String message){
    	JSONObject obj = new JSONObject();
    	try {
    		System.err.println(message);
    		String jsonobj = main_service.queryshopcar(message);
    		return jsonobj;
    	}
    	catch (Exception e) {
    		MyLog.log.debug("查询某个用户购物车失败："+e.getMessage());
    		obj.put("msg", IMyEnums.FAIL);
			return obj.toString();
		}
    
    }
    
    /**
     * 删除某个用户购物车某个商品
     * @param message
     * @return
     */
    @RequestMapping(value = "delShopCar")
    @ResponseBody
    public String delShopCar(String message){
    	JSONObject obj = new JSONObject();
    	try {
    		System.err.println(message);
    		String jsonobj = main_service.deleteshopcar(message);
    		return jsonobj;
    	}
    	catch (Exception e) {
    		MyLog.log.debug("删除某个用户购物车某个商品失败："+e.getMessage());
    		obj.put("msg", IMyEnums.FAIL);
			return obj.toString();
		}
    }
    
    /**
     * 发送验证码
     * @param message
     * @return
     */
    @RequestMapping(value = "sendVisCode")
    @ResponseBody
    public String sendVisCode(String message,HttpServletRequest request){
    	JSONObject obj = new JSONObject();
    	try {
    		if(message!=null&&!"".equals(message)) {
    			JSONObject json = JSONObject.fromObject(message);
    			if(json.getString("email")!=null&&!"".equals(json.getString("email"))) {
    				if(QqEmailSendMessage.sendEmail(json.getString("email"), request)) {
    					String code =  (String) request.getSession().getAttribute("appEmailVerifyCode");
    					obj.put("code", MD5.getMD5(code));
    					obj.put("msg", IMyEnums.SUCCEED);
    					return obj.toString();
    				}
    				else {
    					obj.put("msg", IMyEnums.FAIL);
    					return obj.toString();
    				}
    			}
    			else {
    				obj.put("msg", IMyEnums.FAIL);
    				return obj.toString();
    			}
    		}
    		else {
    			obj.put("msg", IMyEnums.FAIL);
    			return obj.toString();
    		}
    	}
    	catch (Exception e) {
    		e.printStackTrace();
    		MyLog.log.debug("发送验证码失败："+e.getMessage());
    		obj.put("msg", IMyEnums.FAIL);
			return obj.toString();
		}
    }
}
