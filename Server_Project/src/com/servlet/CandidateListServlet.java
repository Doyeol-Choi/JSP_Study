package com.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.CandidateDAO;
import com.vo.CandidateVO;

@WebServlet("/CandidateListServlet")
public class CandidateListServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String url = "/vote/CandidateList.jsp";
		
		CandidateDAO cdao = CandidateDAO.getInstance();

		List<CandidateVO> CandidateList = cdao.selectAllCandidate();

		request.setAttribute("CandidateList", CandidateList);

		request.getRequestDispatcher(url).forward(request, response);
		
	}

}


