package com.ktdsuniversity.edu.scy.bbs.vo;

public class BoardVO {
	private int id;
	private String subject;
	private String content;
	private String email;
	private int viewCnt;
	private String crtDt;
	private String mdfyDt;
	private String fileName;
	private String originFileName;
	
	public int getId() {
		return this.id;
	}
	public String getSubject() {
		return this.subject;
	}
	public String getContent() {
		return this.content;
	}
	public String getEmail() {
		return this.email;
	}
	public int getViewCnt() {
		return this.viewCnt;
	}
	public String getCrtDt() {
		return this.crtDt;
	}
	public String getMdfyDt() {
		return this.mdfyDt;
	}
	public String getFileName() {
		return this.fileName;
	}
	public String getOriginFileName() {
		return this.originFileName;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setViewCnt(int viewCnt) {
		this.viewCnt = viewCnt;
	}
	public void setCrtDt(String crtDt) {
		this.crtDt = crtDt;
	}
	public void setMdfyDt(String mdfyDt) {
		this.mdfyDt = mdfyDt;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public void setOriginFileName(String originFileName) {
		this.originFileName = originFileName;
	}
}
