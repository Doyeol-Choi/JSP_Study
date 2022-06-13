<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>



<% 
	request.setCharacterEncoding("UTF-8");
	if (session.getAttribute("a_todo")==null) {
%>
		<%! ArrayList<String> a_todo = new ArrayList<>(); %>
<%
		a_todo.add(request.getParameter("todo"));
	} else {
		ArrayList<String> a_todo = (ArrayList<String>) session.getAttribute("a_todo");
		
		a_todo.add(request.getParameter("todo"));
	}
	session.setAttribute("a_todo", a_todo);
	
	response.sendRedirect("Q4_main.jsp");
%>