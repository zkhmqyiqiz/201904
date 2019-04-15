package com.example.smart.dao;

import com.example.smart.entity.Lessonuse;
import com.example.smart.entity.SignInLog;

import java.util.Date;
import java.util.List;

public interface UserToLessonDao {
	public List<SignInLog> selectUserToLesson(Long curriculumid);//查询某门课程已签到的人
	public List<SignInLog> selectUserToLessonNotTickup(Long curriculumid);//查询某门课程所有的人
	public List<SignInLog> selectStudentListInOneLesson(Long curriculumid);//查询某门课程所有的人
	public Lessonuse selectSignLesson(String IP);//查询某节课的课堂号
	public SignInLog selectTickupStudent(Long curriculumid, String userid);//查询当前课程中是否存在这个学生
	/**
	 * @author ZHANKUN
	 * @Version 2019-03-07
	   * 功能描述: 通过教室ID查询当前时间，在这个教室即将要上的课堂ID或者即将要上的某节课的课堂ID
	 * @param classroomid 教室ID
	 * return 
	 * 返回参数：返回值为Lessonuse对象，但只有curriculumid有值*/
	public Lessonuse selectSignLessonbyClassroomids(String classroomid);//查询某节课的课堂号
	
	/**
	 * @author ZHANKUN
	 * @Version 2019-03-07
	   * 功能描述: 通过教室ID查询当前时间，在这个教室即将要上的课堂ID或者即将要上的某节课的课堂ID
	 * @param classroomid 教室ID
	 * @param time 日期，2018-10-11
	 * @param lessonjc 节次
	 * return 
	 * 返回参数：返回值为Lessonuse对象，但只有curriculumid有值*/
	public Lessonuse selecthSignLesson(String classroomid, Date time, int lessonjc);//查询某节课的课堂号
	
	
	/**
	 * @author ZHANKUN
	 * @Version 2019-03-07
	   * 功能描述: 通过课堂ID、日期（单位为天），查询某节课的所有签到学生信息
	 * @param curriculumid 课堂ID
	 * @param time 日期，2018-10-11
	 * return 
	 * 返回参数：返回值为Lessonuse对象，但只有curriculumid有值*/
	public List<SignInLog> selecthUserToLesson(Long curriculumid, Date time);//查询某节课的课堂号

}
