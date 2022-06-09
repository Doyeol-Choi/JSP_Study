<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>바탕화면 색을 선택하세요.</h1>
	<form action="bgColor.jsp" method="get">
		<select name="bgcolor">
			<option value="red">빨강</option>
			<option value="blue">파랑</option>
			<option value="green">초록</option>
		</select>
		<input type="submit" value="선택">
	</form>
</body>
</html>