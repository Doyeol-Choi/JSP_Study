<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>자바 빈에 데이터 저장</h3>
	<jsp:useBean id="member" class="com.green.beans.Member" scope="request">
		<jsp:setProperty name="member" property="userId" value="hong"/>
		<jsp:setProperty name="member" property="userPwd" value="1234"/>
		<jsp:setProperty name="member" property="userName" value="홍길동"/>
	</jsp:useBean>
	
	<jsp:forward page="ex08_result.jsp"/>
</body>
</html>