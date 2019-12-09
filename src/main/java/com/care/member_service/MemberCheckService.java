package com.care.member_service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.care.member_dao.memberDAO;

@Service
public class MemberCheckService implements MemberService{
	@Autowired
	private memberDAO dao;

	@Override
	public void execute(Model model) {
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest)map.get("request");
		int rs = dao.userCheck(request.getParameter("id"),request.getParameter("pw"));
		if(rs == 0) {
			HttpSession session = request.getSession();
			session.setAttribute("loginUser", request.getParameter("id"));
		}
	}

}
