<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>영화 목록 등록</title>
<style>
	#container {
		width:971px;
		margin:20px auto;
	}
	form { text-align:center; }
	table {
		width:100%;
	}
	table, th, td {
		border:1px solid #ccc;
		border-collapse:collapse;
	}
</style>
</head>
<body>
	<div id="container">
		<h2>영화 등록 하기</h2>
		<form action="MDS" method="post" enctype="multipart/form-data">
			<table>
				<tr>
					<th><label for="code">코드 : </label></th>
					<td><input type="number" name="code" id="code" required></td>
				</tr>
				<tr>
					<th><label for="moviename">영화 이름 : </label></th>
					<td><input type="text" name="moviename" id="moviename" value="${mVo.moviename}" required></td>
				</tr>
				<tr>
					<th><label for="director">영화 감독 : </label></th>
					<td><input type="text" name="director" id="director" value="${mVo.director}" required></td>
				</tr>
				<tr>
					<th><label for="actor">주연 배우 : </label></th>
					<td><input type="text" name="actor" id="actor" value="${mVo.actor}" required></td>
				</tr>
				<tr>
					<th>이미지</th>
					<td>
						<input type="file" name="pictureurl" required>
					</td>
				</tr>
				<tr>
					<th><label for="price">가격 : </label></th>
					<td><input type="number" name="price" id="price" value="${mVo.price}" required></td>
				</tr>
				<tr>
					<td colspan="2">
						<input type="submit" value="등록">
						<input type="reset" value="재입력">
					</td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>