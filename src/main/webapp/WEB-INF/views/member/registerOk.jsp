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
<c:choose>
	<c:when test="${insert == 1 }">
		<script type="text/javascript">
			alert('회원가입이 완료 되었습니다.'); location.href="login";
		</script>
	</c:when>
	<c:otherwise>
		<script type="text/javascript">
			alert('가입 오류'); location.href="login";
		</script>
	</c:otherwise>
</c:choose>
</body>
</html>