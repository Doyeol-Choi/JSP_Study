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
	<c:url var="pic" value="images/cat-g45714413b_640.jpg" scope="request"/>
	<div>${pic}</div>
	<hr>
	<img alt="고양이" src="${pic}" width="400px" height="250px">
</body>
</html>