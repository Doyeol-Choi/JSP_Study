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
		HttpSession session = request.getSession();
		int delete = Integer.parseInt(request.getParameter("delete"));
		
		if(delete == 0) {
			session.invalidate();
		} else if(delete == 1) {
			String coffee = request.getParameter("coffee");
			int price = Integer.parseInt(request.getParameter("price"));
			
			ArrayList<CafeVO> list = (ArrayList<CafeVO>) session.getAttribute("list");
			
			for(int i=0; i<list.size(); i++) {
				if(list.get(i).getCoffee().equals(coffee) && (list.get(i).getPrice() == price)) {
					list.remove(i);
					break;
				}
			}
			session.setAttribute("list", list);
		}
		response.sendRedirect("index.jsp");
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
		
		//request.getRequestDispatcher("index.jsp").forward(request, response);
		response.sendRedirect("index.jsp");
	}

}
