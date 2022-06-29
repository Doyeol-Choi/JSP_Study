package com.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.CandidateDAO;
import com.dao.VoterDAO;
import com.vo.CandidateVO;
import com.vo.VoterVO;

@WebServlet("/VoteServlet")
public class VoteServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 투표하기 페이지의 경로
		String url = "/vote/vote.jsp";
		
		CandidateDAO cdao = CandidateDAO.getInstance();
		// 투표하기 페이지의 후보목록을 가져오기위해 dao객체를 통한 메서드를 호출하고 리스트로 반환
		List<CandidateVO> list = cdao.getCandidateName();
		
		request.setAttribute("CandidateList", list);
		// 리스트를 request로 넘겨주고 포워드를 통해 투표하기 페이지로 이동
		request.getRequestDispatcher(url).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		VoterVO vVo = new VoterVO();
		// 투표하기 페이지에서 넝어온 값을 VO 객체에 각각 저장
		vVo.setJumin(request.getParameter("jumin"));
		vVo.setName(request.getParameter("name"));
		vVo.setNo(request.getParameter("no"));
		vVo.setTime(request.getParameter("time"));
		vVo.setArea(request.getParameter("area"));
		vVo.setConfirm(request.getParameter("confirm"));
		
		// DAO 객체를 통해 유권자 정보를 DB에 저장하기 위한 메서드를 호출하고 매개값으로 VO객체를 넣어준다
		VoterDAO vdao = VoterDAO.getInstance();
		vdao.voterInsert(vVo);
		// 입력 완료후 메인 페이지로 이동
		response.sendRedirect("index.jsp");
	}

}
