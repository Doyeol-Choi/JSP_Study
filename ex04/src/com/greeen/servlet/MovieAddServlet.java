package com.greeen.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.greeen.dao.MovieDAO;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

@WebServlet("/MAS")
public class MovieAddServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("add.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		MovieDAO dao = MovieDAO.getInstance();
		
		try {
			String url = "D:\\정보처리산업기사 수업\\Study\\JSP\\ex04\\WebContent\\upload";
			MultipartRequest multi = new MultipartRequest(request, url, 100*1024*1024, "UTF-8", new DefaultFileRenamePolicy());
		
			int code = Integer.parseInt(multi.getParameter("code"));
			String moviename = multi.getParameter("moviename");
			String director = multi.getParameter("director");
			String actor = multi.getParameter("actor");
			String pictureurl = multi.getFilesystemName("pictureurl");
			int price = Integer.parseInt(multi.getParameter("price"));
			
		
			dao.addMovie(code, moviename, director, actor, pictureurl, price);
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		response.sendRedirect("MLS");
	}

}
