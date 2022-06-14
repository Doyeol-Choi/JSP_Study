<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 가입 페이지</title>
<script type="text/javascript" src="./script/member.js"></script>
<style>
	table, tr, td {
		border:1px solid #ccc;
		border-collapse:collapse;
		padding:10px;
	}
</style>
</head>
<body>
	<h2>회원 가입 페이지</h2>
	<span>'*' 표시 항목은 필수 입력사항입니다.</span>
	<form action="JS" method="POST" name="frm">
		<table>
			<tr>
				<td><label for="name">이름</label></td>
				<td><input type="text" name="name" id="name" size="20"> * </td>
			</tr>
			<tr>
				<td><label for="userid">아이디</label></td>
				<td>
					<input type="text" name="userid" id="userid" size="20"> *
					<input type="hidden" name="reid" size="20"> 
					<input type="button" value="중복체크" onclick="idCheck()">
				</td>
			</tr>
			<tr>
				<td><label for="userpwd">비밀번호</label></td>
				<td><input type="password" name="userpwd" id="userpwd" size="20"> * </td>
			</tr>
						<tr>
				<td><label for="pwdChk">비밀번호확인</label></td>
				<td><input type="password" name="pwdChk" id="pwdChk" size="20"> * </td>
			</tr>
			<tr>
				<td><label for="email">이메일</label></td>
				<td><input type="email" name="email" id="email" size="20"></td>
			</tr>
			<tr>
				<td><label for="phone">전화번호</label></td>
				<td><input type="tel" name="phone" id="phone" size="20"> * </td>
			</tr>
			<tr>
				<td>권한</td>
				<td>
					<input type="radio" name="admin" id="admin_a" value="0" checked><label for="admin_a"> 일반회원</label>
					<input type="radio" name="admin" id="admin_b" value="1"><label for="admin_b"> 관리자</label>
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="가입" onclick="return joinCheck()">
					<input type="reset" value="취소">
				</td>
			</tr>
			<tr>
				<td colspan="2">${msg}</td>
			</tr>
		</table>
	</form>
</body>
</html>