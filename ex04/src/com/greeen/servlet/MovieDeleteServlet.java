package com.greeen.servlet;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.greeen.dao.MovieDAO;

@WebServlet("/MDS")
public class MovieDeleteServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int code = Integer.parseInt(request.getParameter("code"));
		String url = "D:\\정보처리산업기사 수업\\Study\\JSP\\ex04\\WebContent\\upload"+request.getParameter("pic");
		File file = new File(url);
		
		MovieDAO dao = MovieDAO.getInstance();
		
		int num = dao.deleteMovie(code);
		
		if (num == 1) {
			if(file.exists())file.delete();
		}
		
		response.sendRedirect("MLS");
	}

}
