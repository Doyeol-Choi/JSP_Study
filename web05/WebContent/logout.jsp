<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// 세션에 정보를 삭제
	/* session.removeAttribute("name");
	session.removeAttribute("id"); */
	
	// 모든 세션 정보를 한번에 삭제
	session.invalidate();
%>
<script>
	alert('로그아웃이 정장적으로 되었습니다.');
	location.href="loginForm.jsp";
</script>