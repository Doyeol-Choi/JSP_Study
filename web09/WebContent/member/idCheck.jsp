<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>아이디 중복 체크 페이지</title>
<script type="text/javascript" src="./script/member.js"></script>
</head>
<body>
	<h2>아이디 중복 체크</h2>
	<form action="ICS" method="GET" name="frm">
		<label for="userid">아이디 : </label>
		<input type="text" name="userid" id="userid" value="${userid}">
		<input type="submit" value="중복 체크"><br>
		<c:if test="${result == 1}">	<%-- 중복 아이디 존재 --%>
			opener.document.frm.userid.value = "";
			<p>${userid}는 이미 사용중인 아이디 입니다.</p>
		</c:if>
		<c:if test="${result == -1}">	<%-- 사용 가능 아이디 --%>
			<p>${userid}는 사용가능한 아이디 입니다.</p>
			<input type="button" value="사용" onclick="idCk()">
		</c:if>
	</form>
</body>
</html>