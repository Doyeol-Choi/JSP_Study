package web01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Hello2")	// web.xml에 작성했던 내용이 어노테이션 하나로 완성
public class Hello2 extends HttpServlet {
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("하하하");
		
		int num1 = 10;
		int num2 = 20;
		
		int result = num1 + num2;
		
		PrintWriter out = response.getWriter();	// 인쇄 장비를 마련
		out.println("<html>");
		out.println("<head>");
		out.println("<title>First Servlet</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>Servlet print.</h1>");
		out.println("<p>" + num1 + "+" + num2 + "=" + result + "</p>");	//	<p>10+20=30</p>
		out.println("</body>");
		out.println("</html>");
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
