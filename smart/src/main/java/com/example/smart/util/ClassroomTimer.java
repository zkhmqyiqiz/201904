package com.example.smart.util;

import java.util.Date;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import net.smartschool.service.ClassroomTimeService;

public class ClassroomTimer {
	//这个全局map用于保存时间
	private static Map<String,Long> ClassroomTimeMap = new ConcurrentHashMap<>();
	private static ClassroomTimeService service = new ClassroomTimeService();
	
	public static boolean finalize(String mainctlip) {
		if(mainctlip == null)
			throw new NullPointerException("传入计时用的教室ID不能为null");
		Long time = ClassroomTimeMap.get(mainctlip);
		if(time != null) {
			try {
				String res = service.insertTimeByMainctlip(mainctlip, (int)((new Date().getTime() - time) / 1000));
			} catch (Exception e) {
				return false;
			}
			ClassroomTimeMap.remove(mainctlip);
			return true;
		} else {
			return false;
		}
	}
	
	public static void start(String mainctlip) {
		if(mainctlip == null)
			throw new NullPointerException("传入计时用的教室ID不能为null");
		if(ClassroomTimeMap.containsKey(mainctlip))
			return;
		ClassroomTimeMap.put(mainctlip,new Date().getTime());
	}
	
	public static boolean have(String mainctlip) {
		if(ClassroomTimeMap.get(mainctlip) != null) {
			return true;
		} else {
			return false;
		}
	}
}
