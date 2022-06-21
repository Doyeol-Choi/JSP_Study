package com.green.ajax;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

@WebServlet("/Ajax01Servlet")
public class Ajax01Servlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("호출 성공");
		String userID = request.getParameter("userID");
		System.out.println("입력된 아이디 : " + userID);
		
		response.setContentType("text/html; charset=UTF-8");
		
		PrintWriter out = response.getWriter();
		
		out.print("홍길동");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String userData = request.getParameter("userInfo");
		
		System.out.println("받아온 값 : " + userData);
		
		JsonParser parser = new JsonParser();
		JsonElement data = parser.parse(userData);
		
		String userID = data.getAsJsonObject().get("userID").getAsString();
		String userName = data.getAsJsonObject().get("userName").getAsString();
		String userPwd = data.getAsJsonObject().get("userPwd").getAsString();
		
		System.out.println("받아온 아이디 : " + userID);
		System.out.println("받아온 이름 : " + userName);
		System.out.println("받아온 비밀번호 : " + userPwd);
	}

}
