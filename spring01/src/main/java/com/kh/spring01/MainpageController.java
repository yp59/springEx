package com.kh.spring01;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class MainpageController implements Controller{

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {


		ModelAndView mv = new ModelAndView();
		mv.setViewName("/WEB-INF/views/mainpage.jsp");
		
		return mv;
	}

	
}
