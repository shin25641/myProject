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
		<form action="board_modify">
		<input type="text" name="id" value="${boardInfo.id }" hidden="true" >

			<table border="1">
				<tr>
					<th>번호</th><td>${boardInfo.id }</td>
				</tr>
				<tr>
					<th>조회수</th><td>${boardInfo.hit }</td>
				</tr>
				<tr>
					<th>이름</th><td><input type="text" name="name" value="${boardInfo.name }"></td>
				</tr>
				<tr>
					<th>제목</th><td><input type="text" name="title" value="${boardInfo.title }"></td>
				</tr>
				<tr>
					<th>내용</th><td><textarea name="content">${boardInfo.content }</textarea></td>
				</tr>
				<tr>
					<th><input type="submit" value="수정"> <a href="board_list">목록보기</a> <a href="board_delete?id=${boardInfo.id }">삭제</a> <a href="board_reply_view?id=${boardInfo.id }">답변</a></th>
				</tr>
			</table>
		</form>
	</div>
<c:import url="../default/footer.jsp" />
</body>
</html>