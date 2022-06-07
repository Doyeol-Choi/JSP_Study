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
		System.out.println("로그인 기능 메서드!!!");
		
		String userid = request.getParameter("userid");
		String name = request.getParameter("name");		// HTML에서 name 값이 없기때문에 그냥 submit을 누르면 값이 null로 출력된다.
		int age = Integer.parseInt(request.getParameter("age"));	// 값은 string으로 들어오기 때문에 숫자형으로 쓰고 싶다면 변환이 필요하다.
		
		// 체크박스등 다수의 데이터가 하나의 이름으로 넘어올때 => 배열로 처리
		String[] hobbys = request.getParameterValues("hobby");
		
		System.out.println("입력된 아이디 : " + userid);
		System.out.println("입력된 이름 : " + name);
		for(String hobby:hobbys) {
			System.out.print("입력된 취미 : " + hobby + ", ");
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("로그인 기능 메서드!!!");
		System.out.println("Post 호출!");
		
		request.setCharacterEncoding("UTF-8");	// 한글이 깨지는 것을 방지
		
		String userid = request.getParameter("userid");
		String userpwd = request.getParameter("userpwd");
		String name = request.getParameter("name");		// HTML에서 name 값이 없기때문에 그냥 submit을 누르면 값이 null로 출력된다.
		int age = Integer.parseInt(request.getParameter("age"));	// 값은 string으로 들어오기 때문에 숫자형으로 쓰고 싶다면 변환이 필요하다.
		
		System.out.println("입력된 아이디 : " + userid);
		System.out.println("입력된 비밀번호 : " + userpwd);
		System.out.println("입력된 이름 : " + name);	
	}

}
