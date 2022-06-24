package com.green.lecturer.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.green.course.db.DBManager;
import com.green.lecturer.vo.LecturerVO;

public class LecturerDAO {
	private LecturerDAO() {}
	
	private static LecturerDAO dao = new LecturerDAO();
	
	public static LecturerDAO getInstance() {
		return dao;
	}
	
	/////////////////////////////////////////////////////////////////////////////////
	// 강사 조회
	public List<LecturerVO> getLecturer() {
		List<LecturerVO> lecturerList = new ArrayList<>();
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		String sql = "SELECT * FROM lecturer_tbl ORDER BY idx";
		
		try {
			conn = DBManager.getConnection();
			stmt = conn.createStatement();
			
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				LecturerVO lVo = new LecturerVO();
				lVo.setIdx(rs.getInt("idx"));
				lVo.setName(rs.getString("name"));
				lVo.setMajor(rs.getString("major"));
				lVo.setField(rs.getString("field"));
				
				lecturerList.add(lVo);
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, stmt, rs);
		}
		
		return lecturerList;
	}
	
	////////////////////////////////////////////////////////////////////////////
	// 강사 등록에 사용할 강사번호 찾기 메서드
	public int findIdx() {
		int idx = 0;
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		String sql = "SELECT LAST_NUMBER FROM USER_SEQUENCES WHERE SEQUENCE_NAME = 'LECTURER_SEQ'";
		
		try {
			conn = DBManager.getConnection();
			stmt = conn.createStatement();
			
			rs = stmt.executeQuery(sql);
			
			if(rs.next()) {
				idx = rs.getInt("last_number");
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, stmt, rs);
		}
		return idx;
	}
	
	//////////////////////////////////////////////////////////////////////////////////
	// 강사 등록을 위한 메서드
	public void insertLecturer(LecturerVO lVo) {
		Connection conn = null;
		PreparedStatement psmt = null;
		
		String sql = "INSERT INTO lecturer_tbl VALUES(lecturer_seq.nextval, ?, ?, ?)";
		
		try {
			conn = DBManager.getConnection();
			psmt = conn.prepareStatement(sql);
			
			psmt.setString(1, lVo.getName());
			psmt.setString(2, lVo.getMajor());
			psmt.setString(3, lVo.getField());
			
			psmt.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, psmt);
		}
	}
	
	////////////////////////////////////////////////////////////////////////////////////////
	// 강사 상세보기를 위한 메서드
	public LecturerVO getLecturerInfo(int idx) {
		LecturerVO lVo = new LecturerVO();
		List<String> course = new ArrayList<>();
		
		String sql = "SELECT idx, l.name, major, field, c.name AS course FROM lecturer_tbl l, course_tbl c WHERE l.idx = c.lecturer(+) AND idx=?";
		
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBManager.getConnection();
			psmt = conn.prepareStatement(sql);
			
			psmt.setInt(1, idx);
			
			rs = psmt.executeQuery();
			
			while(rs.next()) {
				lVo.setIdx(idx);
				lVo.setName(rs.getString("name"));
				lVo.setMajor(rs.getString("major"));
				lVo.setField(rs.getString("field"));
				
				course.add(rs.getString("course"));
			}
			lVo.setCourse(course);
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, psmt, rs);
		}
		
		return lVo;
	}

	////////////////////////////////////////////////////////////////////////////////
	// 강사 수정을 위한 메서드
	public void updateLecturer(LecturerVO lVo) {
		Connection conn = null;
		PreparedStatement psmt = null;
		
		String sql = "UPDATE lecturer_tbl SET name=?, major=?, field=? WHERE idx=?";
		
		try {
			conn = DBManager.getConnection();
			psmt = conn.prepareStatement(sql);
			
			psmt.setString(1, lVo.getName());
			psmt.setString(2, lVo.getMajor());
			psmt.setString(3, lVo.getField());
			psmt.setInt(4, lVo.getIdx());
			
			psmt.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, psmt);
		}
	}
	
	
}
