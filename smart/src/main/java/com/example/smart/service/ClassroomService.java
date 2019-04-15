package com.example.smart.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.alibaba.fastjson.JSONObject;

import net.smartschool.dao.ClassroomDao;
import net.smartschool.dao.DeviceDao;
import net.smartschool.entity.Classroom;
import net.smartschool.entity.ClassroomSnap;
import net.smartschool.entity.Device;
import net.smartschool.entity.DeviceNote;
import net.smartschool.impl.ClassroomDaoImp;
import net.smartschool.impl.DeviceDaoImpl;

public class ClassroomService {
	ClassroomDao dao = new ClassroomDaoImp();
	DeviceDao dao01 = new DeviceDaoImpl();
	private static final Logger logger = LogManager.getLogger();
	/**
	 * 根据教室ID 公司名查询设备信息
	 * @param classroomid 教室id 
	 * @return
	 */
	public String selectDeviceByClassroomid(String classroomid) {
		JSONObject res = new JSONObject();
		try {
			List<Device> list = null;
			list = dao.selectDeviceByClassroomid(classroomid);
			if(list != null&&list.size()>0) {
				res.put("state", 0);
				res.put("msg", "查询配置成功！");
				res.put("data", list);
				
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
	 * 根据设备id 修改设备的教室id
	 * @param classroomid
	 * @param deviceid
	 * @return
	 */
	public String updateDeviceByDeviceid(String classroomid, String deviceid ) {
		JSONObject res = new JSONObject();
		try {
			int count = 0;
			count = dao.updateDeviceByDeviceid(classroomid, deviceid);
			if(count > 0) {
				res.put("state", 0);
				res.put("msg", "更新设备信息成功！");
				
				
			}else {
				res.put("state", 100);
				res.put("msg", "更新设备信息失败！");
				
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
	 * 根据教室Id 查询教室详情信息
	 * @param classroomid
	 * @return
	 */
	public String selectClassRoomById(String classroomid) {
		JSONObject res = new JSONObject();
	try {
		Classroom classroom = null;
		classroom = dao.selectClassroomById(classroomid);
		if(classroom != null) {
			res.put("state", 0);
			res.put("msg", "查询配置成功！");
			res.put("data", classroom);
			
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
	 * 根据公司名查询 设备所有信息（加了教室名）
	 * @param page 页数
	 * @param count  条数
	 * @classroomid 教室id
	 * @return
	 */
	public String selectAllDeviceNote01(int page, int count, String classroomid) {
		JSONObject res = new JSONObject();
		try {
			List<DeviceNote> t = null; 
			List<Device> list = null;
			list = dao.selectDeviceByClassroomid(classroomid);
			t = dao01.selectAllDeviceNote((page - 1) * count, count);
			if (t != null) {
				res.put("state", 0);
				res.put("msg", "查询设备信息成功！");
				res.put("data", t);//所有的设备；
				res.put("dddd", list);//教室里的设备
			} else {
				res.put("state", 100);
				res.put("msg", "查询设备信息失败！");
			}
		} catch (Exception e) {
			e.printStackTrace();
			res.put("state", -500);
			res.put("msg", "数据库错误！");
		}
		logger.info("从" + this.getClass().getName() + "收到请求返回：" + res.toString());
		return res.toString();
		
	}
	
	
	public String selectAllClassroom() {
		JSONObject res = new JSONObject();
		try {
			List<Classroom> t = null;
			t = dao.selectAllClassroom();
			if(t != null) {
				res.put("state", 0);
				res.put("msg", "查询配置成功！");
				res.put("data", t);
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

	public String getAllClassRoom() {
		JSONObject res = new JSONObject();
		List<Classroom> list = new ArrayList<>();
		try {
			list = dao.selectAllClassroom();
			if(list.size() == 0) {
				res.put("state", 100);
				res.put("msg", "没有查询到教室信息！");
			}else {
				res.put("state", 0);
				res.put("msg", "查询教室信息成功！");
				res.put("data", list);
			}
		} catch (Exception e) {
			e.printStackTrace();
			res.put("state", -500);
			res.put("msg", "查询教室信息时，数据库错误！");
		}
		logger.info("从" + this.getClass().getName() + "收到请求返回：" + res.toString());
		return res.toString();
	}
	public String selectClassroomSnap(String classroomname) {
		JSONObject res = new JSONObject();
		List<ClassroomSnap> list1 = new ArrayList<>();
		try {
			list1 = dao.selectClassroomByLike(classroomname);
			if(list1.size() == 0) {
				res.put("state", 100);
				res.put("msg", "没有查询到教室信息！");
			}else {
				Map<String, ClassroomSnap> map = new HashMap<>();
				List<String> listString= new LinkedList<>();
				String key = "";
				for (int i = 0; i < list1.size(); i ++) {
					key = list1.get(i).getClassroomid();
					map.put(key, list1.get(i));
					listString.add(key);
				}
				List<ClassroomSnap> list2 = dao.selectClassroomSnap(listString);
				for (int i = 0; i < list2.size(); i ++) {
					map.put(list2.get(i).getClassroomid(), list2.get(i));
				}
				List<ClassroomSnap> listsnap = new ArrayList<>();
				 Set<Map.Entry<String, ClassroomSnap>> es = map.entrySet();
		           Iterator<Map.Entry<String, ClassroomSnap>> it = es.iterator();
		           while(it.hasNext()){
		               Map.Entry<String, ClassroomSnap> mey = it.next();
		               listsnap.add(mey.getValue());
		           }
				System.out.println(list1.size());
				System.out.println(list2.size());
				res.put("state", 0);
				res.put("msg", "查询教室信息成功！");
				res.put("data", listsnap);
			}
		} catch (Exception e) {
			e.printStackTrace();
			res.put("state", -500);
			res.put("msg", "查询教室信息时，数据库错误！");
		}
		logger.info("从" + this.getClass().getName() + "收到请求返回：" + res.toString());
		return res.toString();
	}
	public String reportTrouble(String classroomid) {
		JSONObject res = new JSONObject();
		Integer count = null;
		try {
			count = dao.reportTrouble(classroomid);
			if(count > 0) {
				res.put("state", 0);
				res.put("msg", "故障反馈成功！");
			}else {
				res.put("state", 100);
				res.put("msg", "没有查询到教室信息！");
			}
		} catch (Exception e) {
			e.printStackTrace();
			res.put("state", -500);
			res.put("msg", "查询教室信息时，数据库错误！");
		}
		logger.info("从" + this.getClass().getName() + "收到请求返回：" + res.toString());
		return res.toString();
	}
}
