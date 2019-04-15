package com.example.smart.dao;

import com.example.smart.entity.Check;

import java.util.List;

public interface CheckDao {
	/**
	 * 根据curriculumid和周次查询当前课堂的考勤信息
	 * 
	 * @param curriculumid  课堂ID
	 * @param zc 周次
	 * @return
	 */
	public Check selectCourseCheck(Long curriculumid, Integer zc);
	
	/**
	 * 根据userid和周次、学年学期号查询该老师本学期本周的考勤信息
	 * 
	 * @param userid  老师编号
	 * @param xnxqh  学年学期号
	 * @param zc 周次
	 * @param page 当前是第几页
	 * @param count 一页显示多少条数据
	 * @return
	 */
	public List<Check> selectWeekCheck(String userid, String xnxqh, Integer zc, Integer page, Integer count);
	
	/**
	 * 根据userid和周次、学年学期号查询该老师本学期本周的考勤信息总量
	 * 
	 * @param userid  老师编号
	 * @param xnxqh  学年学期号
	 * @param zc 周次
	 * @return
	 */
	public int selectWeekCheckCount(String userid, String xnxqh, Integer zc);
	
	/**
	 * 根据userid和周次、学年学期号查询该老师本学期本月的考勤信息
	 * 
	 * @param userid  老师编号
	 * @param xnxqh  学年学期号
	 * @param page 当前是第几页
	 * @param count 一页显示多少条数据
	 * @return
	 */
	public List<Check> selectMonthCheck(String userid, String xnxqh, Integer page, Integer count);
	
	/**
	 * 根据userid和周次、学年学期号查询该老师本学期本月的考勤信息总量
	 * 
	 * @param userid  老师编号
	 * @param xnxqh  学年学期号
	 * @return
	 */
	public int selectMonthCheckCount(String userid, String xnxqh);
	
	/**
	 * 根据userid和周次、学年学期号查询该老师本学期考勤信息
	 * 
	 * @param userid  老师编号
	 * @param xnxqh  学年学期号
	 * @param page 当前是第几页
	 * @param count 一页显示多少条数据
	 * @return
	 */
	public List<Check> selectSemesterCheck(String userid, String xnxqh, Integer page, Integer count);
	
	/**
	 * 根据userid和周次、学年学期号查询该老师本学期考勤信息总量
	 * 
	 * @param userid  老师编号
	 * @param xnxqh  学年学期号
	 * @return
	 */
	public int selectSemesterCheckCount(String userid, String xnxqh);
	
	
	/**
	 * 根据星期和周次、学年学期号今天需要插入的所有课堂的考勤信息
	 * 
	 * @param week  星期
	 * @param xnxqh  学年学期号
	 * @param zc     周次
	 * @param page 当前是第几页
	 * @param count 一页显示多少条数据
	 * @return
	 */
	public List<Check> selectbatchInsertCheck(Integer week, String xnxqh, Integer zc, Integer page, Integer count);
	
	/**
	 * 根据星期和周次、学年学期号今天需要插入的所有课堂的总数
	 * @param week  星期
	 * @param xnxqh  学年学期号
	 * @param zc     周次
	 * @return
	 */
	public int selectbatchInsertCheckCount(Integer week, String xnxqh, Integer zc);
	
	/**
	 * 根据课堂ID，星期，应道人数，实到人数插入相关信息到考勤表当中
	 * @param curriculumid  课堂ID
	 * @param weekid  星期
	 * @param shouldpeople     应到人数
	 * @param realpeople     实到人数
	 * @return
	 */
	public int InsertCheck(Long curriculumid, Integer weekid, Integer shouldpeople, Integer realpeople);

}
