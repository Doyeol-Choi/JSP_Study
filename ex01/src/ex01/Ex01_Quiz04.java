package ex01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "Ex04_Quiz04", urlPatterns = { "/Q04" })
public class Ex01_Quiz04 extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=utF-8");
		PrintWriter out = response.getWriter();
		
		String name = request.getParameter("u_name");
		double heat = Double.parseDouble(request.getParameter("u_heat"));
		String result;
		
		out.println("<html><body>");
		if(heat >= 37.5) {
			int num = (int)(Math.random()*100);
			out.println("<p> num���� " + num + "�Դϴ�.");
			if(num>19) {
				result = "����";
			} else {
				result = "�缺";
			}
		} else {
			
			result = "����";
		}
		out.println("<h1>���� ���</h1>");
		out.println("<p>" + name + " �� �ڷγ� '" + result + "'�Դϴ�.");
		
		out.println("</body></html>");
	}

}
