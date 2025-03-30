package com.ktdsuniversity.edu.scy.bbs.service;

import com.ktdsuniversity.edu.scy.bbs.vo.BoardListVO;
import com.ktdsuniversity.edu.scy.bbs.vo.BoardVO;

public interface BoardService {

	public BoardListVO getAllBoard();
	public boolean createNewBoard(BoardVO boardVO);
	public BoardVO getOneBoard(int id);
	public BoardVO getOneBoard(int id, boolean isIncrease);
	public boolean updateOneBoard(BoardVO boardVO); 
	public boolean deleteOneBoard(int id);
}
