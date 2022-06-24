<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>강사 목록 페이지</title>
<link type="text/css" href="css/course.css" rel="stylesheet">
</head>
<body>
	<div id="container">
		<h1>강사 목록</h1>
		<table>
			<tr>
				<td colspan="3">
					<p style="float:left;">총 <c:out value="${lecturerList.size()}"/>개의 교과목이 있습니다.</p>
					<button style="float:right;" onclick="location.href='CS?command=course_list'">교과목 보기</button>
				</td>
			</tr>
			<tr>
				<th>번호</th>
				<th>강사명</th>
				<th>전공</th>
			</tr>
			<c:forEach var="lecturer" items="${lecturerList}">
				<tr>
					<td>${lecturer.idx}</td>
					<td><a href="CS?command=lecturer_info&idx=${lecturer.idx}">${lecturer.name}</a></td>
					<td>${lecturer.major}</td>
				</tr>
			</c:forEach>
			<tr>
				<td colspan="3" style="text-align:right;">
					<button onclick="location.href='CS?command=lecturer_insert_form'">강사 등록</button>
				</td>
			</tr>
		</table>
	</div>
</body>
</html>