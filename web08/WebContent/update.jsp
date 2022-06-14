<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.Statement" %>
<%@ page import="java.sql.DriverManager" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>데이터 수정</title>
</head>
<body>
	<%
		// 연결 객체,쿼리전송 객체
		Connection conn = null;
		Statement stmt = null;
		
		// 접속을 위한 정보 5가지
		String url = "jdbc:oracle:thin:@localhost:1521:XE";
		String uId = "green";
		String uPwd = "1234";
		
		request.setCharacterEncoding("UTF-8");
		String sName = request.getParameter("uName");
		String suserid = request.getParameter("userId");
		String suserpwd = request.getParameter("userPwd");
		String semail = request.getParameter("uMail");
		String sphone = request.getParameter("uPhone");
		int sadmin = Integer.parseInt(request.getParameter("uAdmin"));
	%>
		<%
			try {
				// 본격적으로 데이터베이스에 연결
				// 1단계 : 드라이버 로드
				Class.forName("oracle.jdbc.driver.OracleDriver");
			
				// 2단계 : 데이터베이스에 연결(5가지 정보) => 연결 객체를 생성
				conn = DriverManager.getConnection(url,uId,uPwd);
				
				// 3단계 : 쿼리문을 실행할 객체 생성
				stmt = conn.createStatement();
			
				// 4단계 : 쿼리문 실행
				String sql = "UPDATE member SET userid='"+suserid+"', userpwd='"+suserpwd+"', email='"+semail+"', phone='"+sphone+"', admin='"+sadmin+"' WHERE name='"+sName+"'";
				
				// String sql = "UPDATE member SET userid=?, userpwd=?, email=?, phone=?, admin=? WHERE name=?";
				
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
		<h1>수정 완료!</h1>
		<a href="serchName.html"><button>이름 조회로 돌아가기</button></a>
</body>
</html>