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
		<c:set var="count" value="0"/>
		<c:forEach var="movieInfo" items="${movieList}">
			<tr>
				<td>${count+1}</td>
				<td><a href="MUS?num=${count}">${movieInfo.moviename}</a></td>
				<td>${movieInfo.actor}</td>
			<tr>
		<c:set var="count" value="${count+1}"/>
		</c:forEach>
		</table>
	</div>
</body>
</html>