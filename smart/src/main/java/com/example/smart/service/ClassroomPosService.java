package com.example.smart.service;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.alibaba.fastjson.JSONObject;

import net.smartschool.entity.Classroom;
import net.smartschool.entity.ClassroomNote;
import net.smartschool.impl.ClassroomPosDaoImp;

public class ClassroomPosService {
	ClassroomPosDaoImp dao =new ClassroomPosDaoImp();
	private static final Logger logger = LogManager.getLogger();
	/**
	 * 查询所有数据
	 * @return
	 */
	public String selectClassroomPos(int page, int count){
		JSONObject res = new JSONObject();
		try {
			int number = 0;
			List<ClassroomNote> list = null;
			list = dao.selectClassroomPos((page - 1) * count, count);
			number = dao.selectCounts();
			if (list != null) {
				res.put("state", 0);
				res.put("msg", "查询设备信息成功！");
				res.put("data", list);//所有的；
				res.put("numbers", number);//教室里的
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
	
	/**
	 * 查询所有数据
	 * @return
	 */
	public String selectClassroomPosByLike(String key, int page, int count){
		JSONObject res = new JSONObject();
		try {
			int number = 0;
			List<ClassroomNote> list = null;
			list = dao.selectClassroomPosByLike(key, (page - 1) * count, count);
			if (list != null) {
				res.put("state", 0);
				res.put("msg", "查询设备信息成功！");
				res.put("data", list);//所有的；
				number = dao.selectCountsByLike(key);
				res.put("numbers", number);//教室里的
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
	/**
	 * 添加数据 
	 * @param classroomtype 教室类型
	 * @param classroomname 教室名
	 * @param buildnumber  楼栋编号
	 * @param tag 备注
	 * @return
	 */
	public String addSelectClassroomPos(Integer classroomtype, String classroomname, int buildnumber, String tag,Integer tjoinnumber) {
		JSONObject res = new JSONObject();
		try {
			int counts = 0;
			counts = dao.addSelectClassroomPos(classroomtype, classroomname, buildnumber, tag,tjoinnumber);
			if (counts > 0) {
				res.put("state", 0);
				res.put("msg", "添加信息成功！");
			} else {
				res.put("state", 100);
				res.put("msg", "添加信息失败！");
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
	 * 根据教室ID查询修改的数据
	 * @param classroomid 教室ID
	 * @return
	 */
	public String selectOneClassroomPos(String classroomid){
		JSONObject res = new JSONObject();
		try {
			Classroom classroom = null;
			classroom = dao.selectOneClassroomPos(classroomid);
			if (classroom != null) {
				res.put("state", 0);
				res.put("msg", "查询信息成功！");
				res.put("data", classroom);
			} else {
				res.put("state", 100);
				res.put("msg", "查询信息失败！");
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
	 * 修改之保存数据
	 * @param classroomtype 教室类型
	 * @param classroomname 教室名
	 * @param cpozitionid 刷卡机id
	 * @param tag 备注
	 * @param classroomid 教室id
	 * @return
	 */
	public String updateOneClassroomPos(Integer classroomtype, String classroomname, int buildnumber, String tag, String classroomid,Integer tjoinnumber){
		JSONObject res = new JSONObject();
		try {
			int counts = 0;
			counts = dao.updateOneClassroomPos(classroomtype, classroomname, buildnumber, tag, classroomid,tjoinnumber);
			if (counts > 0) {
				res.put("state", 0);
				res.put("msg", "修改信息成功！");
			} else {
				res.put("state", 100);
				res.put("msg", "修改信息失败！");
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
	 * 删除教室数据（同时要删除预约） 两个删除判断？
	 * 
	 * @param classroomid 教室id 
	 * @return
	 */
	public String deleteOneClassroomPos(String classroomid){
		JSONObject res = new JSONObject();
		try {
			//删除教室信息
			int counts = 0;
			counts = dao.deleteOneClassroomPos(classroomid);
			//删除预约信息
			int count = 0;
			count = dao.deleteOneClassroomCall(classroomid);
			if (counts > 0) {
				res.put("state", 0);
				res.put("msg", "删除信息成功！");
				System.out.println(count);
			} else {
				res.put("state", 100);
				res.put("msg", "删除信息失败！");
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
