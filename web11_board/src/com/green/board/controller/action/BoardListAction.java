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
		/*
		 * String url = "/board/boardList.jsp";
		 * 
		 * BoardDAO dao = BoardDAO.getInstance(); List<BoardVO> boardList =
		 * dao.selectAllBoards();
		 * 
		 * request.setAttribute("boardList", boardList);
		 * 
		 * request.getRequestDispatcher(url).forward(request, response);
		 */
		 
		
		// 페이징 처리가 된 게시물 목록 보기
		String url = "/board/boardList.jsp";
		// 페이지로 부터 보여주고자 하는 섹션 정보와 페이지 정보 읽어오기
		String _section = request.getParameter("section");
		String _pageNum = request.getParameter("pageNum");
		
		// 처음 왔을때
		int section = Integer.parseInt((_section == null)?"1":_section);
		int pageNum = Integer.parseInt((_pageNum == null)?"1":_pageNum);
		
		BoardDAO dao = BoardDAO.getInstance();
		List<BoardVO> list = dao.selectTargetBoards(section, pageNum);
		int totalCnt = dao.selectAllBoardNumber();
		
		request.setAttribute("boardList", list);
		request.setAttribute("totalCnt", totalCnt);
		request.setAttribute("section", section);
		request.setAttribute("pageNum", pageNum);
		
		System.out.println("전체 게시글 수 : " + totalCnt);
		System.out.println("조회된 게시글 수 : " + list.size());
		
		request.getRequestDispatcher(url).forward(request, response);
	}

}
