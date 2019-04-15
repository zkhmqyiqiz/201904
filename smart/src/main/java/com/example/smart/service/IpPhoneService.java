package com.example.smart.service;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.alibaba.fastjson.JSONObject;

import net.smartschool.entity.IpCall;
import net.smartschool.impl.IpPhoneDaoImp;

public class IpPhoneService {
	IpPhoneDaoImp dao=new IpPhoneDaoImp();
	private static final Logger logger = LogManager.getLogger();
	public String selectAllIpCall(int page,int count){
		JSONObject res =new JSONObject();
		try {
			List<IpCall>list=null;
			int number=0;
			list=dao.selectAllIpCall((page-1)*count, count);
			number=dao.selectCount();
			if(list!=null) {
				res.put("state", 0);
				res.put("msg", "查询配置成功！");
				res.put("data", list);
				res.put("numbers", number);
			}else {
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
}
