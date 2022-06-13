<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%
	request.setCharacterEncoding("UTF-8");
	ArrayList<String> a_todo = (ArrayList<String>) session.getAttribute("a_todo");
	
	String todo = request.getParameter("todo");
	
	a_todo.remove(todo);
	
	response.sendRedirect("Q4_main.jsp");
%>