<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SNS</title>
<script type="text/javascript" src="jQuery/jquery-3.6.0.js"></script>
</head>
<body>
	<table>
		<tr>
			<th>번호</th>
			<th>글 제목</th>
			<th>글 내용</th>
			<th>날짜</th>
		</tr>
		<c:forEach val="board" varStatus="i" items="list">
			<tr>
				<td>${i.count}</td>
				<td><a href="" onclick="return info(${i.count-1}, ${board.name}, ${board.content})">${board.name}</a></td>
				<td>${board.content}</td>
				<td>${board.date}</td>
			</tr>
		</c:forEach>
	</table>
	<form action="SS" method="post">
		<input type="hidden" name="num" id="num">
		<label for="name">글 제목</label>
		<input type="text" name="name" id="name"><br>
		<label for="content">글 내용</label>
		<input type="text" name="content" id="content"><br>
		<input type="button" value="등록" onclick="insert()">
		<input type="button" value="수정" onclick="update()">
		<input type="button" value="삭제" onclick="delete()">
	</form>
	<script type="text/javascript">
		function info(count, name, content) {
			let boardInfo = {
					"num" : count,
					"name" : name,
					"content" : content
			}
			
			$.ajax({
				type:"get",
				async:true,
				url:"SS",
				data:{
					"boardInfo":JSON.stringify(boardInfo)
				},
				success:function() {
					
				}
			});
		}
	</script>
</body>
</html>