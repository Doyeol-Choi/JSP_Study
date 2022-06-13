<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%-- 자바의 데이터를 HTML 문서로 표기하는 방법 --%>
	
	<%
		String str = "안녕하세요";
		request.setAttribute("str", str);
	%>
	
	<%-- 1. 스크립트릿으로 출력 --%>
	<% out.println(str); %>
	
	<%-- 2. 표현식을 이용하는 방법 --%>
	<%=str %>
	
	<%-- 3. 액션태그 --%>

	
	<%-- 4. EL표기법 --%>
	${ str }
</body>
</html>