package com.example.smart.service;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSONObject;

import net.common.util.FtpUtils;
import net.common.util.StrUtil;
import net.smartschool.dao.DeviceDao;
import net.smartschool.entity.DeviceDeviceprpNote;
import net.smartschool.impl.DeviceDaoImpl;

public class SmartschoolOutsideService {
	DeviceDao dao = new DeviceDaoImpl();
	
	@SuppressWarnings("unchecked")
	public String getClassDevices(String classroomname) {
		JSONObject res = new JSONObject();
		List<DeviceDeviceprpNote> t = dao.selectAllDeviceByClassname(classroomname);
		try {
			if (t.size() > 0) {
				res.put("state", 0);
				res.put("msg", "查询设备成功！");
				Map<String, Object> data = new LinkedHashMap<>();
				List<String> devicelist = new LinkedList<>();
				for (DeviceDeviceprpNote d : t) {
					devicelist.add(d.getDevicename());
				}
				devicelist = StrUtil.removeDuplicate(devicelist);
				for (String temp : devicelist) {
					data.put(FtpUtils.getProperties("devicegb.properties", temp), new LinkedList<>());
				}
				for (DeviceDeviceprpNote d : t) {
					String devicename = FtpUtils.getProperties("devicegb.properties", d.getDevicename());
					for(String temp:data.keySet()) {
						if(devicename==temp) {
							List<DeviceDeviceprpNote> list = (List<DeviceDeviceprpNote>) data.get(temp);
							list.add(d);
							data.replace(temp, list);
						}
					}
				}
				//TODO
				res.put("data", data);
			} else {
				res.put("state", 100);
				res.put("msg", "查询设备失败！");
			} 
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			res.put("state", -500);
			res.put("msg", "数据库错误！");
		}
		return res.toString();
	}
}
