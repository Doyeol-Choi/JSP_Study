<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.net.URLEncoder" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>핵션 태그 forward 예제</h1>
	<jsp:forward page="ex07_targetPage.jsp">
		<jsp:param value='<%= URLEncoder.encode("홍길동", "UTF-8") %>' name="name"/>
	</jsp:forward>
	
	<!-- 위 아래 같은 내용 -->
	
	<%-- <%
		request.setAttribute("name", "홍길동");
		request.getRequestDispatcher("ex07_targetPage.jsp").forward(request,response);
	%> --%>
</body>
</html>