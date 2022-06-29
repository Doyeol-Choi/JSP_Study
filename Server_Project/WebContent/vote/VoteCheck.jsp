<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>투표 검수 조회</title>
<link type="text/css" href="./css/style.css" rel="stylesheet">
</head>
<body>
	<div id="container">
		<jsp:include page="../header.html"/>
		<div id="wrap">		
			<h1>투표 검수 조회</h1>
			<table>
				<tr>
					<th>성명</th>
					<th>생년월일</th>
					<th>나이</th>
					<th>성별</th>
					<th>후보번호</th>
					<th>투표시간</th>
					<th>유권자확인</th>
				</tr>
				<c:forEach items="${VoteCheck}" var="Vote">
					<tr>
						<td>${Vote.name}</td>
						<td>
							<!-- 7번째 숫자의 크기에 따라 1900년대와 2000년대 표기를 나눔 -->
							<c:if test="${fn:substring(Vote.jumin,6,7) < 3}">
								19${fn:substring(Vote.jumin,0,2)}년 ${fn:substring(Vote.jumin,2,4)}월 ${fn:substring(Vote.jumin,4,6)}일 생
							</c:if>
							<c:if test="${fn:substring(Vote.jumin,6,7) >= 3}">
								20${fn:substring(Vote.jumin,0,2)}년 ${fn:substring(Vote.jumin,2,4)}월 ${fn:substring(Vote.jumin,4,6)}일 생
							</c:if>
						</td>
						<td>
							<!-- 기준으로 잡은 2020년05월을 기준으로 만 나이 계산 -->
							만 ${fn:substring((202005-(190000+(fn:substring(Vote.jumin,0,4)))),0,2)}세
						</td>
						<td>
							<!-- 주민등록번호 7번째 숫자를 기준으로 남자와 여자를 출력 2로 나눈 나머지가 홀수면 남자 짝수면 여자-->
							<c:if test="${fn:substring(Vote.jumin,6,7)%2 == 1}">남자</c:if>
							<c:if test="${fn:substring(Vote.jumin,6,7)%2 == 0}">여자</c:if>
						</td>
						<td>${Vote.no}</td>
						<td>
							<!-- fn:substring을 이용해서 문자열을 잘라서 표기 -->
							${fn:substring(Vote.time,0,2)}:${fn:substring(Vote.time,2,4)}
						</td>
						<td>
							<c:if test="${Vote.confirm == 'Y'}">확인</c:if>
							<c:if test="${Vote.confirm == 'N'}">미확인</c:if>
						</td>
					</tr>
				</c:forEach>
			</table>
		</div>
		<jsp:include page="../footer.html" />
	</div>
</body>
</html>