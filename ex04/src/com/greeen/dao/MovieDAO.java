package com.greeen.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.green.vo.MovieVO;

public class MovieDAO {
	private MovieDAO() {}
	
	private static MovieDAO dao = new MovieDAO();
	
	public static MovieDAO getInstance() {
		return dao;
	}
	
	public Connection getConnection() throws Exception{
		Context initContext = new InitialContext();
		Context envContext  = (Context)initContext.lookup("java:/comp/env");
		DataSource ds = (DataSource)envContext.lookup("jdbc/myoracle");
		Connection conn = ds.getConnection();
		
		return conn;
	}

	public List<MovieVO> movieList() {
		List<MovieVO> list = new ArrayList<>();
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		String sql = "SELECT * FROM movie";
		
		try {
			conn = getConnection();
			stmt = conn.createStatement();
			
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				int code = rs.getInt("code");
				String moviename = rs.getString("moviename");
				String director = rs.getString("director");
				String actor = rs.getString("actor");
				int price = rs.getInt("price");
				
				MovieVO mVo = new MovieVO();
				
				mVo.setCode(code);
				mVo.setMoviename(moviename);
				mVo.setDirector(director);
				mVo.setActor(actor);
				mVo.setPrice(price);
				
				list.add(mVo);
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
		return list;
	}

	public void updateMovie(int code, String moviename, String director, String actor, int price) {
		
		Connection conn = null;
		PreparedStatement psmt = null;
		
		String sql = "UPDATE movie SET moviename=?, director=?, actor=?, price=? WHERE code=?";
		
		try {
			conn = getConnection();
			psmt = conn.prepareStatement(sql);
			
			psmt.setString(1, moviename);
			psmt.setString(2, director);
			psmt.setString(3, actor);
			psmt.setInt(4, price);
			psmt.setInt(5, code);
			
			psmt.executeUpdate();
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(psmt!=null)psmt.close();
				if(conn!=null)conn.close();
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void deleteMovie(int code) {
		Connection conn = null;
		PreparedStatement psmt = null;
		
		String sql = "DELETE FROM movie WHERE code=?";
		
		try {
			conn = getConnection();
			psmt = conn.prepareStatement(sql);
			
			psmt.setInt(1, code);
			
			psmt.executeUpdate();
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(psmt!=null)psmt.close();
				if(conn!=null)conn.close();
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
	}

}
