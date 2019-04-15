package com.example.smart.service;

import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.junit.Test;

import com.alibaba.fastjson.JSONObject;

import net.smartschool.dao.ClassroomTimeDao;
import net.smartschool.dao.ElectricDeviceDao;
import net.smartschool.entity.ElectricDevice;
import net.smartschool.impl.ClassroomTimeDaoImpl;
import net.smartschool.impl.ElectricDeviceImpl;

public class ClassroomTimeService {
	ClassroomTimeDao dao = new ClassroomTimeDaoImpl();
	ElectricDeviceDao edao = new ElectricDeviceImpl();

	public String insertTimeByMainctlip(String ip, Integer time) {
		JSONObject res = new JSONObject();
		List<ElectricDevice> list = edao.selectDeviceByType(0, 9999);
		String classroomid = null;
		for (ElectricDevice one : list) {
			try {
				Document d = DocumentHelper.parseText(one.getXml());
				String mainctlip = d.getRootElement().element("captures").elements().get(0).attributeValue("mainctlip");
				if (ip.equals(mainctlip))
					classroomid = one.getClassroomid();
			} catch (Exception e) {
				System.out.println("unsupported xml,give up.ip=" + one.getEdeviceip()+"Exception="+e.getLocalizedMessage());
			}
		}
		if (classroomid != null) {
			int i = dao.insertTimeByClassroomid(classroomid, time);
			try {
				if (i > 0) {
					res.put("state", 0);
					res.put("msg", "添加时间成功");
				} else {
					res.put("state", 100);
					res.put("msg", "添加时间失败");
				}
			} catch (Exception e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
				res.put("state", -500);
				res.put("msg", "数据库错误");
			}
		} else {
			res.put("state", 300);
			res.put("msg", "中控没有绑定教室");
		}
		return res.toString();
	}
	public String selectClassroomidByMainip(String ip) {
		JSONObject res = new JSONObject();
		List<ElectricDevice> list = edao.selectDeviceByType(0, 9999);
		String classroomid = null;
		for (ElectricDevice one : list) {
			try {
				Document d = DocumentHelper.parseText(one.getXml());
				String mainctlip = d.getRootElement().element("captures").elements().get(0).attributeValue("mainctlip");
				if (ip.equals(mainctlip))
					classroomid = one.getClassroomid();
			} catch (Exception e) {
				System.out.println("unsupported xml,give up.ip=" + one.getEdeviceip()+"Exception="+e.getLocalizedMessage());
			}
		}
		return classroomid;
	}
}
