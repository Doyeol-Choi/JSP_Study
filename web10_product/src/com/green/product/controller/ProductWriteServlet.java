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

@WebServlet("/PWS")
public class ProductWriteServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("product/productWrite.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String url = "D:\\정보처리산업기사 수업\\Study\\JSP\\web10_product\\WebContent\\upload";
		
		try {
			MultipartRequest multi = new MultipartRequest(request, url, 100*1024*1024, "UTF-8", new DefaultFileRenamePolicy());
			
			ProductDAO dao = ProductDAO.getInstance();
			
			ProductVO pVo = new ProductVO();
			
			pVo.setName(multi.getParameter("name"));
			pVo.setPrice(Integer.parseInt(multi.getParameter("price")));
			pVo.setDescription(multi.getParameter("description"));
			pVo.setPictureurl(multi.getFilesystemName("pictureurl"));
			
			dao.insertProduct(pVo);
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		response.sendRedirect("PLS");
		
	}

}
