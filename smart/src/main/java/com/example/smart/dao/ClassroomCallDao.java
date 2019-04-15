package com.example.smart.dao;

import java.util.Date;
import java.util.List;

import com.example.smart.entity.Classroom;
import com.example.smart.entity.ClassroomCallNote;
import com.example.smart.entity.ClassroomUsed;
import org.apache.ibatis.annotations.Param;



public interface ClassroomCallDao {
	/**
	  * 通过公司名 查询所有并分页
	 * @param page
	 * @param count
	 * @return
	 */
	public List<ClassroomCallNote> selectClassroomCall(int page, int count);
	/**
	 * 通过预约主题，用户名，开始时间，结束时间查询（预约主题，用户名是模糊查询）
	 * @param page  页数
	 * @param count 显示数
	 * @param pstart  开始时间
	 * @param pend  终止时间
	 * @param calltheme 预约 主题
	 * @param userid 用户名
	 * @return
	 */
	
	public List<ClassroomCallNote> selectAllCall(int page, int count, @Param("pstart") Date pstart, @Param("pend") Date pend, @Param("calltheme") String calltheme, @Param("userid") String userid) ;
	/**
	 * 查询所有的教室信息
	 * @return
	 */
	public List<Classroom> selectAllClassroom();
	/**
	 * 添加预约 
	 * @param userid 用户名
	 * @param callstart 预约开始时间
	 * @param callend 预约结束时间	
	 * @param calltype 预约类型
	 * @param peoplecount 人数
	 * @param calltheme 预约主题
	 * @param classroomid 教室id
	 * @return
	 */
	public int addCall(String userid, Date callstart, Date callend, String calltype, int peoplecount, String calltheme, String classroomid, Date calltime) ;
	/**
	 * 修改之通过预约id查询数据
	 * @param callid 预约id
	 * @return
	 */
	public ClassroomCallNote selectOneCallById(int callid);
	
	/**
	 * 根据预约id修改预约
	 * @param callid 预约id
	 * @param --userid 用户名
	 * @param callstart 预约开始时间
	 * @param callend 预约结束时间
	 * @param calltype 预约类型
	 * @param peoplecount 人数
	 * @param calltheme 预约主题
	 * @param --classroomid  教室id
	 * @param calltime  预约发起时间
	 * @return
	 */
	public  int updateCall(int callid, Date callstart, Date callend, String calltype, int peoplecount, String calltheme, Date calltime);
	
	
	/**
	 * 通过预约id删除预约
	 * @param callid 预约id
	 * @return
	 */
	public int deleteCall(int callid) ;
	
	/**
	 * 查询总条数
	 * @return
	 */
	public int selectClassroomCount();
	
	/**
	 * 通过预约主题，用户名，开始时间，结束时间查询总页数（预约主题，用户名是模糊查询）
	 * @param pstart  开始时间
	 * @param pend  终止时间
	 * @param calltheme 预约 主题
	 * @param userid 用户名
	 * @return
	 */
	public int selectClassroomCountByCalltheme(@Param("pstart") Date pstart, @Param("pend") Date pend, @Param("calltheme") String calltheme, @Param("userid") String userid);
	/**
	  *   查询教室使用情况
	 * @return
	 */
	public List<ClassroomUsed> selectClassroomUsed(String xnxqh, int zc, int jc, int page, int count);
	
	
}
