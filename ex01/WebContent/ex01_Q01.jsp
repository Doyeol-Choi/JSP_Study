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
		int ko_score = Integer.parseInt(request.getParameter("ko_score"));
		int en_score = Integer.parseInt(request.getParameter("en_score"));
		int mt_score = Integer.parseInt(request.getParameter("mt_score"));
		int sum = ko_score + en_score + mt_score;
		double avg = sum / 3.0;
	%>
	<h3>성적 결과</h3>
	<p>
		국어 : <%=ko_score %>점 <br>
		영어 : <%=en_score %>점 <br>
		수학 : <%=mt_score %>점 <br>
		평균 : <%=sum %>점 <br>
		총점 : <%=avg %>점
	</p>
</body>
</html>