package com.green.course.controller.Action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.green.course.dao.CourseDAO;
import com.green.course.vo.CourseVO;

public class CourseListAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "/course/list.jsp";
		
		CourseDAO Cdao = CourseDAO.getInstance();
		
		List<CourseVO> courseList = Cdao.getList();
		
		request.setAttribute("courseList", courseList);
		
		request.getRequestDispatcher(url).forward(request, response);
	}

}
