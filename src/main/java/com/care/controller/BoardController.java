package com.care.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.care.board_service.BoardService;

@Controller
public class BoardController {
	private BoardService board;
	
	private ApplicationContext applicationContext = applicationContextprovider.getApplicationContext();
	
	@RequestMapping("board_list")
	public String board_list(Model model, HttpServletRequest request) {
		model.addAttribute("request", request);
		board = (BoardService) applicationContext.getBean("boardMemberListService");
		board.executeBoard(model);
		return "board/board_list";
	}
	
	@RequestMapping("borad_write")
	public String borad_write() {
		return "board/borad_write";
	}
	
	@RequestMapping("board_write_save")
	public String board_write_save(Model model, HttpServletRequest request) {
		model.addAttribute("request", request);
		board = (BoardService) applicationContext.getBean("boardMemberWriteSaveService");
		board.executeBoard(model);
		return "redirect:board_list";
	}
	
	@RequestMapping("board_select_view")
	public String board_select_view(Model model,HttpServletRequest request) {
		model.addAttribute("request", request);
		board = (BoardService) applicationContext.getBean("boardMemberSelectViewService");
		board.executeBoard(model);
		board = (BoardService) applicationContext.getBean("boardCntService");
		board.executeBoard(model);
		return "board/board_select_view";
	}
	
	
	@RequestMapping("board_modify")
	public String board_modify(Model model, HttpServletRequest request) {
		model.addAttribute("request", request);
		board = (BoardService) applicationContext.getBean("boardMemberSelectModifyService");
		board.executeBoard(model);
		return "redirect:board_list";
	}
	
	@RequestMapping("board_delete")
	public String board_delete(Model model,HttpServletRequest request) {
		model.addAttribute("request", request);
		board = (BoardService) applicationContext.getBean("boardDeleteService");
		board.executeBoard(model);
		return "redirect:board_list";
	}
	
	@RequestMapping("board_reply_view")
	public String board_reply(Model model,HttpServletRequest request) {
		model.addAttribute("request", request);
		board = (BoardService) applicationContext.getBean("boardReplyServiceView");
		board.executeBoard(model);
		return "board/board_reply_view";
	}
	
	@RequestMapping("board_reply_save")
	public String board_reply_save(Model model,HttpServletRequest request) {
		model.addAttribute("request", request);
		board = (BoardService) applicationContext.getBean("boardReplySaveService");
		board.executeBoard(model);
		return "redirect:board_list";
	}
	
	

}
