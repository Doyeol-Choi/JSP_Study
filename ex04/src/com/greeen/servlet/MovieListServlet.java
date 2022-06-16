package com.greeen.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.greeen.dao.MovieDAO;
import com.green.vo.MovieVO;

@WebServlet("/MLS")
public class MovieListServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		MovieDAO dao = MovieDAO.getInstance();
		
		List<MovieVO> list = dao.movieList();
		
		session.setAttribute("movieList", list);
		
		response.sendRedirect("list.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
