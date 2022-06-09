<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<% com.green.beans.Member m1 = (com.green.beans.Member)request.getAttribute("member1");  %>
	이름 : <%=m1.getName() %><br>
	아이디 : <%=m1.getUserId() %><br>
</body>
</html>