package com.example.smart.dao;

import java.util.List;

import com.example.smart.entity.LessonuseNote;
import com.example.smart.entity.TeamWeekFestivals;
import com.example.smart.entity.WeekCourse;
import org.apache.ibatis.annotations.Param;



public interface LessonuseDao {
	/**
	 * 查询所有的课表
	 * 
	 * @param page  从那条数据显示
	 * @param count 一页显示多少条数据
	 * @return
	 */
	public List<LessonuseNote> selectLessonuse(int page, int count);

	/**
	 * 查询总页数
	 * 
	 * @return
	 */
	public int selectCount();

	/**
	 * 课程名称模糊查询。
	 * 
	 * @param userid 课程名称（以前是根据useid(老师的编号)查询，现在根据课程名模糊查询）
	 * @param page   从那条数据显示
	 * @param count  一页显示多少条数据
	 * @return
	 */
	public List<LessonuseNote> selectLessonuseByUserid(@Param("userid") String userid, int page, int count);

	/**
	 * 根据条件查询总条数
	 * 
	 * @param userid 用户名
	 * @return
	 */
	public int selectLessonuseByUseridCount(@Param("userid") String userid);

	/**
	 * 根据curriculumid删除对应的数据
	 * 
	 * @param curriculumid
	 */
	public int deleteLessonUseById(Long curriculumid);

	/**
	 * 根据当前时间查询学年学期号、周次、星期、节次、开始时间、结束时间
	 */
	public TeamWeekFestivals selectWeekCourse();
	
	/**
	 * 根据当前时间查询学年学期号、周次、星期
	 */
	public TeamWeekFestivals selectWeekCourseZC();
	
	/**
	 * 根据学年学期号，查询本学期最大的课程节次
	 * @param xnxqh
	 */
	public int selectWeekCourseJC(String xnxqh);
	
	/**
	 * 根据老师编号、学年学期号、周次查询该老师在本周的课程
	 * @param userid
	 * @param xnxqh
	 * @param zc
	 * @param page
	 * @param count
	 */
	public List<WeekCourse> selectWeekCourseTeach(String userid, String xnxqh, Integer zc, Integer page, Integer count);
	
	/**
	 * 根据老师编号、学年学期号、周次查询该老师在本周的课程总数
	 * @param userid
	 * @param xnxqh
	 * @param zc
	 */
	public int selectWeekCourseCount(String userid, String xnxqh, Integer zc);
	/**
	 * 根据本月该老师共有那些课并分页
	 * @param userid
	 * @param xnxqh
	 * @param page
	 * @param count
	 */
	public List<WeekCourse> selectMonthCourse(String userid, String xnxqh, Integer page, Integer count);
	
	/**
	 * 查询本学期本月该老师共有多少课程
	 * @param userid
	 * @param xnxqh
	 */
	public int selectMonthCourseCount(String userid, String xnxqh);
	
	/**
	 * 根据本学期该老师共有那些课并分页
	 * @param userid
	 * @param xnxqh
	 * @param page
	 * @param count
	 */
	public List<WeekCourse> selectSemesterCourse(String userid, String xnxqh, Integer page, Integer count);
	
	/**
	 * 查询本学期该老师共有多少课程
	 * @param userid
	 * @param xnxqh
	 */
	public int selectSemesterCourseCount(String userid, String xnxqh);
	
	/**
	 * 根据本日该老师共有那些课并分页
	 * @param userid
	 * @param xnxqh
	 * @param page
	 * @param count
	 */
	public List<WeekCourse> selectDayCourse(String userid, String xnxqh, Integer page, Integer count);
	
	/**
	 * 查询本日该老师共有多少课程
	 * @param userid
	 * @param xnxqh
	 */
	public int selectDayCourseCount(String userid, String xnxqh);
	
	
	public List<WeekCourse> selectWeekCourseStat(String userid, String xnxqh, Integer zc);
	public List<WeekCourse> selectMonthCourseStat(String userid, String xnxqh);
	public List<WeekCourse> selectSemesterCourseStat(String userid, String xnxqh);
	
}
