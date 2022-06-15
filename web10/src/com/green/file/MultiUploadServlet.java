package com.green.file;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

@WebServlet("/MultiUploadServlet")
public class MultiUploadServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		serviceTest(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		serviceTest(request,response);
	}
	
	protected void serviceTest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 실제 코드를 작성
		response.setContentType("text/html; charset=UTF-8");
		
		PrintWriter out = response.getWriter();
		
		String uploadPath = "C://fileTest";
		int uploadFilesize = 10*1024*1024;	// 합계 파일 사이즈
		String encType = "UTF-8";
		
		try {
			MultipartRequest mul = new MultipartRequest(request, uploadPath, uploadFilesize, encType, new DefaultFileRenamePolicy());
				if(mul == null) {
					System.out.println("업로드 실패");
				} else {
					System.out.println("업로드 성공");
				}
				
				Enumeration<String> fileNames = mul.getFileNames();		// 파일 이름들을 배열 형태로 가져온다.
				
				while(fileNames.hasMoreElements()) {
					String file = fileNames.nextElement();	// 파일 이름이 아님 => name이름 : uploadFile01
					String fileName = mul.getFilesystemName(file);
					
					String originFileName = mul.getOriginalFileName(file);	// 정책에 의해서 변경되기전 원본 파일명
					
					out.println("업로드된 파일명 : " + fileName + "<br>");
					out.println("원본 파일명 : " + originFileName + "<br>");
				}
				
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
