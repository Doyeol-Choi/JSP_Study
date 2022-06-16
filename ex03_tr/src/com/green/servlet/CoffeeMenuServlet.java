package com.green.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.green.dao.CoffeeDAO;
import com.green.vo.CoffeeVO;

@WebServlet("/CMS")
public class CoffeeMenuServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		CoffeeDAO dao = CoffeeDAO.getInstance();
		
		List<String> coffeeNames = dao.getCoffeeName();
		
		// if(session.getAttribute("coffeeList")==null)session.setAttribute("coffeeList", new ArrayList<>());
		
		request.setAttribute("cNames", coffeeNames);
		
		request.getRequestDispatcher("coffeeMenu.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		
		String cName = request.getParameter("coffeeName");
		String cType = request.getParameter("coffeeType");
		int cCount = Integer.parseInt(request.getParameter("coffeeCount"));
		
		CoffeeDAO dao = CoffeeDAO.getInstance();
		
		int cPrice = dao.getCoffeePrice(cName, cType);
		
		int cTotal = cPrice * cCount;
		
		List<String> coffeeNames = dao.getCoffeeName();
		request.setAttribute("cNames", coffeeNames);
		
		CoffeeVO cVo = new CoffeeVO();
		
		cVo.setCoffeeName(cName);
		cVo.setCoffeeType(cType);
		cVo.setCount(cCount);
		cVo.setPrice(cPrice);
		cVo.setTotal(cTotal);
		
		List<CoffeeVO> coffeeList = (List<CoffeeVO>) session.getAttribute("coffeeList");
		
		if(coffeeList==null)coffeeList = new ArrayList<>();		// 처음 get으로 받아왔을때 만들어두어도 된다.
		
		coffeeList.add(cVo);
		
		session.setAttribute("coffeeList", coffeeList);
		
		request.getRequestDispatcher("coffeeMenu.jsp").forward(request, response);
	}

}
