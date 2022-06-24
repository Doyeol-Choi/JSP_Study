package com.green.course.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.green.course.db.DBManager;
import com.green.course.vo.CourseVO;

public class CourseDAO {
	private CourseDAO() {}
	
	private static CourseDAO dao = new CourseDAO();
	
	public static CourseDAO getInstance() {
		return dao;
	}
	
	/////////////////////////////////////////////////////////////////////////////
	// 리스트 조회
	public List<CourseVO> getList() {
		List<CourseVO> courseList = new ArrayList<>();
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		String sql = "SELECT id, c.name, credit, l.name AS lecturer, week, start_hour, end_hour FROM course_tbl c, lecturer_tbl l WHERE c.lecturer = l.idx ORDER BY id";
		
		try {
			conn = DBManager.getConnection();
			stmt = conn.createStatement();
			
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				CourseVO cVo = new CourseVO();
				
				cVo.setId(rs.getString("id"));
				cVo.setName(rs.getString("name"));
				cVo.setCredit(rs.getInt("credit"));
				cVo.setLecturer(rs.getString("lecturer"));
				cVo.setWeek(rs.getInt("week"));
				cVo.setStart_hour(rs.getInt("start_hour"));
				cVo.setEnd_hour(rs.getInt("end_hour"));
				
				courseList.add(cVo);
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, stmt, rs);
		}
		
		return courseList;
	}
	
	//////////////////////////////////////////////////////////////////////////
	// 리스트 추가
	public void insertCourse(CourseVO cVo) {
		Connection conn = null;
		PreparedStatement psmt = null;
		
		String sql = "INSERT INTO course_tbl VALUES(?, ?, ?, ?, ?, ?, ?)";
		
		try {
			conn = DBManager.getConnection();
			psmt = conn.prepareStatement(sql);
			
			psmt.setString(1, cVo.getId());
			psmt.setString(2, cVo.getName());
			psmt.setInt(3, cVo.getCredit());
			psmt.setInt(4, Integer.parseInt(cVo.getLecturer()));
			psmt.setInt(5, cVo.getIweek());
			psmt.setInt(6, cVo.getStart_hour());
			psmt.setInt(7, cVo.getEnd_hour());
			
			psmt.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, psmt);
		}
	}
	
	/////////////////////////////////////////////////////////////////////////////
	// 강의 상세보기를 위한 메서드
	public CourseVO getInfo(String id) {
		CourseVO cVo = new CourseVO();
		
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		
		String sql = "SELECT id, c.name, credit, l.name AS lecturer, week, start_hour, end_hour FROM course_tbl c, lecturer_tbl l WHERE c.lecturer = l.idx AND id=?";
		
		try {
			conn = DBManager.getConnection();
			psmt = conn.prepareStatement(sql);
			
			psmt.setString(1, id);
			
			rs = psmt.executeQuery();
			
			if(rs.next()) {
				cVo.setId(id);
				cVo.setName(rs.getString("name"));
				cVo.setCredit(rs.getInt("credit"));
				cVo.setLecturer(rs.getString("lecturer"));
				cVo.setWeek(rs.getInt("week"));
				cVo.setIweek(rs.getInt("week"));
				cVo.setStart_hour(rs.getInt("start_hour"));
				cVo.setEnd_hour(rs.getInt("end_hour"));
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, psmt, rs);
		}
		
		return cVo;
	}
	
	/////////////////////////////////////////////////////////////////
	// 강의 삭제를 위한 메서드
	public void deleteCourse(String id) {
		Connection conn = null;
		PreparedStatement psmt = null;
		
		String sql = "DELETE FROM course_tbl WHERE id=?";
		
		try {
			conn = DBManager.getConnection();
			psmt = conn.prepareStatement(sql);
			
			psmt.setString(1, id);
			
			psmt.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, psmt);
		}
	}
	
	//////////////////////////////////////////////////////////////////
	// 강의 수정을 위한 메서드
	public void updateCourse(CourseVO cVo, String originID) {
		Connection conn = null;
		PreparedStatement psmt = null;
		
		String sql = "UPDATE course_tbl SET id=?, name=?, credit=?, lecturer=?, week=?, start_hour=?, end_hour=? WHERE id=?";
		
		try {
			conn = DBManager.getConnection();
			psmt = conn.prepareStatement(sql);
			
			psmt.setString(1, cVo.getId());
			psmt.setString(2, cVo.getName());
			psmt.setInt(3, cVo.getCredit());
			psmt.setInt(4, Integer.parseInt(cVo.getLecturer()));
			psmt.setInt(5, cVo.getIweek());
			psmt.setInt(6, cVo.getStart_hour());
			psmt.setInt(7, cVo.getEnd_hour());
			psmt.setString(8, originID);
			
			psmt.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, psmt);
		}
	}
	
	
}
