package com.example.smart.dao;

import com.example.smart.entity.IpCall;

import java.util.List;



public interface IpPhoneDao {
	/**
	 * 根据开始时间倒序 分页
	 * @param page 
	 * @param count
	 * @return
	 */
	public List<IpCall> selectAllIpCall(int page, int count);
	/**
	 * 获取总条数
	 * @return
	 */
	public int selectCount();
}
