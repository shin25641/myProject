package com.care.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.care.log_service.LogService;

@Controller
public class LogController {
	private LogService log;
	
	private ApplicationContext applicationContext = applicationContextprovider.getApplicationContext();
	
	@RequestMapping("logView")
	public String logView(Model model, HttpServletRequest request) {
		model.addAttribute("request", request);
		log = (LogService) applicationContext.getBean("logViewService");
		log.executeLog(model);
		return "log/logView";
	}
}
