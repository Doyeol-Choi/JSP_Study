package ex01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Q02")
public class Ex01_Quiz02 extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 기존 저장된 아이디와 비밀번호
		String id = "green";
		String pwd = "1234";
		// 받아온 아이디와 비밀번호
		String s_id = request.getParameter("u_id");
		String s_pwd = request.getParameter("u_pwd");
		
		response.setContentType("text/html; charset=utF-8");
		PrintWriter out = response.getWriter();
		
		if(id.equals(s_id) && pwd.equals(s_pwd)) {
			out.println("<html><body>");
			out.println("<h1>로그인 성공</h1>");
			out.println("</body></html>");
		} else {
			out.println("<html><body>");
			out.println("<h1>로그인 실패</h1>");
			out.println("</body></html>");
		}
		
		
	}

}
