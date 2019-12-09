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
		<form action="board_reply_save">
		<input type="text" name="id" value="${boardReply.id }" hidden="true" >

			<table border="1">
				<tr>
					<th>번호</th><td>${boardReply.id }</td>
				</tr>
				<tr>
					<th>조회수</th><td>${boardReply.hit }</td>
				</tr>
				<tr>
					<th>이름</th><td><input type="text" name="name" value="${boardReply.name }"></td>
				</tr>
				<tr>
					<th>제목</th><td><input type="text" name="title" value="${boardReply.title }"></td>
				</tr>
				<tr>
					<th>내용</th><td><textarea name="content">${boardReply.content }</textarea></td>
				</tr>
				<tr>
					<th><input type="submit" value="답변"> <a href="board_list">목록보기</a></th>
				</tr>
			</table>
		</form>
	</div>
<c:import url="../default/footer.jsp" />
</body>
</html>