package com.example.smart.dao;

import com.example.smart.entity.AttendClass;

public interface AttendClassDao {
	
	public AttendClass selectAttendClass(int attendclassid);
	public AttendClass selectAttendClassByZC(Long curriculumid, int zc);
	
}
