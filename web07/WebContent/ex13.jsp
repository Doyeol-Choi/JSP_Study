<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		String names = "구본승:김민중;김민지:김세훈;김은식:김혜인;명수연:박나연;송치현:유명선;전한수:최도열;하성민:황경민;황다현";
		pageContext.setAttribute("names", names);
	%>
	<c:forTokens items="${names}" delims=";" var="name">
		${name}<br>
	</c:forTokens>
	<c:forTokens items="${names}" delims=":" var="name">
		${name}<br>
	</c:forTokens>
</body>
</html>