package web02;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/HS")
public class HelloServlet extends HttpServlet {

	@Override
	public void destroy() {
		// 서블릿 인스턴스가 메모리상에서 사라질 때 호출되는 메서드
		System.out.println("destroy 메서드 동작 : 내가 사라진다!!!");
	}


	@Override
	public void init() throws ServletException {
		// 서블릿이 최초 인스턴스가 만들어질때 호출되는 메서드
		System.out.println("init 메서드 동작 : 내가 나타났다!!!");
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=utF-8");
		
		PrintWriter out = response.getWriter();
		out.println("<html><body>");
		out.println("<h1> Hello World!!</h1>");
		out.println("</body></html>");
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
