package com.green.question;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/IS")
public class InsertServlet extends HttpServlet {

	// 연결 객체,쿼리전송 객체
	private Connection conn = null;
	private Statement stmt = null;
	
	// 접속을 위한 정보 5가지
	private String url = "jdbc:oracle:thin:@localhost:1521:XE";
	private String uId = "green";
	private String uPwd = "1234";
	private String driver = "oracle.jdbc.driver.OracleDriver";
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 삽입할 데이터 준비
		request.setCharacterEncoding("UTF-8");
		String name = request.getParameter("uName");
		String userid = request.getParameter("userId");
		String userpwd = request.getParameter("userPwd");
		String email = request.getParameter("uMail");
		String phone = request.getParameter("uPhone");
		int admin = Integer.parseInt(request.getParameter("uAdmin"));

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
		
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<h2>입력 성공</h2>");
		out.println("<p>"+name+"님 환영합니다.</p>");
	}

}
