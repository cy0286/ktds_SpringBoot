package com.ktdsuniversity.edu.scy.bbs.dao.impl;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.context.annotation.Import;

import com.ktdsuniversity.edu.scy.bbs.dao.BoardDao;
import com.ktdsuniversity.edu.scy.bbs.vo.BoardVO;
import com.ktdsuniversity.edu.scy.bbs.vo.BoardWriteRequestVO;

@MybatisTest
// 실제 SQL을 테스트 해야하는 환경
// Mybatis 전용의 테스트 데이터베이스는 쓰지말고
// application.yml 에 설정된 실제 데이터베이스를 대상으로 테스트 하겠다!를 정의하는 설정
@AutoConfigureTestDatabase(replace = Replace.NONE)
// BoardDaoIml의 테스트용 Spring Bean 이 만들어진다. (Mybatis 설정이 완료된 Bean)
@Import({BoardDaoImpl.class})
public class BoardDaoTest {

	@Autowired
	private BoardDao boardDaoImpl;
	
	@Test
	public void testCount() {
		int count = boardDaoImpl.getBoardAllCount();
//		int correctCount = 15;
		// 두 개가 같으면 성공
		// 다르면 실패
		Assertions.assertTrue(count > 0);
	}
	
	@Test
	public void testSelect() {
		List<BoardVO> boardList = boardDaoImpl.getAllBoard();
		int size = boardList.size();
//		int correctSize = 15;
		Assertions.assertTrue(size > 0);
	}
	
	@Test
	public void testInsert() {
		BoardWriteRequestVO testVO = new BoardWriteRequestVO();
		testVO.setContent("testContent");
		testVO.setEmail("testEmail");
		testVO.setSubject("testSubject");
		
		int insertedCount = this.boardDaoImpl.insertNewBoard(testVO);
		Assertions.assertEquals(insertedCount, 1);
	}
	
	@Test
	public void testSelectionOne() {
		// insert -> 게시글의 ID -> 조회
		BoardVO boardVO = this.boardDaoImpl.getOneBoard(3/*파일 여러개인 게시글 아이디 찾아서 넣기*/);
		
		Assertions.assertNotNull(boardVO);
		Assertions.assertNotNull(boardVO.getFileList());
		Assertions.assertNotNull(boardVO.getFileList().size() > 0);
	}
	
	@Test
	public void testUpdateViewCount() {
		int updateCount = this.boardDaoImpl.updateViewCountBy(3);
		Assertions.assertTrue(updateCount == 1);
	}
	
	@Test
	public void testDeleteBoard() {
		int deletedCount = this.boardDaoImpl.deleteOneBoard(33);
		Assertions.assertTrue(deletedCount ==1);
	}
	
	@Test
	public void testDeleteBoardFail() {
		int deletedCount = this.boardDaoImpl.deleteOneBoard(1_000_000_000);
		Assertions.assertTrue(deletedCount == 0);
	}
}
