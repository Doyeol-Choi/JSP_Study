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

@WebServlet("/CandidateResultServlet")
public class CandidateResultServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 후보자 등수 페이지로 가기위한 경로
		String url ="/vote/result.jsp";
		
		CandidateDAO cdao = CandidateDAO.getInstance();
		//DAO 객체를 통해 후보자 등수 데이터를 가져올 함수를 호출하고 반환값을 리스트로 받음
		List<CandidateVO> list = cdao.getVoteResult();
		
		request.setAttribute("resultList", list);
		// 리스트를 request로 넘겨주고 포워드를 통해 후보자 등수 페이지로 이동
		request.getRequestDispatcher(url).forward(request, response);
	}

}
