package com.green.ajax;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

@WebServlet("/Ajax02Servlet")
public class Ajax02Servlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		
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
