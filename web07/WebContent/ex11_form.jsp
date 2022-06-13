<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>색상을 선택하세요.</h3>
	<form action="ex11_result.jsp" method="POST">
		<label for="color"> 색을 선택하세요 </label><br>
		<select id="color" name="color">
			<option value="red">빨강</option>
			<option value="blue">파랑</option>
			<option value="green">초록</option>
		</select>
		<input type="submit" value="선택">
	</form>
</body>
</html>