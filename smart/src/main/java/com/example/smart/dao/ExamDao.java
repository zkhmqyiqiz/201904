package com.example.smart.dao;


import com.example.smart.entity.Exam;

public interface ExamDao {
	//根据设备IP查询距离当前时间最近的一次考试的相关信息
	public Exam selectByEdeviceIp(String IP);

}
