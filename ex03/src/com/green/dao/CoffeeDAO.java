package com.green.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.green.vo.CafeVO;

public class CoffeeDAO {
	private CoffeeDAO() {}
	
	private static CoffeeDAO dao = new CoffeeDAO();
	
	public static CoffeeDAO getInstance() {
		return dao;
	}
	
	public Connection getConnection() throws Exception{
		Context initContext = new InitialContext();
		Context envContext  = (Context)initContext.lookup("java:/comp/env");
		DataSource ds = (DataSource)envContext.lookup("jdbc/myoracle");
		Connection conn = ds.getConnection();
		
		return conn;
	}

	public CafeVO order(String coffee, String size, int number) {
		CafeVO order = new CafeVO();
		
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		
		String sql = "SELECT * FROM cafe WHERE coffee=?";
		try {
			conn = getConnection();
			psmt = conn.prepareStatement(sql);
			
			psmt.setString(1, coffee);
			
			rs = psmt.executeQuery();
			
			if(rs.next()) {
				if(rs.getString("coffee").equals(coffee)) {
					int price = Integer.parseInt(rs.getString(size));
					int total = price * number;
					
					order.setCoffee(coffee);
					order.setSize(size);
					order.setNumber(number);
					order.setPrice(price);
					order.setTotal(total);
					
					return order;
				}
			}
				
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs!=null)rs.close();
				if(psmt!=null)psmt.close();
				if(conn!=null)conn.close();
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		return order;
	}


}
