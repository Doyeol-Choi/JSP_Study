<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 수정 하기</title>
<link type="text/css" href="css/board.css" rel="stylesheet">
</head>
<body>
	<div id="wrap">
		<h1>게시글 수정 하기</h1>
		<form action="BS" method="post">
			<input type="hidden" name="command" value="board_update">
			<table>
				<tr>
					<th><label id="num">작성번호</label></th>
					<td><input type="number" name="num" id="num" value="${board.num}" readonly></td>
					<th><label id="name">작성자</label></th>
					<td><input type="text" name="name" id="name" value="${board.name}" required></td>
				</tr>
				<tr>
					<th><label id="email">이메일</label></th>
					<td><input type="email" name="email" id="email" value="${board.email}"></td>
					<th><label id="pass">비밀번호</label></th>
					<td><input type="password" name="pass" id="pass" required></td>
				</tr>
				<tr>
					<th><label id="title">글 제목</label></th>
					<td colspan="3"><input type="text" name="title" id="title" value="${board.title}" required></td>
				</tr>
				<tr>
					<th>글 내용</th>
					<td colspan="3"><textarea rows="15" cols="70" name="content" id="content">${board.content}</textarea></td>
				</tr>
				<tr>
					<td colspan="4">
						<input type="submit" value="수정하기">
						<input type="reset" value="다시쓰기">
						<input type="button" value="목록 보기" onclick="location.href='BS?command=board_list'">
					</td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>