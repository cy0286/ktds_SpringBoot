package com.ktdsuniversity.edu.scy.bbs.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.ktdsuniversity.edu.scy.bbs.dao.BoardDao;
import com.ktdsuniversity.edu.scy.bbs.service.BoardService;
import com.ktdsuniversity.edu.scy.bbs.vo.BoardListVO;
import com.ktdsuniversity.edu.scy.bbs.vo.BoardUpdateRequestVO;
import com.ktdsuniversity.edu.scy.bbs.vo.BoardVO;
import com.ktdsuniversity.edu.scy.bbs.vo.BoardWriteRequestVO;
import com.ktdsuniversity.edu.scy.beans.FileHandler;
import com.ktdsuniversity.edu.scy.beans.FileHandler.StoredFile;
import com.ktdsuniversity.edu.scy.file.dao.FileDao;
import com.ktdsuniversity.edu.scy.file.vo.FileVO;

@Service
public class BoardServiceImpl implements BoardService {
	
	@Autowired
	private BoardDao boardDao;
	
	@Autowired
	private FileDao fileDao;
	
	@Autowired
	private FileHandler fileHandler;

	@Override
	public BoardListVO getAllBoard() {
	
		BoardListVO boardListVO = new BoardListVO();
		boardListVO.setBoardCnt(boardDao.getBoardAllCount());
		boardListVO.setBoardList(boardDao.getAllBoard());
		return boardListVO;
	}
	
//	@Override
//	public boolean createNewBoard(BoardVO boardVO) {
//		int createCount = boardDao.createNewBoard(boardVO);
//		return createCount > 0;
//	}
	
	@Override
	public boolean createNewBoard(BoardWriteRequestVO boardWriteRequestVO) {

		int insertedCount = this.boardDao.insertNewBoard(boardWriteRequestVO);

		// insertedCount > 0 then file upload
		if (insertedCount > 0) {
			for (MultipartFile file : boardWriteRequestVO.getFile()) {

				StoredFile storedFile = this.fileHandler.store(file);
				if (storedFile != null) {
					// 파일 업로드가 정상적으로 이루어 졌다.
					// FILE 테이블에 파일 데이터를 추가한다.
					FileVO fileVO = new FileVO();
					fileVO.setId(boardWriteRequestVO.getId());
					fileVO.setFlNm(storedFile.getFileName());
					fileVO.setObfsFlNm(storedFile.getRealFileName());
					fileVO.setObfsFlPth(storedFile.getRealFilePath());
					fileVO.setFlSz(storedFile.getFileSize());

					this.fileDao.insertNewFile(fileVO);

				}
			}

		}
		return insertedCount > 0;
	}

	@Override
	public BoardVO getOneBoard(int id) {
		// 1. 조회하려는 게시글의 조회수를 증가시킨다.
		int updateCount = this.boardDao.updateViewCountBy(id);
		
		// 2. 업데이트의 수가 0보다 크다면 게시글이 존재한다는 의미이므로
		//	  게시글을 조회해 온다.
		if (updateCount > 0) {
			BoardVO boardVO = this.boardDao.getOneBoard(id);
			return boardVO;
		}
		
		// 3. 게시글 반환
		throw new IllegalArgumentException(id + "는 존재하지 않는 게시글 번호입니다.");
	}
	
	@Override
	public BoardVO getOneBoard(int id, boolean isIncrease) {
		if (isIncrease) {
			int updateCount = boardDao.updateViewCountBy(id);
			if (updateCount == 0) {
				throw new IllegalArgumentException("잘못된 접근입니다.");
			}
		}
		BoardVO boardVO = boardDao.getOneBoard(id);
		if (boardVO == null) {
			throw new IllegalArgumentException("잘못된 접근입니다.");
		}
		return boardVO;
	}
	
	@Override
	public boolean updateOneBoard(BoardUpdateRequestVO boardUpdateRequestVO) {
		int updateCount = boardDao.updateOneBoard(boardUpdateRequestVO);
		return updateCount > 0;
	}

	@Override
	public boolean deleteOneBoard(int id) {
		int deleteCount = boardDao.deleteOneBoard(id);
		if (deleteCount == 0) {
			throw new IllegalArgumentException(id + "는 존재하지 않는 게시글 번호입니다.");
		}
		return deleteCount > 0;
	}

}
