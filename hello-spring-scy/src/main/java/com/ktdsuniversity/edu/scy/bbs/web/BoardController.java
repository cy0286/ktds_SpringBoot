package com.ktdsuniversity.edu.scy.bbs.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ktdsuniversity.edu.scy.bbs.service.BoardService;
import com.ktdsuniversity.edu.scy.bbs.vo.BoardListVO;
import com.ktdsuniversity.edu.scy.bbs.vo.BoardVO;

@Controller
public class BoardController {

	@Autowired
	private BoardService boardService;
	
	@GetMapping("/board/list-scy")
	public ModelAndView viewBoardList() {
		BoardListVO boardListVO = boardService.getAllBoard();
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("board/boardlist");
		modelAndView.addObject("boardList", boardListVO);
		return modelAndView;
	}
	
	@GetMapping("/board/write-scy")
	public String viewBoardWritePage() {
		return "board/boardwrite";
	}
	
	@PostMapping("/board/write-scy")
	public ModelAndView doBoardWrite(BoardVO boardVO) {
		System.out.println("제목: " + boardVO.getSubject());
		System.out.println("이메일: " + boardVO.getEmail());
		System.out.println("내용: " + boardVO.getContent());
		System.out.println("등록일: " + boardVO.getCrtDt());
		System.out.println("수정일: " + boardVO.getMdfyDt());
		System.out.println("FileName: " + boardVO.getFileName());
		System.out.println("OriginFileName: " + boardVO.getOriginFileName());
		
		ModelAndView modelAndView = new ModelAndView();
		
		boolean isSuccess = boardService.createNewBoard(boardVO);
		if (isSuccess) {
			modelAndView.setViewName("redirect:/board/list-scy");
			return modelAndView;
		}
		else {
			modelAndView.setViewName("board/boardwrite");
			modelAndView.addObject("boardVO", boardVO);
			return modelAndView;
		}
	}
	
	@GetMapping("/board/view-scy")
	public ModelAndView viewOneBoard(@RequestParam int id) {
		BoardVO boardVO = boardService.getOneBoard(id, true);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("board/boardview");
		modelAndView.addObject("boardVO", boardVO);
		return modelAndView;
	}
	
	@GetMapping("/board/modify-scy/{id}") 
	public ModelAndView viewBoardModifyPage(@PathVariable int id) {
		BoardVO boardVO = boardService.getOneBoard(id, false);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("board/boardmodify");
		modelAndView.addObject("boardVO", boardVO);
		return modelAndView;
	}
	
	@PostMapping("/board/modify-scy")
	public ModelAndView doBoardUpdate(@ModelAttribute BoardVO boardVO) {
		System.out.println("ID: " + boardVO.getId());
		System.out.println("제목: " + boardVO.getSubject());
		System.out.println("이메일: " + boardVO.getEmail());
		System.out.println("내용: " + boardVO.getContent());
		System.out.println("등록일: " + boardVO.getCrtDt());
		System.out.println("수정일: " + boardVO.getMdfyDt());
		System.out.println("FileName: " + boardVO.getFileName());
		System.out.println("OriginFileName: " + boardVO.getOriginFileName());
		ModelAndView modelAndView = new ModelAndView();

		boolean isSuccess = boardService.updateOneBoard(boardVO);
		if (isSuccess) {
			modelAndView.setViewName("redirect:/board/view-scy?id=" + boardVO.getId());
			return modelAndView;
		}
		else {
			modelAndView.setViewName("board/boardmodify");
			modelAndView.addObject("boardVO", boardVO);
			return modelAndView;
		}
	}
	
	@GetMapping("/board/delete-scy/{id}")
	public String doDeleteBoard(@PathVariable int id) {
		boolean isSuccess = boardService.deleteOneBoard(id);
		if (isSuccess) {
			return "redirect:/board/list-scy";
		}
		else {
			return "redirect:/board/view-scy?id=" + id;
		}
	}
}