package web02;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/LCT")
public class LifeCycleTest extends HttpServlet {
	public static int num = 1;

	public void init(ServletConfig config) throws ServletException {
		// 서블릿이 최초 인스턴스가 만들어질때 호출되는 메서드
		System.out.println("init 메서드 동작 : 내가 나타났다!!!");
	}

	public void destroy() {
		// 서블릿 인스턴스가 메모리상에서 사라질 때 호출되는 메서드
		System.out.println("destroy 메서드 동작 : 내가 사라진다!!!");
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// get 호출이 발생할 때마다 호출되는 메서드
		System.out.println("doGet 메서드 동작 : " + (num++) + "번째 호출된다!!!");
	}

}
