<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cafe Menu</title>
<style>
	#container {
		width:600px;
		margin:20px auto;
	}
	table, th, tr, td {
		border:1px solid #ccc;
		border-collapse:collapse;
		padding:10px;
		text-align:center;
	}
	table { margin: 10px auto; }
	form { text-align:center; }
</style>
</head>
<body>
	<div id="container">
		<h2>커피 메뉴 선택 페이지</h2>
		<form action="CMS" method="post">
			<select name="coffeeName">
				<c:forEach var="cName" items="${cNames}">
					<option value="${cName}">${cName}</option>
				</c:forEach>
			</select> &nbsp;
			<select name="coffeeType">
				<option value="톨">톨</option>
				<option value="그란데">그란데</option>
				<option value="벤티">벤티</option>
			</select> &nbsp;
			<input style="width:35px" type="number" name="coffeeCount" value="1" min="1" max="100">잔 &nbsp;
			<input type="submit" name="선 택">
		</form>
		<br>
		<hr>
		<br>
		<c:if test="${coffeeList!=null}">
			<form action="ResetBtn" method="get">
				<input type="submit" value="전체 삭제">
			</form>
			<table border="1">
				<tr>
					<th>커피</th>
					<th>타입</th>
					<th>가격</th>
					<th>개수</th>
					<th>합계</th>
				</tr>
				<c:set var = "allTotal" value = "0"/>
				<c:forEach var="coffeeInfo" items="${coffeeList}">
					<tr>
						<td>${coffeeInfo.coffeeName}</td>
						<td>${coffeeInfo.coffeeType}</td>
						<td>${coffeeInfo.price}</td>
						<td>${coffeeInfo.count}</td>
						<td>${coffeeInfo.total}</td>	<!-- get메서드의 이름을 기반으로 불러온다 getTotal()이 있기 때문에 total로 호출 가능 -->
					</tr>
					<c:set var="allTotal" value="${allTotal + coffeeInfo.total}"/>
				</c:forEach>
				<tr>
					<td colspan="5" style="text-align:right;">
						<c:out value="최종 합산 가격 : ${allTotal}원"/>
					</td>
				</tr>
			</table>	
		</c:if>
	</div>
</body>
</html>