<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.Statement" %>
<%@ page import="java.sql.DriverManager" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 가입 결과</title>
</head>
<body>
	<%!
		// 연결 객체,쿼리전송 객체
		Connection conn = null;
		Statement stmt = null;
		
		// 접속을 위한 정보 5가지
		String url = "jdbc:oracle:thin:@localhost:1521:XE";
		String uId = "green";
		String uPwd = "1234";
		String driver = "oracle.jdbc.driver.OracleDriver";
	%>
	<%	
		// 삽입할 데이터 준비
		request.setCharacterEncoding("UTF-8");
		String name = request.getParameter("uName");
		String userid = request.getParameter("userId");
		String userpwd = request.getParameter("userPwd");
		String email = request.getParameter("uMail");
		String phone = request.getParameter("uPhone");
		int admin = Integer.parseInt(request.getParameter("uAdmin"));
	%>
	
	<%
		try {
			// 1단계 : 드라이버 로드
			Class.forName(driver);
		
			// 2단계 : 데이터베이스 연결 객체 생성
			conn = DriverManager.getConnection(url,uId,uPwd);
		
			// 3단계 : 쿼리문을 실행할 객체 생성
			stmt = conn.createStatement();
		
			// 4단계 : 쿼리문 실행
			String sql = "insert into member values ('"+name+"','"+userid+"','"+userpwd+"','"+email+"','"+phone+"',"+admin+")";
		
			int num = stmt.executeUpdate(sql);
			System.out.println("바뀐 행의 개수 : " + num);
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try{
				if(stmt != null)stmt.close();	//	반복문, 조건문 등이 한줄이라면 중괄호 생략가능
				if(conn != null)conn.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	%>
	<h1>입력 성공</h1>
	<a href="form.html"><button>회원가입 창으로 돌아가기</button></a><br>
	<a href="serchName.html"><button>이름으로 조회하기</button></a>
</body>
</html>