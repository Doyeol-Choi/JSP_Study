<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="javax.servlet.RequestDispatcher" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>1</h1>
<%
	// 데이터 저장용 내장 객체
	// 데이터를 저장하는 방법 setAttribute("이름", 데이터);
	// 저장된 데이터를 꺼내는 방법 getAttribute("이름");
	
	pageContext.setAttribute("name", "page Data");
	request.setAttribute("name", "request Data");
	session.setAttribute("name", "session Data");
	application.setAttribute("name", "application Data");
	
	System.out.println("ex05_firstPage.jsp");
	System.out.println("하나의 페이지 속성 : " + pageContext.getAttribute("name"));
	System.out.println("하나의 리퀘스트 속성 : " + request.getAttribute("name"));
	System.out.println("하나의 세션 속성 : " + session.getAttribute("name"));
	System.out.println("하나의 애플리케이션 속성 : " + application.getAttribute("name"));
	
	// 포워드로 세컨드 페이지로 이동
	RequestDispatcher dispatcher = request.getRequestDispatcher("ex05_secondPage.jsp");
	dispatcher.forward(request, response);
%>
</body>
</html>