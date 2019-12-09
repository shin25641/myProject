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
info페이지<br>
	<c:set var="dto" value="${info }"></c:set>
	ID : ${dto.id }<br>
	PW : ${dto.pw }<br>
</body>
</html>