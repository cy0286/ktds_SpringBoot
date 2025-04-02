package com.ktdsuniversity.edu.scy.bbs.vo;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public class BoardWriteRequestVO {

	private int id;
	private String subject;
	private String content;
	private String email;
	
	private List<MultipartFile> file;
	
	public int getId() {
		return this.id;
	}
	public List<MultipartFile> getFile() {
		return this.file;
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
	public void setFile(List<MultipartFile> file) {
		this.file = file;
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
