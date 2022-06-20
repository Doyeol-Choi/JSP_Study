package com.green.board.controller.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.green.board.dao.BoardDAO;
import com.green.board.vo.BoardVO;

public class BoardListAction implements Action {	// 실제 기능을 담당할 클래스

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "/board/boardList.jsp";
		
		BoardDAO dao = BoardDAO.getInstance();
		List<BoardVO> boardList = dao.selectAllBoards();
		
		request.setAttribute("boardList", boardList);
		
		request.getRequestDispatcher(url).forward(request, response);
	}

}
