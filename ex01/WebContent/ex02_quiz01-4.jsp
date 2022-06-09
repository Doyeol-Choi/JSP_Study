<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>상품 상세 설명 페이지</h1>
	<%
		String[] a_name = (String[])session.getAttribute("a_name");
		String[] a_code = (String[])session.getAttribute("a_code");
		String[] a_price = (String[])session.getAttribute("a_price");
		String[] a_company = (String[])session.getAttribute("a_company");
		String[] a_material = (String[])session.getAttribute("a_material");
		String[] a_soldout = (String[])session.getAttribute("a_soldout");
	%>
	<table border=1>
		<tr>
			<td>상품명</td>
			<td>상품코드</td>
			<td>가격</td>
			<td>제조사</td>
			<td>주요원료</td>
			<td>품절여부</td>
		</tr>
	<%
		for(int i=0; i<=10; i++) {
			if(a_name[i]!=null) {
				%>
				<tr>
					<td><%= a_name[i] %></td>
					<td><%= a_code[i] %></td>
					<td><%= a_price[i] %></td>
					<td><%= a_company[i] %></td>
					<td><%= a_material[i] %></td>
					<td><%= a_soldout[i] %></td>
				</tr>
				<%
			} else {
				break;
			}
		}
	%>
	</table>
	<a href="ex02_quiz01-3.jsp">상품 목록으로 돌아가기</a>
</body>
</html>