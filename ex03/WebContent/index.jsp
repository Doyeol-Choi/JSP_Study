<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.green.vo.CafeVO" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>카페 주문</title>
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
	#number { width:30px; }
</style>
</head>
<body>
	<div id="container">
		<table>
			<tr>
				<th>커피 명</th>
				<th>톨</th>
				<th>그란데</th>
				<th>벤티</th>
			</tr>
			<tr>
				<td>돌체 라떼</td>
				<td>5600</td>
				<td>6100</td>
				<td>6600</td>
			</tr>
			<tr>
				<td>화이트 초콜릿 모카</td>
				<td>5600</td>
				<td>6100</td>
				<td>6600</td>
			</tr>
			<tr>
				<td>카페 모카</td>
				<td>5100</td>
				<td>5600</td>
				<td>6100</td>
			</tr>
			<tr>
				<td>카페 라떼</td>
				<td>4600</td>
				<td>5100</td>
				<td>5600</td>
			</tr>
			<tr>
				<td>아메리카노</td>
				<td>4100</td>
				<td>4600</td>
				<td>5100</td>
			</tr>
			<tr>
				<td>오늘의 커피</td>
				<td>3800</td>
				<td>4300</td>
				<td>4800</td>
			</tr>
			<tr>
				<td>블론드 바닐라 더블샷 마키야또</td>
				<td>5600</td>
				<td>6100</td>
				<td>6600</td>
			</tr>
		</table>
		<br>
		<hr>
		<br>
		<form action="Basket" method="post" name="frm">
			<select name="coffee">
				<option value="돌체 라떼">돌체 라떼</option>
				<option value="화이트 초콜릿 모카">화이트 초콜릿 모카</option>
				<option value="카페 모카">카페 모카</option>
				<option value="카페 라떼">카페 라떼</option>
				<option value="아메리카노">아메리카노</option>
				<option value="오늘의 커피">오늘의 커피</option>
				<option value="블론드 바닐라 더블샷 마키아또">블론드 바닐라 더블샷 마키아또</option>
			</select>&nbsp;&nbsp;
			<select name="size">
				<option value="tall">톨</option>
				<option value="grande">그란데</option>
				<option value="venti">벤티</option>
			</select>&nbsp;&nbsp;
			<input type="number" name="number" id="number" value="1"> 잔 &nbsp;&nbsp;
			<input type="submit" value="선택">
		</form>
		<c:if test="${list != null}">
			<table>
				<tr>
					<th>커피</th>
					<th>타입</th>
					<th>가격</th>
					<th>개수</th>
					<th>합계</th>
					<th><a href="Basket?delete=0">전체 삭제</a></th>
				</tr>
				<c:set var="orderPrice" value="0"/>
				<c:forEach var="ilist" items="${list}">
					<tr>
						<td>${ilist.getCoffee()}</td>
						<td>${ilist.getSize()}</td>
						<td>${ilist.getPrice()}</td>
						<td>${ilist.getNumber()}</td>
						<td>${ilist.getTotal()}</td>
						<td><a href="Basket?delete=1&coffee=${ilist.getCoffee()}&price=${ilist.getPrice()}">제거</a></td>
					</tr>
					<c:set var="orderPrice" value="${orderPrice + ilist.getTotal()}"/>
				</c:forEach>
				<tr>
					<td colspan="6" style="text-align:right;">
						<c:out value="최종 합산 가격 : ${orderPrice}원"/>
					</td>
				</tr>
			</table>
		</c:if>
	</div>
</body>
</html>