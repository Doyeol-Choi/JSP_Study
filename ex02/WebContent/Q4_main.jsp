<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>목록</title>
<style>
	table, th, td {border:1px solid #ccc; border-collapse:collapse; padding:10px; }
</style>
</head>
<body>
	<h1>할일 목록</h1>
	<table>
	<%
		ArrayList<String> a_todo = (ArrayList<String>) session.getAttribute("a_todo");
		for(int i=0; i<a_todo.size(); i++) { 
	%>
			<tr>
				<td><%= a_todo.get(i) %></td>
				<td><a href="Q4_delete.jsp?todo=<%= a_todo.get(i) %>"><button>삭제</button></a></td>
			</tr>
	<%
		}
	%>
	</table>
	<br>
	<a href="Q4_form.html"><button>할 일 등록</button></a>
</body>
</html>