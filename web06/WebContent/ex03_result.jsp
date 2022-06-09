<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.green.beans.Member" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		request.setCharacterEncoding("UTF-8");
	%>
	
	<%-- 1. 자바 빈 생성 --%>
	<%-- 방법 1. 스크립트릿으로 자바 빈 생성 --%>
	<%
		Member m1 = new Member();
		session.setAttribute("m1", m1);
	%>
	
	<%-- 방법 2. 액션 태그로 자바 빈 생성 --%>
	<jsp:useBean id="m2" class="com.green.beans.Member" scope="session"/>
	
	
	<%-- 2. 자바 빈에 데이터 입력 --%>
	<%-- 방법 1. 스크립트릿으로 데이터 입력 (변수 활용) --%>
	<% 
		/* String name = request.getParameter("name");
		String userId = request.getParameter("userId");
		String nickName = request.getParameter("nickName");
		String userPw = request.getParameter("userPw");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		
		m1.setName(name);
		m1.setUserId(userId);
		m1.setNickName(nickName);
		m1.setUserPw(userPw);
		m1.setEmail(email);
		m1.setPhone(phone); */
	%>
	<%-- 방법 2. 스크립트릿으로 데이터 입력 (직접 입력) --%>
	<%
		m1.setName(request.getParameter("name"));
		m1.setUserId(request.getParameter("userId"));
		m1.setNickName(request.getParameter("nickName"));
		m1.setUserPw(request.getParameter("userPw"));
		m1.setEmail(request.getParameter("email"));
		m1.setPhone(request.getParameter("phone"));
	%>
	
	<%-- 방법 3. 액션 태그를 활용한 데이터 입력 (form에서 리퀘스트 객체를 통해 데이터 전달) --%>
	<%-- <jsp:setProperty property="name" name="m2" value='<%= request.getParameter("name") %>'/>
	<jsp:setProperty property="userId" name="m2" value='<%= request.getParameter("userId") %>'/>
	<jsp:setProperty property="nickName" name="m2" value='<%= request.getParameter("nickName") %>'/>
	<jsp:setProperty property="userPw" name="m2" value='<%= request.getParameter("userPw") %>'/>
	<jsp:setProperty property="email" name="m2" value='<%= request.getParameter("email") %>'/>
	<jsp:setProperty property="phone" name="m2" value='<%= request.getParameter("phone") %>'/> --%>
	
	<%-- 방법 4. 액션 태그를 활용한 데이터 입력 (리퀘스트 객체 없이 데이터 입력 = 프로퍼티와 받아온 값의 이름이 같을 때) --%>
	<%-- <jsp:setProperty property="name" name="m2"/>
	<jsp:setProperty property="userId" name="m2"/>
	<jsp:setProperty property="nickName" name="m2"/>
	<jsp:setProperty property="userPw" name="m2"/>
	<jsp:setProperty property="email" name="m2"/>
	<jsp:setProperty property="phone" name="m2"/> --%>
	
	<%-- 방법 5. 액션 태그를 활용한 데이터 입력 (한번에 입력) --%>
	<jsp:setProperty property="*" name="m2"/>
	
	<%-- 3. 자바 빈에서 데이터 출력 --%>
	<h2>입력된 회원 정보 출력</h2>
	<%-- 방법 1. 스크립트릿을 이용한 출력 --%>
	이름 : <%= m1.getName() %><br>
	닉네임 : <%= m1.getNickName() %><br>
	아이디 : <%= m1.getUserId() %><br>
	비밀번호 : <%= m1.getUserPw() %><br>
	이메일 : <%= m1.getEmail() %><br>
	전화번호 : <%= m1.getPhone() %><br>
	<hr>
	<%-- 방법 2. 액션 태그를 이용한 출력 --%>
	이름 : <jsp:getProperty property="name" name="m2"/><br>
	닉네임 : <jsp:getProperty property="nickName" name="m2"/><br>
	아이디 : <jsp:getProperty property="userId" name="m2"/><br>
	비밀번호 : <jsp:getProperty property="userPw" name="m2"/><br>
	이메일 : <jsp:getProperty property="email" name="m2"/><br>
	전화번호 : <jsp:getProperty property="phone" name="m2"/><br>
	
</body>
</html>