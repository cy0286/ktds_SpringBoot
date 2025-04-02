package com.ktdsuniversity.edu.scy.bbs.dao;
import java.util.List;

import com.ktdsuniversity.edu.scy.bbs.vo.BoardUpdateRequestVO;
import com.ktdsuniversity.edu.scy.bbs.vo.BoardVO;
import com.ktdsuniversity.edu.scy.bbs.vo.BoardWriteRequestVO;


public interface BoardDao {

	public int getBoardAllCount();
	public List<BoardVO> getAllBoard();
	public int insertNewBoard(BoardWriteRequestVO boardWriteRequestVO);
	public int createNewBoard(BoardVO boardVO);
	public int updateViewCountBy(int id);
	public BoardVO getOneBoard(int id);
	public int updateOneBoard(BoardUpdateRequestVO boardUpdateRequestVO);
	public int deleteOneBoard(int id);
}
