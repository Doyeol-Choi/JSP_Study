<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>숫자 표기</h3>
	<fmt:formatNumber value="1234567.89"/><br> <!-- 1,234,567.89 -->
	<fmt:formatNumber value="1234567.89" groupingUsed="false"/><br> <!-- 1234567.89 -->
	
	<fmt:formatNumber value=".35" type="percent"/><br> <!-- 35% -->
	<fmt:formatNumber value="5000" type="currency"/><br> <!-- ₩5,000 => 톰캣이 한국으로 인식하고 있기 때문에 -->
	<fmt:formatNumber value="5000" type="currency" currencySymbol="£"/><br> <!-- £5,000 -->
	
	<hr>
	<h3>소수점 표시</h3>
	<fmt:formatNumber value="1234567.891234567" pattern="#,#00.0#"/><br> <!-- 1,234,567.89 => 천단위 , 표시 및 소수점 2째자리까지 표기 -->
	<fmt:formatNumber value="1234567.8" pattern="#,#00.0#"/><br> <!-- 1,234,567.8 -->
	<fmt:formatNumber value="1234567.8" pattern="#,#00.000"/><br> <!-- 1,234,567.800 -->
	<fmt:formatNumber value="12.8" pattern="#,#00.000"/><br> <!-- 12.800 -->
	<fmt:formatNumber value="12.8" pattern="0,000,000.000"/><br> <!-- 0,000,012.800 -->
	
	<hr>
	<h3>날짜 표기</h3>
	<c:set var="now" value="<%= new java.util.Date() %>"/>
	
	<fmt:formatDate value="${now}"/><br>	<!-- 2022. 6. 10 => 기본 type="date" -->
	<fmt:formatDate value="${now}" type="time"/><br>	<!-- 오후 4:37:10 -->
	<fmt:formatDate value="${now}" type="both"/><br>	<!-- 2022. 6. 10 오후 4:37:10 -->
	<fmt:formatDate value="${now}" pattern="yyyy년 MM월 dd일 hh시 mm분 ss초"/><br>	<!-- 2022년 6월 10일 04시 39분 53초 => mm은 분 MM은 월 -->
	
	<hr>
	<fmt:timeZone value="GMT">
		GMT : <fmt:formatDate value="${now}" type="both"/><br> <!-- 영국시간 GMT -->
	</fmt:timeZone>
	<fmt:timeZone value="GMT+9">
		GMT+9 : <fmt:formatDate value="${now}" type="both"/><br> <!-- 한국시간 -->
	</fmt:timeZone>
	
	<hr>
	톰캣 서버의 기본 로케일 : <%= response.getLocale() %><br>
	<br>
	<fmt:setLocale value="zh_CN"/>
	로케일을 중국으로 설정한 후 로케일 확인 : <%= response.getLocale() %><br>
	통화 : <fmt:formatNumber value="10000" type="currency"/><br>
	날짜 : <fmt:formatDate value="${now}" type="both"/><br>
	
	<hr>
	<fmt:setLocale value="ja_JP"/>
	로케일을 일본으로 설정한 후 로케일 확인 : <%= response.getLocale() %><br>
	통화 : <fmt:formatNumber value="10000" type="currency"/><br>
	날짜 : <fmt:formatDate value="${now}" type="both"/><br>
	
	<hr>
	<fmt:setLocale value="en_US"/>
	로케일을 미국으로 설정한 후 로케일 확인 : <%= response.getLocale() %><br>
	통화 : <fmt:formatNumber value="10000" type="currency"/><br>
	날짜 : <fmt:formatDate value="${now}" type="both"/><br>
	
	<hr>
	<fmt:setLocale value="lt_LT"/>
	로케일을 리투아니아로 설정한 후 로케일 확인 : <%= response.getLocale() %><br>
	통화 : <fmt:formatNumber value="10000" type="currency"/><br>
	날짜 : <fmt:formatDate value="${now}" type="both"/><br>
	
	<hr>
	<fmt:setLocale value="ko_KR"/>
	로케일을 한국으로 설정한 후 로케일 확인 : <%= response.getLocale() %><br>
	통화 : <fmt:formatNumber value="10000" type="currency"/><br>
	날짜 : <fmt:formatDate value="${now}" type="both"/><br>
	
</body>
</html>