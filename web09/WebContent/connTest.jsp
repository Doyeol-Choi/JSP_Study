<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.Connection" %>
<%@ page import="com.green.dao.MemberDAO" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>데이터 베이스 연동 테스트 페이지</title>
</head>
<body>
	<%
		MemberDAO dao = MemberDAO.getInstance();
		Connection conn = dao.getConnection();
		if (conn!=null) {
			out.println("데이터베이스 연결 성공");
		} else {
			out.println("데이터베이스 연결 실패");
		}
	%>
</body>
</html>