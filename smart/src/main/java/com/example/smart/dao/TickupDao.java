package com.example.smart.dao;

import java.util.List;

import com.example.smart.entity.SignInLog;
import com.example.smart.entity.Tickup;
import org.apache.ibatis.annotations.Param;



public interface TickupDao {
	/**
	 * 查询所有的签到记录。
	 * @param --company 公司名
	 * @param page  起始页数
	 * @param count  每页显示的条数
	 * @param days  days==2时查询当天的数据
	 * @return
	 */
	public List<Tickup> selectAllTickup(int page, int count, @Param("days") int days);
	
	public List<Tickup> selectTodayTickup(int page, int count, @Param("days") int days);
	
	/**
	 * 查询所有的签到记录
	 * @param --company
	 * @param days  days==2时查询当天的数据
	 * @return
	 */
	public int selectAllCounts(@Param("days") int days);
	
	public int selectTodayCounts(@Param("days") int days);
	
	/**
	 * 添加签到记录
	 * @param userid
	 * @param weekid
	 * @param curriculumid
	 * @param success
	 * @param tickuptype
	 * @return
	 */
	public int addTickup(String userid, int weekid, long curriculumid, int success, int tickuptype);
	
	/**
	 * 根据课堂id查询当前时间是否在课程开始之后
	 * @param curriculumid 课堂ID
	 * @return
	 */
	public int selectTickupStatus(long curriculumid);
	
	/**
	 * 根据课堂ID和签到人ID以及当天时间，查询该人是否已经在之前签到过了
	 * @param curriculumid 课堂ID
	 * @param userid 签到人的ID
	 * @return
	 */
	public int selectTickupExist(long curriculumid, String userid);
	public int selectTickCountByScanning(long tempcurriculumid, int zc);
	public List<SignInLog> selectScanTickup(long tempcurriculumid, Integer zc, int tickuptype);
}
