package com.care.member_service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.care.member_dao.memberDAO;
import com.care.member_dto.memberDTO;

@Service
public class MemberListService implements MemberService{
	@Autowired
	private memberDAO dao;
	
	@Override
	public void execute(Model model) {
		List<Object> list = dao.list();
		model.addAttribute("list",list);
	
	}

}
