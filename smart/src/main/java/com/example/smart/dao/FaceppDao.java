package com.example.smart.dao;

import com.example.smart.entity.Facepp;
import com.example.smart.entity.FaceppUser;

import java.util.List;



public interface FaceppDao {
	public int insertFacepp(String ip, String name, Integer port);
	public int insertFaceppByLogin(String ip, String name, Integer port, String userName, String passWord);//人脸识别设备中添加登录名和密码
	public int updateFacepp(String ip, String name, Integer port, String oldIp, Integer oldPort);
	public int updateFaceppByLogin(String ip, String name, Integer port, String userName, String passWord);
	public int deleteFacepp(String ip, Integer port);
	public List<Facepp> selectAllFacepp(Integer page, Integer count);
	//public 
	public Facepp selectFacepp(String ip);
	public int updatetoSmartclass(String ip, Integer port, String sclass);
	//通过req的班牌ip查询电子设备表，获得人脸识别设备ip，再获得用户名和密码
	public FaceppUser selectFaceppByEdeviceip(String ip);
	
}
