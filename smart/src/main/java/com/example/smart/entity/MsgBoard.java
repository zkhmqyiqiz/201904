package com.example.smart.entity;

import java.io.Serializable;
import java.util.Date;

public class MsgBoard implements Serializable{
	private static final long serialVersionUID = -3537786772020646078L;
	private String userid;		    //留言人
	private Date starttime;		//留言时间
	private String beuserid;		//被留言人
	private String content;		    //内容
	private Integer readstate;		//阅读状态，已读0，未读1
	private Date readtime;		//阅读时间
	public MsgBoard(String userid, Date starttime, String beuserid, String content, Integer readstate, Date readtime) {
		this.userid = userid;
		this.starttime = starttime;
		this.beuserid = beuserid;
		this.content = content;
		this.readstate = readstate;
		this.readtime = readtime;
	}
	public MsgBoard() {
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public Date getStarttime() {
		return starttime;
	}
	public void setStarttime(Date starttime) {
		this.starttime = starttime;
	}
	public String getBeuserid() {
		return beuserid;
	}
	public void setBeuserid(String beuserid) {
		this.beuserid = beuserid;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Integer getReadstate() {
		return readstate;
	}
	public void setReadstate(Integer readstate) {
		this.readstate = readstate;
	}
	public Date getReadtime() {
		return readtime;
	}
	public void setReadtime(Date readtime) {
		this.readtime = readtime;
	}
	@Override
	public String toString() {
		return "MsgBoard [userid=" + userid + ", starttime=" + starttime + ", beuserid=" + beuserid + ", content="
				+ content + ", readstate=" + readstate + ", readtime=" + readtime + "]";
	}
	
}
