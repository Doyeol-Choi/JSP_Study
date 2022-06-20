<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판 목록</title>
<link type="text/css" href="css/board.css" rel="stylesheet">
</head>
<body>
	<div id="wrap" align="center">
		<h1>게시판 목록</h1>
		<table class="list">
			<tr>
				<td colspan="5" style="border:white; text-align:right">
					<button onclick="location.href='BS?command=board_write_form'">게시글 등록</button>
				</td>
			</tr>
			<tr>
				<th>번호</th>
				<th>제목</th>
				<th>작성자</th>
				<th>작성일</th>
				<th>조회수</th>
			</tr>
			<c:forEach var="board" items="${boardList}">
				<tr>
					<td>${board.num}</td>
					<td><a href="BS?command=board_view&num=${board.num}">${board.title}</a></td>
					<td>${board.name}</td>
					<td><fmt:formatDate value="${board.writeDate}"/></td>
					<td>${board.readCount}</td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>