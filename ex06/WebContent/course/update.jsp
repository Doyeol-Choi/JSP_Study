<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>교과목 수정</title>
<link type="text/css" href="css/course.css" rel="stylesheet">
<script type="text/javascript" src="jQuery/jquery-3.6.0.js"></script>
</head>
<body>
	<div id="container">
		<h1>교과목 수정하기</h1>
		<form action="CS" method="post">
			<input type="hidden" name="command" value="course_update">
			<input type="hidden" name="originID" value="${course.id}">
			<table>
				<tr>
					<th><label for="id">교과목 코드</label></th>
					<td><input type="text" name="id" id="id" value="${course.id}" required></td>
				</tr>
				<tr>
					<th><label for="name">과목 명</label></th>
					<td><input type="text" name="name" id="name" value="${course.name}" required></td>
				</tr>
				<tr>
					<th>담당강사</th>
					<td>
						<select name="lecturer">
							<c:forEach var="lecturer" items="${lecturerList}">
								<option value="${lecturer.idx}" <c:if test="${course.lecturer eq lecturer.name}">selected</c:if>>${lecturer.name}</option>
							</c:forEach>
						</select>
					</td>
				</tr>
				<tr>
					<th><label for="credit">학점</label></th>
					<td><input type="number" name="credit" id="credit" value="${course.credit}"></td>
				</tr>
				<tr>
					<th>요일</th>
					<td>
						<input type="radio" name="week" value="1"> 월 &nbsp;
						<input type="radio" name="week" value="2"> 화 &nbsp;
						<input type="radio" name="week" value="3"> 수 &nbsp;
						<input type="radio" name="week" value="4"> 목 &nbsp;
						<input type="radio" name="week" value="5"> 금 &nbsp;
						<input type="radio" name="week" value="6"> 토 &nbsp;
					</td>
				</tr>
				<tr>
					<th><label for="start_hour">시작</label></th>
					<td><input type="text" name="start_hour" id="start_hour" value="${course.start_hour}" required></td>
				</tr>
				<tr>
					<th><label for="end_hour">종료</label></th>
					<td><input type="text" name="end_hour" id="end_hour" value="${course.end_hour}" required></td>
				</tr>
				<tr>
					<td colspan="2">
						<input type="submit" value="완료">&nbsp;
						<input type="reset" value="다시쓰기">&nbsp;
						<input type="button" value="목록" onclick="location.href='CS?command=course_list'">
					</td>
				</tr>
			</table>
		</form>
	</div>
	<script type="text/javascript">
		var check = ${course.iweek};
		$(":radio[name='week'][value='"+check+"']").attr('checked', true);
	</script>
</body>
</html>