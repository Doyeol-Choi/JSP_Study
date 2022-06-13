<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>리퀘스트 내장 객체에 값을 저장</h3>
	<%
		request.setAttribute("num1", 10);
		session.setAttribute("num2", 20);
	%>
	<h3>표현식에서의 합계</h3>
	<%= request.getAttribute("num1") %> + <%= session.getAttribute("num2") %> = <%= (Integer)request.getAttribute("num1") + (Integer)session.getAttribute("num2") %>
	<h3>EL 표기법에서의 합계</h3>
	${requestScope.num1} + ${sessionScope.num2} = ${requestScope.num1 + sessionScope.num2}
</body>
</html>