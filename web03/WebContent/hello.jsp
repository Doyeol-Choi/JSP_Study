<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%!
		// 선언문은 _jspService 메서드 외부
		public int abs(int n){		
			if(n<0){
				n = -n;
			}
			return n;
		}
		String name = "홍길동";
		int a=5, b=-5;
	%>
	
	<%
		String subject = "Servlet";
	%>
	<h1>Hello <% out.println(subject); %>!!</h1>
	
	<hr>
	<%
		int num1 = 10;
		int num2 = 20;
		int result = num1 + num2;
		
		out.println(num1+"+"+num2+"="+result + "<br>");	// 10+20=30
		// 자바코드의 줄바꿈과 html의 줄바꿈이 다르기 때문에 println을 사용했지만 줄바꿈이 되지 않는다.		
	%>
		<%= "이름 : " + name %><br>
	<%
		out.println(a + "의 절대값 : " + abs(a) + "<br>");
		out.println(b + "의 절대값 : " + abs(b) + "<br>");
		
		//public int abs(int n){
		// 스크립트릿 내부는 _jspService 메서드 내부이기 때문에 메서드 안에 메서드가 나올 수 없다.
		//	if(n<B){
		//		n = -n;
		//	}
		//	return n;
		//}
	%>
	
	<%-- JSP 전용 주석문 : 노출되면 곤란한 정보 --%>
	
	<!-- HTML 전용 주석문 : 노출 되어서 상관없는 정보, 소스보기를 통해 볼 수 있다. -->
	
</body>
</html>