package com.example.smart.dao;

import com.example.smart.entity.MsgBoard;

import java.util.Date;
import java.util.List;


public interface MsgBoardDao {
	
	public List<MsgBoard> selectMsgBoard(int page, int count);
	
	public int insertMsgBoard(String userid, Date starttime, String beuserid, String content);
	
	public int deleteMsgBoard(String userid, Date starttime);
	
	public int changeReadState(String userid, Date starttime, Date readtime);
	
	public List<MsgBoard> selectMsgBoardByBeuser(String userid, int page, int count);
}
