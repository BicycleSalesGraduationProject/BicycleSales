package com.hlbrc.bicyclesales.service.Impl;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hlbrc.bicyclesales.entity.Address;
import com.hlbrc.bicyclesales.entity.AddressExample;
import com.hlbrc.bicyclesales.entity.Bicycle;
import com.hlbrc.bicyclesales.entity.Collect;
import com.hlbrc.bicyclesales.entity.CollectExample;
import com.hlbrc.bicyclesales.entity.FeedBack;
import com.hlbrc.bicyclesales.entity.FeedBackExample;
import com.hlbrc.bicyclesales.entity.Photo;
import com.hlbrc.bicyclesales.entity.PhotoExample;
import com.hlbrc.bicyclesales.entity.User;
import com.hlbrc.bicyclesales.entity.UserExample;
import com.hlbrc.bicyclesales.enums.IMyEnums;
import com.hlbrc.bicyclesales.mapper.IAddressMapper;
import com.hlbrc.bicyclesales.mapper.IBicycleMapper;
import com.hlbrc.bicyclesales.mapper.ICollectMapper;
import com.hlbrc.bicyclesales.mapper.IFeedBackMapper;
import com.hlbrc.bicyclesales.mapper.IPhotoMapper;
import com.hlbrc.bicyclesales.mapper.IUserMapper;
import com.hlbrc.bicyclesales.service.IAddressService;
import com.hlbrc.bicyclesales.service.IUserService;
import com.hlbrc.bicyclesales.util.MD5;
import com.hlbrc.bicyclesales.util.Time;

import net.sf.json.JSONObject;

@Service("UserServiceImpl")
public class UserServiceImpl implements IUserService {
	@Autowired
	IUserMapper user_mapper;
	@Autowired
	IAddressMapper address_mapper;
	@Autowired
	ICollectMapper collect_mapper;
	@Autowired
	IFeedBackMapper feed_back_mapper;
	@Autowired
	IBicycleMapper bicycle_mapper;
	@Autowired
	IPhotoMapper photo_mapper;
	@Autowired
	IAddressService address_service;

	@Override
	public String userlogin(String message, HttpSession session) {
		JSONObject obj = new JSONObject();
		JSONObject json = new JSONObject();
		if(message!=null&&!"".equals(message)) {
			json = JSONObject.fromObject(message);
			UserExample example = new UserExample();
			UserExample.Criteria criteria = example.createCriteria();
			criteria.andEmailEqualTo(json.getString("email"));
			criteria.andPasswordEqualTo(MD5.getMD5(json.getString("password")));
			List<User> list = user_mapper.selectByExample(example);
			if(list!=null&&list.size()>0) {
				session.setAttribute("user", list.get(0));
				obj.put("user", list.get(0));
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
	public String userregister(String message) {
		JSONObject obj = new JSONObject();
		JSONObject json = new JSONObject();
		if(message!=null&&!"".equals(message)) {
			json = JSONObject.fromObject(message);
			User user = new User();
			String idnumber = json.getString("idnumber");
			if(idnumber!=null&&!"".equals(idnumber)) {
	//			String birthday=idnumber.substring(6,14);
				int day=Integer.parseInt(idnumber.substring(10,14));
				int age=Time.Getyear()-Integer.parseInt(idnumber.substring(6,10));
				if(Integer.parseInt(Time.Getmonth()+Time.Getday())<day)
					 age=age-1;		
				//通过身份证号码判断性别
				String sex;
				if(Integer.parseInt(idnumber.substring(16,17))%2==0)
					sex="女";
				else
					sex="男";
				user.setAge(age);
				user.setSex(sex);
			}
			user.setIdnumber(idnumber);
			if(json.getString("name")!=null&&!"".equals(json.getString("name"))) {
				user.setName(json.getString("name"));
			}
			if(json.getString("password")!=null&&!"".equals(json.getString("password"))) {
				user.setPassword(MD5.getMD5(json.getString("password")));
			}
			if(json.getString("email")!=null&&!"".equals(json.getString("email"))) {
				UserExample example = new UserExample();
				UserExample.Criteria criteria = example.createCriteria();
				criteria.andEmailEqualTo(json.getString("email"));
				List<User> list = user_mapper.selectByExample(example);
				if(list!=null&&list.size()>0) {
					obj.put("msg", IMyEnums.EMAIL_ALREADY_EXISTS);
					return obj.toString();
				}
				user.setEmail(json.getString("email"));
			}
			user.setUserstate(IMyEnums.NORMAL);
			user.setDelstate(IMyEnums.NORMAL);
			user.setCreatetime(new Date());
			int i = user_mapper.insertSelective(user);
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
	public String insertaddress(String message) {
		JSONObject obj = new JSONObject();
		JSONObject json = new JSONObject();
		if(message!=null&&!"".equals(message)) {
			json = JSONObject.fromObject(message);
			Address address = new Address();
			AddressExample example = new AddressExample();
			AddressExample.Criteria criteria = example.createCriteria();
			if(json.getString("userid")!=null&&!"".equals(json.getString("userid"))) {
				address.setUserid(Integer.parseInt(json.getString("userid")));
				criteria.andUseridEqualTo(Integer.parseInt(json.getString("userid")));
			}
			if(json.getString("name")!=null&&!"".equals(json.getString("name"))) {
				address.setName(json.getString("name"));
			}
			if(json.getString("tel")!=null&&!"".equals(json.getString("tel"))) {
				address.setTel(json.getString("tel"));
			}
			if(json.getString("privince")!=null&&!"".equals(json.getString("privince"))) {
				address.setPrivince(json.getString("privince"));
			}
			if(json.getString("city")!=null&&!"".equals(json.getString("city"))) {
				address.setCity(json.getString("city"));
			}
			if(json.getString("district")!=null&&!"".equals(json.getString("district"))) {
				address.setDistrict(json.getString("district"));
			}
			if(json.getString("adsDetails")!=null&&!"".equals(json.getString("adsDetails"))) {
				address.setAdsdetails(json.getString("adsDetails"));
			}
			if(json.getString("adsLabel")!=null&&!"".equals(json.getString("adsLabel"))) {
				address.setAdslabel(json.getString("adsLabel"));
			}
			criteria.andAdsdefaultEqualTo(IMyEnums.ADDRESS_DEFAULT+"");
			List<Address> list = address_mapper.selectByExample(example);
			if(list!=null&&list.size()>0) {
				address.setAdsdefault(IMyEnums.ADDRESS_DEFAULT+"");
			}
			else {
				address.setAdsdefault(IMyEnums.ADDRESS_NOT_DEFAULT+"");
			}
			
			address.setCreatetime(new Date());
			address.setDelstate(IMyEnums.NORMAL);
			int i = address_mapper.insertSelective(address);
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
	public String updateaddress(String message) {
		JSONObject obj = new JSONObject();
		JSONObject json = new JSONObject();
		if(message!=null&&!"".equals(message)) {
			json = JSONObject.fromObject(message);
			Address address = new Address();
			if(json.getString("name")!=null&&!"".equals(json.getString("name"))) {
				address.setName(json.getString("name"));
			}
			if(json.getString("tel")!=null&&!"".equals(json.getString("tel"))) {
				address.setTel(json.getString("tel"));
			}
			if(json.getString("privince")!=null&&!"".equals(json.getString("privince"))) {
				address.setPrivince(json.getString("privince"));
			}
			if(json.getString("city")!=null&&!"".equals(json.getString("city"))) {
				address.setCity(json.getString("city"));
			}
			if(json.getString("district")!=null&&!"".equals(json.getString("district"))) {
				address.setDistrict(json.getString("district"));
			}
			if(json.getString("adsDetails")!=null&&!"".equals(json.getString("adsDetails"))) {
				address.setAdsdetails(json.getString("adsDetails"));
			}
			if(json.getString("adsLabel")!=null&&!"".equals(json.getString("adsLabel"))) {
				address.setAdslabel(json.getString("adsLabel"));
			}
			if(json.getString("adsdefault")!=null&&!"".equals(json.getString("adsdefault"))) {
				address.setAdsdefault(json.getString("adsdefault"));
			}
			address.setUpdatetime(new Date());
			AddressExample example = new AddressExample();
			AddressExample.Criteria criteria = example.createCriteria();
			criteria.andUseridEqualTo(Integer.parseInt(json.getString("userId")));
			criteria.andAdsidEqualTo(Integer.parseInt(json.getString("addressid")));
			int i = address_mapper.updateByExampleSelective(address, example);
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
	public String setaddressstatus(String message) {
		JSONObject obj = new JSONObject();
		JSONObject json = new JSONObject();
		if(message!=null&&!"".equals(message)) {
			json = JSONObject.fromObject(message);
			Address address = new Address();
			AddressExample example = new AddressExample();
			AddressExample.Criteria criteria = example.createCriteria();
			if(json.getString("delstate")!=null&&!"".equals(json.getString("delstate"))) {
				address.setDelstate(json.getString("delstate"));
			}
			else {
				obj.put("msg", IMyEnums.FAIL);
				return obj.toString();
			}
			if(json.getString("userid")!=null&&!"".equals(json.getString("userid"))) {
				criteria.andUseridEqualTo(Integer.parseInt(json.getString("userid")));
			}
			else {
				obj.put("msg", IMyEnums.FAIL);
				return obj.toString();
			}
			if(json.getString("addressid")!=null&&!"".equals(json.getString("addressid"))) {
				criteria.andAdsidEqualTo(Integer.parseInt(json.getString("addressid")));
			}
			else {
				obj.put("msg", IMyEnums.FAIL);
				return obj.toString();
			}
			int i = address_mapper.updateByExampleSelective(address, example);
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
	public String setaddressdefaultstatus(String message) {
		JSONObject obj = new JSONObject();
		JSONObject json = new JSONObject();
		if(message!=null&&!"".equals(message)) {
			json = JSONObject.fromObject(message);
			if(json.getString("userid")!=null&&!"".equals(json.getString("userid"))) {
				AddressExample example = new AddressExample();
				AddressExample.Criteria criteria = example.createCriteria();
				criteria.andUseridEqualTo(Integer.parseInt(json.getString("userid")));
				List<Address> list = address_mapper.selectByExample(example);
				int i = 0;
				if(list!=null&&list.size()>0) {
					for(Address ad:list) {
						if(json.getString("adsid").equals(ad.getAdsid()+"")) {
							ad.setAdsdefault(IMyEnums.ADDRESS_DEFAULT+"");
						}
						else {
							ad.setAdsdefault(IMyEnums.ADDRESS_NOT_DEFAULT+"");
						}
						ad.setUpdatetime(new Date());
						i += address_mapper.updateByPrimaryKeySelective(ad);
					}
				}
				else {
					obj.put("msg", IMyEnums.FAIL);
				}
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
		}
		else {
			obj.put("msg", IMyEnums.FAIL);
		}
		return obj.toString();
	}

	@Override
	public String queryuseralladdress(String message) {
		JSONObject obj = new JSONObject();
		JSONObject json = new JSONObject();
		if(message!=null&&!"".equals(message)) {
			json = JSONObject.fromObject(message);
			if(json.getString("userid")!=null&&!"".equals(json.getString("userid"))) {
				AddressExample example = new AddressExample();
				AddressExample.Criteria criteria = example.createCriteria();
				criteria.andUseridEqualTo(Integer.parseInt(json.getString("userid")));
				criteria.andAdsdefaultNotEqualTo(IMyEnums.ADDRESS_DEL+"");
				List<Address> list = address_mapper.selectByExample(example); 
				if(list!=null&&list.size()>0){
					for(Address a:list) {
						String details = a.getAdsdetails();
						a.setAdsdetails(address_service.getProCityDis(a.getDistrict())+" "+details);
					}
					obj.put("useralladdress", list);
					obj.put("msg", IMyEnums.SUCCEED);
				}
				else {
					obj.put("msg", IMyEnums.FAIL);
				}
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
	public String insertcollect(String message) {
		JSONObject obj = new JSONObject();
		JSONObject json = new JSONObject();
		if(message!=null&&!"".equals(message)) {
			json = JSONObject.fromObject(message);
			Collect collect = new Collect();
			CollectExample example = new CollectExample();
			CollectExample.Criteria criteria = example.createCriteria();
			if(json.getString("bicycleid")!=null&&!"".equals(json.getString("bicycleid"))) {
				collect.setBicycleid(Integer.parseInt(json.getString("bicycleid")));
				criteria.andBicycleidEqualTo(Integer.parseInt(json.getString("bicycleid")));
			}
			else {
				obj.put("msg", IMyEnums.FAIL);
				return obj.toString();
			}
			if(json.getString("userid")!=null&&!"".equals(json.getString("userid"))) {
				collect.setUserid(Integer.parseInt(json.getString("userid")));
				criteria.andUseridEqualTo(Integer.parseInt(json.getString("userid")));
			}
			else {
				obj.put("msg", IMyEnums.FAIL);
				return obj.toString();
			}
			int i = 0;
			List<Collect> list = collect_mapper.selectByExample(example);
			if(list!=null&&list.size()>0) {
				obj.put("msg", IMyEnums.SUCCEED);
			}
			else {
				i = collect_mapper.insertSelective(collect);
				if(i>0) {
					obj.put("msg", IMyEnums.SUCCEED);
				}
				else {
					obj.put("msg", IMyEnums.FAIL);
				}
			}
		}
		else {
			obj.put("msg", IMyEnums.FAIL);
		}
		return obj.toString();
	}

	@Override
	public String queryuserallcollect(String message) {
		JSONObject obj = new JSONObject();
		JSONObject json = new JSONObject();
		if(message!=null&&!"".equals(message)) {
			json = JSONObject.fromObject(message);
			if(json.getString("userid")!=null&&!"".equals(json.getString("userid"))) {
				CollectExample example = new CollectExample();
				CollectExample.Criteria criteria = example.createCriteria();
				criteria.andUseridEqualTo(Integer.parseInt(json.getString("userid")));
				if(json.getString("pageIndex")!=null&&!"".equals(json.getString("pageIndex"))) {
					example.setPageIndex(Integer.parseInt(json.getString("pageIndex"))-1);
				}
				else {
					example.setPageIndex(0);
				}
		        example.setPageSize(10);
				List<Collect> list = collect_mapper.selectByExample(example);
				if(list!=null&&list.size()>0) {
					for(Collect c:list) {
						Bicycle bicycle = bicycle_mapper.selectByPrimaryKey(c.getBicycleid());
						PhotoExample example1 = new PhotoExample();
						PhotoExample.Criteria criteria1 = example1.createCriteria();
						criteria1.andBicycleidEqualTo(c.getBicycleid());
						List<Photo> list1 = photo_mapper.selectByExample(example1);
						bicycle.setPhoto(list1);
						if(list1!=null&&list1.size()>0) {
							bicycle.setFirstphoto("http://127.0.0.1:9090/bicycle_pic/"+list1.get(0).getPath());
							bicycle.setSecondphoto("http://127.0.0.1:9090/bicycle_pic/"+list1.get(1).getPath());
						}
						c.setBicycle(bicycle);
					}
					obj.put("userallcollect", list);
					obj.put("msg", IMyEnums.SUCCEED);
				}
				else {
					obj.put("msg", IMyEnums.FAIL);
				}
			}
			else {
				obj.put("msg", IMyEnums.FAIL);
				return obj.toString();
			}
			
		}
		else {
			obj.put("msg", IMyEnums.FAIL);
		}
		return obj.toString();
	}

	@Override
	public String deletecollect(String message) {
		JSONObject obj = new JSONObject();
		JSONObject json = new JSONObject();
		if(message!=null&&!"".equals(message)) {
			json = JSONObject.fromObject(message);
			CollectExample example = new CollectExample();
			CollectExample.Criteria criteria = example.createCriteria();
			if(json.getString("bicycleid")!=null&&!"".equals(json.getString("bicycleid"))) {
				criteria.andBicycleidEqualTo(Integer.parseInt(json.getString("bicycleid")));
			}
			else {
				obj.put("msg", IMyEnums.FAIL);
				return obj.toString();
			}
			if(json.getString("userid")!=null&&!"".equals(json.getString("userid"))) {
				criteria.andUseridEqualTo(Integer.parseInt(json.getString("userid")));
			}
			else {
				obj.put("msg", IMyEnums.FAIL);
				return obj.toString();
			}
			int i = collect_mapper.deleteByExample(example);
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
	public String deletelistcollect(String message) {
		JSONObject obj = new JSONObject();
		JSONObject json = new JSONObject();
		if(message!=null&&!"".equals(message)) {
			json = JSONObject.fromObject(message);
			CollectExample example = new CollectExample();
			CollectExample.Criteria criteria = example.createCriteria();
			
			if(json.getString("userId")!=null&&!"".equals(json.getString("userId"))) {
				criteria.andUseridEqualTo(Integer.parseInt(json.getString("userId")));
			}
			else {
				obj.put("msg", IMyEnums.FAIL);
				return obj.toString();
			}
			String[] bicycleIds = null; 
			if(json.getString("bicycleIds")!=null&&!"".equals(json.getString("bicycleIds"))) {
				bicycleIds = json.getString("bicycleIds").split(";");
			}
			else {
				obj.put("msg", IMyEnums.FAIL);
				return obj.toString();
			}
			if(bicycleIds!=null&&bicycleIds.length>0) {
				int i = 0;
				for(String id:bicycleIds) {
					criteria.andBicycleidEqualTo(Integer.parseInt(id));
					i +=collect_mapper.deleteByExample(example);
				}
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
		}
		else {
			obj.put("msg", IMyEnums.FAIL);
		}
		return obj.toString();
	}

	@Override
	public String insertfeedback(String message) {
		JSONObject obj = new JSONObject();
		JSONObject json = new JSONObject();
		if(message!=null&&!"".equals(message)) {
			json = JSONObject.fromObject(message);
			FeedBack feedback = new FeedBack();
			if(json.getString("name")!=null&&!"".equals(json.getString("name"))) {
				feedback.setName(json.getString("name"));
			}
			if(json.getString("tel")!=null&&!"".equals(json.getString("tel"))) {
				feedback.setTel(json.getString("tel"));
			}
			if(json.getString("email")!=null&&!"".equals(json.getString("email"))) {
				feedback.setEmail(json.getString("email"));
			}
			if(json.getString("issue")!=null&&!"".equals(json.getString("issue"))) {
				feedback.setIssue(json.getString("issue"));
			}
			if(json.getString("voiceMessage")!=null&&!"".equals(json.getString("voiceMessage"))) {
				feedback.setVoicemessage(json.getString("voiceMessage"));
			}
			int i =feed_back_mapper.insertSelective(feedback);
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

	@SuppressWarnings("unused")
	@Override
	public String queryuserallfeedback(String message) {
		JSONObject obj = new JSONObject();
		JSONObject json = new JSONObject();
		if(message!=null&&!"".equals(message)) {
			json = JSONObject.fromObject(message);
			FeedBackExample example = new FeedBackExample();
			example.setOrderByClause("createTime ASC");
			example.setPageIndex(Integer.parseInt(json.getString("pageIndex"))-1);
	        example.setPageSize(2);
			List<FeedBack> list = feed_back_mapper.selectByExample(example);
			if(list!=null&&list.size()>0) {
				obj.put("allfeedback", JSONObject.fromObject(list));
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
	public String deletefeedback(String message) {
		JSONObject obj = new JSONObject();
		JSONObject json = new JSONObject();
		if(message!=null&&!"".equals(message)) {
			json = JSONObject.fromObject(message);
			if(json.getString("feedbackid")!=null&&!"".equals(json.getString("feedbackid"))) {
				int i = feed_back_mapper.deleteByPrimaryKey(Integer.parseInt(json.getString("feedbackid")));
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
		}
		else {
			obj.put("msg", IMyEnums.FAIL);
		}
		return obj.toString();
	}

	@Override
	public String deletelistfeedback(String message) {
		JSONObject obj = new JSONObject();
		JSONObject json = new JSONObject();
		if(message!=null&&!"".equals(message)) {
			json = JSONObject.fromObject(message);
			if(json.getString("feedbackids")!=null&&!"".equals(json.getString("feedbackids"))) {
				String[] ids = json.getString("feedbackids").split(";");
				int i = 0;
				if(ids!=null&&ids.length>0) {
					for(String id:ids) {
						i += feed_back_mapper.deleteByPrimaryKey(Integer.parseInt(id));
					}
				}
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
		}
		else {
			obj.put("msg", IMyEnums.FAIL);
		}
		return obj.toString();
	}

	@Override
	public String updateuser(String message) {
		JSONObject obj = new JSONObject();
		JSONObject json = new JSONObject();
		if(message!=null&&!"".equals(message)) {
			json = JSONObject.fromObject(message);
			User user = new User();
			UserExample example = new UserExample();
			UserExample.Criteria criteria = example.createCriteria();
			if(json.getString("idnumber")!=null&&!"".equals(json.getString("idnumber"))) {
				String idnumber = json.getString("idnumber");
				if(idnumber!=null&&!"".equals(idnumber)) {
					int day=Integer.parseInt(idnumber.substring(10,14));
					int age=Time.Getyear()-Integer.parseInt(idnumber.substring(6,10));
					if(Integer.parseInt(Time.Getmonth()+Time.Getday())<day)
						 age=age-1;		
					//通过身份证号码判断性别
					String sex;
					if(Integer.parseInt(idnumber.substring(16,17))%2==0)
						sex="女";
					else
						sex="男";
					user.setAge(age);
					user.setSex(sex);
				}
				user.setIdnumber(idnumber);
			}
			if(json.getString("name")!=null&&!"".equals(json.getString("name"))) {
				user.setName(json.getString("name"));
			}
			if(json.getString("password")!=null&&!"".equals(json.getString("password"))) {
				user.setPassword(MD5.getMD5(json.getString("password")));
			}
			if(json.getString("email")!=null&&!"".equals(json.getString("email"))) {
				criteria.andEmailEqualTo(json.getString("email"));
				List<User> list = user_mapper.selectByExample(example);
				if(list!=null&&list.size()>0) {
					obj.put("msg", IMyEnums.EMAIL_ALREADY_EXISTS);
					return obj.toString();
				}
				user.setEmail(json.getString("email"));
			}
			if(json.getString("userstate")!=null&&!"".equals(json.getString("userstate"))) {
				user.setUserstate(IMyEnums.NORMAL);
			}
			if(json.getString("userid")!=null&&!"".equals(json.getString("userid"))) {
				example = new UserExample();
				criteria = example.createCriteria();
				criteria.andUseridEqualTo(Integer.parseInt(json.getString("userid")));
			}
			else {
				obj.put("msg", IMyEnums.FAIL);
				return obj.toString();
			}
			user.setUpdatetime(new Timestamp(new Date().getTime()).toString());
			int i = user_mapper.updateByExampleSelective(user, example);
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
	public String updateuserpassword(String message) {
		JSONObject obj = new JSONObject();
		JSONObject json = new JSONObject();
		if(message!=null&&!"".equals(message)) {
			json = JSONObject.fromObject(message);
			json = JSONObject.fromObject(message);
			User user = new User();
			UserExample example = new UserExample();
			UserExample.Criteria criteria = example.createCriteria();
			if(json.getString("password")!=null&&!"".equals(json.getString("password"))) {
				user.setPassword(MD5.getMD5(json.getString("password")));
			}
			if(json.getString("userid")!=null&&!"".equals(json.getString("userid"))) {
				example = new UserExample();
				criteria = example.createCriteria();
				criteria.andUseridEqualTo(Integer.parseInt(json.getString("userid")));
			}
			else {
				obj.put("msg", IMyEnums.FAIL);
				return obj.toString();
			}
			user.setUpdatetime(new Timestamp(new Date().getTime()).toString());
			int i = user_mapper.updateByExampleSelective(user, example);
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
	public String queryuserById(String message) {
		JSONObject obj = new JSONObject();
		JSONObject json = new JSONObject();
		if(message!=null&&!"".equals(message)) {
			json = JSONObject.fromObject(message);
			if(json.getString("userid")!=null&&!"".equals(json.getString("userid"))) {
				User user = user_mapper.selectByPrimaryKey(Integer.parseInt(json.getString("userid")));
				obj.put("user", user);
				obj.put("msg", IMyEnums.SUCCEED);
			}
			else {
				obj.put("msg", IMyEnums.FAIL);
				return obj.toString();
			}
			
		}
		else {
			obj.put("msg", IMyEnums.FAIL);
		}
		return obj.toString();
	}

	@Override
	public String queryalluser(String message) {
		JSONObject obj = new JSONObject();
		JSONObject json = new JSONObject();
		if(message!=null&&!"".equals(message)) {
			json = JSONObject.fromObject(message);
			UserExample example = new UserExample();
			UserExample.Criteria criteria = example.createCriteria();
			example.setOrderByClause("createTime ASC");
			if(json.getString("pageIndex")!=null&&!"".equals(json.getString("pageIndex"))) {
				example.setPageIndex(Integer.parseInt(json.getString("pageIndex"))-1);
			}
			else {
				example.setPageIndex(0);
			}
	        example.setPageSize(10);
	        if(json.getString("username")!=null&&!"".equals(json.getString("username"))) {
	        	criteria.andNameLike("%"+json.getString("username")+"%");
	        }
	        if(json.getString("sex")!=null&&!"".equals(json.getString("sex"))) {
	        	criteria.andSexLike("%"+json.getString("sex")+"%");
	        }
	        if(json.getString("age")!=null&&!"".equals(json.getString("age"))) {
	        	criteria.andAgeEqualTo(Integer.parseInt(json.getString("age")));
	        }
	        List<User> list = user_mapper.selectByExample(example);
	        if(list!=null&&list.size()>0) {
	        	obj.put("alluser", list);
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
	public String setuserstatus(String message) {
		JSONObject obj = new JSONObject();
		JSONObject json = new JSONObject();
		if(message!=null&&!"".equals(message)) {
			json = JSONObject.fromObject(message);
			User user = new User();
			UserExample example = new UserExample();
			UserExample.Criteria criteria = example.createCriteria();
			if(json.getString("userstate")!=null&&!"".equals(json.getString("userstate"))) {
				user.setUserstate(json.getString("userstate"));
			}
			if(json.getString("delstate")!=null&&!"".equals(json.getString("delstate"))) {
				user.setDelstate(json.getString("delstate"));
			}
			if(json.getString("userid")!=null&&!"".equals(json.getString("userid"))) {
				example = new UserExample();
				criteria = example.createCriteria();
				criteria.andUseridEqualTo(Integer.parseInt(json.getString("userid")));
			}
			else {
				obj.put("msg", IMyEnums.FAIL);
				return obj.toString();
			}
			user.setUpdatetime(new Timestamp(new Date().getTime()).toString());
			int i = user_mapper.updateByExampleSelective(user, example);
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
	public String setuserliststatus(String message) {
		JSONObject obj = new JSONObject();
		JSONObject json = new JSONObject();
		if(message!=null&&!"".equals(message)) {
			json = JSONObject.fromObject(message);
			json = JSONObject.fromObject(message);
			User user = new User();
			UserExample example = new UserExample();
			UserExample.Criteria criteria = example.createCriteria();
			if(json.getString("userstate")!=null&&!"".equals(json.getString("userstate"))) {
				user.setUserstate(json.getString("userstate"));
			}
			if(json.getString("delstate")!=null&&!"".equals(json.getString("delstate"))) {
				user.setDelstate(json.getString("delstate"));
			}
			int i = 0;
			if(json.getString("userids")!=null&&!"".equals(json.getString("userids"))) {
				String[] userids = json.getString("userids").split(";");
				if(userids!=null&&userids.length>0) {
					for(String id:userids) {
						example = new UserExample();
						criteria = example.createCriteria();
						criteria.andUseridEqualTo(Integer.parseInt(id));
						i += user_mapper.updateByExampleSelective(user, example);
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
	public String deleteuser(String message) {
		JSONObject obj = new JSONObject();
		JSONObject json = new JSONObject();
		if(message!=null&&!"".equals(message)) {
			json = JSONObject.fromObject(message);
			User user = new User();
			UserExample example = new UserExample();
			UserExample.Criteria criteria = example.createCriteria();
			if(json.getString("userid")!=null&&!"".equals(json.getString("userid"))) {
				example = new UserExample();
				criteria = example.createCriteria();
				criteria.andUseridEqualTo(Integer.parseInt(json.getString("userid")));
			}
			else {
				obj.put("msg", IMyEnums.FAIL);
				return obj.toString();
			}
			user.setUpdatetime(new Timestamp(new Date().getTime()).toString());
			int i = user_mapper.deleteByExample(example);
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
	public String deletelistuser(String message) {
		JSONObject obj = new JSONObject();
		JSONObject json = new JSONObject();
		if(message!=null&&!"".equals(message)) {
			json = JSONObject.fromObject(message);
			User user = new User();
			UserExample example = new UserExample();
			UserExample.Criteria criteria = example.createCriteria();
			if(json.getString("userids")!=null&&!"".equals(json.getString("userids"))) {
				String[] userids = json.getString("userids").split(";");
				int i = 0;
				for(String id:userids) {
					example = new UserExample();
					criteria = example.createCriteria();
					criteria.andUseridEqualTo(Integer.parseInt(id));
					user.setUpdatetime(new Timestamp(new Date().getTime()).toString());
					i += user_mapper.deleteByExample(example);
				}
				if(i>0) {
					obj.put("msg", IMyEnums.SUCCEED);
				}
				else {
					obj.put("msg", IMyEnums.FAIL);
				}
				
			}
			else {
				obj.put("msg", IMyEnums.FAIL);
				return obj.toString();
			}
			
		}
		else {
			obj.put("msg", IMyEnums.FAIL);
		}
		return obj.toString();
	}

	@Override
	public String queryuserByEmail(String message) {
		JSONObject obj = new JSONObject();
		JSONObject json = new JSONObject();
		if(message!=null&&!"".equals(message)) {
			json = JSONObject.fromObject(message);
			if(json.getString("email")!=null&&!"".equals(json.getString("email"))) {
				UserExample example = new UserExample();
				UserExample.Criteria criteria = example.createCriteria();
				criteria.andEmailEqualTo(json.getString("email"));
				List<User> list = user_mapper.selectByExample(example);
				if(list!=null&&list.size()>0) {
					obj.put("user", JSONObject.fromObject(list.get(0)));
					obj.put("msg", IMyEnums.SUCCEED);
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
		}
		return obj.toString();
	}

	@Override
	public String querycollectnum(String message) {
		JSONObject obj = new JSONObject();
		JSONObject json = new JSONObject();
		if(message!=null&&!"".equals(message)) {
			json = JSONObject.fromObject(message);
			CollectExample example = new CollectExample();
			CollectExample.Criteria criteria = example.createCriteria();
			if(json.getString("userid")!=null&&!"".equals(json.getString("userid"))) {
				criteria.andUseridEqualTo(Integer.parseInt(json.getString("userid")));
			}
			else {
				obj.put("msg", IMyEnums.FAIL);
				return obj.toString();
			}
			long i = collect_mapper.countByExample(example);
			obj.put("collectnum", i);
			obj.put("msg", IMyEnums.SUCCEED);
		}
		else {
			obj.put("msg", IMyEnums.FAIL);
		}
		return obj.toString();
	}
}
