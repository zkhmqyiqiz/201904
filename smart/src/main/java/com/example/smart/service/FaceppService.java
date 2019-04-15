package com.example.smart.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.alibaba.fastjson.JSONObject;

import net.smartschool.dao.FaceppDao;
import net.smartschool.entity.Facepp;
import net.smartschool.impl.FaceppImpl;

public class FaceppService {
	FaceppDao dao = new FaceppImpl();
	private static final Logger logger = LogManager.getLogger();
	public String selectAllFacepp(Integer page,Integer count) {
		JSONObject res =new JSONObject();
		List<Facepp> list= new ArrayList<>();
		try {
			
			list = dao.selectAllFacepp(page, count);
			if(list.size()>0) {
				res.put("state", 0);
				res.put("msg", "查询设备成功！");
				res.put("data", list);
				
			}else {
				res.put("state", 100);
				res.put("msg", "查询设备失败！");
				
			}
		} catch (Exception e) {
			e.printStackTrace();
			res.put("state", -500);
			res.put("msg", "查询设备失败，数据库错误！");
		}
		logger.info("从"+this.getClass().getName()+"收到请求返回："+res.toString());
		return res.toString();
	}
	
	public String insertFacepp(String ip,String name,Integer port) {
		JSONObject res =new JSONObject();
		Integer list = 0;
		try {
			
			list = dao.insertFacepp(ip, name, port);
			if(list!=0) {
				res.put("state", 0);
				res.put("msg", "添加设备成功！");
				res.put("data", list);
				
			}else {
				res.put("state", 100);
				res.put("msg", "添加设备失败！");
				
			}
		} catch (Exception e) {
			e.printStackTrace();
			res.put("state", -500);
			res.put("msg", "添加设备失败，数据库错误！");
		}
		logger.info("从"+this.getClass().getName()+"收到请求返回："+res.toString());
		return res.toString();
	}
	
	public String insertFaceppByLogin(String ip, String name, Integer port, String userName, String passWord) {
		JSONObject res =new JSONObject();
		Integer list = 0;
		try {
			Facepp f =dao.selectFacepp(ip);
			if(f != null) {
				res.put("state", 100);
				res.put("msg", "该设备和端口已经存在！");
				return res.toString();
			}
			list = dao.insertFaceppByLogin(ip, name, port, userName, passWord);
			if(list!=0) {
				res.put("state", 0);
				res.put("msg", "添加设备成功！");
				res.put("data", list);
				
			}else {
				res.put("state", 100);
				res.put("msg", "添加设备失败！");
				
			}
		} catch (Exception e) {
			e.printStackTrace();
			res.put("state", -500);
			res.put("msg", "添加设备失败，数据库错误！");
		}
		logger.info("从"+this.getClass().getName()+"收到请求返回："+res.toString());
		return res.toString();
	}
	
	public String updateFacepp(String ip,String name,Integer port,String oldIp,Integer oldPort) {
		JSONObject res =new JSONObject();
		Integer list = 0;
		try {
			
			list = dao.updateFacepp(ip, name, port, oldIp, oldPort);
			if(list!=0) {
				res.put("state", 0);
				res.put("msg", "修改设备成功！");
				res.put("data", list);
				
			}else {
				res.put("state", 100);
				res.put("msg", "修改设备失败！");
				
			}
		} catch (Exception e) {
			e.printStackTrace();
			res.put("state", -500);
			res.put("msg", "修改设备失败，数据库错误！");
		}
		logger.info("从"+this.getClass().getName()+"收到请求返回："+res.toString());
		return res.toString();
	}
	
	
	public String updateFaceppByLogin(String ip, String name, Integer port, String userName, String passWord) {
		JSONObject res =new JSONObject();
		Integer list = 0;
		try {
			
			list = dao.updateFaceppByLogin(ip, name, port, userName, passWord);
			if(list!=0) {
				res.put("state", 0);
				res.put("msg", "修改设备成功！");
				res.put("data", list);
				
			}else {
				res.put("state", 100);
				res.put("msg", "修改设备失败！");
				
			}
		} catch (Exception e) {
			e.printStackTrace();
			res.put("state", -500);
			res.put("msg", "修改设备失败，数据库错误！");
		}
		logger.info("从"+this.getClass().getName()+"收到请求返回："+res.toString());
		return res.toString();
	}
	
	public String deleteFacepp(String ip,Integer port) {
		JSONObject res =new JSONObject();
		Integer list = 0;
		try {
			
			list = dao.deleteFacepp(ip, port);
			if(list!=0) {
				res.put("state", 0);
				res.put("msg", "删除设备成功！");
				res.put("data", list);
				
			}else {
				res.put("state", 100);
				res.put("msg", "删除设备失败！");
				
			}
		} catch (Exception e) {
			e.printStackTrace();
			res.put("state", -500);
			res.put("msg", "删除设备失败，数据库错误！");
		}
		logger.info("从"+this.getClass().getName()+"收到请求返回："+res.toString());
		return res.toString();
	}

	public String selectFacepp(String ip, Integer port) {
		JSONObject res =new JSONObject();
		Facepp list = null;
		try {
			
			list = dao.selectFacepp(ip);
			if(list!=null) {
				res.put("state", 0);
				res.put("msg", "查询设备成功！");
				res.put("data", list);
				
			}else {
				res.put("state", 100);
				res.put("msg", "查询设备失败！");
				
			}
		} catch (Exception e) {
			e.printStackTrace();
			res.put("state", -500);
			res.put("msg", "查询设备失败，数据库错误！");
		}
		return res.toString();
	}
	
	public String updatetoSmartclass(String ip, Integer port,String sclass) {
		JSONObject res =new JSONObject();
		Integer list = 0;
		try {
			
			list = dao.updatetoSmartclass(ip, port, sclass);
			if(list!=0) {
				res.put("state", 0);
				res.put("msg", "修改设备成功！");
				res.put("data", list);
				
			}else {
				res.put("state", 100);
				res.put("msg", "修改设备失败！");
				
			}
		} catch (Exception e) {
			e.printStackTrace();
			res.put("state", -500);
			res.put("msg", "修改设备失败，数据库错误！");
		}
		logger.info("从"+this.getClass().getName()+"收到请求返回："+res.toString());
		return res.toString();
	}
}
