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
	<%	// 자바 빈을 사용해 봅시다.
		// 자바 빈 객체를 생성
		com.green.beans.Member m1 = new com.green.beans.Member();
		
		// 자바 빈 객체에 데이터 저장
		m1.setName("홍길동");
		m1.setUserId("hong");
		
		request.setAttribute("member1", m1);	// 데이터 덩어리를 자바 빈에 담아서 한번에 전송
		
		//request.getRequestDispatcher("ex01_result.jsp").forward(request, response);
		
		// 패키지를 import 해서 처리할 수 있다.
		Member m2 = new Member();
	%>
	<%-- 액션 태그로 자바 빈 생성 --%>
	
	<jsp:useBean id="m3" class="com.green.beans.Member" scope="request"/>
	
	<%-- com.green.beans.Member m3 = new com.green.beans.Member();
	request.setAttribute("m3", m3); // 이 내용과 같은 액션태그  --%>

이름 : <%=m3.getName() %><br>
<% m3.setName("세요"); %>
이름 : <%=m3.getName() %><br>

</body>
</html>