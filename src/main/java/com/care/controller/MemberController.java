package com.care.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import com.care.board_service.BoardService;
import com.care.member_dao.memberDAO;
import com.care.member_service.MemberCheckService;
import com.care.member_service.MemberInfoService;
import com.care.member_service.MemberInsertService;
import com.care.member_service.MemberListService;
import com.care.member_service.MemberService;
import com.care.template.Constant;

@Controller
public class MemberController {
	private MemberService member;
	private BoardService board;
	
	private ApplicationContext applicationContext = applicationContextprovider.getApplicationContext();
		
	@RequestMapping("index")
	public String index() {
		return "member/index";
	}
	
	@RequestMapping("login")
	public String login() {
		return "member/login";
	}
	
	@RequestMapping("logout")
	public String logout(HttpServletRequest request) {
		HttpSession session = request.getSession();
		session.invalidate();
		return "member/logout";
	}
	
	@RequestMapping("chkuser")
	public String chkuser(Model model, HttpServletRequest request) {
		model.addAttribute("request", request);
		//member = new MemberCheckService();
		member = (MemberService) applicationContext.getBean("memberCheckService");
		member.execute(model);
		
		HttpSession session = request.getSession();
		if(session.getAttribute("loginUser") != null) {
			return "redirect:successLogin";
		}
		return "redirect:chkUserNoPassword";
	}
	
	
	@RequestMapping("successLogin")
	public String successLogin() {
		return "member/successLogin";
	}
	
	@RequestMapping("chkUserNoPassword")
	public String chkUserNoPassword() {
		return "member/chkUserNoPassword";
	}
	
	
	@RequestMapping("memberInfo")
	public String memberInfo(Model model, HttpServletRequest request) {
		model.addAttribute("request", request);
		//member = new MemberListService();
		member = (MemberService) applicationContext.getBean("memberListService");
		member.execute(model);
		
		return "member/memberInfo";
	}
	
	@RequestMapping("info")
	public String info(Model model, HttpServletRequest request) {
		model.addAttribute("request", request);
		//member = new MemberInfoService();
		member = (MemberService) applicationContext.getBean("memberInfoService");
		member.execute(model);
		return "member/info";
	}
	
	@RequestMapping("register")
	public String register() {
		return "member/register";
	}
	
	@RequestMapping("registerOk")
	public String registerOk(Model model, HttpServletRequest request) {
		model.addAttribute("request", request);
		//member = new MemberInsertService();
		member = (MemberService) applicationContext.getBean("memberInsertService");
		member.execute(model);		
		return "member/registerOk";
	}
	
	
	

}
