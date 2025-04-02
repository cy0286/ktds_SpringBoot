package com.ktdsuniversity.edu.scy.bbs.dao.impl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ktdsuniversity.edu.scy.bbs.dao.BoardDao;
import com.ktdsuniversity.edu.scy.bbs.vo.BoardUpdateRequestVO;
import com.ktdsuniversity.edu.scy.bbs.vo.BoardVO;
import com.ktdsuniversity.edu.scy.bbs.vo.BoardWriteRequestVO;

@Repository
public class BoardDaoImpl extends SqlSessionDaoSupport implements BoardDao {
	
	private static final String NAME_SPACE = "com.ktdsuniversity.edu.scy.bbs.dao.BoardDao.";
	
	@Autowired
	@Override
	public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
		super.setSqlSessionTemplate(sqlSessionTemplate);
	}
	
	@Override
	public int getBoardAllCount() {
		// return getSqlSession().selectOne("getBoardAllCount");
		return getSqlSession().selectOne(NAME_SPACE + "getBoardAllCount");
	}
	
	@Override
	public List<BoardVO> getAllBoard() {
		// return getSqlSession().selectList("getAllBoard");
		return getSqlSession().selectList(NAME_SPACE + "getAllBoard");
	}
	
	@Override
	public int insertNewBoard(BoardWriteRequestVO boardWriteRequestVO) {
		return getSqlSession().insert(NAME_SPACE + "insertNewBoard", boardWriteRequestVO);
	}
	
	@Override
	public int createNewBoard(BoardVO boardVO) {
		return getSqlSession().insert("createNewBoard", boardVO);
	}
	
	@Override
	public int updateViewCountBy(int id) {
		return getSqlSession().update("updateViewCountBy", id);
	}
	
	@Override
	public BoardVO getOneBoard(int id) {
		return getSqlSession().selectOne("getOneBoard", id);
	}
	
	@Override
	public int updateOneBoard(BoardUpdateRequestVO boardUpdateRequestVO) {
		return getSqlSession().update("updateOneBoard", boardUpdateRequestVO);
	}
	
	@Override
	public int deleteOneBoard(int id) {
		return getSqlSession().delete("deleteOneBoard", id);
	}
}
