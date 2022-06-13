<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%-- El 표기법 --%>
	<%-- 1. 데이터(숫자, 문자열등)를 그대로 출력한다. --%>
	정수타입 : ${30}<br>
	실수타입 : ${3.14}<br>
	문자열 타입 : ${"안녕하세요"}<br>
	논리타입 : ${true}<br>
	null(null값을 EL표기를 하면 출력되지 않는다.) : ${null}<br>
	<hr>
	<%-- 2. 산술연산도 가능하다. --%>
	5+2 = ${5+2}<br>
	5-2 = ${5-2}<br>
	5*2 = ${5*2}<br>
	5/2 = ${5/2}<br>
	5%2 = ${5%2}<br>
	<hr>
	<%-- 3. 비교연산도 가능하다. --%>
	5>2 : ${5>2}<br>
	5>2 : ${5 gt 2}<br>
</body>
</html>