package com.kh.spring01;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

//Spring은 요청 처리를 위해 컨트롤러를 생성하도록 요구한다.
//과거의 스프링에서는 controller라는 인터페이스를 상속받도록 요구한다.
//modelandview 모델과 뷰의 정보가 담긴 객체
// view 결과가 표시될 화면의 정보(ex:jsp)
// model : 결과가 표시될 화면으로 전달될 데이터
// control : 입력받은 정보를 어떻게 처리할 것인지 선택하는 것

public class HelloController implements Controller{

	@Override
	public ModelAndView handleRequest(
			HttpServletRequest request, HttpServletResponse response) 
					throws Exception {
		
		//이 컨트롤러에서는 modelandview 객체를 만들어서 다음 페이지와 연결시키는게 목적
		ModelAndView mv = new ModelAndView();
		mv.addObject("Message","스프링에 오신 것을 환영합니다");
		mv.setViewName("/WEB-INF/views/hello.jsp");
		return mv;
	}

}
