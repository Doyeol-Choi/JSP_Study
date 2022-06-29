package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.db.DBManager;
import com.vo.VoterVO;

public class VoterDAO {

	private VoterDAO() {}
	
	private static VoterDAO vdao = new VoterDAO();
	
	public static VoterDAO getInstance() {
		return vdao;
	}
	
	// 유권자의 투표 정보를 등록하기 위한 메서드
	public void voterInsert(VoterVO vVo) {
		Connection conn = null;
		PreparedStatement psmt = null;
		
		String sql = "INSERT INTO tbl_vote_202005 VALUES(?, ?, ?, ?, ?, ?)";
		
		try {
			conn = DBManager.getConnection();
			psmt = conn.prepareStatement(sql);
			
			psmt.setString(1, vVo.getJumin());
			psmt.setString(2, vVo.getName());
			psmt.setString(3, vVo.getNo());
			psmt.setString(4, vVo.getTime());
			psmt.setString(5, vVo.getArea());
			psmt.setString(6, vVo.getConfirm());
			
			psmt.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, psmt);
		}
	}
	
	// 투표 검수 조회를 위해 유권자 리스트를 출력하기 위한 메서드
	public List<VoterVO> checkAllVoter(){
		List<VoterVO> list = new ArrayList<>();
		// WHERE을 이용해서 제1투표장에서 투표한 유권자만을 출력하는 쿼리문
		String sql="SELECT V_NAME, V_JUMIN, M_NO, V_TIME, V_CONFIRM FROM TBL_VOTE_202005 WHERE V_AREA='제1투표장'";
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBManager.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			while (rs.next()) {
				VoterVO vVo = new VoterVO();
				
				vVo.setName(rs.getString("V_NAME"));
				vVo.setJumin(rs.getString("V_JUMIN"));
				vVo.setNo(rs.getString("M_NO"));
				vVo.setTime(rs.getString("V_TIME"));
				vVo.setConfirm(rs.getString("V_CONFIRM"));
				
				list.add(vVo);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, stmt, rs);
		}
		return list;
		
	}
}
