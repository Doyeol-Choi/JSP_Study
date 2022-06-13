<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>EL 표기법의 내장 객체 생략</h3>
	<%
		// 각 내장 객체에 데이터 저장
		pageContext.setAttribute("name", "페이지");
		request.setAttribute("name", "리퀘스트");
		session.setAttribute("name", "세션");
		application.setAttribute("name", "어플리케이션");
	%>
	
	<h3>EL 표기법으로 내장객체에 저장된 데이터 출력</h3>
	page속성 : ${pageScope.name}<br>
	request속성 : ${requestScope.name}<br>
	session속성 : ${sessionScope.name}<br>
	application속성 : ${applicationScope.name}<br>
	<hr>
	이름 : ${name}<br>
</body>
</html>