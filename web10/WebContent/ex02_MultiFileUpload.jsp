<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>한꺼번에 다수의 파일을 업로드</title>
</head>
<body>
	<h2>한꺼번에 다수의 파일을 업로드</h2>
	<form action="MultiUploadServlet" method="post" enctype="multipart/form-data">
		1. 파일 지정 : <input type="file" name="uploadFile01" accept=".jpg,png"><br>	<!-- accept => 확장자 제한 -->
		2. 파일 지정 : <input type="file" name="uploadFile02"><br>
		3. 파일 지정 : <input type="file" name="uploadFile03"><br>
		4. 파일 지정 : <input type="file" name="uploadFile04"><br>
		<input type="submit" value="전송">
	</form>
</body>
</html>