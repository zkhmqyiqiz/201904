package com.example.smart.dao;

import com.example.smart.entity.Bulletin;

import java.util.Date;
import java.util.List;


public interface BulletinDao {
	
	public List<Bulletin> selectBulletin(int page, int count);
	
	public int insertBulletin(String userid, Date starttime, int level, String content);

	public int deleteBulletin(String userid, Date starttime);
	
	public int updateBulletin(String userid, Date starttime, int level, String content);
	
}
