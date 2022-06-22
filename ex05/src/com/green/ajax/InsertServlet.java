package com.green.ajax;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

@WebServlet("/IS")
public class InsertServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();

		List<BoardVO> list = (List<BoardVO>)session.getAttribute("list");
		
		String boardInfo = request.getParameter("boardInfo");
		
		JsonParser parser = new JsonParser();
		JsonElement board = parser.parse(boardInfo);
		
		String name = board.getAsJsonObject().get("name").getAsString();
		String content = board.getAsJsonObject().get("content").getAsString();
		String date = board.getAsJsonObject().get("date").getAsString();
		
		BoardVO bVo = new BoardVO();
		
		bVo.setName(name);
		bVo.setContent(content);
		bVo.setDate(date);
		
		list.add(bVo);
		
		session.setAttribute("list", list);
	}

}
