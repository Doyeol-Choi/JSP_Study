<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String product_a = request.getParameter("product_a");
	String product_b = request.getParameter("product_b");
	String product_c = request.getParameter("product_c");
	String product_d = request.getParameter("product_d");
	String product_e = request.getParameter("product_e");
	String product_f = request.getParameter("product_f");
	String product_g = request.getParameter("product_g");
	
	String product_a2 = request.getParameter("product_a2");
	String product_b2 = request.getParameter("product_b2");
	String product_c2 = request.getParameter("product_c2");
	String product_d2 = request.getParameter("product_d2");
	String product_e2 = request.getParameter("product_e2");
	String product_f2 = request.getParameter("product_f2");
	String product_g2 = request.getParameter("product_g2");
	
	
	if(request.getCookies()==null) {
		Cookie cookie1 = new Cookie(product_a, product_a2);
		Cookie cookie2 = new Cookie(product_b, product_b2);
		Cookie cookie3 = new Cookie(product_c, product_c2);
		Cookie cookie4 = new Cookie(product_d, product_d2);
		Cookie cookie5 = new Cookie(product_e, product_e2);
		Cookie cookie6 = new Cookie(product_f, product_f2);
		Cookie cookie7 = new Cookie(product_g, product_g2);
	}
	
%>