package ex01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Q01")
public class Ex01_Quiz01 extends HttpServlet {
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int ko_score = Integer.parseInt(request.getParameter("ko_score"));
		int en_score = Integer.parseInt(request.getParameter("en_score"));
		int mt_score = Integer.parseInt(request.getParameter("mt_score"));
		int sum = ko_score + en_score + mt_score;
		double avg = sum / 3.0;
		response.setContentType("text/html; charset=utF-8");
		
		PrintWriter out = response.getWriter();
		out.println("<html><body>");
		out.println("<p>���� : " + ko_score + "��<br>");
		out.println("���� : " + en_score + "��<br>");
		out.println("���� : " + mt_score + "��<br>");
		out.println("���� : " + sum + "��<br>");
		out.println("��� : " + avg + "��</p>");
		out.println("</body></html>");
	}

}
