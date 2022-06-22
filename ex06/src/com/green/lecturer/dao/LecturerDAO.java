package com.green.lecturer.dao;

import java.sql.Connection;
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
		
		String sql = "SELECT idx, name FROM lecturer_tbl ORDER BY idx";
		
		try {
			conn = DBManager.getConnection();
			stmt = conn.createStatement();
			
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				LecturerVO lVo = new LecturerVO();
				lVo.setName(rs.getString("name"));
				lVo.setIdx(rs.getInt("idx"));
				
				lecturerList.add(lVo);
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, stmt, rs);
		}
		
		return lecturerList;
	}
}
