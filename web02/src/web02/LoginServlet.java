package web02;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/LS")
public class LoginServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("�α��� ��� �޼���!!!");
		
		String userid = request.getParameter("userid");
		String name = request.getParameter("name");		// HTML���� name ���� ���⶧���� �׳� submit�� ������ ���� null�� ��µȴ�.
		int age = Integer.parseInt(request.getParameter("age"));	// ���� string���� ������ ������ ���������� ���� �ʹٸ� ��ȯ�� �ʿ��ϴ�.
		
		// üũ�ڽ��� �ټ��� �����Ͱ� �ϳ��� �̸����� �Ѿ�ö� => �迭�� ó��
		String[] hobbys = request.getParameterValues("hobby");
		
		System.out.println("�Էµ� ���̵� : " + userid);
		System.out.println("�Էµ� �̸� : " + name);
		for(String hobby:hobbys) {
			System.out.print("�Էµ� ��� : " + hobby + ", ");
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("�α��� ��� �޼���!!!");
		System.out.println("Post ȣ��!");
		
		request.setCharacterEncoding("UTF-8");	// �ѱ��� ������ ���� ����
		
		String userid = request.getParameter("userid");
		String userpwd = request.getParameter("userpwd");
		String name = request.getParameter("name");		// HTML���� name ���� ���⶧���� �׳� submit�� ������ ���� null�� ��µȴ�.
		int age = Integer.parseInt(request.getParameter("age"));	// ���� string���� ������ ������ ���������� ���� �ʹٸ� ��ȯ�� �ʿ��ϴ�.
		
		System.out.println("�Էµ� ���̵� : " + userid);
		System.out.println("�Էµ� ��й�ȣ : " + userpwd);
		System.out.println("�Էµ� �̸� : " + name);	
	}

}
