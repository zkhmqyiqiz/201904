package com.example.smart.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.alibaba.fastjson.JSONObject;

import net.smartschool.dao.TimeDao;
import net.smartschool.entity.XNXQHAndZC;
import net.smartschool.impl.TimeDaoImpl;
/**
 * 12.13添加
 * @author Administrator
 *
 */
public class TimeService {
	TimeDao dao = new TimeDaoImpl();
	private static final Logger logger = LogManager.getLogger();
	public String selectXNXQHAndZC() {
		JSONObject res = new JSONObject();
		XNXQHAndZC data = new XNXQHAndZC();
		try {
			data = dao.selectXNXQHAndZC();
			if (data == null) {
				data = dao.selectLastJC();
			}
			if(data != null) {
				res.put("state", 0);
				res.put("msg", "查询成功");
				res.put("data", data);
			}else {
				res.put("state", 200);
				res.put("msg", "查询失败，数据库错误！");
			}
		} catch (Exception e) {
			e.printStackTrace();
			res.put("state", -500);
			res.put("msg", "查询失败，数据库错误！");
		}
		logger.info("从"+this.getClass().getName()+"收到请求返回："+res.toString());
		return res.toString();
	}
}