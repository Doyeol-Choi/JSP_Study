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

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

@WebServlet("/SS")
public class SnsServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String command = request.getParameter("command");
		List<BoardVO> list = null;
		if(command.equals("start")) {
			list = new ArrayList<BoardVO>();
			BoardVO bVo1 = BoardVO.dummy1();
			BoardVO bVo2 = BoardVO.dummy2();
			BoardVO bVo3 = BoardVO.dummy3();
			
			list.add(bVo1);
			list.add(bVo2);
			list.add(bVo3);
			
			request.setAttribute("list", list);
			
			request.getRequestDispatcher("main.jsp").forward(request, response);
		} else {
			String boardInfo = request.getParameter("boardInfo");
			
			JsonParser parser = new JsonParser();
			JsonElement data = parser.parse(boardInfo);
			
			String num = data.getAsJsonObject().get("num").getAsString();
			String name = data.getAsJsonObject().get("name").getAsString();
			String content = data.getAsJsonObject().get("content").getAsString();
			// 여기서 수정
			MemberInfo memberInfo = new MemberInfo();
			memberInfo.setuID("han");
			memberInfo.setuName("한명희");
			memberInfo.setuPwd("1234");
			
			Gson gson = new Gson();
			
			String memberInfoJson = gson.toJson(memberInfo);
			
			PrintWriter out = response.getWriter();
			
			out.print(memberInfoJson);
		}
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
