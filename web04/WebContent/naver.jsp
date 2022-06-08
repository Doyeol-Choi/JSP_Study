<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>네이버 웹툰으로 이동합니다.</h2>
	<% 
		response.sendRedirect("http://comic.naver.com/");
	%>
</body>
</html>