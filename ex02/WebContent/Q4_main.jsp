<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>할일 목록</h1>
	<table border="1" width="600">
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
	<a href="Q4_form.html"><button>할 일 등록</button></a>
</body>
</html>