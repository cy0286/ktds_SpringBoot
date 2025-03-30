package com.ktdsuniversity.edu.scy.bbs.dao;
import java.util.List;

import com.ktdsuniversity.edu.scy.bbs.vo.BoardVO;


public interface BoardDao {

	public int getBoardAllCount();
	public List<BoardVO> getAllBoard();
	public int createNewBoard(BoardVO boardVO);
	public int increaseViewCount(int id);
	public BoardVO getOneBoard(int id);
	public int updateOneBoard(BoardVO boardVO);
	public int deleteOneBoard(int id);
}
