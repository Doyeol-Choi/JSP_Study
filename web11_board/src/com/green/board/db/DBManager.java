package com.green.board.db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class DBManager {	// DB의 연결 및 해제를 담당할 기능을 가진 클래스
	
	public static Connection getConnection() {
		Connection conn = null;
		try {
			Context initContext = new InitialContext();
			Context envContext  = (Context)initContext.lookup("java:/comp/env");
			DataSource ds = (DataSource)envContext.lookup("jdbc/myoracle");
			conn = ds.getConnection();
		} catch(Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	public static void close(Connection conn, Statement stmt) {
		try {
			if(stmt!=null)stmt.close();
			if(conn!=null)conn.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void close(Connection conn, Statement stmt, ResultSet rs) {
		try {
			if(rs!=null)rs.close();
			if(stmt!=null)stmt.close();
			if(conn!=null)conn.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
