package com.example.smart.service;

import java.util.Date;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.alibaba.fastjson.JSONObject;

import net.smartschool.dao.MsgBoardDao;
import net.smartschool.entity.MsgBoard;
import net.smartschool.impl.MsgBoardDaoImp;

public class MsgBoardService {
	MsgBoardDao dao = new MsgBoardDaoImp();
	private static final Logger logger = LogManager.getLogger();
	/**
	 *  查询留言板
	 */
	public String selectMsgBoard(int page, int count) {
		JSONObject res = new JSONObject();
		List<MsgBoard> list = null; 
		try {
			list = dao.selectMsgBoard((page - 1) * count, count);
			if (list != null) {
				res.put("state", 0);
				res.put("msg", "查询留言板成功！");
				res.put("data", list);
			} else {
				res.put("state", 100);
				res.put("msg", "查询留言板失败！");
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
	 *  查询留言板
	 */
	public String selectMsgBoardByBeuser(String userid,int page, int count) {
		JSONObject res = new JSONObject();
		List<MsgBoard> list = null; 
		try {
			list = dao.selectMsgBoardByBeuser(userid,(page - 1) * count, count);
			if (list != null) {
				res.put("state", 0);
				res.put("msg", "查询留言板成功！");
				res.put("data", list);
			} else {
				res.put("state", 100);
				res.put("msg", "查询留言板失败！");
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
	 * 添加留言
	 */
	public String insertMsgBoard(String userid, String beuserid, String content) {
		JSONObject res = new JSONObject();
		Integer t = null;
		Date starttime = new Date(); 
		try {
			t = dao.insertMsgBoard(userid, starttime, beuserid, content);
			if (t == 1) {
				res.put("state", 0);
				res.put("msg", "留言成功！");
			} else {
				res.put("state", 100);
				res.put("msg", "留言失败！");
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
	 * 删除留言
	 */
	public String deleteMsgBoard(String userid, Date starttime) {
		JSONObject res = new JSONObject();
		Integer t = null;
		try {
			t = dao.deleteMsgBoard(userid, starttime);
			if (t == 1) {
				res.put("state", 0);
				res.put("msg", "删除留言成功！");
			} else {
				res.put("state", 100);
				res.put("msg", "删除留言失败！");
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
	 * 修改阅读状态
	 */
	public String changeReadState(String userid, Date starttime) {
		JSONObject res = new JSONObject();
		Integer t = null;
		Date readtime = new Date();
		try {
			t = dao.changeReadState(userid, starttime, readtime);
			if (t == 1) {
				res.put("state", 0);
				res.put("msg", "修改阅读状态成功！");
			} else {
				res.put("state", 100);
				res.put("msg", "修改阅读状态失败！");
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
