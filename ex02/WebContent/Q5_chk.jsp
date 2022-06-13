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
		double fever = Double.parseDouble(request.getParameter("fever"));
		
		if(fever>=37.5) {
	%>
			<h1>정밀 검사</h1>
			<form action="Q5_result.jsp" method="post">
				발열 증상 여부 : Y<input type="radio" name="fever_ck" value="Y">  N<input type="radio" name="fever_ck" value="N"><br>
				호흡기 증상 여부 : Y<input type="radio" name="rs_ck" value="Y">  N<input type="radio" name="rs_ck" value="N"><br>
				2주내 해외 여행 여부 : Y<input type="radio" name="travel_ck" value="Y">  N<input type="radio" name="travel_ck" value="N"><br>
				<input type="hidden" id="name" name="name" value="<%= name %>"><br>
				<input type="hidden" id="fever" name="fever" value="<%= fever %>"><br>
				<input type="submit" value="제출">
			</form>
	<%
		} else {
			out.println("<h1>"+name+"님 체온 "+fever+"도 코로나 음성입니다.</h1>");
		}
	%>
</body>
</html>