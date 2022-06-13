<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>리퀘스트에 저장된 자바빈에서 프로퍼티 꺼내서 출력하기</h3>
	<h4>EL 표기법으로 출력</h4>
	아이디 : ${requestScope.member.userId}<br>
	비밀번호 : ${member["userPwd"]}<br>
	<!-- scope는 생략가능 -->
	이름 : ${member.userName}<br>
</body>
</html>