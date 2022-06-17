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

	public void updateMovie(int code, String moviename, String director, String actor, String pictureurl, int price) {
		
		Connection conn = null;
		PreparedStatement psmt = null;
		
		String sql = "UPDATE movie SET moviename=?, director=?, actor=?, pictureurl=?, price=? WHERE code=?";
		
		try {
			conn = getConnection();
			psmt = conn.prepareStatement(sql);
			
			psmt.setString(1, moviename);
			psmt.setString(2, director);
			psmt.setString(3, actor);
			psmt.setString(4, pictureurl);
			psmt.setInt(5, price);
			psmt.setInt(6, code);
			
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

	public int deleteMovie(int code) {
		int num = -1;
		
		Connection conn = null;
		PreparedStatement psmt = null;
		
		String sql = "DELETE FROM movie WHERE code=?";
		
		try {
			conn = getConnection();
			psmt = conn.prepareStatement(sql);
			
			psmt.setInt(1, code);
			
			num = psmt.executeUpdate();
			
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
		return num;
	}

	public void addMovie(int code, String moviename, String director, String actor, String pictureurl, int price) {
		Connection conn = null;
		PreparedStatement psmt = null;
		
		String sql = "INSERT INTO movie VALUES(?, ?, ?, ?, ?, ?)";
		
		try {
			conn = getConnection();
			psmt = conn.prepareStatement(sql);
			
			psmt.setInt(1, code);
			psmt.setString(2, moviename);
			psmt.setString(3, director);
			psmt.setString(4, actor);
			psmt.setString(5, pictureurl);
			psmt.setInt(6, price);
			
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

	public MovieVO movieInfo(int code) {
		MovieVO mVo = new MovieVO();
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		String sql = "SELECT * FROM movie WHERE code="+code;
		
		try {
			conn = getConnection();
			stmt = conn.createStatement();
			
			rs = stmt.executeQuery(sql);
			
			if(rs.next()) {
				int rscode = rs.getInt("code");
				String moviename = rs.getString("moviename");
				String director = rs.getString("director");
				String actor = rs.getString("actor");
				String pictureurl = rs.getString("pictureurl");
				int price = rs.getInt("price");
				
				mVo.setCode(rscode);
				mVo.setMoviename(moviename);
				mVo.setDirector(director);
				mVo.setActor(actor);
				mVo.setPictureurl(pictureurl);
				mVo.setPrice(price);
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
		return mVo;
	}

}
