<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>영화 상세 정보</title>
<style>
	#container {
		width:600px;
		margin:20px auto;
	}
	form { text-align:center; }
</style>
</head>
<body>
	<div id="container">
		<h2>영화 정보 상세 보기</h2>
		<form action="MUS" method="post">
			<label for="code">코드 : </label>
			<input type="number" name="code" id="code" value="${movieList.get(i).code}" readonly><br>
			<label for="moviename">영화 이름 : </label>
			<input type="text" name="moviename" id="moviename" value="${movieList.get(i).moviename}"><br>
			<label for="director">영화 감독 : </label>
			<input type="text" name="director" id="director" value="${movieList.get(i).director}"><br>
			<label for="actor">주연 배우 : </label>
			<input type="text" name="actor" id="actor" value="${movieList.get(i).actor}"><br>
			<label for="price">가격 : </label>
			<input type="number" name="price" id="price" value="${movieList.get(i).price}"><br>
			<input type="submit" value="수정">
			<a href="MDS?code=${movieList.get(i).code}"><input type="button" value="삭제"></a>
		</form>
	</div>
</body>
</html>