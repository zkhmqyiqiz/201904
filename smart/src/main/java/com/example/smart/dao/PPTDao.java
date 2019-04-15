package com.example.smart.dao;


import com.example.smart.entity.PPT;

public interface PPTDao {
	public int insertPPT(PPT ppt);
	public PPT selectPPTById(int pptid);
}
