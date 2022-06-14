package com.green.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.green.dao.MemberDAO;
import com.green.vo.MemberVO;

@WebServlet("/JS")
public class JoinServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("member/join.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 입력된 정보를 통해서 회원가입 진행
		
		request.setCharacterEncoding("UTF-8");
		
		String name = request.getParameter("name");
		String userid = request.getParameter("userid");
		String userpwd = request.getParameter("userpwd");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		int admin = Integer.parseInt(request.getParameter("admin"));
		
		MemberDAO dao = MemberDAO.getInstance();
		//dao.insertMember(name, userid, userpwd, email, phone, admin);
		
		MemberVO mVo = new MemberVO();
		mVo.setName(name);
		mVo.setUserid(userid);
		mVo.setUserpwd(userpwd);
		mVo.setEmail(email);
		mVo.setPhone(phone);
		mVo.setAdmin(admin);
		
		int result = dao.insertMember(mVo);
		
		if(result == 1) {
			request.setAttribute("userid", userid);
			request.setAttribute("msg", "회원 가입에 성공했습니다.");
		} else {
			request.setAttribute("msg", "회원 가입에 실패했습니다.");
		}
		
		request.getRequestDispatcher("member/login.jsp").forward(request, response);
		
	}

}
