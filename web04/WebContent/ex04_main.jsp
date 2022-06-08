<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.net.URLDecoder" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%-- <h1><%= URLDecoder.decode(request.getParameter("name"), "UTF-8") %> 님 환영합니다.</h1> --%>
	<h1><%= request.getAttribute("name") %> 님 환영합니다.</h1>
	<hr>
	<p>저희 홈페이지를 방문해 주셔서 감사합니다.</p>
	<a href="ex04_loginForm.html">로그 아웃</a>
</body>
</html>