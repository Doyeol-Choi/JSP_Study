package com.greeen.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.greeen.dao.MovieDAO;
import com.green.vo.MovieVO;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

@WebServlet("/MUS")
public class MovieUpdateServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int code = Integer.parseInt(request.getParameter("code"));

		MovieDAO dao = MovieDAO.getInstance();
		
		MovieVO mVo = dao.movieInfo(code);
		
		request.setAttribute("mVo", mVo);
		
		request.getRequestDispatcher("info.jsp").forward(request, response);
	
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
		
		if(pictureurl == null) {
			pictureurl = multi.getParameter("originPictureUrl");
		}
		
		dao.updateMovie(code, moviename, director, actor, pictureurl, price);
		} catch(Exception e) {
			e.printStackTrace();
		} 
		response.sendRedirect("MLS");
	}

}
