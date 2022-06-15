package com.green.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.green.dao.MemberDAO;
import com.green.vo.MemberVO;

@WebServlet("/MUS")
public class MemberUpdateServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userid = request.getParameter("userid");
		
		// 세션에 저장된 정보를 활용 가능
		
		MemberDAO dao = MemberDAO.getInstance();
		MemberVO mVo = dao.getMember(userid);	// 아이디를 통해 회원의 정보 가져오기
		
		request.setAttribute("mVo", mVo);
		
		request.getRequestDispatcher("member/memberUpdate.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String userid = request.getParameter("userid");
		String userpwd = request.getParameter("userpwd");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		int admin = Integer.parseInt(request.getParameter("admin"));
		
		MemberVO mVo = new MemberVO();
		mVo.setUserid(userid);
		mVo.setUserpwd(userpwd);
		mVo.setEmail(email);
		mVo.setPhone(phone);
		mVo.setAdmin(admin);
		
		MemberDAO dao = MemberDAO.getInstance();
		dao.updateMember(mVo);
		
		response.sendRedirect("LS");
	}

}
