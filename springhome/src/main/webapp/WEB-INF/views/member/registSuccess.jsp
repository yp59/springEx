<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>

<div class="container-600">
	<div class="row">
		<h2>가입이 완료되었습니다</h2>
		<p>로그인 하셔서 다양한 경험을 시작하세요!</p>
	</div>
	
	<div class="row">
		<img src="${pageContext.request.contextPath}/image/background.jpg" width="100%">
	</div>
	
	<div class="row">
		<h3><a href="#">로그인</a></h3>
	</div>
	<div class="row">
		<h3><a href="#">메인 페이지</a></h3>
	</div>
</div>

<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>