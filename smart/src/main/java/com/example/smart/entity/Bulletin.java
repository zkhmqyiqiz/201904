package com.example.smart.entity;

import java.io.Serializable;
import java.util.Date;

/**
  *  系统公告
 *
 */
public class Bulletin implements Serializable{
	private static final long serialVersionUID = 2361073444852971513L;
	private String userid;       //公告人
	private Date starttime;	 //公告时间
	private Integer level;		 //级别
	private String content;      //内容
	public Bulletin(String userid, Date starttime, Integer level, String content) {
		this.userid = userid;
		this.starttime = starttime;
		this.level = level;
		this.content = content;
	}
	public Bulletin() {
	}
	@Override
	public String toString() {
		return "Bulletin [userid=" + userid + ", starttime=" + starttime + ", level=" + level + ", content=" + content
				+ "]";
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
	public Integer getLevel() {
		return level;
	}
	public void setLevel(Integer level) {
		this.level = level;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
}
