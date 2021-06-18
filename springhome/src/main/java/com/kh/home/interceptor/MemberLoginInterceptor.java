package com.kh.home.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;

public class MemberLoginInterceptor implements HandlerInterceptor{

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
	//비회원의 접근 차단
		//참조 : 세션의 memberNo(없을 수 있으므로 Integer로 처리)
		Integer memberNo=(Integer)request.getSession().getAttribute("memberNo");
		if(memberNo==null) {
			response.sendRedirect(request.getContextPath()+"/member/login");
			return false;
		}
		
		return true;
	}
}
