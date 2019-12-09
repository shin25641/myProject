package com.care.board_service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.care.board_dao.boardDAO;
import com.care.board_dto.boardDTO;

@Service
public class BoardReplySaveService implements BoardService{
	@Autowired
	private boardDAO dao;

	@Override
	public void executeBoard(Model model) {
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest)map.get("request");
		boardDTO Bdto = new boardDTO();
		Bdto.setId(Integer.parseInt(request.getParameter("id")));
		Bdto.setName(request.getParameter("name"));
		Bdto.setTitle(request.getParameter("title"));
		Bdto.setContent(request.getParameter("content"));
		dao.boardReplyViewReply(Bdto);
		
	}

}
