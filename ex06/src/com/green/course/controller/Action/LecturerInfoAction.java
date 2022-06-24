package com.green.course.controller.Action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.green.lecturer.dao.LecturerDAO;
import com.green.lecturer.vo.LecturerVO;

public class LecturerInfoAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "/lecturer/lecturerInfo.jsp";
		
		int idx = Integer.parseInt(request.getParameter("idx"));
		
		LecturerDAO ldao = LecturerDAO.getInstance();
		
		LecturerVO lVo = ldao.getLecturerInfo(idx);
		
		request.setAttribute("lecturer", lVo);
		
		request.getRequestDispatcher(url).forward(request, response);
	}

}
