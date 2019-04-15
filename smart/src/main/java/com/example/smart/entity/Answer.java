package com.example.smart.entity;

import java.io.Serializable;
import java.util.Date;

public class Answer implements Serializable{
	private static final long serialVersionUID = 4425460961056684459L;
	private Integer subjectid;
	private Integer attendclassid;
	private Integer answercount;
	private Integer unanswercount;
	private Integer correctcount;
	private Date startanswertime;
	private Date endanswertime;
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
	public Integer getAnswercount() {
		return answercount;
	}
	public void setAnswercount(Integer answercount) {
		this.answercount = answercount;
	}
	public Integer getUnanswercount() {
		return unanswercount;
	}
	public void setUnanswercount(Integer unanswercount) {
		this.unanswercount = unanswercount;
	}
	public Integer getCorrectcount() {
		return correctcount;
	}
	public void setCorrectcount(Integer correctcount) {
		this.correctcount = correctcount;
	}
	public Date getStartanswertime() {
		return startanswertime;
	}
	public void setStartanswertime(Date startanswertime) {
		this.startanswertime = startanswertime;
	}
	public Date getEndanswertime() {
		return endanswertime;
	}
	public void setEndanswertime(Date endanswertime) {
		this.endanswertime = endanswertime;
	}
	public Answer(Integer subjectid, Integer attendclassid, Integer answercount, Integer unanswercount,
			Integer correctcount, Date startanswertime, Date endanswertime) {
		super();
		this.subjectid = subjectid;
		this.attendclassid = attendclassid;
		this.answercount = answercount;
		this.unanswercount = unanswercount;
		this.correctcount = correctcount;
		this.startanswertime = startanswertime;
		this.endanswertime = endanswertime;
	}
	public Answer() {
		super();
	}
	@Override
	public String toString() {
		return "Answer [subjectid=" + subjectid + ", attendclassid=" + attendclassid + ", answercount=" + answercount
				+ ", unanswercount=" + unanswercount + ", correctcount=" + correctcount + ", startanswertime="
				+ startanswertime + ", endanswertime=" + endanswertime + "]";
	}
	
}
