package com.kh.spring02;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class PlusController implements Controller{

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		int plus = Integer.parseInt(request.getParameter("a"))+Integer.parseInt(request.getParameter("b"));
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("plus", plus);
		mv.setViewName("WEB-INF/views/plus.jsp");
		return mv;
	}
	

}
