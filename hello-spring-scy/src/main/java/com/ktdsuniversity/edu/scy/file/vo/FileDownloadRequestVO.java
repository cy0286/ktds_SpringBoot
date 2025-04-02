package com.ktdsuniversity.edu.scy.file.vo;

public class FileDownloadRequestVO {

	/**
	 * 게시글의 아이디
	 */
	private int id;
	
	/**
	 * 파일의 아이디
	 */
	private int flId;
	
	public int getId() {
		return this.id;
	}
	public int getFlId() {
		return this.flId;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	public void setFlId(int flId) {
		this.flId = flId;
	}
}
