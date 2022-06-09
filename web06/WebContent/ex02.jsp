<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:useBean id="m1" class="com.green.beans.Member" scope="session"/>
	
	<%-- 액션태그로 값을 저장해 봅시다. --%>
	<%-- m1.setName("홍길동");	// 어떤 변수 : m1, 어떤 필드 : name, 어떤 데이터 : 홍길동 --%>
	<jsp:setProperty property="name" name="m1" value="홍길동"/>
	
	<%-- 액션태그로 값을 출력해 봅시다. --%>
	<%-- m1.getName();	// 어떤 변수 : m1, 어떤 필드 : name --%>
	저장된 이름 : <jsp:getProperty property="name" name="m1"/><br>
	<%-- 액션 태그로 출력할때는 출력문(<%=  %>) 사용 안해도 됨 --%>
</body>
</html>