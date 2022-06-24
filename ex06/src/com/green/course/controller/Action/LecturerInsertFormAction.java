package com.green.course.controller.Action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.green.lecturer.dao.LecturerDAO;

public class LecturerInsertFormAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "/lecturer/lecturerInsert.jsp";
		
		LecturerDAO ldao = LecturerDAO.getInstance();
		
		int idx = ldao.findIdx();
		
		request.setAttribute("idx", idx);
		
		request.getRequestDispatcher(url).forward(request, response);
	}

}
