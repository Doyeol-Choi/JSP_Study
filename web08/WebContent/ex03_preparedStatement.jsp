<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.PreparedStatement" %>
<%@ page import="java.sql.DriverManager" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>preparedStatement 사용</title>
</head>
<body>
	<%
		// 연결 객체,쿼리전송 객체
		Connection conn = null;
		PreparedStatement psmt = null;
		
		// 접속을 위한 정보 5가지
		String url = "jdbc:oracle:thin:@localhost:1521:XE";	// 프로토콜 정보 : jdbc:oracle:thin:@
		//String url = "jdbc:oracle:thin:@localhost:1521:XE";	
		String uId = "green";
		String uPwd = "1234";
		
		// 삽입할 데이터 준비
		String name = "강길동";
		String userid = "kang";
		String userpwd = "1234";
		String email = "kang@naver.com";
		String phone = "010-1234-5678";
		int admin = 0;
	%>
	
	<%
		try {
			// 1단계 : 드라이버 로드
			Class.forName("oracle.jdbc.driver.OracleDriver");

		
			// 2단계 : 데이터베이스 연결 객체 생성
			conn = DriverManager.getConnection(url,uId,uPwd);
			
			String sql = "insert into member values (?,?,?,?,?,?)";
			
			// 3단계 : 미완성된 쿼리를 매개로 준다.
			psmt = conn.prepareStatement(sql);
		
			// 4단계 : 미완성된 쿼리를 채워 넣는다.
			psmt.setString(1, name);
			psmt.setString(2, userid);
			psmt.setString(3, userpwd);
			psmt.setString(4, email);
			psmt.setString(5, phone);
			psmt.setInt(6, admin);
			
			// 5단계 : 쿼리문 실행 => 이미 완성된 쿼리가 있으므로 쿼리를 넣으면 안됨
			int num = psmt.executeUpdate();
			System.out.println("바뀐 행의 개수 : " + num);
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try{
				if(psmt != null)psmt.close();	//	반복문, 조건문 등이 한줄이라면 중괄호 생략가능
				if(conn != null)conn.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	%>
</body>
</html>