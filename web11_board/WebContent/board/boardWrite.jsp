<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시물 등록</title>
<link type="text/css" href="css/board.css" rel="stylesheet">
</head>
<body>
	<div id="wrap">
		<h1>게시물 등록</h1>
		<form action="BS" method="post">
			<input type="hidden" name="command" value="board_write">
			<table>
				<tr>
					<th><label for="name">작성자</label></th>
					<td><input type="text" name="name" id="name" required> * 필수 </td>
				</tr>
				<tr>
					<th><label for="pass">비밀번호</label></th>
					<td><input type="password" name="pass" id="pass" required> * 필수(글 수정/삭제시 필요) </td>
				</tr>
				<tr>
					<th><label for="email">이메일</label></th>
					<td><input type="email" name="email" id="email"></td>
				</tr>
				<tr>
					<th><label for="title">글 제목</label></th>
					<td><input type="text" name="title" id="title" required> * 필수 </td>
				</tr>
				<tr>
					<th><label for="content">글 내용</label></th>
					<td><textarea rows="15" cols="70" name="content" id="content"></textarea></td>
				</tr>
				<tr>
					<td colspan="2">
						<input type="submit" value="글 작성">
						<input type="reset" value="다시 작성">
						<input type="button" value="목록보기" onclick="location.href='BS?command=board_list'">
					</td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>