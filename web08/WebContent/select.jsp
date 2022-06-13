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
<title>이름 조회결과</title>
</head>
<body>
	<%
		// 연결 객체,쿼리전송 객체
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		// 접속을 위한 정보 5가지
		String url = "jdbc:oracle:thin:@localhost:1521:XE";
		String uId = "green";
		String uPwd = "1234";
		
		request.setCharacterEncoding("UTF-8");
		String sName = request.getParameter("name");
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
				String query = "SELECT * FROM member";		// 쿼리는 문자열로 처리하되 세미콜론은 반드시 뺀다.
				
				rs = stmt.executeQuery(query);
				
				// 5단계 : 읽어온 데이터를 꺼내서 출력하기
				while(rs.next()){
					String name = rs.getString("name");
					if (name.equals(sName)) {
						String userid = rs.getString("userid");
						String userpwd = rs.getString("userpwd");
						String email = rs.getString("email");
						String phone = rs.getString("phone");
						int admin = rs.getInt("admin");
		%>
					<h1>이름 조회 결과</h1>
					<form action="update.jsp" method="post">
						<label for="uName">이름 : </label>
						<input type="text" name="uName" id="uName" value="<%= name %>" readonly><br>
						<label for="userId">아이디 : </label>
						<input type="text" name="userId" id="userId" value="<%= userid %>"><br>
						<label for="userPwd">비밀번호 : </label>
						<input type="password" name="userPwd" id="userPwd" value="<%= userpwd %>"><br>
						<label for="uMail">이메일 : </label>
						<input type="email" name="uMail" id="uMail" value="<%= email %>"><br>
						<label for="uPhone">전화번호 : </label>
						<input type="tel" name="uPhone" id="uPhone" value="<%= phone %>"><br>
						<label for="uAdmin">Admin : </label>
						<input type="number" name="uAdmin" id="uAdmin" value="<%= admin %>"><br>
						<input type="submit" value="수정하기">
					</form>
		<%
						break;
					}					
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
		<a href="serchName.html"><button>이름 조회로 돌아가기</button></a>
</body>
</html>