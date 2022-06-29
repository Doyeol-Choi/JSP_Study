<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>후보조회</title>
<link type="text/css" href="./css/style.css" rel="stylesheet">
</head>
<body>
	<div id="container">
		<jsp:include page="../header.html" />
		<div id="wrap">
		<h1>후보조회</h1>
		<table>
			<tr>
				<th>후보번호</th>
				<th>성명</th>
				<th>소속정당</th>
				<th>학력</th>
				<th>주민번호</th>
				<th>지역구</th>
				<th>대표전화</th>
			</tr>
			<!-- c:forEach를 통해 리스트에 담긴 값들을 순서대로 출력 -->
			<c:forEach items="${CandidateList}" var="Candidate">
				<tr>
					<td>${Candidate.no}</td>
					<td>${Candidate.name}</td>
					<td>${Candidate.partyname}</td>
					<td>
						<c:choose>
							<!-- school의 값에 따라 학력을 출력하기 위해 c:choose 태그 사용 -->
							<c:when test="${Candidate.school == 1}">고졸</c:when>
							<c:when test="${Candidate.school == 2}">학사</c:when>
							<c:when test="${Candidate.school == 3}">석사</c:when>
							<c:when test="${Candidate.school == 4}">박사</c:when>
						</c:choose>
					</td>
					<!-- fn:substring을 이용해 문자열을 잘라서 표기 -->
					<td>${fn:substring(Candidate.jumin,0,6)} - ${fn:substring(Candidate.jumin,6,13)}</td>
					<td>${Candidate.city}</td>
					<td>${Candidate.tel1}-${Candidate.tel2}-${Candidate.tel3}</td>
				</tr>
			</c:forEach>
		</table>
		</div>
		<jsp:include page="../footer.html" />
	</div>
</body>
</html>