package com.green.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.green.vo.MemberVO;

public class MemberDAO {	// 데이터베이스 연동을 위한 클래스
	// 싱글톤 패턴 구성
	// 1. 생성자 차단
	private MemberDAO() {}
	
	// 2. 클래스 내부에 인스턴스 생성
	private static MemberDAO dao = new MemberDAO();
	
	// 3. 만들어진 인스턴스를 꺼내 쓰기 위한 메서드
	public static MemberDAO getInstance() {
		return dao;
	}
	
	//////////////////////////////////////////////////
	// 데이터 베이스 연결 객체를 생성하기 위한 메서드
	public Connection getConnection() throws Exception{
		Context initContext = new InitialContext();
		Context envContext  = (Context)initContext.lookup("java:/comp/env");
		DataSource ds = (DataSource)envContext.lookup("jdbc/myoracle");
		Connection conn = ds.getConnection();
		
		return conn;
	}
	
	///////////////////////////////////////////////////
	// 아이디 정보를 통해서 회원 정보를 찾아오는 메서드
	public int userCheck(String userid, String userpwd) {
		int result = -1;
		
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		
		String sql = "SELECT userpwd FROM member WHERE userid=?";
		try {
			conn = getConnection();
			psmt = conn.prepareStatement(sql);
			
			psmt.setString(1, userid);
			
			rs = psmt.executeQuery();
			
			if(rs.next()) {
				if(rs.getString("userpwd")!=null && rs.getString("userpwd").equals(userpwd)) {
					result = 1;	// 로그인 성공
				} else {
					result = 0;	// 비밀번호가 틀리거나 null인 경우
				}
			} else {
				result = -1;	// 아이디를 찾을 수 없는 경우
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
		
		return result;
	}
	
	////////////////////////////////////////////////////////////
	// 아이디를 가지고 회원 정보를 가져오는 메서드
	public MemberVO getMember(String userid) {
		MemberVO mVo = null;
		
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		
		String sql = "SELECT * FROM member WHERE userid=?";
		try {
			conn = getConnection();
			psmt = conn.prepareStatement(sql);
			
			psmt.setString(1, userid);
			
			rs = psmt.executeQuery();
			
			if(rs.next()) {
				mVo = new MemberVO();
				mVo.setName(rs.getString("name"));
				mVo.setUserid(rs.getString("userid"));
				mVo.setUserpwd(rs.getString("userpwd"));
				mVo.setEmail(rs.getString("email"));
				mVo.setPhone(rs.getString("phone"));
				mVo.setAdmin(rs.getInt("admin"));
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
		
		return mVo;
	}
	
	///////////////////////////////////////////////////////////////////
	// 회원 가입을 처리할 메서드
	public int insertMember(MemberVO mVo) {
		int result = -1;
		
		Connection conn = null;
		PreparedStatement psmt = null;
		
		String sql = "INSERT INTO member VALUES(?,?,?,?,?,?)";
		
		try {
			conn = getConnection();
			psmt = conn.prepareStatement(sql);
			
			psmt.setString(1, mVo.getName());
			psmt.setString(2, mVo.getUserid());
			psmt.setString(3, mVo.getUserpwd());
			psmt.setString(4, mVo.getEmail());
			psmt.setString(5, mVo.getPhone());
			psmt.setInt(6, mVo.getAdmin());
			
			result = psmt.executeUpdate();
			
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
		
		return result;
	}
	
	///////////////////////////////////////////////////////////////////////////
	// 아이디 중복 체크를 위한 메서드
	public int confirmID(String userid) {
		int result = -1;
		
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		
		String sql = "SELECT userid FROM member WHERE userid=?";
		
		
		try {
			conn = getConnection();
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, userid);
			
			rs = psmt.executeQuery();
			
			if(rs.next()) {	// 중복된 아이디 존재
				result = 1;
			} else {	// 중복된 아이디 없다 => 사용 가능한 아이디
				result = -1;
			}
			
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
		
		return result;
	}
	
	/////////////////////////////////////////////////////////////////////////////
	// 회원 정보를 수정하기 위한 메서드
	public int updateMember(MemberVO mVo) {
		int result = -1;
		
		Connection conn = null;
		PreparedStatement psmt = null;
		
		String sql = "UPDATE member SET userpwd=?, email=?, phone=?, admin=? WHERE userid=?";
		
		try {
			conn = getConnection();
			psmt = conn.prepareStatement(sql);
			
			psmt.setString(5, mVo.getUserid());
			psmt.setString(1, mVo.getUserpwd());
			psmt.setString(2, mVo.getEmail());
			psmt.setString(3, mVo.getPhone());
			psmt.setInt(4, mVo.getAdmin());
			
			result = psmt.executeUpdate();
			
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
		
		return result;
	}
}
