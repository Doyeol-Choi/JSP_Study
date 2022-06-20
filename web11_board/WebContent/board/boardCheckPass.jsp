<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>암호 확인 페이지</title>
</head>
<body>
	<div id="wrap">
		<h1>암호 확인</h1>
		<form action="BS" method="post">
			<input type="hidden" name="command" value="board_check_pass">
			<input type="hidden" name="num" value="${param.num}">
			<!-- 그냥 num으로 쓰고 싶다면 중간 BCPF서블릿에서 num을 꺼냈다가 다시 request로 보내주어야 한다. --> 
			<table>
				<tr>
					<th><label for="pass">비밀번호</label></th>
					<td><input type="password" name="pass" id="pass" required></td>
				</tr>
				<tr>
					<td colspan="2" style="color:red;">${msg}</td>
				</tr>
				<tr>
					<td colspan="2">
						<input type="submit" value="확인">
					</td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>