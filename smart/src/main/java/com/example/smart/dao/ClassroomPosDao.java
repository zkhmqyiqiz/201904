package com.example.smart.dao;

import com.example.smart.entity.Classroom;
import com.example.smart.entity.ClassroomNote;

import java.util.List;



public interface ClassroomPosDao {
	/**
	 * 查询所有的数据
	 * @return
	 */
	public List<ClassroomNote> selectClassroomPos(int page, int count);
	public List<ClassroomNote> selectClassroomPosByLike(String key, int page, int count);
	/**
	 * 查询总条数
	 * @return
	 */
	public int selectCounts();
	//selectCountsByLike
	public int selectCountsByLike(String key);
	/**
	 * 添加数据 
	 * @param classroomtype 教室类型
	 * @param classroomname 教室名
	 * @param buildnumber 楼栋编号
	 * @param tag 备注
	 * @return
	 */
	public int addSelectClassroomPos(Integer classroomtype, String classroomname, int buildnumber, String tag, Integer tjoinnumber);
	
	/**
	 * 根据教室ID查询修改的数据
	 * @param classroomid 教室ID
	 * @return
	 */
	public Classroom selectOneClassroomPos(String classroomid);
	/**
	 * 修改之保存数据
	 * @param classroomtype 教室类型
	 * @param classroomname 教室名
	 * @param --cpozitionid 刷卡机id
	 * @param tag 备注
	 * @param classroomid 教室id
	 * @return
	 */
	public int updateOneClassroomPos(Integer classroomtype, String classroomname, int buildnumber, String tag, String classroomid, Integer tjoinnumber);
	
	/**
	 * 删除教室数据（同时要删除预约）
	 * @param classroomid 教室id 
	 * @return
	 */
	public int deleteOneClassroomPos(String classroomid);
	
	/**
	 * 删除预约信息
	 * @param classroomid  教室id
	 * @return
	 */
	public int deleteOneClassroomCall(String classroomid);
}
