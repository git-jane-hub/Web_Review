package kr.co.abc.board.model;

import java.sql.*;

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
	}
}
