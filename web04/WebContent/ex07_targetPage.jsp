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
	<h1>포워드로 이동된 페이지</h1>
	
	<%
		//String name = (String)request.getAttribute("name");
		String name = URLDecoder.decode(request.getParameter("name"), "UTF-8");
	%>
	<p><%=name %>님 환영합니다.</p>
</body>
</html>