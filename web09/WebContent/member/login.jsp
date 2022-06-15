<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 관리</title>
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
	<h2>로그인 페이지</h2>
	<form action="LS" method="POST" name="frm">
		<table>
			<tr>
				<td><label for="userid">아이디</label></td>
				<td><input type="text" name="userid" id="userid" value="${userid}" required></td>
			</tr>
			<tr>
				<td><label for="userpwd">비밀번호</label></td>
				<td><input type="password" name="userpwd" id="userpwd" required></td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<input type="submit" value="로그인" onclick="return loginCheck()">&nbsp;&nbsp;&nbsp;
					<input type="reset" value="취소">&nbsp;&nbsp;&nbsp;
					<input type="button" value="회원 가입" onclick="location.href='JS'">
				</td>
			</tr>
			<tr>
				<td colspan="2">${msg}</td>
			</tr>
		</table>
	</form>
</body>
</html>