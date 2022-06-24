<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>강의 등록 실패</title>
<link type="text/css" href="css/course.css" rel="stylesheet">
</head>
<body>
	<div id="container">
		<h1>강의 등록 실패!</h1>
		<p>강의 등록에 실패 했습니다. 잘못 입력한 정보는 없는지 확인해보세요</p>
		<p>교과목 코드가 중복될 시 등록할 수 없습니다.</p>
		<button onclick="location.href='CS?command=course_list'">목록으로 돌아가기</button>&nbsp;
		<button onclick="location.href='CS?command=course_insert_form'">교과목 등록 창으로 돌아가기</button>
	</div>
</body>
</html>