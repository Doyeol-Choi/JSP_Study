package com.green.course.controller.Action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.green.lecturer.dao.LecturerDAO;
import com.green.lecturer.vo.LecturerVO;

public class LecturerInsertAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		LecturerVO lVo = new LecturerVO();
		
		lVo.setName(request.getParameter("name"));
		lVo.setMajor(request.getParameter("major"));
		lVo.setField(request.getParameter("field"));
		
		LecturerDAO ldao = LecturerDAO.getInstance();
		
		ldao.insertLecturer(lVo);
		
		response.sendRedirect("CS?command=lecturer_list");
	}

}
