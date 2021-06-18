<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>

<div class="container-600">
	<div class="row">
		<h2>회원 정보 변경</h2>
	</div>
	
	<form action="change_info" method="post">
		<div class="row text-left">
			<label>닉네임</label>
			<input type="text" name="memberNick" required class="form-input form-input-underline"
							value="${memberDto.memberNick}">
		</div>
		<div class="row text-left">
			<label>생년월일</label>
			<input type="date" name="memberBirth" required class="form-input form-input-underline"
							value="${memberDto.memberBirth}">
		</div>
		<div class="row text-left">
			<label>전화번호</label>
			<input type="text" name="memberPhone" required class="form-input form-input-underline"
							value="${memberDto.memberPhone}">
		</div>
		<div class="row text-left">
			<label>이메일</label>
			<input type="text" name="memberEmail" class="form-input form-input-underline"
							value="${memberDto.memberEmail}">
		</div>
		
		<div class="row text-left">
			<label>현재비밀번호</label>
			<input type="password" name="memberPw" required class="form-input form-input-underline">
		</div>
		
		<!-- 오류인 상황에는 오류 메세지를 추가해준다 -->
		<c:if test="${param.error != null}">
		<div class="row">
			<h5 class="error">정보가 일치하지 않습니다</h5>
		</div>
		</c:if>
		
		<div class="row">
			<input type="submit" value="수정하기" class="form-btn form-btn-negative">
		</div>
		
	</form>
</div>

<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>