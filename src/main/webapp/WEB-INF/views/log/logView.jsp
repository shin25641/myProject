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
	<div align="center">
		<h2>로그 정보</h2>
		<table border="1">
			<tr>
				<th>번호</th><th>아이디</th><th>접속</th><th>종료</th><th>사용시간</th>
			</tr>
			<c:forEach var="logDto" items="${logList }">
			<tr>
				<th>${logDto.num }</th><th>${logDto.id }</th><th>${logDto.starttime }</th><th>${logDto.endtime }</th><th>${logDto.resulttime }</th>
			</tr>
			</c:forEach>
		</table>
	</div>

<c:import url="../default/footer.jsp" />


</body>
</html>