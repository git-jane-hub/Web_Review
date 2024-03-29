package kr.co.abc.board.model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import javax.naming.*;
import javax.sql.*;

public class R02BoardDAO {
	private DataSource ds;
	
	private R02BoardDAO() {
		try {
			Context ct = new InitialContext();
			ds = (DataSource)ct.lookup("java:comp/env/jdbc/mysql");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	private static R02BoardDAO dao = new R02BoardDAO();
	
	public static R02BoardDAO getInstance() {
		// dao 가 비어있으면 객체를 먼저 생성
		if(dao == null) {
			dao = new R02BoardDAO();
		}
		return dao;
	}
	
	// 글 작성
	public int write(R01BoardVO board) {
		Connection con = null;
		PreparedStatement pstmt = null;
		int result;
		try {
			con = ds.getConnection();
			String sql = "INSERT INTO rboard (bname, btitle, bcontent, bdate, bhit) VALUES (?, ?, ?, now(), 0)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, board.getbName());
			pstmt.setString(2, board.getbTitle());
			pstmt.setString(3, board.getbContent());
			pstmt.executeUpdate();
			result = 1;
		}catch(Exception e){
			System.out.println("에러: " + e);
			result = 0;
		}finally {
			try {
				if(con != null && !con.isClosed()) {
					con.close();
				}
				if(pstmt != null && !pstmt.isClosed()) {
					pstmt.close();
				}
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return result;
	}// end write()
	
	public List<R01BoardVO> boardSelect() {
		List<R01BoardVO> boardList = new ArrayList<>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = ds.getConnection();
			String sql = "SELECT * FROM rboard";
			pstmt = con.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			while(rs.next()) {
				R01BoardVO board = new R01BoardVO();
				board.setbId(rs.getInt("bId"));
				board.setbName(rs.getString("bName"));
				board.setbTitle(rs.getString("bTitle"));
				board.setbContent(rs.getString("bContent"));
				board.setbDate(rs.getTimestamp("bDate"));
				board.setbHit(rs.getInt("bHit"));
				boardList.add(board);
			}
		}catch(Exception e){
			System.out.println("에러: " + e);
		}finally {
			try {
				if(con != null && !con.isClosed()) {
					con.close();
				}
				if(pstmt != null && !pstmt.isClosed()) {
					pstmt.close();
				}
				if(rs != null && !rs.isClosed()) {
					rs.close();
				}
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return boardList;
	}// end boardSelect()
	
	public R01BoardVO boardDetail(String bId) {
		R01BoardVO board = new R01BoardVO();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = ds.getConnection();
			String sql = "SELECT * FROM rboard WHERE bId = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, bId);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				board.setbId(rs.getInt("bId"));
				board.setbName(rs.getString("bName"));
				board.setbTitle(rs.getString("bTitle"));
				board.setbContent(rs.getString("bContent"));
				board.setbDate(rs.getTimestamp("bDate"));
				board.setbHit(rs.getInt("bHit"));
			}
		}catch(Exception e){
			System.out.println("에러: " + e);
		}finally {
			try {
				if(con != null && !con.isClosed()) {
					con.close();
				}
				if(pstmt != null && !pstmt.isClosed()) {
					pstmt.close();
				}
				if(rs != null && !rs.isClosed()) {
					rs.close();
				}
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return board;
	}// end boardDetail
	
	public List<R01BoardVO> getPageList(int currentPage){
		  List<R01BoardVO> boardList = new ArrayList<R01BoardVO>();
		  Connection con = null;
		  PreparedStatement pstmt = null;
		  ResultSet rs = null;
		  try {
			  R01BoardVO board = new R01BoardVO();
			  con = ds.getConnection();
			  String sql = "SELECT * FROM rboard ORDER BY bId LIMIT ?, 10";
			  pstmt = con.prepareStatement(sql);
			  pstmt.setInt(1, (currentPage - 1) * 10);
			  pstmt.executeQuery();
			  while(rs.next()) {
				  board.setbId(rs.getInt("bId"));
				  board.setbName(rs.getString("bName"));
				  board.setbTitle(rs.getString("bTitle"));
				  board.setbContent(rs.getString("bContent"));
				  board.setbDate(rs.getTimestamp("bDate"));
				  board.setbHit(rs.getInt("bHit"));
				  boardList.add(board);
			  }
		  }catch(Exception e) {
			  e.printStackTrace();
		  }finally {
			  try {
				  if(con != null && !con.isClosed()) {
					  con.close();
				  }
				  if(pstmt != null && !pstmt.isClosed()) {
					  pstmt.close();
				  }
				  if(rs != null && !rs.isClosed()) {
					  rs.close();
				  }
			  }catch(Exception e) {
				  e.printStackTrace();
			  }
		  }
		  return boardList;
	}
}
