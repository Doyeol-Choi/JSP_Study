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
		// ���� �ν��Ͻ��� �޸𸮻󿡼� ����� �� ȣ��Ǵ� �޼���
		System.out.println("destroy �޼��� ���� : ���� �������!!!");
	}


	@Override
	public void init() throws ServletException {
		// ������ ���� �ν��Ͻ��� ��������� ȣ��Ǵ� �޼���
		System.out.println("init �޼��� ���� : ���� ��Ÿ����!!!");
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
