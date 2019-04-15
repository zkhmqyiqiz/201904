package com.example.smart.dao;

import com.example.smart.entity.Vkbjc;

import java.util.List;


public interface VkbjcDao {
	public List<Vkbjc> selectAllVkbjc();//查询vkbjc表的所有数据
	public int insertAndUpdateVkbjc(Vkbjc vkbjc);//通过对象的形式插入数据，一个一个对象的插入和更新
}
