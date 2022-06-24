package com.green.course.controller.Action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.green.course.dao.CourseDAO;

public class CourseDeleteAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String id = request.getParameter("id");
		
		CourseDAO cdao = CourseDAO.getInstance();
		
		cdao.deleteCourse(id);
		
		response.sendRedirect("CS?command=course_list");
	}

}
