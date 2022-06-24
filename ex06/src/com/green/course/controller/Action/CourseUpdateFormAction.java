package com.green.course.controller.Action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.green.course.dao.CourseDAO;
import com.green.course.vo.CourseVO;
import com.green.lecturer.dao.LecturerDAO;
import com.green.lecturer.vo.LecturerVO;

public class CourseUpdateFormAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String url = "/course/update.jsp";
		
		CourseDAO cdao = CourseDAO.getInstance();
		CourseVO cVo = cdao.getInfo(id);
		
		LecturerDAO ldao = LecturerDAO.getInstance();
		List<LecturerVO> list = ldao.getLecturer();
		
		request.setAttribute("course", cVo);
		request.setAttribute("lecturerList", list);
		
		request.getRequestDispatcher(url).forward(request, response);
	}

}
