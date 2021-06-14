package com.kh.spring02;

import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class DiceController implements Controller{

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mv = new ModelAndView();
		
		Random R = new Random();
		
		int x = R.nextInt(6)+1;
		mv.addObject("dice",x);
		mv.setViewName("WEB-INF/views/dice.jsp");
		return mv;
	}

	
}
