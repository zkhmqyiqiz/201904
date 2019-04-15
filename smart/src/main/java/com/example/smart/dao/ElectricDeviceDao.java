package com.example.smart.dao;

import com.example.smart.entity.ClassName;
import com.example.smart.entity.DeviceNote;
import com.example.smart.entity.ElectricDevice;
import com.example.smart.entity.User;

import java.util.List;



public interface ElectricDeviceDao {
   public int insertEDevice(String edeviceip, String edevicename, String classroomid, String ip);
   public int insertEDeviceByPandect(String edeviceip, String edevicename, String classroomid);
   
   public int selectDeviceByIP(String edeviceip);
   
   public List<ElectricDevice> selectEDevice();
   /**
    * 通过ip 删除 信息
    * @param edeviceip
    * @return
    */
   public int deleteDeviceByIp(String edeviceip);
   public int deleteElectricDeviceList(List<String> list);
   
   public int updateDeviceByIp(String classroomid, String edevicename, String edeviceip, String ip);
   
   public String selectXmlById(String classroomid, int type);
   
   public String selectXmlByIp(String edeviceip);
   
   public String selectVideoByIp(String edeviceip);
   
   public int updateXmlById(String xml, String classroomid, int type);
   
   public int updateXmlByIp(String xml, String edeviceip);
   
   public int updateVideoByIp(String xml, String edeviceip);
   /**
	 * 通过教室id和deviceType=4查询
	 * @param --company 公司名
	 * @param classroomid 教室id
	 * @return
	 */
   public List<DeviceNote> selsetDeviceByClassID(String classroomid);
   /**
    * 通过查询curriculum,teacherlesson,classtime,lesson,electricdevice 查询curriculumid  subclass，lessonname
    * @param Ip 
    * @return
    */
   public ClassName selectDeviceByIp(String Ip);
   
   public ClassName selectDeviceByIpForNext(String Ip);
   
   public ClassName selectElectricDeviceByIp(String Ip);
   
   /**
	 * 通过type=1 查询所有的教室班牌信息，并分页
	 * @return
	 */
	public List<ElectricDevice> selectDeviceByType(int page, int count);
	
	/**
	 * 通过type的值，查询对应的内容，并分页 。比如说type=2的时候查询的是电子总览设备的信息并分页
	 * @return
	 */
	public List<ElectricDevice> selectDeviceByTypes(int page, int count, int type);
	
	public List<ElectricDevice> selectDeviceByTypeElectric(int page, int count, int type, int types);
	/**
	 * 通过type=1 查询所有的教室班牌信息的条数
	 * @return
	 */
	public int  selectDevicecount();
	
	/**
	 * 通过type的值，查询对应的数据总量 。比如说type=2的时候查询的是电子总览设备的信息总条数
	 * @return
	 */
	public int  selectDeviceCounts(int type);
	public int  selectDeviceCountsElectric(int type, int types);
	

	/**
	 * 查询所有的教室名(修改，添加操作使用)
	 * @return
	 */
	public List<ElectricDevice> selsetDeviceClass();
	
	
	/**
	 * 通过ip查询修改的一条数据
	 * @param edeviceIp ip
	 * @return
	 */
	public ElectricDevice selsetDeviceClassByIp(String edeviceIp);
	/**
	  *  通过电脑ip查询教室id
	 * @param edeviceIp
	 * @return
	 */
	public ElectricDevice selectClassroomidByComputerip(String edeviceIp);
	
	/**
	 * 通过ip修改数据
	 * @param edeviceIp IP
	 * @param edevicename 设备名
	 * @param classroomid 教室 id
	 * @param ip 人脸设备ip
	 * @return
	 */
	public int updateElectricDeviceByIP(String edeviceIp, String edevicename, String classroomid, String ip);
	/**
	 * 添加 教室班牌的数据 xml=“ ”，type=1 在 xml中写死
	 * @param edeviceIp ip
	 * @param edevicename 设备名
	 * @param classroomid 教室 id
	 * @return
	 */
	public int addElectricDeviceClass(String edeviceIp, String edevicename, String classroomid, String ip);
	
	public List<ElectricDevice> selectByClassroomidAndType(String classroomid, int type);
	
	public List<String> selectEdeviceipByFacepp(String faceppIp);
	/**
	 * 功能描述：在教室班牌中，老师刷卡进入操作界面
	 * 根据设备IP和卡号，查询当前设备所在教室的当前时间段内，对应卡号的老师的信息
	 * @param IP 设备IP
	 * @param cardid 卡号ID
	 * @return user对象*/
	public User selectByIPToUser(String IP, Long cardid);
}
