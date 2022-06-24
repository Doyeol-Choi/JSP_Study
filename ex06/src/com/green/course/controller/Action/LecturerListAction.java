package com.green.course.controller.Action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.green.lecturer.dao.LecturerDAO;
import com.green.lecturer.vo.LecturerVO;

public class LecturerListAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "/lecturer/lecturerList.jsp";
		
		LecturerDAO ldao = LecturerDAO.getInstance();
		
		List<LecturerVO> lecturerList = ldao.getLecturer();
		
		request.setAttribute("lecturerList", lecturerList);
		
		request.getRequestDispatcher(url).forward(request, response);
	}

}
