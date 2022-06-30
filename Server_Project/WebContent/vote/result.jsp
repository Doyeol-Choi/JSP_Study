<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>후보자등수</title>
<link type="text/css" href="./css/style.css" rel="stylesheet">
<script type="text/javascript" src="./jQuery/jquery-3.6.0.js"></script>
</head>
<body>
	<div id="container">
		<jsp:include page="../header.html" />
		<div id="wrap">
			<h1>후보자 등수</h1>
			<table>
				<tr>
					<th>후보번호</th>
					<th>성명</th>
					<th>총투표건수</th>
				</tr>
				<!-- 서블릿에서 보낸 List를 하나씩 꺼내서 출력 -->
				<c:forEach var="result" items="${resultList}">
					<tr>
						<td>${result.no}</td>
						<td>${result.name}</td>
						<td>${result.count}</td>
					</tr>
				</c:forEach>
			</table>
		</div>
		<jsp:include page="../footer.html" />
	</div>
</body>
</html>