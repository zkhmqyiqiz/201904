package com.example.smart.service;

import java.util.Date;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.alibaba.fastjson.JSONObject;

import net.smartschool.dao.ClassroomCallDao;
import net.smartschool.entity.Classroom;
import net.smartschool.entity.ClassroomCallNote;
import net.smartschool.entity.ClassroomUsed;
import net.smartschool.entity.XNXQHAndZC;
import net.smartschool.impl.ClassroomCallDaoImp;
import net.smartschool.impl.TimeDaoImpl;

public class ClassroomCallService {
	ClassroomCallDao dao = new ClassroomCallDaoImp();
	private static final Logger logger = LogManager.getLogger();
	public String selectClassroomCall(int page, int count) {
		JSONObject res = new JSONObject();
		try {
			List<ClassroomCallNote> list = null;
			int number = 0;
			System.out.println("page " + page + "+++count " + count);
			list = dao.selectClassroomCall((page - 1) * count, count);
			number = dao.selectClassroomCount();
			if(list != null) {
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
		logger.info("从" + this.getClass().getName() + "收到请求返回：" + res.toString());
		return res.toString();
	}
	/**
	 * 通过预约主题，用户名，开始时间，结束时间查询（预约主题，用户名是模糊查询）
	 * @param page  页数
	 * @param count 显示数
	 * @param pstart  开始时间
	 * @param pend  终止时间
	 * @param rstart 预约 开始时间
	 * @param rend 预约终止时间
	 * @return
	 */
	public String selectAllCall(int page, int count, Long pstart, Long pend, String calltheme, String userid) {
		Date Pstart;
		Date Pend;
		//当值为空时try catch 转化为null
		try {
			Pstart = new Date(pstart);
		} catch (NullPointerException e1) {
			Pstart = null;
		}
		
		try {
			Pend = new Date(pend);
		} catch (NullPointerException e1) {
			Pend = null;
		}
		JSONObject res = new JSONObject();
		try {
			List<ClassroomCallNote> list = null;
			//查询总页数
			int number = 0;
			list = dao.selectAllCall((page-1) * count, count, Pstart, Pend, calltheme, userid);
			number = dao.selectClassroomCountByCalltheme(Pstart, Pend, calltheme, userid);
			if(list != null) {
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
		logger.info("从" + this.getClass().getName() + "收到请求返回：" + res.toString());
		return res.toString();
	}
	/**
	 * 添加时要用到  教室名  查询所有教室名
	 * @return
	 */
	public String selectAllClassroom() {
		JSONObject ret = new JSONObject();
		List<Classroom> classroom = dao.selectAllClassroom();
		try {
			if(classroom != null) {
				ret.put("state", 0);
				ret.put("msg", "添加成功!");
				ret.put("data", classroom);
			}else {
				ret.put("state", 100);
				ret.put("msg", "添加失败!");
			}
		} catch (Exception e) {
			e.printStackTrace();
			ret.put("state", -500);
			ret.put("msg", "数据库错误！");
		}
		logger.info("从" + this.getClass().getName() + "收到请求返回：" + ret.toString());
		return ret.toString();
	}
	/**
	 * 添加预约
	 * @param userid  用户id
	 * @param callstart 预约开始时间	
	 * @param callend  预约结束时间	
	 * @param calltype  预约类型
	 * @param peoplecount  人数
	 * @param calltheme  预约主题
	 * @param classroomid 教室id
	 * @return
	 */
	public  String addCall (String userid, Long callstart, Long callend, String calltype, int peoplecount, String calltheme, String classroomid) {
		Date Callstart = new Date(callstart);
		Date Callend = new Date(callend);
		Date date = new Date();
		JSONObject ret = new JSONObject();
		int count = dao.addCall(userid, Callstart, Callend, calltype, peoplecount, calltheme, classroomid, date);
		try {
			if(count > 0) {
				ret.put("state", 0);
				ret.put("msg", "添加成功!");
			}else {
				ret.put("state", 100);
				ret.put("msg", "添加失败!");
			}
		} catch (Exception e) {
			e.printStackTrace();
			ret.put("state", -500);
			ret.put("msg", "数据库错误！");
		}
		logger.info("从" + this.getClass().getName() + "收到请求返回：" + ret.toString());
		return ret.toString();
	}
	/**
	 * 通过预约id查询一条数据
	 * @param callid
	 * @return
	 */
	public String selectOneCallById(int callid){
		JSONObject res = new JSONObject();
		try {
			ClassroomCallNote classroomCallNote = null;
			classroomCallNote = dao.selectOneCallById(callid);
			if(classroomCallNote != null) {
				res.put("state", 0);
				res.put("msg", "查询配置成功！");
				res.put("data", classroomCallNote);
			}else {
				res.put("state", 100);
				res.put("msg", "查询配置失败！");
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
	 * 根据预约id修改预约
	 * @param callid 预约id
	 * @param callstart 预约开始时间
	 * @param callend 预约结束时间
	 * @param calltype 预约类型
	 * @param peoplecount 人数
	 * @param calltheme 预约主题
	 * 
	 * @return
	 */
	public String updateCall(int callid, Long callstart, Long callend, String calltype,
			int peoplecount, String calltheme) {
		Date Callstart = new Date(callstart);
		Date Callend = new Date(callend);
		Date date = new Date();
		JSONObject jb = new JSONObject();
		int count = dao.updateCall(callid, Callstart, Callend, calltype, peoplecount, calltheme, date);
		try {
			if(count > 0) {
				jb.put("state", 0);
				jb.put("msg", "修改成功");
			}else {
				jb.put("state", 100);
				jb.put("msg", "修改失败");
			}
		} catch (Exception e) {
			e.printStackTrace();
			jb.put("state", -500);
			jb.put("msg", "数据库错误");
		}
		logger.info("从" + this.getClass().getName() + "收到请求返回：" + jb.toString());
		return jb.toString();
	}
	
	/**
	 * 通过预约id删除预约
	 * @param callid 预约id
	 * @return
	 */
	public String deleteCall(int callid) {
		JSONObject jb = new JSONObject();
		int count = dao.deleteCall(callid);
		try {
			if(count > 0) {
				jb.put("state", 0);
				jb.put("msg", "删除成功");
			}else {
				jb.put("state", 100);
				jb.put("msg", "删除失败");
			}
		} catch (Exception e) {
			e.printStackTrace();
			jb.put("state", -500);
			jb.put("msg", "数据库错误");
		}
		logger.info("从" + this.getClass().getName() + "收到请求返回：" + jb.toString());
		return jb.toString();
	}
	/**
	 * 查询教室使用情况
	 * @return
	 */
	public String selectClassroomUsed(int page, int count) {
		JSONObject jb = new JSONObject();
		List<ClassroomUsed> t = null;		
		try {
			XNXQHAndZC xnxqhAndZC = new TimeDaoImpl().selectXNXQHAndZC();
	 		String xnxqh = xnxqhAndZC.getXnxqh();
	 		int zc = xnxqhAndZC.getZc();
	 		int jc = xnxqhAndZC.getJc();
			t = dao.selectClassroomUsed(xnxqh, zc, jc, (page - 1) * count, count);
			if (t != null) {
				jb.put("state", 0);
				jb.put("msg", "查询教室使用情况成功");
				jb.put("data", t);
			} else {
				jb.put("state", 100);
				jb.put("msg", "查询教室使用情况失败");
			}
		} catch (Exception e) {
			e.printStackTrace();
			jb.put("state", -500);
			jb.put("msg", "数据库错误");
		}
		logger.info("从" + this.getClass().getName() + "收到请求返回：" + jb.toString());
		return jb.toString();
	}
	
}
