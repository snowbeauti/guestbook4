<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="/guestbook4/guest/delete" method="get">
		비밀번호 <input type="password" name="password" value=""> <input
			type="hidden" name="no" value="${param.no}">

		<c:if test="${param.result == 'fail'}">
			<p>비밀번호가 일치하지 않습니다.</p>
		</c:if>
		<button type="submit">확인</button>
	</form>
	<a href="/guestbook4/guest/addlist">메인으로 돌아가기</a>
</body>
</html>