package ex01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Q03")
public class Ex01_Quiz03 extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=utF-8");
		PrintWriter out = response.getWriter();
		String[] s_nums = request.getParameterValues("chk");
		out.println("<html><body>");
		
		for (int i=0; i<s_nums.length; i++) {
			int n = Integer.parseInt(s_nums[i]);
			
			out.println("<h3>" + n + "´Ü</h3>");
			out.println("<table border='1'>");
			for (int j=0; j < n; j++) {
				out.println("<tr><td>"+(j+1)+"</td></tr>");
			}
			out.println("</table>");
		}
		out.println("</body></html>");
		
		
	}

}
