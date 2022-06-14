package com.green.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.green.dao.MemberDAO;
import com.green.vo.MemberVO;


@WebServlet("/LS")
public class LoginServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 폼페이지로 연결
		String url = "member/login.jsp";
		
		HttpSession session = request.getSession();
		if(session.getAttribute("loginUser")!=null) {	// 현재 로그인한 사용자가 있다면
			url = "main.jsp";
		}
		
		request.getRequestDispatcher(url).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 입력받은 데이터를 처리
		request.setCharacterEncoding("UTF-8");
		
		String url = "member/login.jsp";
		
		String userid = request.getParameter("userid");
		String userpwd = request.getParameter("userpwd");
		
		// 로그인 인증 처리
		MemberDAO dao = MemberDAO.getInstance();
		
		int result = dao.userCheck(userid, userpwd);
		
		if(result==1) {	// 로그인 성공
			MemberVO mVo = dao.getMember(userid);
			
			HttpSession session = request.getSession();
			session.setAttribute("loginUser", mVo);
			
			request.setAttribute("msg", "로그인 성공");
			url = "main.jsp";
		} else if(result==0) {	// 비밀번호가 틀린 경우
			request.setAttribute("msg", "비밀번호가 맞지 않습니다.");
		} else if(result==-1) {	// 아이디가 없는 경우
			request.setAttribute("msg", "존재하지 않는 회원입니다.");
		}
		request.getRequestDispatcher(url).forward(request, response);
	}

}
