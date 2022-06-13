<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		request.setCharacterEncoding("UTF-8");
		String name = request.getParameter("name");
		String fever = request.getParameter("fever");
		String fe_ck = request.getParameter("fever_ck");
		String rs_ck = request.getParameter("rs_ck");
		String tr_ck = request.getParameter("travel_ck");
		
		if(fe_ck.equals("N")&&rs_ck.equals("N")&&tr_ck.equals("N")) {
			out.println("<h1>"+name+"님 체온 "+fever+"도 코로나 음성입니다.</h1>");
		} else {
			int num = (int)(Math.random()*100+1);
			if(num%2!=0) {
				out.println("<h1>"+name+"님 체온 "+fever+"도 코로나 음성입니다.</h1>");
			} else {
				out.println("<h1>"+name+"님 체온 "+fever+"도 코로나 양성입니다.</h1>");
			}
		}
	%>
</body>
</html>