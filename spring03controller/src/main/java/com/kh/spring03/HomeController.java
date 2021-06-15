package com.kh.spring03;

import java.util.Random;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller//이 클래스가 컨트롤러 계층임을 명시하는 어노테이션(설정해두면 자동으로 컨트롤러로 인식함)
public class HomeController {

	
	@RequestMapping("/")
	public String home() {
		return "home";
	}
	//아래의 메소드는 /라는 요청에 대한 처리 내용임을 명시하는 어노테이션
	//매개변수에 model이라는 자료형으로 매개변수로 선언하면 자동 할당된다..
	//자동 할당된 model 객체에 데이터를 추가하면 자동으로 view로 전달된다.
	@RequestMapping("/dice")
	public String dice(Model model) {
		Random r = new Random();
		int dice = r.nextInt(6)+1;
		model.addAttribute("dice", dice);
		
		return "dice";
	}
	
	@RequestMapping("/plus")
	public String plus(HttpServletRequest req, Model model) {
		
		int total = Integer.parseInt(req.getParameter("a"))+Integer.parseInt(req.getParameter("b"));//이거 안해도 가능함 아래 메소드로
		model.addAttribute("total", total);
		
		//return "/WEB-INF/views/plus.jsp;
		return "plus";
	}
	
	@RequestMapping("/plus2")
	public String plus2(
			@RequestParam int a,//안적어도 알아서 파라미터 지정되지만 나중에 복잡해지면 표시를 해두는게 좋음
			@RequestParam int b,
			Model model) {
		model.addAttribute("total", a+b);
		return "plus";
	}
	
	@RequestMapping("/plus3")
	public String plus3(
			@ModelAttribute TestDto testDto,
			Model model) {
		model.addAttribute("total", testDto.getA()+testDto.getB());
		return "plus";
	}
}
