<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>강사 등록 페이지</title>
<link type="text/css" href="css/course.css" rel="stylesheet">
</head>
<body>
	<div id="container">
		<h1>강사 등록</h1>
		<form action="CS" method="post">
			<input type="hidden" name="command" value="lecturer_insert">
			<table>
				<tr>
					<th>강사 번호</th>
					<td><input type="number" name="idx" id="idx" value="${idx}" readonly></td>
				</tr>
				<tr>
					<th><label for="name">강사 명</label></th>
					<td><input type="text" name="name" id="name" required></td>
				</tr>
				<tr>
					<th><label for="major">전공</label></th>
					<td><input type="text" name="major" id="major" required></td>
				</tr>
				<tr>
					<th><label for="field">세부 전공</label></th>
					<td><input type="text" name="field" id="field" required></td>
				</tr>
				<tr>
					<td colspan="2">
						<input type="submit" value="등록">&nbsp;
						<input type="button" value="목록" onclick="location.href='CS?command=lecturer_list'">
					</td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>