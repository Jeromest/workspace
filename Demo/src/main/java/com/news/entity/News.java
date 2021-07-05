package com.news.entity;

import java.util.Date;

public class News {
	private int nid;
	private String title;
	private String tid;
	private String inputer;
	private String chkuser;
	private String deptcode;
	private Date time;
	private int hits;
	private String content;
	public int getNid() {
		return nid;
	}
	public void setNid(int nid) {
		this.nid=nid;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title=title;
	}
	public String getTid() {
		return tid;
	}
	public void setTid(String tid) {
		this.tid=tid;
	}
	public String getInputer() {
		// TODO Auto-generated method stub
		return inputer;
	}
	public void setInputer(String inputer) {
		this.inputer=inputer;
	}
	public String getChkuser() {
		return chkuser;
	}
	public void setChkuser(String chkuser) {
		this.chkuser=chkuser;
	}
	public String getDeptcode() {
		return deptcode;
	}
	public void setDeptcode(String deptcode) {
		this.deptcode=deptcode;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time=time;
	}
	public int getHits() {
		return hits;
	}
	public void setHits(int htis) {
		this.hits=hits;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content=content;
	}
}
