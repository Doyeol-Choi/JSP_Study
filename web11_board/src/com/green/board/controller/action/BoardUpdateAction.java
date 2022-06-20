package com.green.board.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.green.board.dao.BoardDAO;
import com.green.board.vo.BoardVO;

public class BoardUpdateAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BoardVO bVo = new BoardVO();
		
		bVo.setNum(Integer.parseInt(request.getParameter("num")));
		bVo.setName(request.getParameter("name"));
		bVo.setEmail(request.getParameter("email"));
		bVo.setPass(request.getParameter("pass"));
		bVo.setTitle(request.getParameter("title"));
		bVo.setContent(request.getParameter("content"));
		
		BoardDAO dao = BoardDAO.getInstance();
		
		dao.updateBoard(bVo);
		
		response.sendRedirect("BS?command=board_list");
	}

}
