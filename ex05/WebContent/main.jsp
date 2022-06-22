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
<style>
	table, th, td {
		border:1px solid #ccc;
		border-collapse:collapse;
	}
</style>
</head>
<body>
	<table>
		<tr>
			<th>번호</th>
			<th>글 제목</th>
			<th>글 내용</th>
			<th>날짜</th>
		</tr>
		<c:forEach var="board" varStatus="i" items="${list}">
			<tr>
				<td>${i.count}</td>
				<td><a href="javascript:void(0)" onclick="info('${i.count-1}', '${board.name}', '${board.content}')">${board.name}</a></td>
				<td>${board.content}</td>
				<td>${board.date}</td>
			</tr>
		</c:forEach>
	</table>
	<form action="SS" method="post">
		<input type="hidden" name="num" id="num">
		<label for="name">글 제목</label>
		<input type="text" name="name" id="name" required><br>
		<label for="content">글 내용</label>
		<input type="text" name="content" id="content" required><br>
		<input type="button" value="등록" onclick="insertBoard()">
		<input type="button" value="수정" onclick="updateBoard()">
		<input type="button" value="삭제" onclick="deleteBoard()">
	</form>
	<script type="text/javascript">
		function info(count, name, content) {
			let boardInfo = {
					"num" : count,
					"name" : name,
					"content" : content
			}
			
			$.ajax({
				type:"post",
				async:true,
				url:"SS",
				data:{
					"boardInfo":JSON.stringify(boardInfo)
				},
				datatype:"JSON",
				success:function(data) {
					let bVo = JSON.parse(data);
					$('#num').val(bVo.num);
					$('#name').val(bVo.name);
					$('#content').val(bVo.content);
				}
			});
		}
		
		function insertBoard() {
			let name = $('#name').val();
			let content = $('#content').val();
			let today = new Date();
			let date = today.toLocaleDateString();
			
			let boardInfo = {
					"name" : name,
					"content" : content,
					"date" : date
			}
			$.ajax({
				type:"post",
				async:true,
				url:"IS",
				data:{
					"boardInfo":JSON.stringify(boardInfo)
				},
				datatype:"JSON",
				success:function() {
					alert('등록 성공!');
					location.href="main.jsp"
				}, error:function() {
					alert('등록 실패..');
				}
			});
		}
		
		function updateBoard() {
			let num = $("#num").val();
			let name = $("#name").val();
			let content = $("#content").val();
			let today = new Date();
			let date = today.toLocaleDateString();
			
			let boardInfo = {
					"num" : num,
					"name" : name,
					"content" : content,
					"date" : date
			}
			$.ajax({
				type:"post",
				async:true,
				url:"US",
				data:{
					"boardInfo":JSON.stringify(boardInfo)
				},
				success:function() {
					alert('수정 성공!');
					location.href="main.jsp";
				}, error:function() {
					alert('수정 실패..');
				}
			});
		}
		
		function deleteBoard() {
			let num = $("#num").val();
			
			$.ajax({
				type:"post",
				async:true,
				url:"DS",
				data:{
					"num" : num
				},
				success:function() {
					alert('삭제 성공!');
					location.href="main.jsp";
				}, error:function() {
					alert('삭제 실패..');
				}
			});
		}
	</script>
</body>
</html>