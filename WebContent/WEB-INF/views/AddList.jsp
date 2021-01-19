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
	<form action="/guestbook4/guest/add" method="get">
		<table border="1" width="800px">
			<tr>
				<td>이름</td>
				<td><input type="text" name="name" value=""></td>
				<td>비밀번호</td>
				<td><input type="password" name="password" value=""></td>
			</tr>

			<tr>
				<td colspan="4"><textarea name="content"></textarea></td>
			</tr>

			<tr>
				<td colspan="4">
					<button type="submit">확인</button>
				</td>
			</tr>

		</table>
	</form>
	<br>


	<c:forEach items="${gList}" var="gvo">
		<table border="1" width="800px">

			<tr>
				<td width="150px">${gvo.no}<input type="hidden" name="no"
					value="${gvo.no}"></td>
				<td width="200px">${gvo.name}</td>
				<td width="300px">${gvo.regDate}</td>
				<td width="150px"><a
					href="/guestbook4/guest/dform?no=${gvo.no}">삭제</a></td>

			</tr>
			<tr>
				<td colspan="4">${gvo.content}</td>
			</tr>

		</table>
	</c:forEach>
	<br>


</body>
</html>