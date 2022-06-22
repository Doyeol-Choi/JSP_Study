<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>교과목 관리 페이지</title>
<link type="text/css" href="css/course.css" rel="stylesheet">
</head>
<body>
	<div id="container">
		<h1>교과목 관리 페이지</h1>
		<table>
			<tr>
				<td colspan="5">
					<p style="float:left;">총 <c:out value="${courseList.size()}"/>개의 교과목이 있습니다.</p>
					<button style="float:right;" onclick="">강사 보기</button>
				</td>
			</tr>
			<tr>
				<th>과목 코드</th>
				<th>과목 명</th>
				<th>학점</th>
				<th>담당 강사</th>
				<th>요일</th>
			</tr>
			<c:forEach var="course" items="${courseList}">
				<tr>
					<td>${course.id}</td>
					<td><a href="CS?command=course_info&id=${course.id}">${course.name}</a></td>
					<td>${course.credit}</td>
					<td>${course.lecturer}</td>
					<td>${course.week}</td>
				</tr>
			</c:forEach>
			<tr>
				<td colspan="5" style="text-align:right;">
					<button onclick="location.href='CS?command=course_insert_form'">교과목 등록</button>
				</td>
			</tr>
		</table>
	</div>
</body>
</html>