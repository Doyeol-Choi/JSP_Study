package com.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.db.DBManager;
import com.vo.CandidateVO;

public class CandidateDAO {

	private CandidateDAO() {}
	
	private static CandidateDAO cdao = new CandidateDAO();
	
	public static CandidateDAO getInstance() {
		return cdao;
	}
	
	// 투표하기 => 후보 목록을 가져오기 위한 메서드
	public List<CandidateVO> getCandidateName() {
		List<CandidateVO> list = new ArrayList<>();
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		// 투표하기 페이지에서 후보 번호와 이름만을 사용하기 때문에 두 컬럼만 조회하는 쿼리문을 후보번호 오름차순으로 출력
		String sql = "SELECT m_no, m_name FROM tbl_member_202005 ORDER BY m_no";
		
		try {
			conn = DBManager.getConnection();
			stmt = conn.createStatement();
			
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				CandidateVO cVo = new CandidateVO();

				cVo.setNo(rs.getString("m_no"));
				cVo.setName(rs.getString("m_name"));
				
				list.add(cVo);
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, stmt, rs);
		}
		
		return list;
	}
	
	// 후보자 등수 조회를 하기위한 메서드
	public List<CandidateVO> getVoteResult() {
		List<CandidateVO> list = new ArrayList<>();
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		// 조인과 그룹함수를 통해 vote테이블과 member테이블의 정보를 같이 조회하고 vote테이블의 후보번호를 count한 후 count값을 내림차순으로 정렬하여 출력
		String sql = "SELECT v.m_no, m_name, count(v.m_no) result " + 
					" FROM tbl_vote_202005 v, tbl_member_202005 m " + 
					" WHERE v.m_no = m.m_no AND v_confirm = 'Y' GROUP BY v.m_no, m_name " + 
					" ORDER BY result DESC";
		
		try {
			conn = DBManager.getConnection();
			stmt = conn.createStatement();
			
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				CandidateVO cVo = new CandidateVO();
				// 위에서 조회했던 후보자 등수 페이지에 필요한 후보번호, 후보이름, 투표결과값을 VO객체에 담아 list에 추가
				cVo.setNo(rs.getString("m_no"));
				cVo.setName(rs.getString("m_name"));
				cVo.setCount(rs.getInt("result"));
				
				list.add(cVo);
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, stmt, rs);
		}
		
		return list;
	}
	
	// 후보조회를 위해 후보리스트를 출력하는 메서드
	public List<CandidateVO> selectAllCandidate() {
		List<CandidateVO> list = new ArrayList<>();
		// 조인을 사용해 후보조회에 필요한 데이터들을 출력하는 쿼리문
		String sql = "SELECT * FROM TBL_MEMBER_202005 M JOIN TBL_PARTY_202005 P ON M.P_CODE = P.P_CODE"; 
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBManager.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			while (rs.next()) {
				CandidateVO cVo = new CandidateVO();

				cVo.setNo(rs.getString("M_No"));
				cVo.setName(rs.getString("M_Name"));
				cVo.setPartyname(rs.getString("p_name"));
				cVo.setSchool(rs.getString("P_school"));
				cVo.setJumin(rs.getString("M_jumin"));
				cVo.setCity(rs.getString("M_city"));
				cVo.setTel1(rs.getString("P_tel1"));
				cVo.setTel2(rs.getString("P_tel2"));
				cVo.setTel3(rs.getString("P_tel3"));
				
				list.add(cVo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, stmt, rs);
		}
		return list;
	
	}
}
