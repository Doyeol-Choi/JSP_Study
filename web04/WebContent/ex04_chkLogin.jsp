<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.net.URLEncoder" %>
<%@ page import="javax.servlet.RequestDispatcher" %>
<%! 
	// 이미 저장된 ID, Password
	String s_id = "green";
	String s_pwd = "1234";
	String s_name = "최서희";
%>
<%
	// 입력받은 ID, Password 읽어와야 함
	String u_id = request.getParameter("userId");
	String u_pwd = request.getParameter("userPwd");
	
	if(s_id.equals(u_id) && s_pwd.equals(u_pwd)){	// 로그인 성공
		//response.sendRedirect("ex04_main.jsp?name=" + URLEncoder.encode(s_name, "UTF-8"));	// ex04_main.jsp?name="최서희"
		
		request.setAttribute("name", s_name);
		
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("ex04_main.jsp");
		dispatcher.forward(request, response);
		
	}else{	// 로그인 실패
		response.sendRedirect("ex04_loginFail.jsp");
	}
%>

<%-- 이 페이지는 사실상 html 부분이 사용될 일이 없기 때문에 html의 기본 형식이 지워져도 무방하다. --%>