package com.care.board_service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.care.board_dao.boardDAO;

@Service
public class BoardMemberListService implements BoardService{
	@Autowired
	private boardDAO dao;
	
	@Override
	public void executeBoard(Model model) {
		List<Object> boardList = dao.board_list();
		model.addAttribute("boardList",boardList);
		
	}

}
