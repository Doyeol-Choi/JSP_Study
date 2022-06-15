<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="uploadServlet" method="post" enctype="multipart/form-data">
		<label for="name">글 쓴 이 : </label>
		<input type="text" name="name" id="name"><br>
		<label for="title">제    목 : </label>
		<input type="text" name="title" id="title"><br>
		<label for="fileUpload">파일지정 : </label>
		<input type="file" name="fileUpload" id="fileUpload"><br>
		<input type="submit" value="전송">
	</form>
</body>
</html>