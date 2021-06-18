<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>

<style>
	.my-board-list {
		margin: 0;
		padding:0;
		list-style: none;
		border:1px solid black;
	}
	.my-board-list > li{
		padding:0.5rem;
	}
	.my-board-list > li:nth-child(2n) {
		background-color:rgba(0, 0, 0, 0.1);
	}
	.my-board-list > li > a{
		text-decoration: none;
		color:black;
	}
	.my-board-list > li > a:hover{
		color:red;
	}
</style>

<div class="container-600">
	<div class="row">
		<h2>나의 정보</h2>
	</div>
	<div class="row">
		<table class="table table-border">
			<tr>
				<th width="25%">회원번호</th>
				<td>${memberDto.memberNo}</td>
			</tr>
			<tr>
				<th>아이디</th>
				<td>${memberDto.memberId}</td>
			</tr>
			<tr>
				<th>닉네임</th>
				<td>${memberDto.memberNick}</td>
			</tr>
			<tr>
				<th>생년월일</th>
				<td>${memberDto.memberBirth}</td>
			</tr>
			<tr>
				<th>전화번호</th>
				<td>${memberDto.memberPhone}</td>
			</tr>
			<tr>
				<th>이메일</th>
				<td>${memberDto.memberEmail}</td>
			</tr>
			<tr>
				<th>등급</th>
				<td>${memberDto.memberGrade}</td>
			</tr>
			<tr>
				<th>포인트</th>
				<td>${memberDto.memberPoint} point</td>
			</tr>
			<tr>
				<th>가입일</th>
				<td>${memberDto.memberJoin}</td>
			</tr>
		</table>
	</div>
	
	<!-- 이용 가능한 메뉴 구성 -->
	<div class="row">
		<a href="change_pw" class="link-btn">비밀번호 변경</a>
		<a href="change_info" class="link-btn">개인정보 변경</a>
		<a href="exit" class="link-btn confirm-link" data-message="정말 탈퇴하시겠습니까?">회원 탈퇴</a>
	</div>
	
	<div class="row text-left">
		<h4>내가 작성한 게시글</h4>
	</div>
	<div class="row text-left">
		<ul class="my-board-list">
			<c:forEach var="boardListDto" items="${myBoardList}">
			<li>
				<a href="${pageContext.request.contextPath}/board/boardDetail.jsp?boardNo=${boardListDto.boardNo}">
					${boardListDto.boardTitle}
				</a>
			</li>
			</c:forEach>
		</ul>
	</div>
	
	<div class="row text-left">
		<h4>내가 좋아요한 게시글</h4>
	</div>
	<div class="row text-left">
		<ul class="my-board-list">
			<c:forEach var="boardListDto" items="${myLikeList}">
			<li>
				<a href="${pageContext.request.contextPath}/board/boardDetail.jsp?boardNo=${boardListDto.boardNo}">
					${boardListDto.boardTitle}
				</a>
			</li>
			</c:forEach>
		</ul>
	</div>
</div>

<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>
