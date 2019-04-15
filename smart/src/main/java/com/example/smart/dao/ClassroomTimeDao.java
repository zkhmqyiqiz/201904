package com.example.smart.dao;

import org.apache.ibatis.annotations.Insert;

public interface ClassroomTimeDao {
	@Insert("insert classroomusetime values(#{0},NOW(),#{1})")
	public int insertTimeByClassroomid(String classroomid, Integer time);
}
