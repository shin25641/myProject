package com.care.board_service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.care.board_dao.boardDAO;

@Service
public class BoardDeleteService implements BoardService{
	@Autowired
	private boardDAO dao;
	
	@Override
	public void executeBoard(Model model) {
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest)map.get("request");
		dao.boardDelete(Integer.parseInt(request.getParameter("id")));
		
	}

}
