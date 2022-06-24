<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>교과목 상세보기</title>
<link type="text/css" href="css/course.css" rel="stylesheet">
</head>
<body>
	<div id="container">
		<table>
			<tr>
				<th>교과목 코드</th>
				<td>${course.id}</td>
			</tr>
			<tr>
				<th>과목 명</th>
				<td>${course.name}</td>
			</tr>
			<tr>
				<th>담당강사</th>
				<td>${course.lecturer}</td>
			</tr>
			<tr>
				<th>학점</th>
				<td>${course.credit}</td>
			</tr>
			<tr>
				<th>요일</th>
				<td>${course.week}요일</td>
			</tr>
			<tr>
				<th>시작</th>
				<td>${course.start_hour}</td>
			</tr>
			<tr>
				<th>종료</th>
				<td>${course.end_hour}</td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="button" value="수정" onclick="location.href='CS?command=course_update_form&id=${course.id}'">&nbsp;
					<input type="button" value="삭제" onclick="location.href='CS?command=course_delete&id=${course.id}'">&nbsp;
					<input type="button" value="목록" onclick="location.href='CS?command=course_list'">
				</td>
			</tr>
		</table>
	</div>
</body>
</html>