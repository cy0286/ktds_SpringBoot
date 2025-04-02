package com.ktdsuniversity.edu.scy.bbs.vo;

public class BoardUpdateRequestVO {

	private int id;
	private String subject;
	private String content;
	private String email;
	
	
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
}
