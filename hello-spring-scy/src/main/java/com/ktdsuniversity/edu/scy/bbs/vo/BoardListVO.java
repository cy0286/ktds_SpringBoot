package com.ktdsuniversity.edu.scy.bbs.vo;
import java.util.List;

public class BoardListVO {
	private int boardCnt;
	private List<BoardVO> boardList;
	
	public int getBoardCnt() {
		return this.boardCnt;
	}
	public List<BoardVO> getBoardList() {
		return this.boardList;
	}
	
	public void setBoardCnt(int boardCnt) {
		this.boardCnt = boardCnt;
	}
	public void setBoardList(List<BoardVO> boardList) {
		this.boardList = boardList;
	}
}
