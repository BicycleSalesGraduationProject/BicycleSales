package com.hlbrc.bicyclesales.service.Impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hlbrc.bicyclesales.entity.Address;
import com.hlbrc.bicyclesales.entity.AddressExample;
import com.hlbrc.bicyclesales.entity.Bicycle;
import com.hlbrc.bicyclesales.entity.BicycleExample;
import com.hlbrc.bicyclesales.entity.BicyclePartCrr;
import com.hlbrc.bicyclesales.entity.BicyclePartCrrExample;
import com.hlbrc.bicyclesales.entity.BicycleType;
import com.hlbrc.bicyclesales.entity.BicycleTypeExample;
import com.hlbrc.bicyclesales.entity.Colour;
import com.hlbrc.bicyclesales.entity.ColourExample;
import com.hlbrc.bicyclesales.entity.OrderForm;
import com.hlbrc.bicyclesales.entity.OrderFormDetail;
import com.hlbrc.bicyclesales.entity.OrderFormDetailExample;
import com.hlbrc.bicyclesales.entity.OrderFormExample;
import com.hlbrc.bicyclesales.entity.PartMessage;
import com.hlbrc.bicyclesales.entity.PartMessageExample;
import com.hlbrc.bicyclesales.entity.PartType;
import com.hlbrc.bicyclesales.entity.PartTypeExample;
import com.hlbrc.bicyclesales.entity.Photo;
import com.hlbrc.bicyclesales.entity.PhotoExample;
import com.hlbrc.bicyclesales.entity.Shopcar;
import com.hlbrc.bicyclesales.entity.ShopcarExample;
import com.hlbrc.bicyclesales.entity.User;
import com.hlbrc.bicyclesales.enums.IMyEnums;
import com.hlbrc.bicyclesales.mapper.IAddressMapper;
import com.hlbrc.bicyclesales.mapper.IBicycleMapper;
import com.hlbrc.bicyclesales.mapper.IBicyclePartCrrMapper;
import com.hlbrc.bicyclesales.mapper.IBicycleTypeMapper;
import com.hlbrc.bicyclesales.mapper.IColourMapper;
import com.hlbrc.bicyclesales.mapper.IOrderFormDetailMapper;
import com.hlbrc.bicyclesales.mapper.IOrderFormMapper;
import com.hlbrc.bicyclesales.mapper.IPartMessageMapper;
import com.hlbrc.bicyclesales.mapper.IPartTypeMapper;
import com.hlbrc.bicyclesales.mapper.IPhotoMapper;
import com.hlbrc.bicyclesales.mapper.IShopcarMapper;
import com.hlbrc.bicyclesales.mapper.IUserMapper;
import com.hlbrc.bicyclesales.service.IAddressService;
import com.hlbrc.bicyclesales.service.IMainService;
import com.hlbrc.bicyclesales.util.Token;

import net.sf.json.JSONObject;

@Service("MainServiceImpl")
public class MainServiceImpl implements IMainService {
	@Autowired
	IShopcarMapper shopcar_mapper;
	@Autowired
	IOrderFormMapper order_form_mapper;
	@Autowired
	IOrderFormDetailMapper order_form_detail_mapper;
	@Autowired
	IBicycleMapper bicycle_mapper;
	@Autowired
	IBicycleTypeMapper bicycle_type_mapper;
	@Autowired
	IBicyclePartCrrMapper bicycle_part_crr_mapper;
	@Autowired
	IPartMessageMapper part_message_mapper;
	@Autowired
	IPartTypeMapper part_type_mapper;
	@Autowired
	IColourMapper colour_mapper;
	@Autowired
	IPhotoMapper photo_mapper;
	@Autowired
	IAddressMapper address_mapper;
	@Autowired
	IUserMapper user_mapper;
	@Autowired
	IAddressService address_service;
	
	@Override
	public String insertshopcar(String message) {
		JSONObject obj = new JSONObject();
		JSONObject json = new JSONObject();
		if(message!=null&&!"".equals(message)) {
			json = JSONObject.fromObject(message);
			obj.put("msg", IMyEnums.SUCCEED);
			Shopcar shopcar = new Shopcar();
			ShopcarExample example = new ShopcarExample();
			ShopcarExample.Criteria criteria = example.createCriteria();
			if(json.getString("userid")!=null&&!"".equals(json.getString("userid"))) {
				shopcar.setUserid(Integer.parseInt(json.getString("userid")));
				criteria.andUseridEqualTo(Integer.parseInt(json.getString("userid")));
			}
			else {
				obj.put("msg", IMyEnums.FAIL);
				return obj.toString();
			}
			if(json.getString("bicycleid")!=null&&!"".equals(json.getString("bicycleid"))) {
				shopcar.setBicycleid(Integer.parseInt(json.getString("bicycleid")));
				criteria.andBicycleidEqualTo(Integer.parseInt(json.getString("bicycleid")));
			}
			else {
				obj.put("msg", IMyEnums.FAIL);
				return obj.toString();
			}
			if(json.getString("num")!=null&&!"".equals(json.getString("num"))) {
				shopcar.setNum(Integer.parseInt(json.getString("num")));
			}
			else {
				shopcar.setNum(1);
			}
			if(json.getString("total")!=null&&!"".equals(json.getString("total"))) {
				shopcar.setTotal(Double.parseDouble(json.getString("total")));
			}
			else {
				obj.put("msg", IMyEnums.FAIL);
				return obj.toString();
			}
			int i = 0;
			List<Shopcar> list = shopcar_mapper.selectByExample(example);
			if(list!=null&&list.size()>0) {
				shopcar.setNum(list.get(0).getNum()+Integer.parseInt(json.getString("num")));
				shopcar.setTotal(list.get(0).getTotal()+Double.parseDouble(json.getString("total")));
				i = shopcar_mapper.updateByExampleSelective(shopcar, example);
			}
			else {
				shopcar.setCreatetime(new Date());
				i = shopcar_mapper.insertSelective(shopcar);
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
	public String deleteshopcar(String message) {
		JSONObject obj = new JSONObject();
		JSONObject json = new JSONObject();
		if(message!=null&&!"".equals(message)) {
			json = JSONObject.fromObject(message);
			ShopcarExample example = new ShopcarExample();
			ShopcarExample.Criteria criteria = example.createCriteria();
			if(json.getString("userid")!=null&&!"".equals(json.getString("userid"))) {
				criteria.andUseridEqualTo(Integer.parseInt(json.getString("userid")));
			}
			else {
				obj.put("msg", IMyEnums.FAIL);
			}
			if(json.getString("bicycleids")!=null&&!"".equals(json.getString("bicycleids"))) {
				String[] bicycleids = json.getString("bicycleids").split(";");
				if(bicycleids!=null&&bicycleids.length>0) {
					for(String id:bicycleids) {
						criteria.andBicycleidEqualTo(Integer.parseInt(id));
						shopcar_mapper.deleteByExample(example);
					}
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
	public String updateshopcarnum(String message) {
		JSONObject obj = new JSONObject();
		JSONObject json = new JSONObject();
		if(message!=null&&!"".equals(message)) {
			json = JSONObject.fromObject(message);
			obj.put("msg", IMyEnums.SUCCEED);
			Shopcar shopcar = new Shopcar();
			ShopcarExample example = new ShopcarExample();
			ShopcarExample.Criteria criteria = example.createCriteria();
			if(json.getString("userid")!=null&&!"".equals(json.getString("userid"))) {
				criteria.andUseridEqualTo(Integer.parseInt(json.getString("userid")));
			}
			else {
				obj.put("msg", IMyEnums.FAIL);
				return obj.toString();
			}
			if(json.getString("bicycleid")!=null&&!"".equals(json.getString("bicycleid"))) {
				criteria.andBicycleidEqualTo(Integer.parseInt(json.getString("bicycleid")));
			}
			else {
				obj.put("msg", IMyEnums.FAIL);
				return obj.toString();
			}
			if(json.getString("num")!=null&&!"".equals(json.getString("num"))) {
				shopcar.setNum(Integer.parseInt(json.getString("num")));
			}
			else {
				obj.put("msg", IMyEnums.FAIL);
				return obj.toString();
			}
			if(json.getString("total")!=null&&!"".equals(json.getString("total"))) {
				shopcar.setTotal(Double.parseDouble(json.getString("total")));
			}
			else {
				obj.put("msg", IMyEnums.FAIL);
				return obj.toString();
			}
			int i = shopcar_mapper.updateByExampleSelective(shopcar, example);
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
	public String queryshopcar(String message) {
		JSONObject obj = new JSONObject();
		JSONObject json = new JSONObject();
		if(message!=null&&!"".equals(message)) {
			json = JSONObject.fromObject(message);
			ShopcarExample example = new ShopcarExample();
			ShopcarExample.Criteria criteria = example.createCriteria();
			example.setOrderByClause("createTime ASC");
			if(json.getString("pageIndex")!=null&&!"".equals(json.getString("pageIndex"))) {
				example.setPageIndex(Integer.parseInt(json.getString("pageIndex"))-1);
			
			}
			else {
				example.setPageIndex(0);
			}
	        example.setPageSize(10);
			if(json.getString("userid")!=null&&!"".equals(json.getString("userid"))) {
				criteria.andUseridEqualTo(Integer.parseInt(json.getString("userid")));
			}
			else {
				obj.put("msg", IMyEnums.FAIL);
				return obj.toString();
			}
			List<Shopcar> list = shopcar_mapper.selectByExample(example);
			if(list!=null&&list.size()>0) {
				for(Shopcar s:list) {
					Bicycle bicycle = bicycle_mapper.selectByPrimaryKey(s.getBicycleid());
					PhotoExample example1 = new PhotoExample();
					PhotoExample.Criteria criteria1 = example1.createCriteria();
					criteria1.andBicycleidEqualTo(s.getBicycleid());
					List<Photo> list1 = photo_mapper.selectByExample(example1);
					bicycle.setPhoto(list1);
					if(list1!=null&&list1.size()>0) {
						bicycle.setFirstphoto("http://127.0.0.1:9090/bicycle_pic/"+list1.get(0).getPath());
						if(list1!=null&&list1.size()>1) {
							bicycle.setSecondphoto("http://127.0.0.1:9090/bicycle_pic/"+list1.get(1).getPath());
						}
					}
					s.setBicycle(bicycle);
				}
				obj.put("shopcarlist", list);
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
	public String insertorder(String message,HttpServletRequest request) {
		JSONObject obj = new JSONObject();
		JSONObject json = new JSONObject();
//		if ("true".equals(Token.validToken(request))) {//校验令牌，防止重复提交
			if(message!=null&&!"".equals(message)) {
				json = JSONObject.fromObject(message);
				OrderForm orderform = new OrderForm();
				if(json.getString("userid")!=null&&!"".equals(json.getString("userid"))) {
					AddressExample example = new AddressExample();
					AddressExample.Criteria criteria = example.createCriteria();
					criteria.andUseridEqualTo(Integer.parseInt(json.getString("userid")));
					List<Address> list = address_mapper.selectByExample(example);
					if(list!=null&&list.size()>0) {
						for(Address a:list) {
							if(a.getAdsdefault().equals(IMyEnums.ADDRESS_DEFAULT+"")) {
								orderform.setAdsid(a.getAdsid());
							}
						}
					}
					else {
						obj.put("msg", IMyEnums.ADDRESS_NOT_LIST);
						return obj.toString();
					}
					
				}
				else {
					obj.put("msg", IMyEnums.FAIL);
					return obj.toString();
				}
				if(json.getString("totalnum")!=null&&!"".equals(json.getString("totalnum"))) {
					orderform.setTotalnum(Integer.parseInt(json.getString("totalnum")));
				}
				else {
					obj.put("msg", IMyEnums.FAIL);
					return obj.toString();
				}
				if(json.getString("totalmoney")!=null&&!"".equals(json.getString("totalmoney"))) {
					orderform.setTotalmoney(Double.parseDouble(json.getString("totalmoney")));
				}
				else {
					obj.put("msg", IMyEnums.FAIL);
					return obj.toString();
				}
				
				orderform.setOrderformstate(IMyEnums.ORDER_NOT_SHIPPED);
				orderform.setPaymoneystate(IMyEnums.ORDER_NON_PAYMENT);
				orderform.setCreatetime(new Date());
				int no = (int)((Math.random()*9+1)*100000);
				String orderno = new Date().getTime()+""+no;
				orderform.setOrderno(orderno);
				//添加订单
				int i = order_form_mapper.insertSelective(orderform);
				if(i>0) {
					OrderFormDetail orderformdetail = new OrderFormDetail();
					orderformdetail.setOrderno(orderno);
					if(json.getJSONArray("bicycles")!=null&&json.getJSONArray("bicycles").size()>0) {
						net.sf.json.JSONArray array = json.getJSONArray("bicycles");
						ShopcarExample example = new ShopcarExample();
						ShopcarExample.Criteria criteria = example.createCriteria();
						for(int j=0;j<array.size();j++) {
							orderformdetail.setBicycleid(Integer.parseInt(array.getJSONObject(j).getString("bicycleid")));
							orderformdetail.setNum(Double.parseDouble(array.getJSONObject(j).getString("num")));
							orderformdetail.setMoney(Double.parseDouble(array.getJSONObject(j).getString("total")));
							System.err.println("shopcarid:"+array.getJSONObject(j).getString("shopcarid"));
							i +=shopcar_mapper.deleteByPrimaryKey(Integer.parseInt(array.getJSONObject(j).getString("shopcarid")));
							String parts = array.getJSONObject(j).getJSONObject("bicycle").getString("partmessageids");
							String[] partmessageids = null;
							if(parts!=null&&!"".equals(parts)) {
								partmessageids = parts.split(";");
							}
							criteria.andBicycleidEqualTo(Integer.parseInt(array.getJSONObject(j).getString("bicycleid")));
							//添加订单详情
							i += order_form_detail_mapper.insertSelective(orderformdetail);
							//删除购物车
							i += shopcar_mapper.deleteByExample(example);
							BicyclePartCrr bicyclepartcrr = new BicyclePartCrr();
							if(partmessageids!=null&&partmessageids.length>0) {
								for(String id:partmessageids) 
								{
									//添加自行车零件信息对应表
									bicyclepartcrr.setBicycleid(Integer.parseInt(array.getJSONObject(j).getString("bicycleid")));
									bicyclepartcrr.setPartmessageid(Integer.parseInt(id));
									bicyclepartcrr.setOrderno(orderno);
									i += bicycle_part_crr_mapper.insertSelective(bicyclepartcrr);
								}
							}
						}
						if(i>0) {
							//设置令牌
							Token.setToken(request);
							obj.put("orderno", orderno);
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
			}
			else {
				obj.put("msg", IMyEnums.FAIL);
			}
//		}
		return obj.toString();
	}
	@Override
	public String queryorderdetail(String message) {
		JSONObject obj = new JSONObject();
		JSONObject json = new JSONObject();
		if(message!=null&&!"".equals(message)) {
			json = JSONObject.fromObject(message);
			OrderFormDetailExample example = new OrderFormDetailExample();
			OrderFormDetailExample.Criteria criteria = example.createCriteria();
			if(json.getString("orderno")!=null&&!"".equals(json.getString("orderno"))) {
				criteria.andOrdernoEqualTo(json.getString("orderno"));
			}
			else {
				obj.put("msg", IMyEnums.FAIL);
				return obj.toString();
			}
			List<OrderFormDetail> list = order_form_detail_mapper.selectByExample(example);
			BicyclePartCrrExample example2 = new BicyclePartCrrExample();
			BicyclePartCrrExample.Criteria criteria2 = example2.createCriteria();
			if(list!=null&&list.size()>0) {
				for(OrderFormDetail od:list) {
					Bicycle bicycle = bicycle_mapper.selectByPrimaryKey(od.getBicycleid());
					od.setBicycle(bicycle);
					criteria2.andBicycleidEqualTo(od.getBicycleid());
					criteria2.andOrdernoEqualTo(od.getOrderno());
					List<BicyclePartCrr> list2 = bicycle_part_crr_mapper.selectByExample(example2);
					List<PartMessage> list3 = new ArrayList<PartMessage>();
					if(list2!=null&&list2.size()>0) {
						for(BicyclePartCrr bc:list2) {
							list3.add(part_message_mapper.selectByPrimaryKey(bc.getPartmessageid()));
						}
					}
					od.setPartmessage(list3);
				}
				obj.put("allorderformdetail", list);
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
	public String updateorderstatus(String message) {
		JSONObject obj = new JSONObject();
		JSONObject json = new JSONObject();
		if(message!=null&&!"".equals(message)) {
			json = JSONObject.fromObject(message);
			OrderFormExample example = new OrderFormExample();
			OrderFormExample.Criteria criteria = example.createCriteria();
			OrderForm orderForm = new OrderForm();
			if(json.getString("orderno") != null&&!"".equals(json.getString("orderno"))) {
				System.err.println(json.getString("orderno"));
				criteria.andOrdernoEqualTo(json.getString("orderno"));
			}
			else {
				obj.put("msg", IMyEnums.FAIL);
				return obj.toString();
			}
			if(json.getString("orderformstate") != null&&!"".equals(json.getString("orderformstate"))) {
				orderForm.setOrderformstate(json.getString("orderformstate"));
			}
			if(json.getString("paymoneystate") != null&&!"".equals(json.getString("paymoneystate"))) {
				orderForm.setPaymoneystate(json.getString("paymoneystate"));
			}
			int i = order_form_mapper.updateByExampleSelective(orderForm, example);
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
	public String updateorderliststatus(String message) {
		JSONObject obj = new JSONObject();
		JSONObject json = new JSONObject();
		if(message!=null&&!"".equals(message)) {
			json = JSONObject.fromObject(message);
			OrderFormExample example = new OrderFormExample();
			OrderFormExample.Criteria criteria = example.createCriteria();
			OrderForm orderForm = new OrderForm();
			int i = 0;
			if(json.getString("orderformstate") != null&&!"".equals(json.getString("orderformstate"))) {
				orderForm.setOrderformstate(json.getString("orderformstate"));
			}
			if(json.getString("paymoneystate") != null&&!"".equals(json.getString("paymoneystate"))) {
				orderForm.setPaymoneystate(json.getString("paymoneystate"));
			}
			if(json.getString("ordernos") != null&&!"".equals(json.getString("ordernos"))) {
				String[] ordernos = json.getString("ordernos").split(";");
				if(ordernos!=null&&ordernos.length>0) {
					for(String s:ordernos) {
						criteria.andOrdernoEqualTo(s);
						i += order_form_mapper.updateByExampleSelective(orderForm, example);
						example = new OrderFormExample();
						criteria = example.createCriteria();
					}
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
	public String insertbicycle(String message) {
		JSONObject obj = new JSONObject();
		JSONObject json = new JSONObject();
		if(message!=null&&!"".equals(message)) {
			json = JSONObject.fromObject(message);
			Bicycle bicycle = new Bicycle();
			if(json.getString("bicycletypeid")!=null&&!"".equals(json.getString("bicycletypeid"))) {
				bicycle.setBicycletypeid(Integer.parseInt(json.getString("bicycletypeid")));
			}
			else {
				obj.put("msg", IMyEnums.FAIL);
				return obj.toString();
			}
			if(json.getString("name")!=null&&!"".equals(json.getString("name"))) {
				bicycle.setName(json.getString("name"));
			}
			else {
				obj.put("msg", IMyEnums.FAIL);
				return obj.toString();
			}
			if(json.getString("money")!=null&&!"".equals(json.getString("money"))) {
				bicycle.setMoney(Double.parseDouble(json.getString("money")));
			}
			else {
				obj.put("msg", IMyEnums.FAIL);
				return obj.toString();
			}
			if(json.getString("inventory")!=null&&!"".equals(json.getString("inventory"))) {
				bicycle.setInventory(Integer.parseInt(json.getString("inventory")));
			}
			else {
				obj.put("msg", IMyEnums.FAIL);
				return obj.toString();
			}
			if(json.getString("state")!=null&&!"".equals(json.getString("state"))) {
				bicycle.setDelstate(json.getString("state"));
			}
			else {
				bicycle.setDelstate(IMyEnums.NORMAL);
			}
			bicycle.setCreatetime(new Date());
			int i =bicycle_mapper.insertSelective(bicycle);
			if(i>0) {
				BicycleExample example = new BicycleExample();
				BicycleExample.Criteria criteria = example.createCriteria();
				criteria.andCreatetimeEqualTo(bicycle.getCreatetime());
				criteria.andNameEqualTo(bicycle.getName());
				obj.put("bid", bicycle_mapper.selectByExample(example).get(0).getBicycleid());
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
	public String updatebicycle(String message) {
		JSONObject obj = new JSONObject();
		JSONObject json = new JSONObject();
		if(message!=null&&!"".equals(message)) {
			json = JSONObject.fromObject(message);
			Bicycle bicycle = new Bicycle();
			BicycleExample example = new BicycleExample();
			BicycleExample.Criteria criteria = example.createCriteria();
			if(json.getString("bicycleid")!=null&&!"".equals(json.getString("bicycleid"))) {
				criteria.andBicycleidEqualTo(Integer.parseInt(json.getString("bicycleid")));
			}
			else {
				obj.put("msg", IMyEnums.FAIL);
				return obj.toString();
			}
			if(json.getString("bicycletypeid")!=null&&!"".equals(json.getString("bicycletypeid"))) {
				bicycle.setBicycletypeid(Integer.parseInt(json.getString("bicycletypeid")));
			}
			if(json.getString("name")!=null&&!"".equals(json.getString("name"))) {
				bicycle.setName(json.getString("name"));
			}
			if(json.getString("money")!=null&&!"".equals(json.getString("money"))) {
				bicycle.setMoney(Double.parseDouble(json.getString("money")));
			}
			if(json.getString("inventory")!=null&&!"".equals(json.getString("inventory"))) {
				bicycle.setInventory(Integer.parseInt(json.getString("inventory")));
			}
			bicycle.setUpdatetime(new Date());
			int i =bicycle_mapper.updateByExampleSelective(bicycle, example);
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
	public String updatebicyclephotostatus(String message) {
		JSONObject obj = new JSONObject();
		JSONObject json = new JSONObject();
		if(message!=null&&!"".equals(message)) {
			json = JSONObject.fromObject(message);
			Photo photo = new Photo();
			PhotoExample example = new PhotoExample();
			PhotoExample.Criteria criteria = example.createCriteria();
			if(json.getString("state")!=null&&!"".equals(json.getString("state"))) {
				photo.setState(json.getString("state"));
			}
			else {
				obj.put("msg", IMyEnums.FAIL);
				return obj.toString();
			}
			if(json.getString("photoid")!=null&&!"".equals(json.getString("photoid"))) {
				criteria.andPhotoidEqualTo(Integer.parseInt(json.getString("photoid")));
			}
			else {
				obj.put("msg", IMyEnums.FAIL);
				return obj.toString();
			}
			int i = photo_mapper.updateByExampleSelective(photo, example);
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
	public String insertbicyclephoto(String message) {
		JSONObject obj = new JSONObject();
		JSONObject json = new JSONObject();
		if(message!=null&&!"".equals(message)) {
			json = JSONObject.fromObject(message);
			Photo photo = new Photo();
			if(json.getString("bicycleid")!=null&&!"".equals(json.getString("bicycleid"))) {
				photo.setBicycleid(Integer.parseInt(json.getString("bicycleid")));
			}
			else {
				obj.put("msg", IMyEnums.FAIL);
				return obj.toString();
			}
			if(json.getString("name")!=null&&!"".equals(json.getString("name"))) {
				photo.setName(json.getString("name"));
			}
			if(json.getString("path")!=null&&!"".equals(json.getString("path"))) {
				photo.setPath(json.getString("path"));
			}
			else {
				obj.put("msg", IMyEnums.FAIL);
				return obj.toString();
			}
			photo.setState(IMyEnums.NORMAL);
			photo.setCreatetime(new Date());
			int i = photo_mapper.insertSelective(photo);
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
	public String updatebicyclestatus(String message) {
		JSONObject obj = new JSONObject();
		JSONObject json = new JSONObject();
		if(message!=null&&!"".equals(message)) {
			json = JSONObject.fromObject(message);
			Bicycle bicycle = new Bicycle();
			BicycleExample example = new BicycleExample();
			BicycleExample.Criteria criteria = example.createCriteria();
			if(json.getString("bicycleid")!=null&&!"".equals(json.getString("bicycleid"))) {
				criteria.andBicycleidEqualTo(Integer.parseInt(json.getString("bicycleid")));
			}
			else {
				obj.put("msg", IMyEnums.FAIL);
				return obj.toString();
			}
			if(json.getString("delstate")!=null&&!"".equals(json.getString("delstate"))) {
				bicycle.setDelstate(json.getString("delstate"));
			}
			else {
				obj.put("msg", IMyEnums.FAIL);
				return obj.toString();
			}
			bicycle.setUpdatetime(new Date());
			int i =bicycle_mapper.updateByExampleSelective(bicycle, example);
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
	public String updatebicycleliststatus(String message) {
		JSONObject obj = new JSONObject();
		JSONObject json = new JSONObject();
		if(message!=null&&!"".equals(message)) {
			json = JSONObject.fromObject(message);
			Bicycle bicycle = new Bicycle();
			BicycleExample example = new BicycleExample();
			BicycleExample.Criteria criteria = example.createCriteria();
			
			if(json.getString("delstate")!=null&&!"".equals(json.getString("delstate"))) {
				bicycle.setDelstate(json.getString("delstate"));
			}
			else {
				obj.put("msg", IMyEnums.FAIL);
				return obj.toString();
			}
			int i = 0;
			if(json.getString("bicycleids")!=null&&!"".equals(json.getString("bicycleids"))) {
				String[] bicycleids = json.getString("bicycleids").split(";");
				if(bicycleids!=null&&bicycleids.length>0) {
					for(String id:bicycleids) {
						example = new BicycleExample();
						criteria = example.createCriteria();
						criteria.andBicycleidEqualTo(Integer.parseInt(id));
						bicycle.setUpdatetime(new Date());
						i +=bicycle_mapper.updateByExampleSelective(bicycle, example);
					}
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
				return obj.toString();
			}
		}
		else {
			obj.put("msg", IMyEnums.FAIL);
		}
		return obj.toString();
	}
	@Override
	public String deletebicycle(String message) {
		JSONObject obj = new JSONObject();
		JSONObject json = new JSONObject();
		System.err.println("message:"+message);
		if(message!=null&&!"".equals(message)) {
			json = JSONObject.fromObject(message);
			if(json.getString("bicycleid")!=null&&!"".equals(json.getString("bicycleid"))) {
				int i = bicycle_mapper.deleteByPrimaryKey(Integer.parseInt(json.getString("bicycleid")));
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
	public String deletelistbicycle(String message) {
		JSONObject obj = new JSONObject();
		JSONObject json = new JSONObject();
		if(message!=null&&!"".equals(message)) {
			json = JSONObject.fromObject(message);
			if(json.getString("bicycleids")!=null&&!"".equals(json.getString("bicycleids"))) {
				String[] bicycleids = json.getString("bicycleids").split(";");
				int i = 0;
				if(bicycleids!=null&&bicycleids.length>0) {
					for(String id:bicycleids) {
						i += bicycle_mapper.deleteByPrimaryKey(Integer.parseInt(id));
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
	public String insertbicycletype(String message) {
		JSONObject obj = new JSONObject();
		JSONObject json = new JSONObject();
		if(message!=null&&!"".equals(message)) {
			json = JSONObject.fromObject(message);
			BicycleType bicycletype = new BicycleType();
			if(json.getString("name")!=null&&!"".equals(json.getString("name"))) {
				bicycletype.setName(json.getString("name"));
			}
			else {
				obj.put("msg", IMyEnums.FAIL);
				return obj.toString();
			}
			bicycletype.setState(IMyEnums.NORMAL);
			bicycletype.setDelstate(IMyEnums.NORMAL);
			bicycletype.setCreatetime(new Date());
			int i = bicycle_type_mapper.insertSelective(bicycletype);
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
	public String deletebicycletype(String message) {
		JSONObject obj = new JSONObject();
		JSONObject json = new JSONObject();
		if(message!=null&&!"".equals(message)) {
			json = JSONObject.fromObject(message);
			if(json.getString("bicycletypeid")!=null&&!"".equals(json.getString("bicycletypeid"))) {
				int i =bicycle_type_mapper.deleteByPrimaryKey(Integer.parseInt(json.getString("bicycletypeid")));
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
	public String deletelistbicycletype(String message) {
		JSONObject obj = new JSONObject();
		JSONObject json = new JSONObject();
		if(message!=null&&!"".equals(message)) {
			json = JSONObject.fromObject(message);
			if(json.getString("bicycletypeids")!=null&&!"".equals(json.getString("bicycletypeids"))) {
				String[] bicycletypeids = json.getString("bicycletypeids").split(";");
				int i = 0;
				if(bicycletypeids!=null&&bicycletypeids.length>0) {
					for(String id:bicycletypeids) {
						i += bicycle_type_mapper.deleteByPrimaryKey(Integer.parseInt(id));
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
				return obj.toString();
			}
		}
		else {
			obj.put("msg", IMyEnums.FAIL);
		}
		return obj.toString();
	}
	@Override
	public String updatebicycletypestatus(String message) {
		JSONObject obj = new JSONObject();
		JSONObject json = new JSONObject();
		if(message!=null&&!"".equals(message)) {
			json = JSONObject.fromObject(message);
			BicycleTypeExample example = new BicycleTypeExample();
			BicycleTypeExample.Criteria criteria = example.createCriteria();
			BicycleType bicycleType = new BicycleType();
			if(json.getString("bicycletypeid")!=null&&!"".equals(json.getString("bicycletypeid"))) {
				criteria.andBicycletypeidEqualTo(Integer.parseInt(json.getString("bicycletypeid")));
			}
			else {
				obj.put("msg", IMyEnums.FAIL);
				return obj.toString();
			}
			if(json.getString("state")!=null&&!"".equals(json.getString("state"))) {
				bicycleType.setState(json.getString("state"));
			}
			else {
				obj.put("msg", IMyEnums.FAIL);
				return obj.toString();
			}
			int i =bicycle_type_mapper.updateByExampleSelective(bicycleType, example);
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
	public String updatebicycletypeliststatus(String message) {
		JSONObject obj = new JSONObject();
		JSONObject json = new JSONObject();
		if(message!=null&&!"".equals(message)) {
			json = JSONObject.fromObject(message);
			BicycleTypeExample example = new BicycleTypeExample();
			BicycleTypeExample.Criteria criteria = example.createCriteria();
			BicycleType bicycleType = new BicycleType();
			if(json.getString("state")!=null&&!"".equals(json.getString("state"))) {
				bicycleType.setState(json.getString("state"));
			}
			else {
				obj.put("msg", IMyEnums.FAIL);
				return obj.toString();
			}
			if(json.getString("bicycletypeids")!=null&&!"".equals(json.getString("bicycletypeids"))) {
				String[] bicycletypeids = json.getString("bicycletypeids").split(";");
				int i = 0;
				if(bicycletypeids!=null&&!"".equals(json.getString("bicycletypeids"))) {
					for(String id:bicycletypeids) {
						criteria.andBicycletypeidEqualTo(Integer.parseInt(id));
						i +=bicycle_type_mapper.updateByExampleSelective(bicycleType, example);
					}
					if(i>0) {
						obj.put("msg", IMyEnums.SUCCEED);
					}
					else {
						obj.put("msg", IMyEnums.FAIL);
					}
				}
				
				criteria.andBicycletypeidEqualTo(Integer.parseInt(json.getString("bicycletypeids")));
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
	public String querybicycletype(String message) {
		JSONObject obj = new JSONObject();
		JSONObject json = new JSONObject();
		if(message!=null&&!"".equals(message)) {
			json = JSONObject.fromObject(message);
			BicycleTypeExample example = new BicycleTypeExample();
			List<BicycleType> list = bicycle_type_mapper.selectByExample(example);
			if(list!=null&&list.size()>0) {
				obj.put("bicycletype", list);
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
	public String updatebicycletype(String message) {
		JSONObject obj = new JSONObject();
		JSONObject json = new JSONObject();
		if(message!=null&&!"".equals(message)) {
			json = JSONObject.fromObject(message);
			BicycleType bicycletype = new BicycleType();
			BicycleTypeExample example = new BicycleTypeExample();
			BicycleTypeExample.Criteria criteria = example.createCriteria();
			if(json.getString("bicycletypeid")!=null&&!"".equals(json.getString("bicycletypeid"))) {
				criteria.andBicycletypeidEqualTo(Integer.parseInt(json.getString("bicycletypeid")));
			}
			else {
				obj.put("msg", IMyEnums.FAIL);
				return obj.toString();
			}
			if(json.getString("name")!=null&&!"".equals(json.getString("name"))) {
				bicycletype.setName(json.getString("name"));
			}
			else {
				obj.put("msg", IMyEnums.FAIL);
				return obj.toString();
			}
			if(json.getString("state")!=null&&!"".equals(json.getString("state"))) {
				bicycletype.setState(json.getString("state"));
			}
			else {
				obj.put("msg", IMyEnums.FAIL);
				return obj.toString();
			}
			int i = bicycle_type_mapper.updateByExampleSelective(bicycletype, example);
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
	public String insertcolour(String message) {
		JSONObject obj = new JSONObject();
		JSONObject json = new JSONObject();
		if(message!=null&&!"".equals(message)) {
			json = JSONObject.fromObject(message);
			Colour colour = new Colour();
			if(json.getString("bicycletypeid")!=null&&!"".equals(json.getString("bicycletypeid"))) {
				colour.setBicycleid(Integer.parseInt(json.getString("bicycletypeid")));
			}
			else {
				obj.put("msg", IMyEnums.FAIL);
				return obj.toString();
			}
			if(json.getString("name")!=null&&!"".equals(json.getString("name"))) {
				colour.setName(json.getString("name"));
			}
			else {
				obj.put("msg", IMyEnums.FAIL);
				return obj.toString();
			}
			if(json.getString("code")!=null&&!"".equals(json.getString("code"))) {
				colour.setCode(json.getString("code"));
			}
			else {
				obj.put("msg", IMyEnums.FAIL);
				return obj.toString();
			}
			colour.setState(IMyEnums.NORMAL);
			colour.setCreatetime(new Date());
			int i = colour_mapper.insertSelective(colour);
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
	public String queryallcolour(String message) {
		JSONObject obj = new JSONObject();
		JSONObject json = new JSONObject();
		if(message!=null&&!"".equals(message)) {
			json = JSONObject.fromObject(message);
			ColourExample example = new ColourExample();
			List<Colour> list = colour_mapper.selectByExample(example);
			if(list!=null&&list.size()>0) {
				obj.put("colour", list);
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
	public String updatecolourstatus(String message) {
		JSONObject obj = new JSONObject();
		JSONObject json = new JSONObject();
		if(message!=null&&!"".equals(message)) {
			json = JSONObject.fromObject(message);
			Colour colour = new Colour();
			ColourExample example = new ColourExample();
			ColourExample.Criteria criteria = example.createCriteria();
			if(json.getString("colourid")!=null&&!"".equals(json.getString("colourid"))) {
				criteria.andBicycleidEqualTo(Integer.parseInt(json.getString("colourid")));
			}
			else {
				obj.put("msg", IMyEnums.FAIL);
				return obj.toString();
			}
			if(json.getString("state")!=null&&!"".equals(json.getString("state"))) {
				colour.setState(json.getString("state"));
			}
			else {
				obj.put("msg", IMyEnums.FAIL);
				return obj.toString();
			}
			int i = colour_mapper.updateByExampleSelective(colour, example);
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
	public String updatecolourliststatus(String message) {
		JSONObject obj = new JSONObject();
		JSONObject json = new JSONObject();
		if(message!=null&&!"".equals(message)) {
			json = JSONObject.fromObject(message);
			Colour colour = new Colour();
			ColourExample example = new ColourExample();
			ColourExample.Criteria criteria = example.createCriteria();
			
			if(json.getString("state")!=null&&!"".equals(json.getString("state"))) {
				colour.setState(json.getString("state"));
			}
			else {
				obj.put("msg", IMyEnums.FAIL);
				return obj.toString();
			}
			int i = 0;
			if(json.getString("colourids")!=null&&!"".equals(json.getString("colourids"))) {
				String[] colourids = json.getString("colourids").split(";");
				if(colourids!=null&&colourids.length>0) {
					for(String id:colourids) {
						criteria.andBicycleidEqualTo(Integer.parseInt(id));
						i += colour_mapper.updateByExampleSelective(colour, example);
					}
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
	public String insertpartmessage(String message) {
		JSONObject obj = new JSONObject();
		JSONObject json = new JSONObject();
		if(message!=null&&!"".equals(message)) {
			json = JSONObject.fromObject(message);
			PartMessage partMessage = new PartMessage();
			if(json.getString("parttypeid")!=null&&!"".equals(json.getString("parttypeid"))) {
				partMessage.setParttypeid(Integer.parseInt(json.getString("parttypeid")));
			}
			else {
				obj.put("msg", IMyEnums.FAIL);
				return obj.toString();
			}
			if(json.getString("name")!=null&&!"".equals(json.getString("name"))) {
				partMessage.setName(json.getString("name"));
			}
			else {
				obj.put("msg", IMyEnums.FAIL);
				return obj.toString();
			}
			if(json.getString("specification")!=null&&!"".equals(json.getString("specification"))) {
				partMessage.setSpecification(json.getString("specification"));
			}
			if(json.getString("money")!=null&&!"".equals(json.getString("money"))) {
				partMessage.setMoney(json.getString("money"));
			}
			else {
				obj.put("msg", IMyEnums.FAIL);
				return obj.toString();
			}
			BicyclePartCrr bicyclePartCrr = new BicyclePartCrr();
			if(json.getString("bicycleid")!=null&&!"".equals(json.getString("bicycleid"))) {
				bicyclePartCrr.setBicycleid(Integer.parseInt(json.getString("bicycleid")));
			}
			else {
				obj.put("msg", IMyEnums.FAIL);
				return obj.toString();
			}
			int i = part_message_mapper.insertSelective(partMessage);
			if(i>0) {
				obj.put("msg", IMyEnums.SUCCEED);
				bicyclePartCrr.setPartmessageid(i);
				bicyclePartCrr.setOrderno("~");
				i =bicycle_part_crr_mapper.insert(bicyclePartCrr);
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
	public String updatepartmessage(String message) {
		JSONObject obj = new JSONObject();
		JSONObject json = new JSONObject();
		if(message!=null&&!"".equals(message)) {
			json = JSONObject.fromObject(message);
			PartMessage partMessage = new PartMessage();
			PartMessageExample example = new PartMessageExample();
			PartMessageExample.Criteria criteria = example.createCriteria();
			if(json.getString("partmessageid")!=null&&!"".equals(json.getString("partmessageid"))) {
				criteria.andPartmessageidEqualTo(Integer.parseInt(json.getString("partmessageid")));
			}
			else {
				obj.put("msg", IMyEnums.FAIL);
				return obj.toString();
			}
			if(json.getString("parttypeid")!=null&&!"".equals(json.getString("parttypeid"))) {
				partMessage.setParttypeid(Integer.parseInt(json.getString("parttypeid")));
			}
			if(json.getString("name")!=null&&!"".equals(json.getString("name"))) {
				partMessage.setName(json.getString("name"));
			}
			if(json.getString("specification")!=null&&!"".equals(json.getString("specification"))) {
				partMessage.setSpecification(json.getString("specification"));
			}
			if(json.getString("money")!=null&&!"".equals(json.getString("money"))) {
				partMessage.setMoney(json.getString("money"));
			}
			int i = part_message_mapper.updateByExampleSelective(partMessage, example);
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
	public String querypartmessage(String message) {
		JSONObject obj = new JSONObject();
		JSONObject json = new JSONObject();
		if(message!=null&&!"".equals(message)) {
			json = JSONObject.fromObject(message);
			PartMessageExample example = new PartMessageExample();
			List<PartMessage> list = part_message_mapper.selectByExample(example);
			if(list!=null&&list.size()>0) {
				obj.put("partmessage", list);
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
	public String deletepartmessage(String message) {
		JSONObject obj = new JSONObject();
		JSONObject json = new JSONObject();
		if(message!=null&&!"".equals(message)) {
			json = JSONObject.fromObject(message);
			if(json.getString("partmessageid")!=null&&!"".equals(json.getString("partmessageid"))) {
				int i = part_message_mapper.deleteByPrimaryKey(Integer.parseInt(json.getString("partmessageid")));
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
	public String deletelistpartmessage(String message) {
		JSONObject obj = new JSONObject();
		JSONObject json = new JSONObject();
		if(message!=null&&!"".equals(message)) {
			json = JSONObject.fromObject(message);
			if(json.getString("partmessageid")!=null&&!"".equals(json.getString("partmessageid"))) {
				int i = 0;
				String[] partmessageid = json.getString("partmessageid").split(";");
				if(partmessageid!=null&&partmessageid.length>0) {
					for(String id:partmessageid) {
						i += part_message_mapper.deleteByPrimaryKey(Integer.parseInt(id));
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
	public String insertparttype(String message) {
		JSONObject obj = new JSONObject();
		JSONObject json = new JSONObject();
		if(message!=null&&!"".equals(message)) {
			json = JSONObject.fromObject(message);
			PartType partType = new PartType();
			if(json.getString("name")!=null&&!"".equals(json.getString("name"))) {
				partType.setName(json.getString("name"));
				partType.setCreatetime(new Date());
				int i = part_type_mapper.insertSelective(partType);
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
	public String updateparttype(String message) {
		JSONObject obj = new JSONObject();
		JSONObject json = new JSONObject();
		if(message!=null&&!"".equals(message)) {
			json = JSONObject.fromObject(message);
			PartType partType = new PartType();
			PartTypeExample example = new PartTypeExample();
			PartTypeExample.Criteria criteria = example.createCriteria();
			if(json.getString("parttypeid")!=null&&!"".equals(json.getString("parttypeid"))) {
				criteria.andParttypeidEqualTo(Integer.parseInt(json.getString("parttypeid")));
			}
			else {
				obj.put("msg", IMyEnums.FAIL);
				return obj.toString();
			}
			if(json.getString("name")!=null&&!"".equals(json.getString("name"))) {
				partType.setName(json.getString("name"));
			}
			else {
				obj.put("msg", IMyEnums.FAIL);
				return obj.toString();
			}
			partType.setCreatetime(new Date());
			int i = part_type_mapper.updateByExampleSelective(partType, example);
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
	public String queryparttype(String message) {
		JSONObject obj = new JSONObject();
		JSONObject json = new JSONObject();
		if(message!=null&&!"".equals(message)) {
			json = JSONObject.fromObject(message);
			PartTypeExample example = new PartTypeExample();
			List<PartType> list = part_type_mapper.selectByExample(example);
			if(list!=null&&list.size()>0) {
				obj.put("parttype", list);
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
	public String deleteparttype(String message) {
		JSONObject obj = new JSONObject();
		JSONObject json = new JSONObject();
		if(message!=null&&!"".equals(message)) {
			json = JSONObject.fromObject(message);
			if(json.getString("parttypeid")!=null&&!"".equals(json.getString("parttypeid"))) {
				int i = part_type_mapper.deleteByPrimaryKey(Integer.parseInt(json.getString("parttypeid")));
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
	public String querybicycle(String message) {
		JSONObject obj = new JSONObject();
		JSONObject json = new JSONObject();
		if(message!=null&&!"".equals(message)) {
			json = JSONObject.fromObject(message);
			BicycleExample example = new BicycleExample();
			BicycleExample.Criteria criteria = example.createCriteria();
			criteria.andDelstateGreaterThan("0");
			if(json.getString("pageIndex")!=null&&!"".equals(json.getString("pageIndex"))) {
				example.setPageIndex(Integer.parseInt(json.getString("pageIndex"))-1);
			}
			else {
				example.setPageIndex(0);
			}
	        example.setPageSize(10);
			example.setOrderByClause("createtime asc");
			if(json.getString("bicycletypeid")!=null&&!"".equals(json.getString("bicycletypeid"))) {
				criteria.andBicycletypeidEqualTo(Integer.parseInt(json.getString("bicycletypeid")));
				//通过自行车分类id查出属于该分类的所有自行车
				List<Bicycle> list = bicycle_mapper.selectByExample(example);
				if(list!=null&&list.size()>0) {
					BicyclePartCrrExample example2 = new BicyclePartCrrExample();
					BicyclePartCrrExample.Criteria criteria2 = example2.createCriteria();
					PhotoExample example3 = new PhotoExample();
					PhotoExample.Criteria criteria3 = example3.createCriteria();
					Set<PartType> partType = new HashSet<PartType>();
					Map<PartType,List<PartMessage>> partmessage = new HashMap<PartType, List<PartMessage>>();
					for(Bicycle bic:list) {
						example2 = new BicyclePartCrrExample();
						criteria2 = example2.createCriteria();
						criteria2.andBicycleidEqualTo(bic.getBicycleid());
						example3 = new PhotoExample();
						criteria3 = example3.createCriteria();
						criteria3.andBicycleidEqualTo(bic.getBicycleid());
						//通过自行车零件信息对应表查出该自行车的所有零件
						List<BicyclePartCrr> list2 = bicycle_part_crr_mapper.selectByExample(example2);
						List<Photo> list3 = photo_mapper.selectByExample(example3);
						if(list2!=null&&list2.size()>0) {
							for(BicyclePartCrr bp:list2) {
								//将该自行车零件所有零件及其所属零件类别进行封装
								PartMessage partMessage = part_message_mapper.selectByPrimaryKey(bp.getPartmessageid());
								PartType partType1 = part_type_mapper.selectByPrimaryKey(partMessage.getParttypeid());
								partType.add(partType1);
								PartMessageExample example1 = new PartMessageExample();
								PartMessageExample.Criteria criteria1 = example1.createCriteria();
								criteria1.andParttypeidEqualTo(partType1.getParttypeid());
								List<PartMessage> list1 = part_message_mapper.selectByExample(example1);
								partmessage.put(partType1, list1);
							}
						}
						bic.setPartType(partType);
						bic.setPartmessage(partmessage);
						if(list3!=null&&list3.size()>0) {
							for(Photo p:list3) {
								String path = "http://127.0.0.1:9090/bicycle_pic/"+p.getPath();
								p.setPath(path);
							}
							bic.setPhoto(list3);
							bic.setFirstphoto(list3.get(0).getPath());
							if(list3!=null&&list3.size()>1) {
								bic.setSecondphoto(list3.get(1).getPath());
							}
						}
					}
					obj.put("allbicycle", list);
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
	public String queryallbicycle(String message) {
		JSONObject obj = new JSONObject();
		JSONObject json = new JSONObject();
		if(message!=null&&!"".equals(message)) {
			json = JSONObject.fromObject(message);
			BicycleExample example = new BicycleExample();
			BicycleExample.Criteria criteria = example.createCriteria();
			if(json.getString("pageIndex")!=null&&!"".equals(json.getString("pageIndex"))) {
				example.setPageIndex(Integer.parseInt(json.getString("pageIndex"))-1);
			}
			else {
				example.setPageIndex(0);
			}
			if(json.getString("name")!=null&&!"".equals(json.getString("name"))) {
				criteria.andNameLike("%"+(json.getString("name"))+"%");
			}
	        example.setPageSize(10);
			example.setOrderByClause("createtime asc");
			//通过自行车分类id查出属于该分类的所有自行车
			List<Bicycle> list = bicycle_mapper.selectByExample(example);
			if(list!=null&&list.size()>0) {
				BicyclePartCrrExample example2 = new BicyclePartCrrExample();
				BicyclePartCrrExample.Criteria criteria2 = example2.createCriteria();
				PhotoExample example3 = new PhotoExample();
				PhotoExample.Criteria criteria3 = example3.createCriteria();
				Set<PartType> partType = new HashSet<PartType>();
				Map<PartType,List<PartMessage>> partmessage = new HashMap<PartType, List<PartMessage>>();
				for(Bicycle bic:list) {
					example2 = new BicyclePartCrrExample();
					criteria2 = example2.createCriteria();
					criteria2.andBicycleidEqualTo(bic.getBicycleid());
					example3 = new PhotoExample();
					criteria3 = example3.createCriteria();
					criteria3.andBicycleidEqualTo(bic.getBicycleid());
					//通过自行车零件信息对应表查出该自行车的所有零件
					List<BicyclePartCrr> list2 = bicycle_part_crr_mapper.selectByExample(example2);
					List<Photo> list3 = photo_mapper.selectByExample(example3);
					if(list2!=null&&list2.size()>0) {
						for(BicyclePartCrr bp:list2) {
							//将该自行车零件所有零件及其所属零件类别进行封装
							PartMessage partMessage = part_message_mapper.selectByPrimaryKey(bp.getPartmessageid());
							PartType partType1 = part_type_mapper.selectByPrimaryKey(partMessage.getParttypeid());
							partType.add(partType1);
							PartMessageExample example1 = new PartMessageExample();
							PartMessageExample.Criteria criteria1 = example1.createCriteria();
							criteria1.andParttypeidEqualTo(partType1.getParttypeid());
							List<PartMessage> list1 = part_message_mapper.selectByExample(example1);
							partmessage.put(partType1, list1);
						}
					}
					bic.setPartType(partType);
					bic.setPartmessage(partmessage);
					if(list3!=null&&list3.size()>0) {
						for(Photo p:list3) {
							String path = "http://127.0.0.1:9090/bicycle_pic/"+p.getPath();
							p.setPath(path);
						}
						bic.setPhoto(list3);
						bic.setFirstphoto(list3.get(0).getPath());
						if(list3!=null&&list3.size()>1) {
							bic.setSecondphoto(list3.get(1).getPath());
						}
					}
				}
				obj.put("allbicycle", list);
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
	public String querybicycleById(String message) {
		JSONObject obj = new JSONObject();
		JSONObject json = new JSONObject();
		if(message!=null&&!"".equals(message)) {
			json = JSONObject.fromObject(message);
			if(json.getString("bicycleid")!=null&&!"".equals(json.getString("bicycleid"))) {
				Bicycle bicycle = bicycle_mapper.selectByPrimaryKey(Integer.parseInt(json.getString("bicycleid")));
				if(bicycle!=null) {
					BicyclePartCrrExample example2 = new BicyclePartCrrExample();
					BicyclePartCrrExample.Criteria criteria2 = example2.createCriteria();
					PhotoExample example3 = new PhotoExample();
					PhotoExample.Criteria criteria3 = example3.createCriteria();
					Set<PartType> partType = new HashSet<PartType>();
					Map<PartType,List<PartMessage>> partmessage = new HashMap<PartType, List<PartMessage>>();
					criteria2.andBicycleidEqualTo(bicycle.getBicycleid());
					//通过自行车零件信息对应表查出该自行车的所有零件
					List<BicyclePartCrr> list2 = bicycle_part_crr_mapper.selectByExample(example2);
					criteria3.andBicycleidEqualTo(bicycle.getBicycleid());
					List<Photo> list3 = photo_mapper.selectByExample(example3);
					if(list2!=null&&list2.size()>0) {
						for(BicyclePartCrr bp:list2) {
							//将该自行车零件所有零件及其所属零件类别进行封装
							PartMessage partMessage = part_message_mapper.selectByPrimaryKey(bp.getPartmessageid());
							PartType partType1 = part_type_mapper.selectByPrimaryKey(partMessage.getParttypeid());
							partType.add(partType1);
							PartMessageExample example1 = new PartMessageExample();
							PartMessageExample.Criteria criteria1 = example1.createCriteria();
							criteria1.andParttypeidEqualTo(partType1.getParttypeid());
							List<PartMessage> list1 = part_message_mapper.selectByExample(example1);
							partmessage.put(partType1, list1);
						}
					}
					bicycle.setPartType(partType);
					bicycle.setPartmessage(partmessage);
					if(list3!=null&&list3.size()>0) {
						for(Photo p:list3) {
							String path = "http://127.0.0.1:9090/bicycle_pic/"+p.getPath();
							p.setPath(path);
						}
						bicycle.setPhoto(list3);
						bicycle.setFirstphoto(list3.get(0).getPath());
						bicycle.setSecondphoto(list3.get(1).getPath());
					}
					obj.put("bicycle", bicycle);
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
	public String querydelstatebicycle(String message) {
		JSONObject obj = new JSONObject();
		JSONObject json = new JSONObject();
		if(message!=null&&!"".equals(message)) {
			json = JSONObject.fromObject(message);
			BicycleExample example = new BicycleExample();
			BicycleExample.Criteria criteria = example.createCriteria();
			if(json.getString("pageIndex")!=null&&!"".equals(json.getString("pageIndex"))) {
				example.setPageIndex(Integer.parseInt(json.getString("pageIndex"))-1);
			}
			else {
				example.setPageIndex(0);
			}
			if(json.getString("pageSize")!=null&&!"".equals(json.getString("pageSize"))) {
				example.setPageSize(Integer.parseInt(json.getString("pageSize")));
			}
			else {
				example.setPageSize(8);
			}
	        
			example.setOrderByClause("createtime asc");
			if(json.getString("delstate")!=null&&!"".equals(json.getString("delstate"))) {
				criteria.andDelstateEqualTo(json.getString("delstate"));
				//通过自行车分类id查出属于该分类的所有自行车
				List<Bicycle> list = bicycle_mapper.selectByExample(example);
				if(list!=null&&list.size()>0) {
					BicyclePartCrrExample example2 = new BicyclePartCrrExample();
					BicyclePartCrrExample.Criteria criteria2 = example2.createCriteria();
					PhotoExample example3 = new PhotoExample();
					PhotoExample.Criteria criteria3 = example3.createCriteria();
					Set<PartType> partType = new HashSet<PartType>();
					Map<PartType,List<PartMessage>> partmessage = new HashMap<PartType, List<PartMessage>>();
					for(Bicycle bic:list) {
						example2 = new BicyclePartCrrExample();
						criteria2 = example2.createCriteria();
						criteria2.andBicycleidEqualTo(bic.getBicycleid());
						example3 = new PhotoExample();
						criteria3 = example3.createCriteria();
						criteria3.andBicycleidEqualTo(bic.getBicycleid());
						//通过自行车零件信息对应表查出该自行车的所有零件
						List<BicyclePartCrr> list2 = bicycle_part_crr_mapper.selectByExample(example2);
						List<Photo> list3 = photo_mapper.selectByExample(example3);
						if(list2!=null&&list2.size()>0) {
							for(BicyclePartCrr bp:list2) {
								//将该自行车零件所有零件及其所属零件类别进行封装
								PartMessage partMessage = part_message_mapper.selectByPrimaryKey(bp.getPartmessageid());
								PartType partType1 = part_type_mapper.selectByPrimaryKey(partMessage.getParttypeid());
								partType.add(partType1);
								PartMessageExample example1 = new PartMessageExample();
								PartMessageExample.Criteria criteria1 = example1.createCriteria();
								criteria1.andParttypeidEqualTo(partType1.getParttypeid());
								List<PartMessage> list1 = part_message_mapper.selectByExample(example1);
								partmessage.put(partType1, list1);
							}
						}
						bic.setPartType(partType);
						bic.setPartmessage(partmessage);
						if(list3!=null&&list3.size()>0) {
							for(Photo p:list3) {
								String path = "http://127.0.0.1:9090/bicycle_pic/"+p.getPath();
								p.setPath(path);
							}
							bic.setPhoto(list3);
							bic.setFirstphoto(list3.get(0).getPath());
							if(list3!=null&&list3.size()>1) {
							bic.setSecondphoto(list3.get(1).getPath());
							}
						}
					}
					obj.put("bicyclelist", list);
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
	public String queryshopcarnum(String message) {
		JSONObject obj = new JSONObject();
		JSONObject json = new JSONObject();
		if(message!=null&&!"".equals(message)) {
			json = JSONObject.fromObject(message);
			obj.put("msg", IMyEnums.SUCCEED);
			Shopcar shopcar = new Shopcar();
			ShopcarExample example = new ShopcarExample();
			ShopcarExample.Criteria criteria = example.createCriteria();
			if(json.getString("userid")!=null&&!"".equals(json.getString("userid"))) {
				shopcar.setUserid(Integer.parseInt(json.getString("userid")));
				criteria.andUseridEqualTo(Integer.parseInt(json.getString("userid")));
			}
			else {
				obj.put("msg", IMyEnums.FAIL);
				return obj.toString();
			}
			long i = shopcar_mapper.countByExample(example);
			obj.put("shopcarnum", i);
			obj.put("msg", IMyEnums.SUCCEED);
		}
		else {
			obj.put("msg", IMyEnums.FAIL);
		}
		return obj.toString();
	}
	@Override
	public String queryorderByUserId(String message) {
		JSONObject obj = new JSONObject();
		JSONObject json = new JSONObject();
		if(message!=null&&!"".equals(message)) {
			json = JSONObject.fromObject(message);
			obj.put("msg", IMyEnums.SUCCEED);
			OrderFormExample example = new OrderFormExample();
			OrderFormExample.Criteria criteria = example.createCriteria();
			AddressExample example2 = new AddressExample();
			AddressExample.Criteria criteria2 = example2.createCriteria();
			if(json.getString("userid")!=null&&!"".equals(json.getString("userid"))) {
				criteria2.andUseridEqualTo(Integer.parseInt(json.getString("userid")));
			}
			else {
				obj.put("msg", IMyEnums.FAIL);
				return obj.toString();
			}
			List<Address> list2 = address_mapper.selectByExample(example2);
			List<OrderForm> orderformlist = new ArrayList<OrderForm>();
			if(list2!=null&&list2.size()>0) {
				for(Address a:list2) {
					example = new OrderFormExample();
					criteria = example.createCriteria();
					criteria.andAdsidEqualTo(a.getAdsid());
					List<OrderForm> list = order_form_mapper.selectByExample(example);
					if(list!=null&&list.size()>0) {
						for(OrderForm o:list) {
							orderformlist.add(o);
						}
					}
				}
			}
			obj.put("OrderFormByUserIdList", orderformlist);
			obj.put("msg", IMyEnums.SUCCEED);
		}
		else {
			obj.put("msg", IMyEnums.FAIL);
		}
		return obj.toString();
	}
	@Override
	public String queryallorder(String message) {
		JSONObject obj = new JSONObject();
		JSONObject json = new JSONObject();
		if(message!=null&&!"".equals(message)) {
			json = JSONObject.fromObject(message);
			OrderFormExample example = new OrderFormExample();
			if(json.getString("pageIndex")!=null&&!"".equals(json.getString("pageIndex"))) {
				example.setPageIndex(Integer.parseInt(json.getString("pageIndex")));
			}
			else {
				example.setPageIndex(0);
			}
			example.setPageSize(10);
			example.setOrderByClause("createtime asc");
			List<OrderForm> list = order_form_mapper.selectByExample(example);
			if(list!=null&&list.size()>0) {
				for(OrderForm o:list) {
					OrderFormDetailExample example2 = new OrderFormDetailExample();
					OrderFormDetailExample.Criteria criteria = example2.createCriteria();
					criteria.andOrdernoEqualTo(o.getOrderno());
					List<OrderFormDetail> list2 = order_form_detail_mapper.selectByExample(example2);
					if(list2!=null&&list2.size()>0) {
						for(OrderFormDetail d:list2) {
							Bicycle bicycle = bicycle_mapper.selectByPrimaryKey(d.getBicycleid());
							PhotoExample example3 = new PhotoExample();
							PhotoExample.Criteria criteria3 = example3.createCriteria();
							criteria3.andBicycleidEqualTo(bicycle.getBicycleid());
							List<Photo> list3 = photo_mapper.selectByExample(example3);
							bicycle.setPhoto(list3);
							if(list3!=null&&list3.size()>0) {
								bicycle.setFirstphoto("http://127.0.0.1:9090/bicycle_pic/"+list3.get(0).getPath());
							}
							if(list3!=null&&list3.size()>1) {
								bicycle.setSecondphoto("http://127.0.0.1:9090/bicycle_pic/"+list3.get(1).getPath());
							}
							d.setBicycle(bicycle);
						}
					}
					o.setOrderFormDetails(list2);
					Address address = address_mapper.selectByPrimaryKey(o.getAdsid());
					String adsdetails = address_service.getProCityDis(address.getDistrict());
					address.setAdsdetails(adsdetails+" "+address.getAdsdetails());
					o.setAddress(address);
					User user = user_mapper.selectByPrimaryKey(address.getUserid());
					o.setUser(user);
				}
				obj.put("allorderform", list);
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
