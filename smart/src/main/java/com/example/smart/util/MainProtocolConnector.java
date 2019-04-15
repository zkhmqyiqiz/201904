package com.example.smart.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Map;

import com.alibaba.fastjson.JSONObject;

import net.smartschool.entity.Terminal;
import net.smartschool.entity.TerminalTime;

/**
 * 地质大学-HTTP连接类
 * 
 * @author Yangdi
 * @since 201904
 */
public class MainProtocolConnector {
	private String url;

	public MainProtocolConnector() {
		super();
	}

	// 初始化URL
	public MainProtocolConnector(String ip, Integer port) {
		super();
		this.url = "http://" + ip + ":" + port + "/";
	}

	// 替换或初始化URL
	public MainProtocolConnector init(String ip, Integer port) {
		this.url = "http://" + ip + ":" + port + "/";
		return this;
	}

	// 获取中控时间参数
	public TerminalTime getDeviceTime() {
		TerminalTime t = null;
		JSONObject json = new JSONObject();
		String res = HttpClientUtil.httpGetRequest(this.url + "DEVICETIME?READ=1");
		try {
			json = JSONObject.parseObject(res);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		if (json.getBooleanValue("success") == false) {
			System.out.println(json);
			return null;
		}
		try {
			t = new TerminalTime(json.getBooleanValue("success"),
					new SimpleDateFormat("yyyy-MM-dd HH:mm").parse(json.getString("StartTime")),
					json.getInteger("Projector_OpenTime"), json.getInteger("FPD_OpenTime"),
					json.getInteger("Record_OpenTime"), json.getInteger("Lesson_OpenTime"));
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}
		return t;
	}

	// 设置设备状态
	public Boolean setTerminalStatus(Map<String, Object> params) {
		JSONObject json = new JSONObject();
		String res = null;
		try {
			res = HttpClientUtil.httpGetRequest(this.url + "TERMINAL_STATUS", params);
			json = JSONObject.parseObject(res);
			if (!json.containsValue(true)) {
				return false;
			}
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	// 获取设备状态
	public Terminal getAllstatus() {
		Terminal t = null;
		JSONObject json = new JSONObject();
		String res = HttpClientUtil.httpGetRequest(this.url + "ALL_STATUS");
		try {
			json = JSONObject.parseObject(res);
		} catch (Exception e) {
			return null;
		}
		if (json.getBooleanValue("success") == false) {
			return null;
		}
		t = new Terminal(null, null, null, null, null, null, null, null, json.getBooleanValue("success"),
				json.getString("TerminalId"), json.getBooleanValue("AC_relay1"), json.getBooleanValue("Lock_Status"),
				json.getBooleanValue("Lock_ACT"), json.getBooleanValue("Computer_Status"),
				json.getBooleanValue("System"), json.getBooleanValue("Projector"), json.getString("Projection_Screen"),
				json.getString("Computer_Signal"), json.getString("Projection_Signal"), json.getBooleanValue("Volume"),
				json.getString("Computer_Control"), json.getString("Opereate_Last"), json.getBooleanValue("LAN1"),
				json.getBooleanValue("LAN2"), json.getBooleanValue("LAN3"), json.getBooleanValue("LAN4"),
				json.getBooleanValue("Alarm_Control"), json.getBooleanValue("DC_Relay2"),
				json.getBooleanValue("Door_Status"), json.getBooleanValue("OC1"), json.getBooleanValue("Alarm_In1"),
				json.getBooleanValue("Alarm_In2"), json.getBooleanValue("FPD"), json.getBooleanValue("Record"),
				json.getBooleanValue("Curtain"), json.getBooleanValue("Lamp"), json.getBooleanValue("Large_Screen"),
				json.getBooleanValue("AirConditioner"), json.getString("Temperature"), json.getString("Humidity"),
				json.getString("Voltage"), json.getString("PowerRate"), json.getString("IN_STATUS1"),
				json.getString("IN_STATUS2"), json.getString("IN_STATUS3"), json.getString("now"));
		return t;
	}
}
