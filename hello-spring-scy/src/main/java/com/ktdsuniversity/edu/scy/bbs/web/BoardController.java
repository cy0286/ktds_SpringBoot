package com.ktdsuniversity.edu.scy.bbs.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ktdsuniversity.edu.scy.bbs.service.BoardService;
import com.ktdsuniversity.edu.scy.bbs.vo.BoardListVO;
import com.ktdsuniversity.edu.scy.bbs.vo.BoardUpdateRequestVO;
import com.ktdsuniversity.edu.scy.bbs.vo.BoardVO;
import com.ktdsuniversity.edu.scy.bbs.vo.BoardWriteRequestVO;

@Controller
public class BoardController {

	@Autowired
	private BoardService boardService;
	
	@GetMapping("/board/list-scy")
	public String viewBoardList(Model model) {
		BoardListVO boardListVO = boardService.getAllBoard();
		model.addAttribute("boardList", boardListVO);

		return "board/boardlist";
	}
	
	@GetMapping("/board/write-scy")
	public String viewBoardWritePage() {
		return "board/boardwrite";
	}
	
	@PostMapping("/board/write-scy")
	public String doBoardWrite(BoardWriteRequestVO boardWriteRequestVO) {
		
		boolean isCreated = this.boardService.createNewBoard(boardWriteRequestVO);
		if (isCreated) {
			/*
			 * HTTP Status Code : 302 Found
			 * Location: http://localhost:8080/board/list
			 */
			return "redirect:/board/list-scy";
		}
		
		return "board/write-scy";
	}
	
	// 1. Query String Parameter
	// /board/view?id=3
	@GetMapping("/board/view-scy")
	public String viewBoardDetailPageUseQueryStringParameter(@RequestParam int id, Model model) {
		
		BoardVO boardVO = this.boardService.getOneBoard(id);
		model.addAttribute("boardVO", boardVO);
		return "board/boardview";
	}
	
	// 2. Path Variable Parameter
	// /board/view/3
	@GetMapping("/board/view-scy/{id}")
	public String viewBoardDetailPageUserPathVariable(@PathVariable int id, Model model) {
		BoardVO boardVO = this.boardService.getOneBoard(id);
		model.addAttribute("boardVO", boardVO);
		return "board/boardview";
	}
	
//	@GetMapping("/board/view-scy")
//	public ModelAndView viewOneBoard(@RequestParam int id) {
//		BoardVO boardVO = this.boardService.getOneBoard(id, true);
//		ModelAndView modelAndView = new ModelAndView();
//		modelAndView.setViewName("board/boardview");
//		modelAndView.addObject("boardVO", boardVO);
//		return modelAndView;
//	}
	
	@GetMapping("/board/modify-scy/{id}") 
	public ModelAndView viewBoardModifyPage(@PathVariable int id) {
		BoardVO boardVO = boardService.getOneBoard(id, false);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("board/boardmodify");
		modelAndView.addObject("boardVO", boardVO);
		return modelAndView;
	}
	
	@PostMapping("/board/modify-scy")
	public ModelAndView doBoardUpdate(@ModelAttribute BoardUpdateRequestVO boardUpdateRequestVO) {
		System.out.println("ID: " + boardUpdateRequestVO.getId());
		System.out.println("제목: " + boardUpdateRequestVO.getSubject());
		System.out.println("이메일: " + boardUpdateRequestVO.getEmail());
		System.out.println("내용: " + boardUpdateRequestVO.getContent());
//		System.out.println("등록일: " + boardUpdateRequestVO.getCrtDt());
//		System.out.println("수정일: " + boardUpdateRequestVO.getMdfyDt());
//		System.out.println("FileName: " + boardUpdateRequestVO.getFileName());
//		System.out.println("OriginFileName: " + boardUpdateRequestVO.getOriginFileName());
		ModelAndView modelAndView = new ModelAndView();

		boolean isSuccess = boardService.updateOneBoard(boardUpdateRequestVO);
		if (isSuccess) {
			modelAndView.setViewName("redirect:/board/view-scy?id=" + boardUpdateRequestVO.getId());
			return modelAndView;
		}
		else {
			modelAndView.setViewName("board/boardmodify");
			modelAndView.addObject("boardVO", boardUpdateRequestVO);
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