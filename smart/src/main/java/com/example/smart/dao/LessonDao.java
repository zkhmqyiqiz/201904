package com.example.smart.dao;

import java.util.List;

import com.example.smart.entity.*;
import org.apache.ibatis.annotations.Param;




public interface LessonDao {
	/**
	 * 根据设备查询当天的课程
	 * @param edeviceip 电子设备IP
	 * @param week 星期
	 * @param xnxqh 学年学期号
	 * @param zc 周次
	 * */
	public List<LessonBatchNew> selectLessonByIp(String edeviceip, Integer week, String xnxqh, Integer zc);

	/**
	 * 根据老师刷卡或刷脸查询当天的课程
	 * @param userid 老师的编号
	 * @param week 星期
	 * @param xnxqh 学年学期号
	 * @param zc 周次
	 * */
	public List<LessonBatchNew> selectLessonByIpToTeacherCard(String userid, Integer week, String xnxqh, Integer zc);
	
	/**
	 * 学生刷卡或者刷脸查询当天的课程
	 * @param userid 学生的编号
	 * @param week 星期
	 * @param xnxqh 学年学期号
	 * @param zc 周次
	 *  */
	public List<LessonBatchNew> selectStudentLessonByIp(String userid, Integer week, String xnxqh, Integer zc);
	
	/**
	 * 学生刷卡或者刷脸查询当前课程
	 * @param userid 学生的编号
	 * @param week 星期
	 * @param xnxqh 学年学期号
	 * @param zc 周次
	 *  */
	public List<LessonBatchNew> selectStudentLessonByIp2(String userid, Integer week, String xnxqh, Integer zc);
	
	/**
	 * 根据设备查询当前的课程
	 * @param edeviceip 电子设备IP
	 * @param week 星期
	 * @param xnxqh 学年学期号
	 * @param zc 周次
	 *  */
	public List<LessonBatchNew> selectLessonByIp2(String edeviceip, Integer week, String xnxqh, Integer zc);
		
	
	/**
	 * //根据老师刷卡或刷脸查询当前的课程
	 * @param userid 老师的编号
	 * @param week 星期
	 * @param xnxqh 学年学期号
	 * @param zc 周次
	 *  */
	public List<LessonBatchNew> selectLessonByIp2ToTeacherCard(String userid, Integer week, String xnxqh, Integer zc);
	/**
	 * 判断是否是临时课程，若查不到则是临时课程
	 * @param userid
	 * @param week
	 * @param xnxqh
	 * @param zc
	 * @return
	 */
	public LessonBatchNew selectForiclassStart(String userid, Integer week, String xnxqh, Integer zc);
	/**
	 * 插入课堂信息表
	 */
	public int insertIntoAttendclass(AttendClass attendClass);
	
	public int insertIntoTempcurriculum(TempCurriculum tempCurriculum);
	public TempCurriculum selectFromTempcurriculum(String userid, String classroomid);
	/**
	 * //根据设备查询下一节课程（比如说当前为07，那么查询的是08，而不是最近的要上的一节课）
	 * @param edeviceip 电子设备IP
	 *  */
	public List<LessonBatchNew> selectLessonByIpForNext(String edeviceip, Integer week, String xnxqh, Integer zc);
	
	/**
	 * //根据学生刷脸查询下一节课
	 * @param userid 学生编号
	 *  */
	public List<LessonBatchNew> selectStudentLessonByIpForNext(String userid, Integer week, String xnxqh, Integer zc);
	
	/**
	 * 通过课程id删除对应的数据
	 * @param lessonid
	 * @return
	 */
	public int deleteLessonById(Integer lessonid);
	
	/**
	 * 查询所有课程分页显示
	 * @param page 那条数据显示
	 * @param count 显示条数
	 * @return
	 */
	public List<Lesson> selectLesson(int page, int count);
	
	/**
	 * 查询总条数
	 * @return
	 */
	public int selectLessonCount();
	
	/**
	 * 通过公司名 ，课程名， 开始时间，结束时间
	 * @param  lessonname
	 * @param --start
	 * @param --end
	 * @return
	 */
	
	public List<Lesson> selectLessonByLessonname(@Param("lessonname") String lessonname, int page, int count);
	
	
	/**
	 * 根据条件查询条数
	 * @param lessonname 课程名
	 * @param --start 开始时间
	 * @param --end 结束时间
	 * @param --userid 用户名
	 * @return
	 */
	public int selectLessonCountByLessonname(@Param("lessonname") String lessonname);
	public LessonBatchNew selectLessonByClassroomId(String classroomid, Integer week, String xnxqh, Integer zc);	
	
	
	/**
	 * @author ZHANKUN
	 * Version 2019-03-07
	 * 功能描述：根据教室ID和当前时间查询临时课表中的临时课
	 * 根据条件查询条数
	 * @param classroomid 教室ID
	 * @return
	 * 返回值：TempCurriculum对象
	 */
	public TempCurriculum selectTempcurriculumByID(String classroomid);
	
	public List<SynchronizationLessonA> synchronizationlesson(String IP);
	
}
