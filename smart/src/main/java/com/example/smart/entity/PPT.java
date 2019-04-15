package com.example.smart.entity;

import java.io.Serializable;
import java.util.Date;

public class PPT implements Serializable{
	private static final long serialVersionUID = -7410224694575407674L;
	private int pptid;
	private int pagecount;
	private String userid;
	private String ppturl;
	private String pptname;
	private Date uploadtime;
	private String pptmd5;
	
	
	public PPT() {
		super();
	}
	public int getPptid() {
		return pptid;
	}
	public void setPptid(int pptid) {
		this.pptid = pptid;
	}
	public int getPagecount() {
		return pagecount;
	}
	public void setPagecount(int pagecount) {
		this.pagecount = pagecount;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getPpturl() {
		return ppturl;
	}
	public void setPpturl(String ppturl) {
		this.ppturl = ppturl;
	}
	public String getPptname() {
		return pptname;
	}
	public void setPptname(String pptname) {
		this.pptname = pptname;
	}
	public Date getUploadtime() {
		return uploadtime;
	}
	public void setUploadtime(Date uploadtime) {
		this.uploadtime = uploadtime;
	}
	public String getPptmd5() {
		return pptmd5;
	}
	public void setPptmd5(String pptmd5) {
		this.pptmd5 = pptmd5;
	}
	public PPT(int pptid, int pagecount, String userid, String ppturl, String pptname, Date uploadtime, String pptmd5) {
		this.pptid = pptid;
		this.pagecount = pagecount;
		this.userid = userid;
		this.ppturl = ppturl;
		this.pptname = pptname;
		this.uploadtime = uploadtime;
		this.pptmd5 = pptmd5;
	}
	@Override
	public String toString() {
		return "PPT [pptid=" + pptid + ", pagecount=" + pagecount + ", userid=" + userid + ", ppturl=" + ppturl
				+ ", pptname=" + pptname + ", uploadtime=" + uploadtime + ", pptmd5=" + pptmd5 + "]";
	}
	
	
	
}	
