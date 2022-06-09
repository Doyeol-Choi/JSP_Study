<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>쿠키 생성</h3>
	
	<%
		// 1. 쿠키 객체를 생성
		Cookie c = new Cookie("name", "홍길동");
		
		// 2. 쿠키 관련 설정
		c.setMaxAge(60*60*24*30);
		
		// 3. 클라이언트에게 쿠키를 전송
		response.addCookie(c);
		
		// 추가 쿠키 저장
		response.addCookie(new Cookie("age", "25"));
		response.addCookie(new Cookie("userid", "hong"));
		response.addCookie(new Cookie("userpwd", "1234"));
	%>
</body>
</html>