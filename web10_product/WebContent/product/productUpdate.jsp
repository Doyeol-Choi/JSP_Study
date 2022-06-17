<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 수정 페이지 - 관리자 페이지</title>
<link type="text/css" href="style/product.css" rel="stylesheet">
</head>
<body>
	<div id="wrap">
		<h1>상품 수정 페이지 - 관리자</h1>
		<form action="PUS" method="post" enctype="multipart/form-data">
			<table>
				<tr>
					<td rowspan="4">
						<c:choose>
							<c:when test="${empty pVo.pictureurl}">
								<img src="./upload/noimage.jpg" alt="이미지 없음">
							</c:when>
							<c:otherwise>
								<img src="./upload/${pVo.pictureurl}" alt="상품 이미지">
							</c:otherwise>
						</c:choose>
						<input type="hidden" name="code" id="code" value="${pVo.code}">
					</td>
					<th><label for="name">상품 명</label></th>
					<td><input type="text" name="name" id="name" value="${pVo.name}" required></td>
				</tr>
				<tr>
					<th><label for="price">가격</label></th>
					<td><input type="number" name="price" id="price" value="${pVo.price}" required>원</td>
				</tr>
				<tr>
					<th>이미지</th>
					<td>
						<input type="file" name="pictureurl"><br>
						(주의사항 : 이미지를 변경하고자 할 때만 선택하세요.)
						<input type="hidden" name="originPictureUrl" value="${pVo.pictureurl}">
					</td>
				</tr>
				<tr>
					<th><label for="description">상품 설명</label></th>
					<td><textarea rows="10" cols="40" name="description" id="description">${pVo.description}</textarea></td>
				</tr>
				<tr>
					<td colspan="3">
						<input type="submit" value="수정하기">&nbsp;
						<input type="reset" value="다시작성">&nbsp;
						<input type="button" value="목록으로 돌아가기" onclick="location.href='PLS'">
					</td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>