package com.green.product.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.green.dao.ProductDAO;
import com.green.vo.ProductVO;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

@WebServlet("/PUS")
public class ProductUpdateServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int code = Integer.parseInt(request.getParameter("code"));
		
		ProductDAO dao = ProductDAO.getInstance();
		
		ProductVO pVo = dao.selectProductByCode(code);
		
		request.setAttribute("pVo", pVo);
		
		request.getRequestDispatcher("product/productUpdate.jsp").forward(request, response);	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		ProductDAO dao = ProductDAO.getInstance();
		
		try {
			String url = "D:\\정보처리산업기사 수업\\Study\\JSP\\web10_product\\WebContent\\upload";
			MultipartRequest multi = new MultipartRequest(request, url, 100*1024*1024, "UTF-8", new DefaultFileRenamePolicy());
		
			int code = Integer.parseInt(multi.getParameter("code"));
			String name = multi.getParameter("name");
			int price = Integer.parseInt(multi.getParameter("price"));
			String pictureurl = multi.getFilesystemName("pictureurl");
			String description = multi.getParameter("description");
			if(pictureurl == null) {
				pictureurl = multi.getParameter("originPictureUrl");
			}
		
			dao.updateProduct(code, name, price, pictureurl, description);
		} catch(Exception e) {
			e.printStackTrace();
		}
		response.sendRedirect("PLS");
	}

}
