package com.green.board.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.green.board.db.DBManager;
import com.green.board.vo.BoardVO;

public class BoardDAO {
	private BoardDAO() {}
	
	private static BoardDAO dao = new BoardDAO();
	
	public static BoardDAO getInstance() {
		return dao;
	} 
	
	////////////////////////////////////////////////////////////////////////
	// 게시판 조회를 위한 메서드
	public List<BoardVO> selectAllBoards() {
		String sql = "SELECT * FROM boardTbl ORDER BY num DESC";
		
		List<BoardVO> list = new ArrayList<>();
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBManager.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				BoardVO bVo = new BoardVO();
				
				bVo.setNum(rs.getInt("num"));
				bVo.setName(rs.getString("name"));
				bVo.setEmail(rs.getString("email"));
				bVo.setPass(rs.getString("pass"));
				bVo.setTitle(rs.getString("title"));
				bVo.setContent(rs.getString("content"));
				bVo.setReadCount(rs.getInt("readCount"));
				bVo.setWriteDate(rs.getTimestamp("writeDate"));
				
				list.add(bVo);
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, stmt, rs);
		}
		
		return list;
	}

	////////////////////////////////////////////////////////////////////////
	// 게시판 글 등록을 위한 메서드
	public void insertBoard(BoardVO bVo) {
		String sql = "INSERT INTO boardTbl(num, name, email, pass, title, content) VALUES(board_seq.nextval, ?, ?, ?, ?, ?)";
		
		Connection conn = null;
		PreparedStatement psmt = null;
		
		try {
			conn = DBManager.getConnection();
			psmt = conn.prepareStatement(sql);
			
			psmt.setString(1, bVo.getName());
			psmt.setString(2, bVo.getEmail());
			psmt.setString(3, bVo.getPass());
			psmt.setString(4, bVo.getTitle());
			psmt.setString(5, bVo.getContent());
			
			psmt.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, psmt);
		}
	}
	
	////////////////////////////////////////////////////////////////////////
	// 조회수를 증가시키기 위한 메서드
	public void updateReadCount(int num) {
		String sql = "UPDATE boardTbl SET readCount = readCount+1 WHERE num=?";
		
		Connection conn = null;
		PreparedStatement psmt = null;
		
		try {
			conn = DBManager.getConnection();
			psmt = conn.prepareStatement(sql);
			
			psmt.setInt(1, num);
			
			psmt.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, psmt);
		}
	}
	
	////////////////////////////////////////////////////////////////////////
	// 게시판 상세보기를 위한 메서드
	public BoardVO selectBoardByNum(int num) {
		BoardVO bVo = null;
		
		String sql = "SELECT * FROM boardTbl WHERE num=?";
		
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBManager.getConnection();
			psmt = conn.prepareStatement(sql);
			
			psmt.setInt(1, num);
			
			rs = psmt.executeQuery();
			
			if(rs.next()) {
				bVo = new BoardVO();
				
				bVo.setNum(rs.getInt("num"));
				bVo.setName(rs.getString("name"));
				bVo.setEmail(rs.getString("email"));
				bVo.setPass(rs.getString("pass"));
				bVo.setTitle(rs.getString("title"));
				bVo.setContent(rs.getString("content"));
				bVo.setReadCount(rs.getInt("readCount"));
				bVo.setWriteDate(rs.getTimestamp("writeDate"));
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, psmt, rs);
		}
		
		return bVo;
	}
	
	//////////////////////////////////////////////////////////////////////////
	// 비밀번호 확인을 위한 메서드
	public boolean checkPassword(int num, String pass) {
		BoardVO bVo = selectBoardByNum(num);
//		위에서 게시판 상세보기 메서드를 통해 원하는 레코드를 가져올 수 있다.
		if(bVo.getPass().equals(pass)) {
			return true;
		} else {
			return false;
		}
	}
	
	///////////////////////////////////////////////////////////////////////////
	// 게시물을 삭제를 위한 메서드
	public void deleteBoard(int num) {
		String sql = "DELETE FROM boardTbl WHERE num=?";
		
		Connection conn = null;
		PreparedStatement psmt = null;
		
		try {
			conn = DBManager.getConnection();
			psmt = conn.prepareStatement(sql);
			
			psmt.setInt(1, num);
			
			psmt.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, psmt);
		}
	}
	
	/////////////////////////////////////////////////////////////////////////////
	// 게시물을 수정하기 위한 메서드
	public void updateBoard(BoardVO bVo) {
		String sql = "UPDATE boardTbl SET name=?, email=?, pass=?, title=?, content=?, writeDate=sysdate WHERE num=?";
		
		Connection conn = null;
		PreparedStatement psmt = null;
		
		try {
			conn = DBManager.getConnection();
			psmt = conn.prepareStatement(sql);
			
			psmt.setString(1, bVo.getName());
			psmt.setString(2, bVo.getEmail());
			psmt.setString(3, bVo.getPass());
			psmt.setString(4, bVo.getTitle());
			psmt.setString(5, bVo.getContent());
			psmt.setInt(6, bVo.getNum());
			
			psmt.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, psmt);
		}
	}

}
