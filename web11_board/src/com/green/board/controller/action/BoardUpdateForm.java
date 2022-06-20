package com.green.board.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.green.board.dao.BoardDAO;
import com.green.board.vo.BoardVO;

public class BoardUpdateForm implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "/board/boardUpdateForm.jsp";
		int num = Integer.parseInt(request.getParameter("num"));
		
		BoardDAO dao = BoardDAO.getInstance();
		
		BoardVO bVo = dao.selectBoardByNum(num);
		
		request.setAttribute("board", bVo);
		
		request.getRequestDispatcher(url).forward(request, response);
	}

}
