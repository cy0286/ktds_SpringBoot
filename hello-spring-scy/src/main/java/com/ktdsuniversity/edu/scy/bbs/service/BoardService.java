package com.ktdsuniversity.edu.scy.bbs.service;

import com.ktdsuniversity.edu.scy.bbs.vo.BoardListVO;
import com.ktdsuniversity.edu.scy.bbs.vo.BoardUpdateRequestVO;
import com.ktdsuniversity.edu.scy.bbs.vo.BoardVO;
import com.ktdsuniversity.edu.scy.bbs.vo.BoardWriteRequestVO;

public interface BoardService {

	public BoardListVO getAllBoard();
	public boolean createNewBoard(BoardWriteRequestVO boardWriteRequestVO);
//	public boolean createNewBoard(BoardVO boardVO);
	public BoardVO getOneBoard(int id);
	public BoardVO getOneBoard(int id, boolean isIncrease);
	public boolean updateOneBoard(BoardUpdateRequestVO boardUpdateRequestVO); 
	public boolean deleteOneBoard(int id);
}
