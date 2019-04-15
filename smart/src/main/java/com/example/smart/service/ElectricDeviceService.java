package com.example.smart.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import net.common.util.ReadFile;
import net.smartschool.dao.ElectricDeviceDao;
import net.smartschool.entity.ClassName;
import net.smartschool.entity.DeviceNote;
import net.smartschool.entity.ElectricDevice;
import net.smartschool.entity.User;
import net.smartschool.impl.ElectricDeviceImpl;

public class ElectricDeviceService {
	ElectricDeviceDao dao = new ElectricDeviceImpl();
	private static final Logger logger = LogManager.getLogger();
	public String addElectricDevice(String edeviceip, String edevicename,String classroomid, String ip) {
		JSONObject res = new JSONObject();
		int count = 0;
		int t = 0;
		try {
			count = dao.selectDeviceByIP(edeviceip);
			if(count>0) {
				res.put("state", 200);
				res.put("msg", "设备ip冲突，请检查！");
				return res.toString();
			}
			t = dao.insertEDevice(edeviceip, edevicename, classroomid, ip);
			if(t>0) {
				res.put("state", 0);
				res.put("msg", "添加设备成功！");
				
			}else {
				res.put("state", 100);
				res.put("msg", "添加设备失败！");
				
			}
		} catch (Exception e) {
			e.printStackTrace();
			res.put("state", -500);
			res.put("msg", "添加设备失败，数据库错误！");
		}
		logger.info("从" + this.getClass().getName() + "收到请求返回：" + res.toString());
		return res.toString();
	}
	
	public String addElectricDeviceByPandect(String edeviceip, String edevicename, String classroomid) {
		JSONObject res = new JSONObject();
		int count = 0;
		int t = 0;
		try {
			count = dao.selectDeviceByIP(edeviceip);
			if(count > 0) {
				res.put("state", 200);
				res.put("msg", "设备ip冲突，请检查！");
				return res.toString();
			}
			t = dao.insertEDeviceByPandect(edeviceip, edevicename, classroomid);
			if(t > 0) {
				res.put("state", 0);
				res.put("msg", "添加设备成功！");
				
			}else {
				res.put("state", 100);
				res.put("msg", "添加设备失败！");
				
			}
		} catch (Exception e) {
			e.printStackTrace();
			res.put("state", -500);
			res.put("msg", "添加设备失败，数据库错误！");
		}
		logger.info("从" + this.getClass().getName() + "收到请求返回：" + res.toString());
		return res.toString();
	}
	
	public String getElectricDevice(Integer page, Integer count) {
		JSONObject res = new JSONObject();
		List<ElectricDevice> list = new ArrayList<>();
		try {
			
			list = dao.selectEDevice();
			if(list.size() > 0) {
				res.put("state", 0);
				res.put("msg", "查询设备成功！");
				res.put("data", list);
				res.put("page", page);
				res.put("count", count);
				
			}else {
				res.put("state", 100);
				res.put("msg", "查询设备失败！");
			}
		} catch (Exception e) {
			e.printStackTrace();
			res.put("state", -500);
			res.put("msg", "查询设备失败，数据库错误！");
		}
		logger.info("从" + this.getClass().getName() + "收到请求返回：" + res.toString());
		return res.toString();
	}
	/**
	 * 通过ip删除
	 * @param edeviceIp ip
	 * @return
	 */
	public String deleteDeviceByIp(String edeviceip) {
		JSONObject res = new JSONObject();
		int t = 0;
		try {
			t = dao.deleteDeviceByIp(edeviceip);
			if(t > 0) {
				res.put("state", 0);
				res.put("msg", "删除设备成功！");
			}else {
				res.put("state", 100);
				res.put("msg", "删除设备失败！");
			}
		} catch (Exception e) {
			e.printStackTrace();
			res.put("state", -500);
			res.put("msg", "删除设备失败，数据库错误！");
		}
		logger.info("从" + this.getClass().getName() + "收到请求返回：" + res.toString());
		return res.toString();
	}
	/**
	 * 通过ip删除批量删除
	 * @param edeviceIp ip
	 * @return
	 */
	public String deleteElectricDeviceList(List<String> list) {
		JSONObject res = new JSONObject();
		int t = 0;
		try {
			t = dao.deleteElectricDeviceList(list);
			if(t > 0) {
				res.put("state", 0);
				res.put("msg", "删除设备成功！");
			}else {
				res.put("state", 100);
				res.put("msg", "删除设备失败！");
			}
		} catch (Exception e) {
			e.printStackTrace();
			res.put("state", -500);
			res.put("msg", "删除设备失败，数据库错误！");
		}
		logger.info("从" + this.getClass().getName() + "收到请求返回：" + res.toString());
		return res.toString();
	}
	public String updateDeviceByIp(String classroomid, String edevicename, String edeviceip, String ip) {
		JSONObject res = new JSONObject();
		int t = 0;
		try {
			t = dao.updateDeviceByIp(classroomid, edevicename, edeviceip, ip);
			if(t > 0) {
				res.put("state", 0);
				res.put("msg", "修改设备成功！");
			}else {
				res.put("state", 100);
				res.put("msg", "修改设备失败！");
			}
		} catch (Exception e) {
			e.printStackTrace();
			res.put("state", -500);
			res.put("msg", "修改设备失败，数据库错误！");
		}
		logger.info("从" + this.getClass().getName() + "收到请求返回：" + res.toString());
		return res.toString();
	}
	public String getXmlById(String classroomid, int type){
		JSONObject res = new JSONObject();
		String xml = "";
		try {
			xml = dao.selectXmlById(classroomid,type);
				res.put("state", 0);
				res.put("msg", "查询xml成功！");
				res.put("data", xml);
		} catch (Exception e) {
			e.printStackTrace();
			res.put("state", -500);
			res.put("msg", "查询xml失败，数据库错误！");
		}
		logger.info("从" + this.getClass().getName() + "收到请求返回：" + res.toString());
		return res.toString();
	}
	
	public String selectXmlByIp(String ip) {
		JSONObject res = new JSONObject();
		String t = null;
		try {
			t = dao.selectXmlByIp(ip);
			if(t!=null) {
				res.put("state", 0);
				res.put("msg", "查询设备成功！");
				res.put("data", t);
			}else {
				res.put("state", 100);
				res.put("msg", "查询设备失败！");
				
			}
		} catch (Exception e) {
			e.printStackTrace();
			res.put("state", -500);
			res.put("msg", "查询设备失败，数据库错误！");
		}
		logger.info("从" + this.getClass().getName() + "收到请求返回：" + res.toString());
		return res.toString();
	}
	
	public String selectVideoByIp(String ip, String filePath) {
		JSONObject res = new JSONObject();
		String t = null;
		try {
			t = dao.selectVideoByIp(ip);
			if(t != null) {
				String logPath = t.split(";")[0];
				filePath = filePath + logPath;
				Map<String,Long> fileMap = new ReadFile().readFileToAndroid(filePath);
				res.put("state", 0);
				res.put("msg", "查询设备成功！");
				res.put("data", t);
				res.put("fileLog", fileMap);
			}else {
				res.put("state", 100);
				res.put("msg", "查询设备失败！");
				
			}
		} catch (Exception e) {
			e.printStackTrace();
			res.put("state", -500);
			res.put("msg", "查询设备失败，数据库错误！");
		}
		logger.info("从" + this.getClass().getName() + "收到请求返回：" + res.toString());
		return res.toString();
	}
	//List<String> listfile = new ReadFile().readFile(filePath);
	
	public String selectVideoByIpForWeb(String ip, String filePath) {
		JSONObject res = new JSONObject();
		String t = null;
		List<String> listfile = new ReadFile().readFile(filePath);
		try {
			t = dao.selectVideoByIp(ip);
			if(listfile != null) {
				res.put("state", 0);
				res.put("msg", "查询设备成功！");
				res.put("data", t);
				res.put("listfile", listfile);
			}else {
				res.put("state", 100);
				res.put("msg", "查询设备失败！");
			}
		} catch (Exception e) {
			e.printStackTrace();
			res.put("state", -500);
			res.put("msg", "查询设备失败，数据库错误！");
		}
		logger.info("从" + this.getClass().getName() + "收到请求返回：" + res.toString());
		return res.toString();
	}
	
	public String selectXmlByIpByPandect(String ip, String filePath) {
		JSONObject res = new JSONObject();
		String t = null;
		List<String> listfile = new ReadFile().readFile(filePath);
		try {
			t = dao.selectXmlByIp(ip);
			if(t!=null) {
				res.put("state", 0);
				res.put("msg", "查询设备成功！");
				res.put("data", t);
				res.put("listfile", listfile);
			}else {
				res.put("state", 100);
				res.put("msg", "查询设备失败！");
			}
		} catch (Exception e) {
			e.printStackTrace();
			res.put("state", -500);
			res.put("msg", "查询设备失败，数据库错误！");
		}
		logger.info("从" + this.getClass().getName() + "收到请求返回：" + res.toString());
		return res.toString();
	}
	
	//修改电子总览的视频配置，当时第一次添加视频的时候
	public String selectXmlByIpByPandectNew(String ip, String filePath) {
		JSONObject res = new JSONObject();
		String t = null;
		List<String> listfile = new ReadFile().readFile(filePath);
		try {
			t = dao.selectXmlByIp(ip);
			if(t != null) {
				res.put("state", 0);
				res.put("msg", "查询设备成功！");
				res.put("data", t);
				res.put("listfile", listfile);
			}else {
				res.put("state", 0);
				res.put("msg", "查询设备成功！");
				res.put("listfile", listfile);
			}
		} catch (Exception e) {
			e.printStackTrace();
			res.put("state", -500);
			res.put("msg", "查询设备失败，数据库错误！");
		}
		logger.info("从" + this.getClass().getName() + "收到请求返回：" + res.toString());
		return res.toString();
	}
	
	/**
	 * 给安卓设备返回指定播放视频的文件夹中所有视频文件的名称和文件的大小*/
	public String selectXmlByPandectToAndroid(String ip, String filePath) {
		JSONObject res = new JSONObject();
		String t = null;
		try {
			t = dao.selectXmlByIp(ip);
			if(t != null) {
				String logPath = t.split(";")[0];
				filePath = filePath + logPath;
				Map<String,Long> fileMap = new ReadFile().readFileToAndroid(filePath);
				res.put("state", 0);
				res.put("msg", "查询设备成功！");
				res.put("data", t);
				res.put("fileLog", fileMap);
			}else {
				res.put("state", 100);
				res.put("msg", "查询设备失败！");
			}
		} catch (Exception e) {
			e.printStackTrace();
			res.put("state", -500);
			res.put("msg", "查询设备失败，数据库错误！");
		}
		logger.info("从" + this.getClass().getName() + "收到请求返回：" + res.toString());
		return res.toString();
	}
	
	public String updateXmlById(String xml, String classroomid, int type) {
		JSONObject res = new JSONObject();
		int t = 0;
		try {
			t = dao.updateXmlById(xml, classroomid, type);
			if(t > 0) {
				res.put("state", 0);
				res.put("msg", "修改设备xml成功！");
			}else {
				res.put("state", 100);
				res.put("msg", "修改设备xml失败！");
			}
		} catch (Exception e) {
			e.printStackTrace();
			res.put("state", -500);
			res.put("msg", "修改设备xml失败，数据库错误！");
		}
		logger.info("从" + this.getClass().getName() + "收到请求返回：" + res.toString());
		return res.toString();
	}
	
	public String updateXmlByIp(String xml, String edeviceip) {
		JSONObject res = new JSONObject();
		int t = 0;
		try {
			t = dao.updateXmlByIp(xml, edeviceip);
			if(t > 0) {
				res.put("state", 0);
				res.put("msg", "修改设备xml成功！");
			}else {
				res.put("state", 100);
				res.put("msg", "修改设备xml失败！");
			}
		} catch (Exception e) {
			e.printStackTrace();
			res.put("state", -500);
			res.put("msg", "修改设备xml失败，数据库错误！");
		}
		logger.info("从" + this.getClass().getName() + "收到请求返回：" + res.toString());
		return res.toString();
	}
	
	public String updateVideoByIp(String xml, String edeviceip) {
		JSONObject res = new JSONObject();
		int t = 0;
		try {
			t = dao.updateVideoByIp(xml, edeviceip);
			if(t > 0) {
				res.put("state", 0);
				res.put("msg", "修改设备成功！");
			}else {
				res.put("state", 100);
				res.put("msg", "修改设备失败！");
			}
		} catch (Exception e) {
			e.printStackTrace();
			res.put("state", -500);
			res.put("msg", "修改设备失败，数据库错误！");
		}
		logger.info("从" + this.getClass().getName() + "收到请求返回：" + res.toString());
		return res.toString();
	}
	
	/**
	 * 通过教室id和deviceType=4查询
	 * @param classroomid 教室id
	 * @return
	 */
	public String selsetDeviceByClassID(String classroomid) {
		JSONObject res = new JSONObject();
		List<DeviceNote> list = new ArrayList<>();
		try {
			list = dao.selsetDeviceByClassID(classroomid);
			if(list.size() > 0) {
				res.put("state", 0);
				res.put("msg", "查询设备成功！");
				res.put("data", list);
			}else {
				res.put("state", 100);
				res.put("msg", "查询设备失败！");
			}
		} catch (Exception e) {
			e.printStackTrace();
			res.put("state", -500);
			res.put("msg", "查询设备失败，数据库错误！");
		}
		logger.info("从" + this.getClass().getName() + "收到请求返回：" + res.toString());
		return res.toString();
	}
	
	/**
	 * 通过查询lessonform（timestart这个时间为条件），lessonuse，lesson，electricdevice 查询数据 班级名，课程名
	 * @param req
	 * @return
	 */
	public String selectDeviceByIp(String Ip) {
		JSONObject res = new JSONObject();
		ClassName className = null;
		try {
			className = dao.selectDeviceByIp(Ip);
			if(className != null) {
				res = JSONObject.parseObject(JSON.toJSONString(className));
			} else {
				className = dao.selectDeviceByIpForNext(Ip);
				if(className != null) {
					res = JSONObject.parseObject(JSON.toJSONString(className));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("从" + this.getClass().getName() + "收到请求返回：" + res.toString());
		return res.toString();
	}
	
	/*
	 * @zhankun
	 * 通过课程结束时间>当前时间，并排序，选择其中的一条*/
	public String selectElectricDeviceByIp(String Ip) {
		JSONObject res = new JSONObject();
		ClassName className = null;
		try {
			className = dao.selectDeviceByIp(Ip);
			if(className != null) {
				res = JSONObject.parseObject(JSON.toJSONString(className));
			} else {
				className = dao.selectElectricDeviceByIp(Ip);
				if(className != null) {
					res = JSONObject.parseObject(JSON.toJSONString(className));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("从" + this.getClass().getName() + "收到请求返回：" + res.toString());
		return res.toString();
	}
	
	public String selectByIPToUser(String Ip,Long cardid) {
		JSONObject res = new JSONObject();
		try {
			User user = dao.selectByIPToUser(Ip, cardid);
			if (user != null) {
				List<User> listUser = new ArrayList<User>();
				listUser.add(user);
				res.put("state", 0);
				res.put("msg", "查询配置成功！");
				res.put("data", listUser);
			} else {
				res.put("state", 100);
				res.put("msg", "查询配置失败！");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("从" + this.getClass().getName() + "收到请求返回：" + res.toString());
		return res.toString();
	}
	
	/**
	 * 通过type=1 查询所有的教室班牌信息，并分页
	 * @return
	 */
	public String selectDeviceByType(int page,int count) {
		JSONObject res = new JSONObject();
		List<ElectricDevice> list = new ArrayList<>();
		int number = 0;
		try{
			list = dao.selectDeviceByType((page - 1) * count, count);
			number = dao.selectDevicecount();
			if(list.size() > 0) {
				res.put("state", 0);
				res.put("msg", "查询设备成功！");
				res.put("data", list);
				res.put("numbers", number);
			}else {
				res.put("state", 100);
				res.put("msg", "查询设备失败！");
			}
		} catch (Exception e) {
			e.printStackTrace();
			res.put("state", -500);
			res.put("msg", "查询设备失败，数据库错误！");
		}
		logger.info("从" + this.getClass().getName() + "收到请求返回：" + res.toString());
		return res.toString();
	}
	
	/**
	 * 通过传入参数type=2 查询所有的电子总览，并分页
	 * @return
	 */
	public String selectDeviceByTypes(int page, int count, int type) {
		JSONObject res = new JSONObject();
		List<ElectricDevice> list = new ArrayList<>();
		int number = 0;
		try{
			//list = dao.selectDeviceByType((page-1)*count,count);
			list = dao.selectDeviceByTypes((page - 1) * count, count, type);
			number = dao.selectDeviceCounts(type);
			if(list.size() > 0) {
				res.put("state", 0);
				res.put("msg", "查询设备成功！");
				res.put("data", list);
				res.put("numbers", number);
			}else {
				res.put("state", 100);
				res.put("msg", "查询设备失败！");
			}
		} catch (Exception e) {
			e.printStackTrace();
			res.put("state", -500);
			res.put("msg", "查询设备失败，数据库错误！");
		}
		logger.info("从" + this.getClass().getName() + "收到请求返回：" + res.toString());
		return res.toString();
	}
	
	public String selectDeviceByTypeElectric(int page, int count, int type, int types) {
		JSONObject res = new JSONObject();
		List<ElectricDevice> list = new ArrayList<>();
		int number = 0;
		try{
			//list = dao.selectDeviceByType((page-1)*count,count);
			list = dao.selectDeviceByTypeElectric((page - 1) * count, count, type, types);
			number = dao.selectDeviceCountsElectric(type, types);
			if(list.size() > 0) {
				res.put("state", 0);
				res.put("msg", "查询设备成功！");
				res.put("data", list);
				res.put("numbers", number);
			}else {
				res.put("state", 100);
				res.put("msg", "查询设备失败！");
			}
		} catch (Exception e) {
			e.printStackTrace();
			res.put("state", -500);
			res.put("msg", "查询设备失败，数据库错误！");
		}
		logger.info("从" + this.getClass().getName() + "收到请求返回：" + res.toString());
		return res.toString();
	}
	
	/**
	 * 查询所有的教室名(修改，添加操作使用)
	 * @return
	 */
	public String selsetDeviceClass() {
		JSONObject res = new JSONObject();
		List<ElectricDevice> list = new ArrayList<>();
		try{
			list = dao.selsetDeviceClass();
			if(list.size() > 0) {
				res.put("state", 0);
				res.put("msg", "查询教室名成功！");
				res.put("data", list);
			}else {
				res.put("state", 100);
				res.put("msg", "查询教室名设备失败！");
				
			}
		} catch (Exception e) {
			e.printStackTrace();
			res.put("state", -500);
			res.put("msg", "查询设备失败，数据库错误！");
		}
		logger.info("从" + this.getClass().getName() + "收到请求返回：" + res.toString());
		return res.toString();
		
	}
	/**
	 * 通过ip查询修改的一条数据
	 * @param edeviceIp ip
	 * @return
	 */
	public String selsetDeviceClassByIp(String edeviceIp) {
		JSONObject res = new JSONObject();
		ElectricDevice electricDevice = null;
		try{
			electricDevice = dao.selsetDeviceClassByIp(edeviceIp);
			if(electricDevice != null) {
				res.put("state", 0);
				res.put("msg", "查询修改数据成功！");
				res.put("data", electricDevice);
			}else {
				res.put("state", 100);
				res.put("msg", "查询修改数据失败！");
			}
		} catch (Exception e) {
			e.printStackTrace();
			res.put("state", -500);
			res.put("msg", "查询设备失败，数据库错误！");
		}
		logger.info("从" + this.getClass().getName() + "收到请求返回：" + res.toString());
		return res.toString();
	}
	
	/**
	 * 通过ip修改数据
	 * @param edeviceIp IP
	 * @param edevicename 设备名
	 * @param classroomid 教室 id
	 * @return
	 */
	public String updateElectricDeviceByIP(String edeviceIp, String edevicename, String classroomid, String ip) {
		JSONObject res = new JSONObject();
		int count = 0;
		try{
			count = dao.updateElectricDeviceByIP(edeviceIp, edevicename, classroomid, ip);
			if(count > 0) {
				res.put("state", 0);
				res.put("msg", "修改设备成功！");
			}else {
				res.put("state", 100);
				res.put("msg", "修改设备失败！");
			}
		} catch (Exception e) {
			e.printStackTrace();
			res.put("state", -500);
			res.put("msg", "查询设备失败，数据库错误！");
		}
		logger.info("从" + this.getClass().getName() + "收到请求返回：" + res.toString());
		return res.toString();
	}
	
	/**
	 * 添加 教室班牌的数据 xml=“ ”，type=1 在 xml中写死
	 * @param edeviceIp ip
	 * @param edevicename 设备名
	 * @param classroomid 教室 id
	 * @return
	 */
	public String addElectricDeviceClass(String edeviceIp, String edevicename, String classroomid, String ip) {
		JSONObject res = new JSONObject();
		int count = 0;
		int counts = 0;
		//查询该ip是否存在
		counts = dao.selectDeviceByIP(edeviceIp);
		if(counts == 0) {
			try{
				count = dao.addElectricDeviceClass(edeviceIp, edevicename, classroomid, ip);
				if(count > 0) {
					res.put("state", 0);
					res.put("msg", "新增设备成功！");
				}else {
					res.put("state", 100);
					res.put("msg", "新增设备失败！");
				}
			} catch (Exception e) {
				e.printStackTrace();
				res.put("state", -500);
				res.put("msg", "查询设备失败，数据库错误！");
			}
			logger.info("从" + this.getClass().getName() + "收到请求返回：" + res.toString());
			return res.toString();	
		}else {
			res.put("state", -100);
			res.put("msg", "该ip已经存在了！");
			logger.info("从" + this.getClass().getName() + "收到请求返回：" + res.toString());
			return res.toString();	
		}
	}
	
	public String addElectricDeviceClass(String edeviceIp, String edevicename, String classroomid, int type, String ip) {
		JSONObject res = new JSONObject();
		int count = 0;
		int counts = 0;
		List<ElectricDevice> electricDeviceList = new ArrayList<ElectricDevice>();
		try{
			electricDeviceList = dao.selectByClassroomidAndType(classroomid, type);
			if(electricDeviceList.size() > 0) {
				res.put("state", 100);
				res.put("msg", "一个教室内，同一种设备只能有一个！");
				return res.toString();
			}
		} catch (Exception e) {
			e.printStackTrace();
			res.put("state", -500);
			res.put("msg", "查询设备失败，数据库错误！");
			return res.toString();
		}
		//查询该ip是否存在
		counts = dao.selectDeviceByIP(edeviceIp);
		if(counts == 0) {
			try{
				count = dao.addElectricDeviceClass(edeviceIp, edevicename, classroomid, ip);
				if(count > 0) {
					res.put("state", 0);
					res.put("msg", "新增设备成功！");
				}else {
					res.put("state", 100);
					res.put("msg", "新增设备失败！");
				}
			} catch (Exception e) {
				e.printStackTrace();
				res.put("state", -500);
				res.put("msg", "查询设备失败，数据库错误！");
			}
			logger.info("从" + this.getClass().getName() + "收到请求返回：" + res.toString());
			return res.toString();	
		}else {
			res.put("state", -100);
			res.put("msg", "该ip已经存在了！");
			logger.info("从" + this.getClass().getName() + "收到请求返回：" + res.toString());
			return res.toString();	
		}
	}
	
	public String selectByClassroomidAndType(String classroomid, int type) {
		JSONObject res = new JSONObject();
		List<ElectricDevice> electricDeviceList = new ArrayList<>();
		try {
			electricDeviceList = dao.selectByClassroomidAndType(classroomid, type);
			if(electricDeviceList.size() > 0) {
				res.put("state", 0);
				res.put("msg", "新增设备成功！");
				res.put("electricDeviceList", electricDeviceList);
			}else {
				res.put("state", 100);
				res.put("msg", "不存在该数据");
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("ElectricDeviceService中selectByClassroomidAndType方法出现异常");
			res.put("state", -500);
			res.put("msg", "数据库查询出错！");
		}
		logger.info("从" + this.getClass().getName() + "收到请求返回：" + res.toString());
		return res.toString();
	}
	
	public String selectEdeviceipByFacepp(String faceppIp) {
		JSONObject res = new JSONObject();
		List<String> list;;
		try {
			list = dao.selectEdeviceipByFacepp(faceppIp);
			if(list.size() != 0) {
				res.put("state", 0);
				res.put("msg", "查询信息成功！");
				res.put("list", list);
			}else {
				res.put("state", 100);
				res.put("msg", "不存在该数据");
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("ElectricDeviceService中selectByClassroomidAndType方法出现异常");
			res.put("state", -500);
			res.put("msg", "数据库查询出错！");
		}
		logger.info("从" + this.getClass().getName() + "收到请求返回：" + res.toString());
		return res.toString();
	}
	
}
