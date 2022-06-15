<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 정보 수정 페이지</title>
<script type="text/javascript" src="./script/member.js"></script>
</head>
<body>
	<h2>회원 정보 수정 페이지</h2>
	<form action="MUS" method="post" name="frm">
		<table>
			<tr>
				<td><label for="name">이름 : </label></td>
				<td><input type="text" name="name" id="name" value="${mVo.name}" readonly></td>
			</tr>
			<tr>
				<td><label for="userid">아이디 : </label></td>
				<td><input type="text" name="userid" id="userid" value="${mVo.userid}" readonly></td>
			</tr>
			<tr>
				<td><label for="userpwd">비밀번호 : </label></td>
				<td><input type="password" name="userpwd" id="userpwd"></td>
			</tr>
			<tr>
				<td><label for="pwdChk">비밀번호 확인 : </label></td>
				<td><input type="password" name="pwdChk" id="pwdChk"></td>
			</tr>
			<tr>
				<td><label for="email">이메일 : </label></td>
				<td><input type="email" name="email" id="email" value="${mVo.email}"></td>
			</tr>
			<tr>
				<td><label for="phone">전화번호 : </label></td>
				<td><input type="tel" name="phone" id="phone" value="${mVo.phone}"></td>
			</tr>
			<tr>
				<td>등급 : </td>
				<td>
					<c:if test="${mVo.admin == 0}">
						<input type="radio" name="admin" id="admin0" value="0" checked><label for="admin0"> 일반회원 </label>
						<input type="radio" name="admin" id="admin1" value="1"><label for="admin1"> 관리자 </label>
					</c:if>
					<c:if test="${mVo.admin == 1}">
						<input type="radio" name="admin" id="admin0" value="0"><label for="admin0"> 일반회원 </label>
						<input type="radio" name="admin" id="admin1" value="1" checked><label for="admin1"> 관리자 </label>
					</c:if>
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="수정" onclick="return updateCheck()">
					<input type="reset" value="취소">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>