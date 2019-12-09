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
	<h2>게시판</h2>
	
		<table border="1">
			<tr>
				<th>번호</th><th>이름</th><th>제목</th><th>날짜</th><th>조회수</th><th>group</th><th>step</th><th>indent</th>
			</tr>
			<c:forEach var="Bdto" items="${boardList }">
			<tr>
				<th>${Bdto.id }</th><th>${Bdto.name }</th><th><a href="board_select_view?id=${Bdto.id }&hit=${Bdto.hit}">${Bdto.title}</a></th>
				<th>${Bdto.savedate }</th><th>${Bdto.hit }</th><th>${Bdto.idgroup }</th>
				<th>${Bdto.step }</th><th>${Bdto.indent }</th>
			</tr>
			</c:forEach>
			<tr>
				<th colspan="8"><a href="borad_write">글작성</a></th>
			</tr>
		</table>
<c:import url="../default/footer.jsp" />
	
</div>

</body>
</html>