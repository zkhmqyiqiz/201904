package com.example.smart.entity;

import java.io.Serializable;

public class Subject implements Serializable{
	private static final long serialVersionUID = -7410508613028803107L;
	private int subjectid;
	private int pptid;
	private int pptpage;
	private int subjecttype;
	private String subjectcontent;
	private String option;
	private String answer;
	private int score;
	private String resolution;
	public int getSubjectid() {
		return subjectid;
	}
	public void setSubjectid(int subjectid) {
		this.subjectid = subjectid;
	}
	public int getPptid() {
		return pptid;
	}
	public void setPptid(int pptid) {
		this.pptid = pptid;
	}
	public int getPptpage() {
		return pptpage;
	}
	public void setPptpage(int pptpage) {
		this.pptpage = pptpage;
	}
	public int getSubjecttype() {
		return subjecttype;
	}
	public void setSubjecttype(int subjecttype) {
		this.subjecttype = subjecttype;
	}
	public String getSubjectcontent() {
		return subjectcontent;
	}
	public void setSubjectcontent(String subjectcontent) {
		this.subjectcontent = subjectcontent;
	}
	public String getOption() {
		return option;
	}
	public void setOption(String option) {
		this.option = option;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public String getResolution() {
		return resolution;
	}
	public void setResolution(String resolution) {
		this.resolution = resolution;
	}
	public Subject(int subjectid, int pptid, int pptpage, int subjecttype, String subjectcontent, String option,
			String answer, int score, String resolution) {
		super();
		this.subjectid = subjectid;
		this.pptid = pptid;
		this.pptpage = pptpage;
		this.subjecttype = subjecttype;
		this.subjectcontent = subjectcontent;
		this.option = option;
		this.answer = answer;
		this.score = score;
		this.resolution = resolution;
	}
	public Subject() {
		super();
	}
	@Override
	public String toString() {
		return "Subject [subjectid=" + subjectid + ", pptid=" + pptid + ", pptpage=" + pptpage + ", subjecttype="
				+ subjecttype + ", subjectcontent=" + subjectcontent + ", option=" + option + ", answer=" + answer
				+ ", score=" + score + ", resolution=" + resolution + "]";
	}
	
	
	
}	
