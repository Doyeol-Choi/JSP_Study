<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>쿠키 삭제</h3>
	<%
		// 쿠키를 삭제하는 기능은 존재하지 않는다.
		
		Cookie c = new Cookie("name", "jklsdfsd");	// 이름이 같은 쿠키를 덮어쓴다.
		c.setMaxAge(0);		// 쿠키가 남아있는 시간을 0초로 지정해서 쿠키를 삭제 해준다.
		response.addCookie(c);	//	시간이 0이 된 쿠키를 올린다.
	%>
</body>
</html>