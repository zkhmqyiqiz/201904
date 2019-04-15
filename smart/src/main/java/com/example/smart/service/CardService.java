package com.example.smart.service;

import java.util.ArrayList;
import java.util.List;

import com.example.smart.dao.CardDao;
import com.example.smart.entity.Card;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.alibaba.fastjson.JSONObject;


public class CardService {
	CardDao dao = new CardDaoImp();
	private static final Logger logger = LogManager.getLogger();
	public String selectAllCard(int page,int count) {
		JSONObject res = new JSONObject();
		try {
			List<Card> t = null;
			int cardcount =0;
			t = dao.selectAllCard((page-1)*count, count);
			cardcount = dao.selectCardCount();
			System.out.println("==============================="+cardcount);
			if (!(t == null)) {
				res.put("state", 0);
				res.put("msg", "查询配置成功！");
				res.put("data", t);
				res.put("cardcount",cardcount);
			} else {
				res.put("state", 100);
				res.put("msg", "查询配置失败！");
			}
		} catch (Exception e) {
			e.printStackTrace();
			res.put("state", -500);
			res.put("msg", "数据库错误！");
		}
		logger.info("从"+this.getClass().getName()+"收到请求返回："+res.toString());
		return res.toString();
		
	}
	
	public String selectUserByCard(Long cardid) {
		JSONObject res = new JSONObject();
		try {
			User t = null; 
			t = dao.selectUserByCard(cardid);
			List<User> listUser = new ArrayList<User>();
			listUser.add(t);
			if (t != null) {
				res.put("state", 0);
				res.put("msg", "查询配置成功！");
				res.put("data", listUser);
			} else {
				res.put("state", 100);
				res.put("msg", "查询配置失败！");
			}
		} catch (Exception e) {
			e.printStackTrace();
			res.put("state", -500);
			res.put("msg", "数据库错误！");
		}
		logger.info("从"+this.getClass().getName()+"收到请求返回："+res.toString());
		return res.toString();
	}

	public String selectCardByUser(String userid) {
		JSONObject res = new JSONObject();
		try {
			List<Card> t = null; 
			t = dao.selectCardByUser(userid);
			if (t != null) {
				res.put("state", 0);
				res.put("msg", "查询配置成功！");
				res.put("data", t);
			} else {
				res.put("state", 100);
				res.put("msg", "查询配置失败！");
			}
		} catch (Exception e) {
			e.printStackTrace();
			res.put("state", -500);
			res.put("msg", "数据库错误！");
		}
		logger.info("从"+this.getClass().getName()+"收到请求返回："+res.toString());
		return res.toString();
	}
	
	public String selectCardToUser(Integer page ,Integer number) {
		JSONObject res = new JSONObject();
		try {
			List<AllCardByUser> t = null; 
			if((page!=null) && (number!=null) && (number > 0) && (page >= 0)) {
				if(page > 0) {//page默认为0
					page = page*number;
				}
			}else {
				res.put("msg", "传递的参数有问题");
				res.put("state", 100);
				return res.toString();
			}
			t = dao.selectCardToUser(page,number);
			Integer temp  = dao.selectCardToUserCount();
			if (t != null) {
				res.put("state", 0);
				res.put("msg", "查询配置成功！");
				res.put("data", t);
				res.put("count", temp);
			} else {
				res.put("state", 100);
				res.put("msg", "暂无数据！");
			}
		} catch (Exception e) {
			e.printStackTrace();
			res.put("state", -500);
			res.put("msg", "数据库错误！");
		}
		logger.info("从"+this.getClass().getName()+"收到请求返回："+res.toString());
		return res.toString();
	}
	
	public String selectCardToUserlike(String userid, String username,Integer page,Integer number) {
		JSONObject res = new JSONObject();
		try {
			List<AllCardByUser> t = null; 
			if((page!=null) && (number!=null) && (number > 0) && (page >= 0)) {
				if(page > 0) {
					page = (page-1)*number;//page默认为1的时候
				}
			}else {
				res.put("msg", "传递的参数有问题");
				res.put("state", 100);
				return res.toString();
			}
			t = dao.selectCardToUserlike(userid, username, page, number);
			Integer temp  = dao.selectCardToUserlikeCount(userid, username);
			if (t != null) {
				res.put("state", 0);
				res.put("msg", "查询配置成功！");
				res.put("data", t);
				res.put("count", temp);
			} else {
				res.put("state", 100);
				res.put("msg", "暂无数据！");
			}
		} catch (Exception e) {
			e.printStackTrace();
			res.put("state", -500);
			res.put("msg", "数据库错误！");
		}
		logger.info("从"+this.getClass().getName()+"收到请求返回："+res.toString());
		return res.toString();
	}
	
	/**
	 * */
	
	public String updateCard(String vlist,Integer radix) {
	JSONObject res = new JSONObject();
	try {
		String[] ss = vlist.split("<br>");//截取每一个用户的对象
		List<Card> list = new ArrayList<>();
		for (int i = 0; i < ss.length; i++) {
			String a = ss[i].split("#")[0];//卡号cardid
			String b = ss[i].split("#")[1];//userid
			Long tempt = 0L;
			if(a!=null&&a!="") {
				//转化
				tempt = RadixUtil.saveData(a);
			}else {
				res.put("state", 100);
				res.put("msg", "参数传递有问题！");
				return res.toString();
			}
			/*//判断是否有radix参数，如果有，那么是安卓设备
			if(radix!=null&&(radix >0)) {
				
			}else {
				//如果没有，那么就从数据库中查询数据
				radix =new CardDaoImp().selectCardRadix();
			}
					
			if(radix.intValue() == 1)//大端
			{
				//大端不处理，理论上所有数据默认都是大端
			}
			else
			{
				//如果是小端，转成大端
				tempt = RadixUtil.ToRevHex(tempt);
			}*/
			Card card = new Card();
			card.setCardid(tempt);
			card.setUserid(b);
			list.add(card);
		}
		Integer t = null;
		t = dao.updateCard(list);
		//dao.updateCardRadix(radix);
		if (t != null) {
			res.put("state", 0);
			res.put("msg", "查询配置成功！");
			res.put("data", t);
		} else {
			res.put("state", 100);
			res.put("msg", "暂无数据！");
		}
	} catch (Exception e) {
		e.printStackTrace();
		res.put("state", -500);
		res.put("msg", "卡号重复！");
	}
	logger.info("从"+this.getClass().getName()+"收到请求返回："+res.toString());
	return res.toString();
}
	
	public String selectCardRadix() {
		JSONObject res = new JSONObject();
		try {
			Integer radix = dao.selectCardRadix();
			if(radix != null) {
				res.put("state", 0);
				res.put("msg", "查询成功");
				res.put("data", radix);
			}else {
				res.put("state", 100);
				res.put("msg", "查询失败");
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			res.put("state", -500);
			res.put("msg", "数据库错误");
		}
		logger.info("从"+this.getClass().getName()+"收到请求返回："+res.toString());
		return res.toString();
		
	}
	
	public String updateAllCard(Integer radix,Integer radixold) {
		JSONObject res = new JSONObject();
		try {
			Integer count = null;
			if(radix.equals(radixold)) {//如果参数的值与数据库的值相同
				count = 1;
			}else {//如果参数的值与数据库的值不相同
				count= dao.updateAllCard();//转换card表中所有的cardid
				dao.updateCardRadix(radix);//修改radix中radixs的值
			}
			if(count != null) {
				res.put("state", 0);
				res.put("msg", "查询成功");
				res.put("data", count);
			}else {
				res.put("state", 100);
				res.put("msg", "查询失败");
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			res.put("state", -500);
			res.put("msg", "数据库错误");
		}
		logger.info("从"+this.getClass().getName()+"收到请求返回："+res.toString());
		return res.toString();
		
	}
	
}
