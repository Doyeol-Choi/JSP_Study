package com.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.VoterDAO;
import com.vo.VoterVO;

@WebServlet("/VoterListServlet")
public class VoterListServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String url = "/vote/VoteCheck.jsp";
		
		VoterDAO dao = VoterDAO.getInstance();
		
		List<VoterVO> list = dao.checkAllVoter();
		
		request.setAttribute("VoteCheck", list);
		
		request.getRequestDispatcher(url).forward(request, response);
	}

}
