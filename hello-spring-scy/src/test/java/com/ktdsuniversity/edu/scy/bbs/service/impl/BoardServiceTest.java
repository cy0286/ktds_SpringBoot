package com.ktdsuniversity.edu.scy.bbs.service.impl;

import java.util.List;

import org.assertj.core.api.BDDAssertions;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

import com.ktdsuniversity.edu.scy.bbs.dao.BoardDao;
import com.ktdsuniversity.edu.scy.bbs.dao.impl.BoardDaoImpl;
import com.ktdsuniversity.edu.scy.bbs.service.BoardService;
import com.ktdsuniversity.edu.scy.bbs.vo.BoardListVO;
import com.ktdsuniversity.edu.scy.bbs.vo.BoardVO;
import com.ktdsuniversity.edu.scy.bbs.vo.BoardWriteRequestVO;

@SpringBootTest // @Controller, @Service, @Repository Bean 들을 모두 생성해라!
@Import({BoardServiceImpl.class, BoardDaoImpl.class})
public class BoardServiceTest {

	@Autowired
	private BoardService boardService;
	
	@MockitoBean // 가짜 Bean
	private BoardDao boardDao;
	
	@Test
	public void getTest() {
		
		// given
		// service 의 역할놀이 시작
		BDDMockito.given(this.boardDao.getBoardAllCount())
				  .willReturn(100);
		BDDMockito.given(this.boardDao.getAllBoard())
				  .willReturn(List.of(new BoardVO() // 1
						  			, new BoardVO() // 2
						  			, new BoardVO() // 3
						  			, new BoardVO() // 4
						  			, new BoardVO() // 5
						  			, new BoardVO() // 6
						  			, new BoardVO() // 7
						  			, new BoardVO() // 8
						  			, new BoardVO() // 9
						  			, new BoardVO())); // 10
		
		BoardListVO boardListVO =  this.boardService.getAllBoard();
		
		Assertions.assertEquals(boardListVO.getBoardCnt(), 100);
		Assertions.assertEquals(boardListVO.getBoardList().size(), 10);
	}
	
	// 단위 테스트
	// 주 목적: 의도한 실패가 잘 일어나는가?
	@Test
	public void createTestFail() {
		//Given
		BDDMockito.given(this.boardDao.insertNewBoard(null))
				  .willReturn(0);
		
		// When
		boolean isFail = this.boardService.createNewBoard(null);
		
		// Then
		Assertions.assertFalse(isFail);
	}
	
	@Test
	public void createTest() {
		
		BoardWriteRequestVO testVO = new BoardWriteRequestVO();
		
		// 역할 놀이 시작!
		// Given
		BDDMockito.given(this.boardDao.insertNewBoard(testVO))
				  .willReturn(1);
		// When
		boolean success = this.boardService.createNewBoard(testVO);
		
		// Then
		Assertions.assertTrue(success);
	}
	
	@Test
	public void testViewBoard() {
		// given
		BDDMockito.given(this.boardDao.getOneBoard(1_000_000))
				  .willReturn(new BoardVO());
		
		BDDMockito.given(this.boardDao.updateViewCountBy(1_000_000))
				  .willReturn(1);
		
		// when
		BoardVO boardVO = this.boardService.getOneBoard(1_000_000);
		
		//Then
		Assertions.assertNotNull(boardVO);
	}
	
	@Test
	public void testViewBoardFail() {
		// given
		BDDMockito.given(this.boardDao.getOneBoard(1_000_000))
				  .willReturn(null);

		BDDMockito.given(this.boardDao.updateViewCountBy(1_000_000))
				  .willReturn(0);

		// when & then
//		BDDMockito.when(this.boardService.getOneBoard(1_000_000)).thenThrow(IllegalArgumentException.class);
		try {
			this.boardService.getOneBoard(1_000_000);
		}
		catch (IllegalArgumentException iae) {
			Assertions.assertEquals("1000000는 존재하지 않는 게시글 번호입니다.", iae.getMessage());
		}
		
		// Then
//		Assertions.assertNull(boardVO);
	}
	
	@Test
	public void deleteBoard() {
		BDDMockito.given(this.boardDao.deleteOneBoard(1))
				  .willReturn(1);
		
		boolean isDeleted = this.boardService.deleteOneBoard(1);
		Assertions.assertTrue(isDeleted);
	}
	
	@Test
	public void deleteBoardFail() {
		BDDMockito.given(this.boardDao.deleteOneBoard(1))
				  .willReturn(0);
		
		String message = BDDAssertions.catchThrowable(() -> this.boardService.deleteOneBoard(1)).getMessage();
		Assertions.assertEquals(1 + "는 존재하지 않는 게시글 번호입니다.", message);
	}
}
