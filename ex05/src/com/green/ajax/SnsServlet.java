package com.green.ajax;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.catalina.connector.Request;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

@WebServlet("/SS")
public class SnsServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		List<BoardVO> list = new ArrayList<BoardVO>();
 
		BoardVO bVo1 = BoardVO.dummy1();
		BoardVO bVo2 = BoardVO.dummy2();
		BoardVO bVo3 = BoardVO.dummy3();
		
		list.add(bVo1);
		list.add(bVo2);
		list.add(bVo3);
		
		session.setAttribute("list", list);
	
		request.getRequestDispatcher("main.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		
		String boardInfo = request.getParameter("boardInfo");
		
		JsonParser parser = new JsonParser();
		JsonElement data = parser.parse(boardInfo);
		
		String num = data.getAsJsonObject().get("num").getAsString();
		String name = data.getAsJsonObject().get("name").getAsString();
		String content = data.getAsJsonObject().get("content").getAsString();
		
		BoardVO bVo = new BoardVO();
		bVo.setNum(num);
		bVo.setName(name);
		bVo.setContent(content);
		
		Gson gson = new Gson();
		
		String bVoJson = gson.toJson(bVo);
		
		PrintWriter out = response.getWriter();
		
		out.print(bVoJson);
	}

}
