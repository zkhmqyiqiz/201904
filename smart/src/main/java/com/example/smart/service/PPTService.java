package com.example.smart.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.alibaba.fastjson.JSONObject;

import net.smartschool.dao.PPTDao;
import net.smartschool.entity.PPT;
import net.smartschool.impl.PPTDaoImpl;

public class PPTService {
	PPTDao dao = new PPTDaoImpl();
	private static final Logger logger = LogManager.getLogger();
	public String insertPPT(PPT ppt) {
		JSONObject res = new JSONObject();
		try {
			int count = 0;
			count = dao.insertPPT(ppt);
			if (count > 0) {
				
				res.put("state", 0);
				res.put("msg", "添加ppt成功！");
				res.put("pptid", ppt.getPptid());
			} else {
				res.put("state", 100);
				res.put("msg", "添加失败！");
			}
		} catch (Exception e) {
			e.printStackTrace();
			res.put("state", -500);
			res.put("msg", "数据库错误！");
		}
		logger.info("从" + this.getClass().getName() + "收到请求返回：" + res.toString());
		return res.toString();
	}

}
