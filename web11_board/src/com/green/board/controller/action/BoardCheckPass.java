package com.green.board.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.green.board.dao.BoardDAO;

public class BoardCheckPass implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int num = Integer.parseInt(request.getParameter("num"));
		String pass = request.getParameter("pass");
		String url = null;
		
		BoardDAO dao = BoardDAO.getInstance();
		
		if(dao.checkPassword(num,pass)) {
			System.out.println("암호 일치");
			url = "/board/CheckSuccess.jsp";
			
		} else {
			System.out.println("암호 불일치");
			url = "/board/boardCheckPass.jsp";
			request.setAttribute("msg", "비밀번호가 틀렸습니다.");
//			앞에서 num값을 param.num으로 안받는다면 여기에서 num값도 같이 request로 넘겨주어야 한다.
		}
		request.getRequestDispatcher(url).forward(request, response);
	}

}
