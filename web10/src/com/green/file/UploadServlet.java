package com.green.file;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

@WebServlet("/uploadServlet")
public class UploadServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		// 파일을 받아줄 준비
		// 1. 파일을 어디에 저장할 것인가?
		// 2. 얼마나 큰 파일을 받을 수 있을 것인가?
		// 3. 파일 이름 인코딩 방식
		// 4. 파일 이름 정책 - 기본값 동일 파일일 경우에 숫자를 붙여서 처리하도록
		
		// COS => MultipartRequest 객체를 지원
		// 1. 저장 위치
		String savePath = "upload";
		
		// 단위 Byte 2MB = 2*1024KB => 2*1024*1024Byte
		int uploadFileSize = 2*1024*1024;
		
		// 파일 이름 인코딩 방식
		String encType = "UTF-8";
		
		ServletContext context = getServletContext();
		String uploadFilePath = context.getRealPath(savePath);
		
		System.out.println("실제 파일 경로 : " + uploadFilePath);
		
		String path = "c:\\fileTest";	// 크롬의 크로스도메인 이슈 CORS
		
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		try {
			MultipartRequest multi = new MultipartRequest(
										request,		// 폼으로 부터 얻어온 request 객체
										path,		// 파일 저장 경로
										uploadFileSize,	// 최대 업로드 크기
										encType,		// 파일이름 인코딩 방식
										new DefaultFileRenamePolicy()	// 정책
										);	// 5개의 매개변수 입력
			// 인스턴스가 만들어지는 순간 업로드 완료
			// 파일 이름을 알아올 필요가 존재
			String fileName = multi.getFilesystemName("fileUpload");
			
			out.println("글쓴이 : " + multi.getParameter("name") + "<br>");
			out.println("제   목 : " + multi.getParameter("title") + "<br>");
			out.println("파일명 : " + fileName + "<br>");
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}

}
