package com.example.smart.service;

import java.util.Date;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.alibaba.fastjson.JSONObject;

import net.smartschool.dao.BulletinDao;
import net.smartschool.entity.Bulletin;
import net.smartschool.impl.BulletinDaoImp;

public class BulletinService {
	BulletinDao dao = new BulletinDaoImp();
	private static final Logger logger = LogManager.getLogger();
	/**
	 *  查询系统公告
	 */
	public String selectBulletin(int page, int count) {
		JSONObject res = new JSONObject();
		List<Bulletin> list = null; 
		try {
			list = dao.selectBulletin((page - 1) * count, count);
			if (list != null) {
				res.put("state", 0);
				res.put("msg", "查询系统公告成功！");
				res.put("data", list);
			} else {
				res.put("state", 100);
				res.put("msg", "查询系统公告失败！");
			}
		} catch (Exception e) {
			e.printStackTrace();
			res.put("state", -500);
			res.put("msg", "数据库错误！");
		}
		logger.info("从" + this.getClass().getName() + "收到请求返回：" + res.toString());
		return res.toString();
	}
	/**
	 * 添加系统公告
	 */
	public String insertBulletin(String userid, int level, String content) {
		JSONObject res = new JSONObject();
		Integer t = null;
		Date starttime = new Date(); 
		try {
			t = dao.insertBulletin(userid, starttime, level, content);
			if (t == 1) {
				res.put("state", 0);
				res.put("msg", "添加系统公告成功！");
			} else {
				res.put("state", 100);
				res.put("msg", "添加系统公告失败！");
			}
		} catch (Exception e) {
			e.printStackTrace();
			res.put("state", -500);
			res.put("msg", "数据库错误！");
		}
		logger.info("从" + this.getClass().getName() + "收到请求返回：" + res.toString());
		return res.toString();
	}
	/**
	 * 删除系统公告
	 */
	public String deleteBulletin(String userid, Date starttime) {
		JSONObject res = new JSONObject();
		Integer t = null;
		try {
			t = dao.deleteBulletin(userid, starttime);
			if (t == 1) {
				res.put("state", 0);
				res.put("msg", "删除系统公告成功！");
			} else {
				res.put("state", 100);
				res.put("msg", "删除系统公告失败！");
			}
		} catch (Exception e) {
			e.printStackTrace();
			res.put("state", -500);
			res.put("msg", "数据库错误！");
		}
		logger.info("从" + this.getClass().getName() + "收到请求返回：" + res.toString());
		return res.toString();
	}
	/**
	 * 修改系统公告
	 */
	public String updateBulletin(String userid, Date starttime, int level, String content) {
		JSONObject res = new JSONObject();
		Integer t = null;
		try {
			t = dao.updateBulletin(userid, starttime, level, content);
			if (t == 1) {
				res.put("state", 0);
				res.put("msg", "修改系统公告成功！");
			} else {
				res.put("state", 100);
				res.put("msg", "修改系统公告失败！");
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
