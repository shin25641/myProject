package com.care.member_service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.care.member_dao.memberDAO;
import com.care.member_dto.memberDTO;

@Service
public class MemberInsertService implements MemberService{
	@Autowired
	private memberDAO dao;

	@Override
	public void execute(Model model) {
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest)map.get("request");
		memberDTO dto = new memberDTO();
		dto.setId(request.getParameter("id"));
		dto.setPw(request.getParameter("pw"));
		int rs = dao.insert(dto);
		model.addAttribute("insert",rs);
	}
	
}
