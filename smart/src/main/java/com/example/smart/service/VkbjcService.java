package com.example.smart.service;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.alibaba.fastjson.JSONObject;

import net.smartschool.entity.MessageData;
import net.smartschool.entity.Vkbjc;
import net.smartschool.impl.VkbjcDaoImp;

public class VkbjcService {
	VkbjcDaoImp dao = new VkbjcDaoImp();
	private static final Logger logger = LogManager.getLogger();
	/**
	 * 查询vkbjc表中所有的数据
	 * @param 
	 * @return
	 */
	public String selectAllVkbjc() {
		JSONObject res = new JSONObject();
		try {
			List<Vkbjc> t = null; 
			t = dao.selectAllVkbjc();
			if (!(t == null)) {
				res.put("state", 0);
				res.put("msg", "查询配置成功！");
				res.put("data", t);
			} else {
				res.put("state", 100);
				res.put("msg", "查询配置失败！");
			}
		} catch (Exception e) {
			e.printStackTrace();
			res.put("state", -500);
			res.put("msg", "数据库错误！");
		}
		logger.info("从"+this.getClass().getName()+"收到请求返回："+res.toString());
		return res.toString();
	}
	
	
	/**
	 * 查询vkbjc表中所有的数据
	 * @param 
	 * @return
	 */
	public MessageData insertAndUpdateVkbjc(String tableName) {
		JSONObject res = new JSONObject();
		MessageData messageData = new MessageData();
		int updateCount = 0;//插入或者更新的总数据
		int errorCount = 0;//插入或者更新失败的总数据
		List<Vkbjc> t = dao.selectAllVkbjc();
		if (!(t == null)) {
			for (Vkbjc vkbjc : t) {
				int i=0;//用于接收插入或更新的返回值
				i = dao.insertAndUpdateVkbjc(vkbjc);
				if(i!=0) {
					updateCount = updateCount + 1;//插入或更新成功
				}else {
					errorCount = errorCount + 1;//操作失败
				}
			}
			messageData.setErrorCount(errorCount);
			messageData.setUpdateCount(updateCount);
			messageData.setTableName(tableName);
		}else {
			messageData.setErrorCount(0);
			messageData.setUpdateCount(0);
			messageData.setTableName("test");//用于区分该表不存在或者没有数据的情况
		}
		logger.info("从"+this.getClass().getName()+"收到请求返回："+res.toString());
		return messageData;
	}

}
