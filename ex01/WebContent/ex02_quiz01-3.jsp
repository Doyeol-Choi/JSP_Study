<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>상품 목록 페이지</h1>
	<%
		String[] a_name = (String[])session.getAttribute("a_name");
		for(int i=0; i<=10; i++) {
			if(a_name[i]!=null) {
				%>
				<a href="ex02_quiz01-4.jsp"><%= a_name[i] %></a>
				<%
			} else {
				break;
			}
		}
	%>
	<a href="ex02_quiz01.jsp">상품 등폭 페이지로 가기</a>
</body>
</html>