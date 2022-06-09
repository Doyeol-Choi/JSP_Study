<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>쿠키 읽어오기</h3>
	<%
		Cookie[] cookies = request.getCookies();	// getcookies는 최대 300개의 여러 쿠키를 배열의 형태로 가져온다.
		for(int i=0; i<cookies.length; i++) {
			out.println(cookies[i].getName() + " : " + cookies[i].getValue() + "<br>");
		}
	%>
</body>
</html>