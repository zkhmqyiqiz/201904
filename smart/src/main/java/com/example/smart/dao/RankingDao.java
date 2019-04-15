package com.example.smart.dao;

import com.example.smart.entity.Lessonuse;
import com.example.smart.entity.Ranking;
import com.example.smart.entity.Tickup;

import java.util.List;



public interface RankingDao {
	public List<Ranking> selectGoodRanking(String userid, String lessonid, int count);
	public List<Ranking> selectBadRanking(String userid, String lessonid, int count);
	/**
	 * 根据学年学期号，连表查询学生ID userid 和课程ID lessonid
	 * @param xnxqh 学年学期号
	 * @param page
	 * @param count
	 * */
	public List<Lessonuse> selectTStudentCheck(String xnxqh, Integer page, Integer count);
	
	/**
	 * 根据学年学期号，查询数据总量
	 * @param xnxqh 学年学期号*/
	public int selectTStudentCheckCount(String xnxqh);
	/**
	 * 根据课程ID和学生ID查询学生要上的课堂相关信息
	 * @param lessonid 课程ID
	 * @param userid 学生ID*/
	public List<Lessonuse> selectLessonuseStudentCheck(Integer lessonid, String userid);
	
	/**
	 * 根据课堂ID和学生ID查询学生签到信息
	 * @param curriculumid 课堂ID
	 * @param userid 学生ID*/
	public List<Tickup> selectTickupStudentCheck(String userid, Long curriculumid);
	
	/**
	 * 根据学年学期号、星期、周次查询今天所有要上的课程（lessonid）、学生ID
	 * @param xnxqh 学年学期号
	 * @param week 星期
	 * @param zc 周次
	 * return lessonid ,userid(学生) 两个字段组成的对象的数据*/
	public List<Lessonuse> selectTodayToStudentAndLesson(String xnxqh, Integer week, Integer zc);
	
	/**
	 * 根据学年学期号、星期、周次查询今天所有要上的课程（lessonID）、学生的ID、老师的ID、课堂ID(curriculumid)、起始周、结束周、学年学期号
	 * @param xnxqh 学年学期号
	 * @param week 星期
	 * @param zc 周次
	 * return lessonid ,userid(学生) 、userid(老师)、curriculumid、weekstart、weekend、xnxqh等字段组成的对象的数据*/
	public List<Lessonuse> selectTodayCurriculumid(String xnxqh, Integer week, Integer zc);
	
	/**
	 * 根据学年学期号、星期、周次查询今天所有要上的课程中每一个学生累计签到次数以及迟到次数
	 * @param xnxqh 学年学期号
	 * @param week 星期
	 * @param zc 周次
	 * return count ,userid(学生) 、curriculumid、tickuptype、success等字段组成的对象的数据*/
	public List<Tickup> selectTickUpAllStatus(String xnxqh, Integer week, Integer zc);
	
	/**
	 * 插入学生考勤信息*/
	public int insertStudentCheck(String userid, Integer lessonid, String xnxqh, String teacherid, Integer alreadyclass, Integer late, Float attendance, Integer absence);
}
