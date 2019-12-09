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
	<form action="board_write_save">
		<table border="1">
			<tr>
				<th>이름</th><th><input type="text" name="name"></th>
			</tr>
			<tr>
				<th>제목</th><th><input type="text" name="title"></th>
			</tr>
			<tr>
				<th>내용</th><th><textarea name="content"></textarea></th>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="저장"><a href="board_list">목록보기</a></td>
			</tr>
		</table>
	</form>
</div>

<c:import url="../default/footer.jsp" />

</body>
</html>