<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.Statement" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.sql.DriverManager" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>데이터 조회</title>
</head>
<body>
	<%
		// 데이터베이스 접속 준비	=> 연결이 종료되면 모두 닫아 주어야 한다.
		Connection conn = null;		// DB 연결용 객체
		Statement stmt = null;		// 쿼리 연결용 객체
		ResultSet rs = null;		// 조회된 데이터를 저장하기 위한 객체
		
		// 접속을 위한 정보 5가지
		String url = "jdbc:oracle:thin:@localhost:1521:XE";	// 프로토콜 정보 : jdbc:oracle:thin:@
		String uId = "green";
		String uPwd = "1234";
		
	%>
	
	<table border='1'>
		<tr>
			<th>이름</th>
			<th>아이디</th>
			<th>암호</th>
			<th>이메일</th>
			<th>전화번호</th>
			<th>권한(1:관리자, 0:사용자)</th>
		</tr>
		<%
			try {
				// 본격적으로 데이터베이스에 연결
				// 1단계 : 드라이버 로드
				Class.forName("oracle.jdbc.driver.OracleDriver");
			
				// 2단계 : 데이터베이스에 연결(5가지 정보) => 연결 객체를 생성
				conn = DriverManager.getConnection(url,uId,uPwd);
				System.out.println("연결객체 : " + conn.toString());
				
				// 3단계 : 쿼리문을 실행할 객체 생성
				stmt = conn.createStatement();
				
				// 4단계 : 쿼리문 실행
				String query = "SELECT * FROM member";		// 쿼리는 문자열로 처리하되 세미콜론은 반드시 뺀다.
				
				// - 데이터를 반영하기위한 쿼리(Insert, Update, Delete)
				// stmt.executeUpdate(query);
				
				// - 데이터를 조회하기위한 쿼리(Select)
				rs = stmt.executeQuery(query);
				
				// 5단계 : 읽어온 데이터를 꺼내서 출력하기
				while(rs.next()){	// rs.next()로 꺼내온 데이터는 레코드 단위
									// 꺼내온 레코드에서 컬럼데이터를 읽어오는 방법
									// rs.getString(컬럼명); 문자열 읽어오기	# re.getString(숫자) 라면 몇번째 컬럼을 뜻한다. 
									// rs.getInt(컬럼명); 숫자형 읽어오기
					String name = rs.getString("name");
					String userid = rs.getString("userid");
					String userpwd = rs.getString("userpwd");
					String email = rs.getString("email");
					String phone = rs.getString("phone");
					int admin = rs.getInt("admin");
					
					out.println("<tr>");
					out.println("<td>"+name+"</td>");
					out.println("<td>"+userid+"</td>");
					out.println("<td>"+userpwd+"</td>");
					out.println("<td>"+email+"</td>");
					out.println("<td>"+phone+"</td>");
					out.println("<td>"+admin+"</td>");
					out.println("</tr>");
					
				}
			} catch(Exception e){
				e.printStackTrace();
			} finally{
				try{
					if(rs != null){
						rs.close();
					}
					if(stmt != null){
						stmt.close();
					}
					if(conn != null){
						conn.close();
					}
				}catch(Exception e){
					e.printStackTrace();
				}
			}
		%>
	</table>
</body>
</html>