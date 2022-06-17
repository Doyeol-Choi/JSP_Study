<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 등록 페이지 - 관리자 페이지</title>
<link type="text/css" href="style/product.css" rel="stylesheet">
</head>
<body>
	<div id="wrap">
		<form action="PWS" method="post" enctype="multipart/form-data">
			<table>
				<tr>
					<th><label for="name">상품 명</label></th>
					<td><input type="text" name="name" id="name" required></td>
				</tr>
				<tr>
					<th><label for="price">가격</label></th>
					<td><input type="number" name="price" id="price" required></td>
				</tr>
				<tr>
					<th>이미지</th>
					<td><input type="file" name="pictureurl"></td>
				</tr>
				<tr>
					<th><label for="description">상품 설명</label></th>
					<td><textarea rows="10" cols="80" name="description" id="description"></textarea></td>
				</tr>
				<tr>
					<td colspan="2">
						<input type="submit" value="등록">
						<input type="reset" value="다시 작성">
						<input type="button" value="목록 돌아가기" onclick="location.href='PLS'">
					</td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>