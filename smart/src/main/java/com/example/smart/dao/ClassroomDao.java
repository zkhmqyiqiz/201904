package com.example.smart.dao;

import com.example.smart.entity.Classroom;
import com.example.smart.entity.ClassroomSnap;
import com.example.smart.entity.Device;

import java.util.List;


public interface ClassroomDao {
	/**
	 * 根据教室ID 公司名查询设备信息
	 * @param classroomid 教室id 
	 * @return
	 */
	public List<Device> selectDeviceByClassroomid(String classroomid);
	
	/**
	 * 根据设备id 修改设备的教室id
	 * @param classroomid
	 * @param deviceid
	 * @return
	 */
	public int updateDeviceByDeviceid(String classroomid, String deviceid);
	
	/**
	 * 根据教室Id 查询教室详情信息
	 * @param classroomid
	 * @return
	 */
	public Classroom selectClassroomById(String classroomid);
	
	public List<Classroom> selectAllClassroom();
	public List<ClassroomSnap> selectClassroomByLike(String name);
	public List<ClassroomSnap> selectClassroomSnap(List<String> likeString);
	public Integer reportTrouble(String classroomid);
}
