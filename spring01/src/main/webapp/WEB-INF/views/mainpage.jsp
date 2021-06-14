<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<h1>메인페이지</h1>

<h2><a href="hello">hello로 이동</a></h2>
<h2><a href="/spring01/hello">hello로 이동</a></h2>
<h2><a href="<%=request.getContextPath()%>/hello">hello로 이동</a></h2>
<h2><a href="${pageContext.request.contextPath}/hello">hello로 이동</a></h2>
