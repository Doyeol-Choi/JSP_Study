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
		// ������ ���� �ν��Ͻ��� ��������� ȣ��Ǵ� �޼���
		System.out.println("init �޼��� ���� : ���� ��Ÿ����!!!");
	}

	public void destroy() {
		// ���� �ν��Ͻ��� �޸𸮻󿡼� ����� �� ȣ��Ǵ� �޼���
		System.out.println("destroy �޼��� ���� : ���� �������!!!");
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// get ȣ���� �߻��� ������ ȣ��Ǵ� �޼���
		System.out.println("doGet �޼��� ���� : " + (num++) + "��° ȣ��ȴ�!!!");
	}

}
