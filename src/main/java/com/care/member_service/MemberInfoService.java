package com.care.member_service;

import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.care.member_dao.memberDAO;
import com.care.member_dto.memberDTO;

@Service
public class MemberInfoService implements MemberService{
	
	@Autowired
	private memberDAO dao; 

	@Override
	public void execute(Model model) {
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest)map.get("request");
		String id = request.getParameter("id");
		model.addAttribute("info", dao.info(id));
	}

}
