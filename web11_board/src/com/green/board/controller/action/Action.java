package com.green.board.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Action {	// 기능 클래스를 묶어줄 역할을 하는 인터페이스
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
}
