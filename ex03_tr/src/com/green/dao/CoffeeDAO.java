package com.green.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.green.vo.CoffeeVO;

import jdk.nashorn.internal.ir.RuntimeNode.Request;

public class CoffeeDAO {
	private CoffeeDAO() {}
	
	private static CoffeeDAO dao = new CoffeeDAO();
	
	public static CoffeeDAO getInstance() {
		return dao;
	}
	
	//////////////////////////////////////////////////////////////////
	// 연결객체를 불러오는 메서드
	public Connection getConnection() throws Exception{
		Context initContext = new InitialContext();
		Context envContext  = (Context)initContext.lookup("java:/comp/env");
		DataSource ds = (DataSource)envContext.lookup("jdbc/myoracle");
		Connection conn = ds.getConnection();
		
		return conn;
	}

	///////////////////////////////////////////////////////////////////
	// 커피 이름을 알아오는 메서드
	public List<String> getCoffeeName() {
		List<String> names = new ArrayList<>();
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		String sql = "SELECT DISTINCT(coffeeName) FROM coffeePriceTbl";
		try {
			conn = getConnection();
			stmt = conn.createStatement();
			
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				String coffeeName = rs.getString(1);
				names.add(coffeeName);
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs!=null)rs.close();
				if(stmt!=null)stmt.close();
				if(conn!=null)conn.close();
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		return names;
	}

	public int getCoffeePrice(String cName, String cType) {
		int price = 0;
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		
		String sql = "SELECT price FROM coffeePriceTbl WHERE coffeename=? AND coffeetype=?";
		
		try {
			conn = getConnection();
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, cName);
			psmt.setString(2, cType);
			
			rs = psmt.executeQuery();
			
			if(rs.next()) {
				price = rs.getInt(1);
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
		return price;
	}
}
