package com.example.smart.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.smartschool.dao.ExamDao;
import net.smartschool.entity.Exam;
import net.smartschool.impl.ExamDaoImp;

public class ExamService {
	ExamDao dao = new ExamDaoImp();
	private static final Logger logger = LogManager.getLogger();
	public Exam selectByEdeviceIp(String IP) {
		Exam t = null;
		t = dao.selectByEdeviceIp(IP);
		logger.info("从" + this.getClass().getName() + "收到请求返回：" + t + "条exam数据");
		return t;
		
	}

}
