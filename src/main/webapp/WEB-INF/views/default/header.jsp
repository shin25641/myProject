<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style type="text/css">
	.nav {height: 50px; }
	ul { margin: 0;}
	ul li{width: 200px; height: 200px; position: relative; display: inline; padding:0 10px; background-color: #5CD1E5;}
	#head-title {margin:0; color:burlywood; font-size:50px; font-family:Gabriola;}
</style>
</head>

<body>
	<div class="head-top" align="left">
		<h2 id="head-title">
		CARE &nbsp; LAB</h2>
	</div>
	
	<div class="nav" align='center'>
		<ul>
			<li><a href="index">HOME</a></li>
			<li>
				<c:choose>
					<c:when test="${loginUser == null }">
						<a href="login">게시판</a>
					</c:when>
					<c:otherwise>
						<a href="board_list">게시판</a>
					</c:otherwise>
				</c:choose>
			</li>
			<li>
				<c:choose>
					<c:when test="${loginUser == null }">
						<a href="login">회원정보</a>
					</c:when>
					<c:otherwise>
						<a href="memberInfo">회원정보</a>
					</c:otherwise>
				</c:choose>
			</li>
			<li>
				<c:choose>
					<c:when test="${loginUser == null }">
						<a href="login">로그보기</a>
					</c:when>
					<c:otherwise>
						<a href="logView">로그보기</a>
					</c:otherwise>
				</c:choose>
			</li>
			<li>
				<c:choose>
					<c:when test="${loginUser == null }">
						<a href="login">로그인</a>
					</c:when>
					<c:otherwise>
						<a href="logout">로그아웃</a>
					</c:otherwise>
				</c:choose>
			</li>
		</ul>
	</div>
</body>
</html>







