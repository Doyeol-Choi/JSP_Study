package com.green.dao;

import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.green.vo.ProductVO;

public class ProductDAO {
	private ProductDAO() {}
	
	private static ProductDAO dao = new ProductDAO();
	
	public static ProductDAO getInstance() {
		return dao;
	}
	
	///////////////////////////////////////////////////////////////
	// 연결 객체를 얻어오기 위한 메서드
	public Connection getConnection() throws Exception {
		Context initContext = new InitialContext();
		Context envContext  = (Context)initContext.lookup("java:/comp/env");
		DataSource ds = (DataSource)envContext.lookup("jdbc/myoracle");
		Connection conn = ds.getConnection();
		
		return conn;
	}
	
	////////////////////////////////////////////////////////////////
	// 연결 해제를 위한 메서드		- INSERT, UPDATE, DELETE	// preparedstatement는 statement와 상속관계에 있기때문에 따로 만들지 않아도 된다. 
	public void close(Connection conn, Statement stmt) {
		try {
			if(stmt!=null)stmt.close();
			if(conn!=null)conn.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	// 연결 해제를 위한 메서드		- SELECT
	public void close(Connection conn, Statement stmt, ResultSet rs) {
		try {
			if(rs!=null)rs.close();
			if(stmt!=null)stmt.close();
			if(conn!=null)conn.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	//////////////////////////////////////////////////////////////////
	// 전체 상풍 정보를 읽어오는 메서드
	public List<ProductVO> selectAllProduct() {
		
		List<ProductVO> list = new ArrayList<>();
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		String sql = "SELECT * FROM productTbl ORDER BY code DESC";
		
		try {
			conn = getConnection();
			stmt = conn.createStatement();
			
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				ProductVO pVo = new ProductVO();
				
				pVo.setCode(rs.getInt("code"));
				pVo.setName(rs.getString("name"));
				pVo.setPrice(rs.getInt("price"));
				pVo.setPictureurl(rs.getString("pictureurl"));
				pVo.setDescription(rs.getString("description"));
				
				list.add(pVo);
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			close(conn, stmt, rs);
		}
		
		return list;
	}
	
	//////////////////////////////////////////////////////////////////////
	// 상품 등록 메서드
	public void insertProduct(ProductVO pVo) {
		Connection conn = null;
		PreparedStatement psmt = null;
		
		String sql = "INSERT INTO productTbl VALUES(product_seq.nextval,?,?,?,?)";
		
		try {
			conn = getConnection();
			psmt = conn.prepareStatement(sql);
			
			psmt.setString(1, pVo.getName());
			psmt.setInt(2, pVo.getPrice());
			psmt.setString(3, pVo.getPictureurl());
			psmt.setString(4, pVo.getDescription());
			
			psmt.executeUpdate();
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			close(conn, psmt);
		}
	}

	//////////////////////////////////////////////////////////////////////////////
	// 상품 삭제 메서드
	public void deleteProduct(int code, String url) {
		String trueUrl = "D:\\정보처리산업기사 수업\\Study\\JSP\\web10_product\\WebContent\\upload\\"+url;
		
		File file = new File(trueUrl);
		
		Connection conn = null;
		PreparedStatement psmt = null;
		
		String sql = "DELETE FROM productTbl WHERE code=?";
		
		try {
			conn = getConnection();
			psmt = conn.prepareStatement(sql);
			
			psmt.setInt(1, code);
			
			psmt.executeUpdate();
			
			if(file.exists()) {
	            
	            // 파일을 삭제합니다.
	            file.delete(); 
	            
	            System.out.println("파일을 삭제하였습니다.");
	            
	        } else {
	            System.out.println("파일이 존재하지 않습니다.");
	        }
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			close(conn, psmt);
		}
	}
	
	////////////////////////////////////////////////////////////////////////////////
	// 수정하기 위한 상품을 찾는 메서드
	public ProductVO selectProductByCode(int code) {
		ProductVO pVo = new ProductVO();
//		ProductVO pVo = null;
		
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		
		String sql = "SELECT * FROM productTbl WHERE code=?";
		
		try {
			conn = getConnection();
			psmt = conn.prepareStatement(sql);
			
			psmt.setInt(1, code);
			
			rs = psmt.executeQuery();
			
			if(rs.next()) {
				pVo.setCode(code);
				pVo.setName(rs.getString("name"));
				pVo.setPrice(rs.getInt("price"));
				pVo.setPictureurl(rs.getString("pictureurl"));
				pVo.setDescription(rs.getString("description"));
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			close(conn, psmt, rs);
		}
		
		return pVo;
	}

	//////////////////////////////////////////////////////////////////////////////////
	// 상품 정보를 수정하기 위한 메서드
	public void updateProduct(int code, String name, int price, String pictureurl, String description) {
		Connection conn = null;
		PreparedStatement psmt = null;
		
		String sql = "UPDATE productTbl SET name=?, price=?, pictureurl=?, description=? WHERE code=?";
		
		try {
			conn = getConnection();
			psmt = conn.prepareStatement(sql);
			
			psmt.setString(1, name);
			psmt.setInt(2, price);
			psmt.setString(3, pictureurl);
			psmt.setString(4, description);
			psmt.setInt(5, code);
			
			psmt.executeUpdate();
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			close(conn, psmt);
		}
	}
}
