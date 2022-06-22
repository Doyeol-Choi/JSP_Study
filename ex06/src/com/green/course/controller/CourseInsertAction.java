package com.green.course.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.green.course.controller.Action.Action;
import com.green.course.dao.CourseDAO;
import com.green.course.vo.CourseVO;

public class CourseInsertAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CourseVO cVo = new CourseVO();
		
		cVo.setId(request.getParameter("id"));
		cVo.setName(request.getParameter("name"));
		cVo.setCredit(Integer.parseInt(request.getParameter("credit")));
		cVo.setLecturer(request.getParameter("lecturer"));
		cVo.setIweek(Integer.parseInt(request.getParameter("week")));
		cVo.setStart_hour(Integer.parseInt(request.getParameter("start_hour")));
		cVo.setEnd_hour(Integer.parseInt(request.getParameter("end_hour")));
		
		CourseDAO cdao = CourseDAO.getInstance();
		
		cdao.insertCourse(cVo);
		
		response.sendRedirect("CS?command=course_list");
	}
}
