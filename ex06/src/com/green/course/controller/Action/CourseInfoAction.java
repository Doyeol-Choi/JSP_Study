package com.green.course.controller.Action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.green.course.dao.CourseDAO;
import com.green.course.vo.CourseVO;

public class CourseInfoAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String url = "/course/info.jsp";
		CourseDAO cdao = CourseDAO.getInstance();
		
		CourseVO cVo = cdao.getInfo(id);
		
		request.setAttribute("course", cVo);
		
		request.getRequestDispatcher(url).forward(request, response);
	}

}
