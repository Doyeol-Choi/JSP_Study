<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>영화 목록</title>
<style>
	#container {
		width:600px;
		margin:20px auto;
	}
	table, th, tr, td {
		border:1px solid #ccc;
		border-collapse:collapse;
		padding:10px;
		text-align:center;
	}
	table { margin: 10px auto; }
	form { text-align:center; }
</style>
</head>
<body>
	<div id="container">
		<h2>영화 목록</h2>
		<table>
			<tr>
				<th>번호</th>
				<th>제목</th>
				<th>주연 배우</th>
			</tr>
		<c:forEach var="movieInfo" varStatus="i" items="${movieList}">
			<tr>
				<td>${i.count}</td>
				<td><a href="MUS?code=${movieInfo.code}">${movieInfo.moviename}</a></td>
				<td>${movieInfo.actor}</td>
			<tr>
		</c:forEach>
			<tr>
				<td colspan="3">
					<a href="MAS"><input type="button" value="영화 등록"></a>
				</td>
			</tr>
		</table>
	</div>
</body>
</html>