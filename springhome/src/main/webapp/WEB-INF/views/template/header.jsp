<%@page import="java.net.URLDecoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="root" value="${pageContext.request.contextPath}"></c:set>
<c:set var="isLogin" value="${not empty memberNo}"></c:set>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>내가 만든 홈페이지</title>
	<link rel="stylesheet" type="text/css" href="${root}/css/common.css">
	<link rel="stylesheet" type="text/css" href="${root}/css/menu.css">
	<link rel="stylesheet" type="text/css" href="${root}/css/layout.css">
	<link rel="stylesheet" type="text/css" href="${root}/css/test.css">
	<style>
		
	</style>
	
	<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
	<script src="${root}/js/confirm-link.js"></script>
	<script>
	
	</script>
</head>
<body>
	<main>
		<header>
			<h1>홈페이지 1달만에 박살내기</h1>
		</header>
		<nav>
			<!-- 메뉴 -->
			<ul class="menu">
				<li>
					<a href="#">회원 기능</a>
					<ul>
						<c:choose>
							<c:when test="${isLogin}">
								<li><a href="${root}/member/logout">로그아웃</a></li>
								<li><a href="${root}/member/myinfo">내 정보 보기</a></li>
								<li><a href="#">회원 조회/검색</a></li>
							</c:when>
							<c:otherwise>
								<li><a href="${root}/member/regist">회원 가입</a></li>
								<li><a href="${root}/member/login">로그인</a></li>
							</c:otherwise>
						</c:choose>
					</ul>
				</li> 
				<li>
					<a href="#">아이템 관리</a>
					<ul>
						<li><a href="#">아이템 등록</a></li>
						<li><a href="#">아이템 목록</a></li>
					</ul>
				</li>
				<c:if test="${isLogin}">
				<li>
					<a href="#">상품 관리</a>
					<ul>
						<li><a href="#">상품 등록</a></li>
						<li><a href="#">상품 목록</a></li>
						<li><a href="#">상품 검색(1)</a></li>
						<li><a href="#">상품 검색(2)</a></li>
					</ul>
				</li>
				</c:if>
				<li>
					<a href="#">자유게시판</a>
					<ul>
						<li><a href="#">게시글 작성</a></li>
						<li><a href="#">게시글 목록</a></li>
					</ul>
				</li>
			</ul>
		</nav>
		<section>