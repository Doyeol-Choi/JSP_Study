<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%!
	//저장된 데이터
	String s_id = "green";
	String s_pwd = "1234";
	String s_name = "cony";
%>

<%
	// 입력된 데이터
	String userId = request.getParameter("userId");
	String userPwd = request.getParameter("userPwd");
	
	// 로그인 처리
	if(s_id.equals(userId) && s_pwd.equals(userPwd)) {	// 로그인 성공시 => 로그인 정보를 세션에 저장
		session.setAttribute("name", s_name);
		session.setAttribute("id", s_id);
		
		response.sendRedirect("main.jsp");
	} else { // 로그인 실패시 => 폼 페이지로 돌아가기
		response.sendRedirect("loginForm.jsp");
	}
%>