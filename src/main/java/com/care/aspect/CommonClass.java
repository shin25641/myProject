package com.care.aspect;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpSession;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.care.log_dto.logDTO;
import com.care.member_dao.memberDAO;

@Component
@Aspect
public class CommonClass {
	@Autowired
	private memberDAO dao;
	
	private logDTO Ldto = new logDTO();
	String time1;
	String time2;
	long startTime = 0;
	long endTime = 0;

	//로그인 할때 로그찍는 기능
	@After("execution(* com.care.controller.MemberController.successLogin(..))")
	public void loginLog(JoinPoint jp) {
		HttpSession session = ((ServletRequestAttributes)RequestContextHolder.currentRequestAttributes()).getRequest().getSession();

		SimpleDateFormat format1 = new SimpleDateFormat ( "yyyy-MM-dd HH:mm:ss");
		Date time = new Date();
		time1 = format1.format(time);
		
		String id = (String) session.getAttribute("loginUser");
		
		startTime = System.currentTimeMillis();

		Ldto.setId(id);
		Ldto.setStarttime(time1);
		Ldto.setEndtime("no");
		//Ldto.setResulttime(startTime);
		dao.logInsert(Ldto);
	}
	
	//로그아웃 할때 로그찍는 기능
	@Before("execution(* com.care.controller.MemberController.logout(..))")
	public void logoutLog(JoinPoint jp) {

		SimpleDateFormat format2 = new SimpleDateFormat ( "yyyy-MM-dd HH:mm:ss");
		Date time2 = new Date();
		String ftime2 = format2.format(time2);
		
		endTime = System.currentTimeMillis(); 
		
		int resultTime = (int) ((endTime-startTime)/1000);
		
		Ldto.setNum(Ldto.getNum());
		Ldto.setEndtime(ftime2);
		Ldto.setResulttime(resultTime);
		dao.logUpdate(Ldto);
		
		
	}
	
}
