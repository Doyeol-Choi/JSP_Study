<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		if(session.getAttribute("name")==null) {	// 로그인 안한 사람
			response.sendRedirect("loginForm.jsp");
		} else {	// 로그인을 한 사람
	%>
	<!-- 이름(아이디)님 환영합니다. -->
	<h2><%=session.getAttribute("name") %>(<%=session.getAttribute("id") %>)님 환영합니다.</h2>
	<p>저희 홈페이지에 오신 것을 환영합니다.</p>
	<form action="logout.jsp" method="post">
		<input type="submit" value="로그아웃">
	</form>
	<% } %>
</body>
</html>