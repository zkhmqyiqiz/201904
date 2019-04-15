package com.example.smart.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimerTask;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.smartschool.service.CheckService;
import net.smartschool.service.RankingService;


public class TimerImportData extends TimerTask{

	private static final Logger logger = LogManager.getLogger();
	
	public static void exportData() {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
		System.out.println("执行时间"+df.format(new Date()));// new Date()为获取当前系统时间
		long l1 = System.currentTimeMillis();
		CheckService service = new CheckService();
 		service.InsertCheck(1,1000);
 		RankingService  rankingService = new RankingService();
 		rankingService.InsertStudentCheck(1, 5000);
		long l2 = System.currentTimeMillis();
		System.out.println("执行后"+df.format(new Date()));// new Date()为获取当前系统时间
		System.out.println("历时"+(l2-l1));
		logger.info("");
		
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		exportData();
	}
}
