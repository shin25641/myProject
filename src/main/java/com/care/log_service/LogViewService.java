package com.care.log_service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.care.log_dao.logDAO;

@Service
public class LogViewService implements LogService{
	@Autowired
	private logDAO dao;

	@Override
	public void executeLog(Model model) {
		List<Object> logList = dao.log_list();
		model.addAttribute("logList",logList);
	}
	
}
