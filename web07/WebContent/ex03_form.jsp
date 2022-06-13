<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>파라미터로 넘겨줄 값 입력</h2>
	<form action="ex03_result.jsp" method="POST">
		아이디 : <input type="text" name="userId"><br>
		비밀번호 : <input type="password" name="userPwd"><br>
		<input type="submit" value="로그인">
	</form>
</body>
</html>