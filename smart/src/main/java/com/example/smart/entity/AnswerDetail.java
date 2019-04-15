package com.example.smart.entity;

import java.io.Serializable;
import java.util.Date;

public class AnswerDetail implements Serializable{
	private static final long serialVersionUID = -7213434027801054662L;
	private Integer subjectid;
	private Integer attendclassid;
	private String userid;
	private String useranswer;
	private Date starttime;
	private int score;
	private int ifsure;
	private Date spendtime;
	
	public Date getSpendtime() {
		return spendtime;
	}
	public void setSpendtime(Date spendtime) {
		this.spendtime = spendtime;
	}
	public Integer getSubjectid() {
		return subjectid;
	}
	public void setSubjectid(Integer subjectid) {
		this.subjectid = subjectid;
	}
	public Integer getAttendclassid() {
		return attendclassid;
	}
	public void setAttendclassid(Integer attendclassid) {
		this.attendclassid = attendclassid;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getUseranswer() {
		return useranswer;
	}
	public void setUseranswer(String useranswer) {
		this.useranswer = useranswer;
	}
	public Date getStarttime() {
		return starttime;
	}
	public void setStarttime(Date starttime) {
		this.starttime = starttime;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public int getIfsure() {
		return ifsure;
	}
	public void setIfsure(int ifsure) {
		this.ifsure = ifsure;
	}
	public AnswerDetail(Integer subjectid, Integer attendclassid, String userid, String useranswer, Date starttime,
			int score, int ifsure) {
		super();
		this.subjectid = subjectid;
		this.attendclassid = attendclassid;
		this.userid = userid;
		this.useranswer = useranswer;
		this.starttime = starttime;
		this.score = score;
		this.ifsure = ifsure;
	}
	public AnswerDetail() {
		super();
	}
	@Override
	public String toString() {
		return "AnswerDetail [subjectid=" + subjectid + ", attendclassid=" + attendclassid + ", userid=" + userid
				+ ", useranswer=" + useranswer + ", starttime=" + starttime + ", score=" + score + ", ifsure=" + ifsure
				+ "]";
	}
	
	
}
