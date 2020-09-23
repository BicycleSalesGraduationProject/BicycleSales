package com.hlbrc.bicyclesales.service.Impl;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hlbrc.bicyclesales.entity.Administrator;
import com.hlbrc.bicyclesales.entity.AdministratorExample;
import com.hlbrc.bicyclesales.enums.IMyEnums;
import com.hlbrc.bicyclesales.mapper.IAdministratorMapper;
import com.hlbrc.bicyclesales.service.IManagerService;
import com.hlbrc.bicyclesales.util.MD5;

import net.sf.json.JSONObject;

@Service("ManagerServiceImpl")
public class ManagerServiceImpl implements IManagerService{
	@Autowired
	IAdministratorMapper administrator_mapper;

	@Override
	public String managerlogin(String message, HttpSession session) {
		JSONObject obj = new JSONObject();
		JSONObject json = new JSONObject();
		if(message!=null&&!"".equals(message)) {
			json = JSONObject.fromObject(message);
			AdministratorExample example = new AdministratorExample();
			AdministratorExample.Criteria criteria = example.createCriteria();
			criteria.andNameEqualTo(json.getString("name"));
			criteria.andPasswordEqualTo(MD5.getMD5(json.getString("password")));
			List<Administrator> list = administrator_mapper.selectByExample(example);
			if(list!=null&&list.size()>0) {
				session.setAttribute("administrator", list.get(0));
				obj.put("administrator", list.get(0));
				obj.put("msg", IMyEnums.SUCCEED);
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

	@Override
	public String managerregister(String message) {
		JSONObject obj = new JSONObject();
		JSONObject json = new JSONObject();
		if(message!=null&&!"".equals(message)) {
			json = JSONObject.fromObject(message);
			Administrator administrator = new Administrator();
			if(json.getString("name")!=null&&!"".equals(json.getString("name"))) {
				administrator.setName(json.getString("name"));
				AdministratorExample example = new AdministratorExample();
				AdministratorExample.Criteria criteria = example.createCriteria();
				criteria.andNameEqualTo(json.getString("name"));
				List<Administrator> list = administrator_mapper.selectByExample(example);
				if(list!=null&&list.size()>0) {
					obj.put("msg", IMyEnums.ADMINISTRATOR_NAME_ALREADY_EXISTS);
					return obj.toString();
				}
			}
			else {
				obj.put("msg", IMyEnums.FAIL);
				return obj.toString();
			}
			if(json.getString("password")!=null&&!"".equals(json.getString("password"))) {
				administrator.setPassword(MD5.getMD5(json.getString("password")));
			}
			else {
				obj.put("msg", IMyEnums.FAIL);
				return obj.toString();
			}
			if(json.getString("duty")!=null&&!"".equals(json.getString("duty"))) {
				administrator.setDuty(json.getString("duty"));
			}
			int i = administrator_mapper.insertSelective(administrator);
			if(i>0) {
				obj.put("msg", IMyEnums.SUCCEED);
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

	@Override
	public String updatemanager(String message) {
		JSONObject obj = new JSONObject();
		JSONObject json = new JSONObject();
		if(message!=null&&!"".equals(message)) {
			json = JSONObject.fromObject(message);
			Administrator administrator = new Administrator();
			if(json.getString("name")!=null&&!"".equals(json.getString("name"))) {
				administrator.setName(json.getString("name"));
			}
			else {
				obj.put("msg", IMyEnums.FAIL);
				return obj.toString();
			}
			if(json.getString("password")!=null&&!"".equals(json.getString("password"))) {
				administrator.setPassword(MD5.getMD5(json.getString("password")));
			}
			else {
				obj.put("msg", IMyEnums.FAIL);
				return obj.toString();
			}
			if(json.getString("duty")!=null&&!"".equals(json.getString("duty"))) {
				administrator.setDuty(json.getString("duty"));
			}
			AdministratorExample example = new AdministratorExample();
			AdministratorExample.Criteria criteria = example.createCriteria();
			criteria.andAdministratoridEqualTo(Integer.parseInt(json.getString("administratorid")));
			int i = administrator_mapper.updateByExampleSelective(administrator,example);
			if(i>0) {
				obj.put("msg", IMyEnums.SUCCEED);
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

	@Override
	public String updatemanagerpassword(String message) {
		JSONObject obj = new JSONObject();
		JSONObject json = new JSONObject();
		if(message!=null&&!"".equals(message)) {
			json = JSONObject.fromObject(message);
			Administrator administrator = new Administrator();
			if(json.getString("password")!=null&&!"".equals(json.getString("password"))) {
				administrator.setPassword(MD5.getMD5(json.getString("password")));
			}
			else {
				obj.put("msg", IMyEnums.FAIL);
				return obj.toString();
			}
			AdministratorExample example = new AdministratorExample();
			AdministratorExample.Criteria criteria = example.createCriteria();
			if(json.getString("administratorid")!=null&&!"".equals(json.getString("administratorid"))) {
				criteria.andAdministratoridEqualTo(Integer.parseInt(json.getString("administratorid")));
			}
			else {
				obj.put("msg", IMyEnums.FAIL);
				return obj.toString();
			}
			int i = administrator_mapper.updateByExampleSelective(administrator,example);
			if(i>0) {
				obj.put("msg", IMyEnums.SUCCEED);
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

	@Override
	public String querymanagerById(String message) {
		JSONObject obj = new JSONObject();
		JSONObject json = new JSONObject();
		if(message!=null&&!"".equals(message)) {
			json = JSONObject.fromObject(message);
			AdministratorExample example = new AdministratorExample();
			AdministratorExample.Criteria criteria = example.createCriteria();
			if(json.getString("administratorid")!=null&&!"".equals(json.getString("administratorid"))) {
				criteria.andAdministratoridEqualTo(Integer.parseInt(json.getString("administratorid")));
			}
			else {
				obj.put("msg", IMyEnums.FAIL);
				return obj.toString();
			}
			List<Administrator> list = administrator_mapper.selectByExample(example);
			if(list!=null&&list.size()>0) {
				obj.put("administrator", JSONObject.fromObject(list.get(0)));
				obj.put("msg", IMyEnums.SUCCEED);
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

}
