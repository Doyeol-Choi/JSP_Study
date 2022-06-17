<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 리스트 - 관리자 페이지</title>
<link type="text/css" href="style/product.css" rel="stylesheet">
</head>
<body>
	<div id="wrap" align="center">
		<h1>상품 리스트 - 관리자 페이지</h1>
		<table class="List">
			<tr>
				<th>번호</th>
				<th>코드</th>
				<th>이름</th>
				<th>가격</th>
				<th>수정</th>
				<th>삭제</th>
			</tr>
			<c:forEach var="product" varStatus="s" items="${productList}">
				<tr>
					<td>${s.count}</td>
					<td>${product.code}</td>
					<td>${product.name}</td>
					<td><fmt:formatNumber value="${product.price}" type="currency"/></td>
					<td><a href="PUS?code=${product.code}">상품 수정</a></td>
					<td><a href="PDS?code=${product.code}&url=${product.pictureurl}">상품 삭제</a></td>
				</tr>
			</c:forEach>
			<tr>
				<td colspan="6" style="border:white; text-align:center;">
					<a href="PWS"><button>상품 등록</button></a>
				</td> 
			</tr>
		</table>
	</div>
</body>
</html>