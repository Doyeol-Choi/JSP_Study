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

@WebServlet("/MUS")
public class MovieUpdateServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int num = Integer.parseInt(request.getParameter("num"));
		
		request.setAttribute("i", num);
		
		request.getRequestDispatcher("info.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		
		int code = Integer.parseInt(request.getParameter("code"));
		String moviename = request.getParameter("moviename");
		String director = request.getParameter("director");
		String actor = request.getParameter("actor");
		int price = Integer.parseInt(request.getParameter("price"));
		
		MovieDAO dao = MovieDAO.getInstance();
		
		dao.updateMovie(code, moviename, director, actor, price);
		
		response.sendRedirect("MLS");
	}

}
