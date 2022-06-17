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
		<h2>영화 정보 상세 보기</h2>
		<form action="MUS" method="post" enctype="multipart/form-data">
			<table>
				<tr>
					<td rowspan="6">
						<img src="upload/${mVo.pictureurl}" alt="movie">
					</td>
					<th><label for="code">코드 : </label></th>
					<td><input type="number" name="code" id="code" value="${mVo.code}" readonly></td>
				</tr>
				<tr>
					<th><label for="moviename">영화 이름 : </label></th>
					<td><input type="text" name="moviename" id="moviename" value="${mVo.moviename}"></td>
				</tr>
				<tr>
					<th><label for="director">영화 감독 : </label></th>
					<td><input type="text" name="director" id="director" value="${mVo.director}"></td>
				</tr>
				<tr>
					<th><label for="actor">주연 배우 : </label></th>
					<td><input type="text" name="actor" id="actor" value="${mVo.actor}"></td>
				</tr>
				<tr>
					<th>이미지</th>
					<td>
						<input type="file" name="pictureurl"><br>
						(주의사항 : 이미지를 변경하고자 할 때만 선택하세요.)
						<input type="hidden" name="originPictureUrl" value="${mVo.pictureurl}">
					</td>
				</tr>
				<tr>
					<th><label for="price">가격 : </label></th>
					<td><input type="number" name="price" id="price" value="${mVo.price}"></td>
				</tr>
				<tr>
					<td colspan="3">
						<input type="submit" value="수정">
						<input type="reset" value="취소">
						<input type="button" value="삭제" onclick="location.href='MDS?code=${mVo.code}&pic=${mVo.pictureurl}'">
						<input type="button" value="목록" onclick="location.href='MLS'">
					</td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>