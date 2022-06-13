<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>POST 전송시 한글 깨짐</h3>
	<form action="ex20_result1.jsp" method="POST">
		이름 : <input type="text" name="name"><br>
		<input type="submit" value="제출">
	</form>
	
	<hr>
	<h3>POST 전송시 한글 방지</h3>
	<form action="ex20_result2.jsp" method="POST">
		이름 : <input type="text" name="name"><br>
		<input type="submit" value="제출">
	</form>
	
	<hr>
	<h3>POST 전송시 한글 방지2 - fmt를 이용한 방법</h3>
	<form action="ex20_result3.jsp" method="POST">
		이름 : <input type="text" name="name"><br>
		<input type="submit" value="제출">
	</form>
</body>
</html>