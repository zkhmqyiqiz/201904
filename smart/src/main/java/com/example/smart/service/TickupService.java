package com.example.smart.service;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.alibaba.fastjson.JSONObject;

import net.smartschool.dao.AttendClassDao;
import net.smartschool.dao.UserToLessonDao;
import net.smartschool.entity.AttendClass;
import net.smartschool.entity.SignInLog;
import net.smartschool.entity.Tickup;
import net.smartschool.impl.AttendClassDaoImp;
import net.smartschool.impl.TickupDaoImp;
import net.smartschool.impl.UserToLessonDaoImp;

public class TickupService {
	TickupDaoImp dao=new TickupDaoImp();
	private static final Logger logger = LogManager.getLogger();
	/**
	 * 查询所有的签到记录。
	 * @param company 公司名	
	 * @param page  起始页数
	 * @param count  每页显示的条数
	 * @param days  days==2时查询当天的数据
	 * @return
	 */
	public String selectAllTickup(int page,int count,int days) {
		JSONObject res = new JSONObject();
		try {
			List<Tickup> t = null; 
			int cardcount =0;
			if(days==2) {
				t = dao.selectTodayTickup((page-1)*count, count,days);
				cardcount = dao.selectTodayCounts(days);
			}else {
				t = dao.selectAllTickup((page-1)*count, count,days);
				cardcount = dao.selectAllCounts(days);
			}
			
			if (!(t == null)) {
				res.put("state", 0);
				res.put("msg", "查询配置成功！");
				res.put("data", t);
				res.put("numbers",cardcount);
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
	
	/**
	 * 添加签到记录
	 * @param userid
	 * @param curriculumid
	 * @param tickuptime
	 * @param success
	 * @return
	 */
	public String addTickup(String userid, long curriculumid, Date tickuptime, int success,int weekid,int tickuptype) {
		JSONObject res = new JSONObject();
		try {
			int counts =0;
			counts = dao.addTickup(userid, weekid, curriculumid, success, tickuptype);
			if(counts>0) {
				res.put("state", 0);
				res.put("msg", "添加信息成功");
			}else {
				res.put("state", 100);
				res.put("msg", "添加信息失败！");
			}
		}catch (Exception e) {
			e.printStackTrace();
			res.put("state", -500);
			res.put("msg", "数据库错误！");
		}
		
		logger.info("从"+this.getClass().getName()+"收到请求返回："+res.toString());
		return res.toString();
	}
	
	public String selectTickupStatus(long curriculumid) {
		JSONObject res = new JSONObject();
		try {
			int counts =0;
			counts = dao.selectTickupStatus(curriculumid);
			if(counts>0) {
				res.put("state", 0);
				res.put("numbers", counts);
				res.put("msg", "查询成功");
			}else {
				res.put("state", 100);
				res.put("numbers", -1);
				res.put("msg", "查询失败！");
			}
		}catch (Exception e) {
			e.printStackTrace();
			res.put("state", -500);
			res.put("msg", "数据库错误！");
		}
		
		logger.info("从" + this.getClass().getName() + "收到请求返回：" + res.toString());
		return res.toString();
	}
	
	public String selectTickupExist(long curriculumid, String userid) {
		JSONObject res = new JSONObject();
		try {
			int counts =0;
			counts = dao.selectTickupExist(curriculumid, userid);
			if(counts>0) {
				res.put("state", 0);
				res.put("numbers", counts);
				res.put("msg", "查询成功");
			}else {
				res.put("state", 100);
				res.put("numbers", -1);
				res.put("msg", "查询失败！");
			}
		}catch (Exception e) {
			e.printStackTrace();
			res.put("state", -500);
			res.put("msg", "数据库错误！");
		}
		
		logger.info("从"+this.getClass().getName()+"收到请求返回："+res.toString());
		return res.toString();
	}

	public String checkedMessage(int attendclassid) {
		JSONObject res = new JSONObject();
		AttendClassDao attendClassDao = new AttendClassDaoImp();
		UserToLessonDao userToLessonDao = new UserToLessonDaoImp();
		try {
			AttendClass attendClass = attendClassDao.selectAttendClass(attendclassid);
			if (attendClass != null) {
				long curriculumid = attendClass.getCurriculumid();
				int zc = attendClass.getZc();
//				int pptid = attendClass.getPptid();
				int attendclasstype = attendClass.getAttendclasstype();
				List<SignInLog> list = userToLessonDao.selectUserToLessonNotTickup(curriculumid);
				if (list != null) {
					if (attendclasstype == 0) {
						Map<String, SignInLog> map = new LinkedHashMap<>();
						SignInLog signInLog = null;
						for (int i = 0; i < list.size(); i ++) {
							signInLog = list.get(i);
							signInLog.setSuccess(-1);
							map.put(signInLog.getUserId(), signInLog);
						}
						List<SignInLog> list1 = dao.selectScanTickup(curriculumid, zc, 1);
						if (list1 != null) {
							for (int i = 0; i < list1.size(); i ++) {
								map.get(list.get(i).getUserId()).setSuccess(0);
							}
						}
						List<SignInLog> listsign = new ArrayList<>();
						 Set<Map.Entry<String, SignInLog>> es = map.entrySet();
				           Iterator<Map.Entry<String, SignInLog>> it = es.iterator();
				           while(it.hasNext()){
				               Map.Entry<String, SignInLog> mey = it.next();
				               listsign.add(mey.getValue());
				               }
						res.put("state", 0);
						res.put("msg", "查询正常课信息成功！");
						res.put("data", listsign);
					} 
					if (attendclasstype == 1) {
						List<SignInLog> list1 = dao.selectScanTickup(curriculumid, zc, 3);
						res.put("state", 0);
						res.put("msg", "查询临时课信息成功！");
						res.put("data", list1);
					}
				}
			} else {
				res.put("state", 100);
				res.put("msg", "未查到此课堂信息！");
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
