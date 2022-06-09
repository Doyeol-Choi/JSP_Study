<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<style>
	table, td, tr {
		border : 1px solid #ccc;
		border-collapse : collapse;
	}
</style>
<body>
	<%
		String[] s_nums = request.getParameterValues("ch");
	
		for (int i=0; i<s_nums.length; i++) {
			int n = Integer.parseInt(s_nums[i]);
	%>
			<h3><%= n %> 단</h3>
			<table>
	<%
			for (int j=1; j < 10; j++) {
	%>
				<tr>
					<td><%= n %> x <%= j %> = <%= (n*j) %></td>
				</tr>
	<%
			}
	%>
			</table>
	<%
		}
	%>
</body>
</html>