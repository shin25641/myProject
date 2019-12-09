<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:import url="../default/header.jsp" />
	
	<div align="center" >
			<h1>회원 목록</h1>
			<table border='1'>
			<tr>
				<th width="100">아이디</th><th width="100">비밀번호</th>
			</tr>
			<c:forEach var="dto" items="${list }">
			<tr>
				<td><a href="info?id=${dto.id }">${dto.id }</a></td>
				<td>${dto.pw }</td>
			</tr>
			</c:forEach>
			</table>
	</div>
	
	<c:import url="../default/footer.jsp" />
</body>
</html>




