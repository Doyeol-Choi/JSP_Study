package com.green.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.green.dao.CoffeeDAO;
import com.green.vo.CafeVO;


@WebServlet("/Basket")
public class Basket extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		HttpSession session = request.getSession();
		
		String coffee = request.getParameter("coffee");
		String size = request.getParameter("size");
		int number = Integer.parseInt(request.getParameter("number"));
		
		CoffeeDAO dao = CoffeeDAO.getInstance();
		CafeVO order = dao.order(coffee, size, number);
		ArrayList<CafeVO> list = (ArrayList<CafeVO>) session.getAttribute("list");
		
		if(list != null) {
			boolean chk = true;
			for(int i=0; i<list.size(); i++) {
				if(list.get(i).getCoffee().equals(order.getCoffee()) && list.get(i).getSize().equals(order.getSize())) {
					list.get(i).setNumber(order.getNumber() + list.get(i).getNumber());
					list.get(i).setTotal(order.getTotal() + list.get(i).getTotal());
					chk = false;
				}
			}
			if(chk) {list.add(order);};			
		} else {
			list = new ArrayList<CafeVO>();
			list.add(order);
		}		
		session.setAttribute("list", list);
		
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

}
