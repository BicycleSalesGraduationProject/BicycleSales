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
     *  显示所有自行车信息
     * @param message
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "queryAllBicycle")
    @ResponseBody
    public String queryAllBicycle(String message){
    	JSONObject obj = new JSONObject();
    	try {
    		System.err.println(message);
    		String jsonobj = main_service.queryallbicycle(message);
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
     * 通过自行车状态查询8辆自行车信息
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
    		e.printStackTrace();
    		MyLog.log.debug("通过自行车状态8辆自行车信息查询失败："+e.getMessage());
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
    		e.printStackTrace();
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
    
    /**
     * 忘记密码发送验证码
     * @param message
     * @return
     */
    @RequestMapping(value = "sendVisCodeForget")
    @ResponseBody
    public String sendVisCodeForget(String message,HttpServletRequest request){
    	JSONObject obj = new JSONObject();
    	try {
    		if(message!=null&&!"".equals(message)) {
    			JSONObject json = JSONObject.fromObject(message);
    			if(json.getString("email")!=null&&!"".equals(json.getString("email"))) {
    				JSONObject obj1 = JSONObject.fromObject(user_service.queryuserByEmail(message));
    				if(!"no".equals(obj1.getString("msg"))) {
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
    					obj.put("msg", IMyEnums.EMAIL_NOT_ALREADY_EXISTS);
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
    
    /**
     * 修改商品状态
     * @param message
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "delProduct")
    @ResponseBody
    public String delProduct(String message){
    	JSONObject obj = new JSONObject();
    	try {
    		System.err.println(message);
    		String jsonobj = main_service.updatebicyclestatus(message);
    		return jsonobj;
    	}
    	catch (Exception e) {
    		MyLog.log.debug("修改商品状态失败："+e.getMessage());
    		obj.put("msg", IMyEnums.FAIL);
			return obj.toString();
		}
        
    }
    
    /**
     * 批量修改商品状态
     * @param message
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "delListProduct")
    @ResponseBody
    public String delListProduct(String message){
    	JSONObject obj = new JSONObject();
    	try {
    		System.err.println(message);
    		String jsonobj = main_service.updatebicycleliststatus(message);
    		return jsonobj;
    	}
    	catch (Exception e) {
    		MyLog.log.debug("批量修改商品状态失败："+e.getMessage());
    		obj.put("msg", IMyEnums.FAIL);
			return obj.toString();
		}
        
    }
    
    /**
     * 彻底删除商品
     * @param message
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "removeProduct")
    @ResponseBody
    public String removeProduct(String message){
    	JSONObject obj = new JSONObject();
    	try {
    		System.err.println(message);
    		String jsonobj = main_service.deletebicycle(message);
    		return jsonobj;
    	}
    	catch (Exception e) {
    		MyLog.log.debug("彻底删除商品失败："+e.getMessage());
    		obj.put("msg", IMyEnums.FAIL);
			return obj.toString();
		}
        
    }
    
    /**
     * 批量彻底删除商品
     * @param message
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "removeListProduct")
    @ResponseBody
    public String removeListProduct(String message){
    	JSONObject obj = new JSONObject();
    	try {
    		System.err.println(message);
    		String jsonobj = main_service.deletelistbicycle(message);
    		return jsonobj;
    	}
    	catch (Exception e) {
    		MyLog.log.debug("批量彻底删除商品失败："+e.getMessage());
    		obj.put("msg", IMyEnums.FAIL);
			return obj.toString();
		}
    }
    
    /**
     * 添加订单
     * @param message
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "insertOrder")
    @ResponseBody
    public String insertOrder(String message,HttpServletRequest request){
    	JSONObject obj = new JSONObject();
    	try {
    		System.err.println(message);
    		String jsonobj = main_service.insertorder(message, request);
    		return jsonobj;
    	}
    	catch (Exception e) {
    		MyLog.log.debug("添加订单失败："+e.getMessage());
    		obj.put("msg", IMyEnums.FAIL);
			return obj.toString();
		}
    }
    
    /**
     * 通过订单编号查询订单详情
     * @param message
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "queryOrderDetailByOrderNo")
    @ResponseBody
    public String queryOrderDetailByOrderNo(String message){
    	JSONObject obj = new JSONObject();
    	try {
    		System.err.println(message);
    		String jsonobj = main_service.queryorderdetail(message);
    		return jsonobj;
    	}
    	catch (Exception e) {
    		MyLog.log.debug("通过订单编号查询订单详情失败："+e.getMessage());
    		obj.put("msg", IMyEnums.FAIL);
			return obj.toString();
		}
    }
    
    /**
     * 通过用户id查询订单
     * @param message
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "queryOrderByUserId")
    @ResponseBody
    public String queryOrderByUserId(String message){
    	JSONObject obj = new JSONObject();
    	try {
    		System.err.println(message);
    		String jsonobj = main_service.queryorderByUserId(message);
    		return jsonobj;
    	}
    	catch (Exception e) {
    		MyLog.log.debug("通过用户id查询订单失败："+e.getMessage());
    		obj.put("msg", IMyEnums.FAIL);
			return obj.toString();
		}
    }
    
    /**
     * 查询所有订单
     * @param message
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "queryAllOrder")
    @ResponseBody
    public String queryAllOrder(String message){
    	JSONObject obj = new JSONObject();
    	try {
    		System.err.println(message);
    		String jsonobj = main_service.queryallorder(message);
    		return jsonobj;
    	}
    	catch (Exception e) {
    		MyLog.log.debug("查询所有订单失败："+e.getMessage());
    		obj.put("msg", IMyEnums.FAIL);
			return obj.toString();
		}
    }
    
    /**
     * 	设置订单状态
     * @param message
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "setOrderStatus")
    @ResponseBody
    public String setOrderStatus(String message){
    	JSONObject obj = new JSONObject();
    	try {
    		System.err.println(message);
    		String jsonobj = main_service.updateorderstatus(message);
    		return jsonobj;
    	}
    	catch (Exception e) {
    		MyLog.log.debug("设置订单状态失败："+e.getMessage());
    		obj.put("msg", IMyEnums.FAIL);
			return obj.toString();
		}
    }
    
    /**
     * 	批量设置订单状态
     * @param message
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "setOrderListStatus")
    @ResponseBody
    public String setOrderListStatus(String message){
    	JSONObject obj = new JSONObject();
    	try {
    		System.err.println(message);
    		String jsonobj = main_service.updateorderliststatus(message);
    		return jsonobj;
    	}
    	catch (Exception e) {
    		MyLog.log.debug("批量设置订单状态失败："+e.getMessage());
    		obj.put("msg", IMyEnums.FAIL);
			return obj.toString();
		}
    }

}
