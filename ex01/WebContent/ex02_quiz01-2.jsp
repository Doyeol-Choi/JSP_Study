<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
if(session.getAttribute("a_name")==null) {
	%>
	<%! 
		String[] a_name = new String[10];
		String[] a_code = new String[10];
		String[] a_price = new String[10];
		String[] a_company = new String[10];
		String[] a_material = new String[10];
		String[] a_soldout = new String[10];
	%>
	<%
		a_name[0] = request.getParameter("name");
		a_code[0] = request.getParameter("code");
		a_price[0] = request.getParameter("price");
		a_company[0] = request.getParameter("company");
		a_material[0] = request.getParameter("material");
		a_soldout[0] = request.getParameter("soldout");
		
		session.setAttribute("a_name", a_name);
		session.setAttribute("a_code", a_code);
		session.setAttribute("a_price", a_price);
		session.setAttribute("a_company", a_company);
		session.setAttribute("a_material", a_material);
		session.setAttribute("a_soldout", a_soldout);
		
		response.sendRedirect("ex02_quiz01-3.jsp");
} else {

	String[] a_name = (String[])session.getAttribute("a_name");
	String[] a_code = (String[])session.getAttribute("a_code");
	String[] a_price = (String[])session.getAttribute("a_price");
	String[] a_company = (String[])session.getAttribute("a_company");
	String[] a_material = (String[])session.getAttribute("a_material");
	String[] a_soldout = (String[])session.getAttribute("a_soldout");

	for(int i=0; i<=10; i++) {
		if(a_name[i]==null) {
			a_name[i] = request.getParameter("name");
			a_code[i] = request.getParameter("code");
			a_price[i] = request.getParameter("price");
			a_company[i] = request.getParameter("company");
			a_material[i] = request.getParameter("material");
			a_soldout[i] = request.getParameter("soldout");
			
			session.setAttribute("a_name", a_name);
			session.setAttribute("a_code", a_code);
			session.setAttribute("a_price", a_price);
			session.setAttribute("a_company", a_company);
			session.setAttribute("a_material", a_material);
			session.setAttribute("a_soldout", a_soldout);
			
			response.sendRedirect("ex02_quiz01-3.jsp");
		} else {
			continue;
		}
	}
	response.sendRedirect("ex02_quiz01-1.jsp");
}
%>