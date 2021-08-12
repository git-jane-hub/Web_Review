package kr.co.abc.user.model;

import java.sql.*;

import javax.naming.*;
import javax.sql.DataSource;

public class R02UserDAO {
	private DataSource ds;
	
	private R02UserDAO() {
		try {
			Context ct = new InitialContext();
			ds = (DataSource)ct.lookup("java:comp/env/jdbc/mysql");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	private static R02UserDAO dao = new R02UserDAO();
	
	public static R02UserDAO getInstance() {
		if(dao == null) {
			dao = new R02UserDAO();
		}
		return dao;
	}
	
	public int userJoin(R01UserVO user) {
		Connection con = null;
		PreparedStatement pstmt = null;
		int result;
		try {
			con = ds.getConnection();
			String sql = "INSERT INTO users2 VALUES (?, ?, ?, ?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, user.getuId()); 
			pstmt.setString(2, user.getuPw()); 
			pstmt.setString(3, user.getuName()); 
			pstmt.setString(4, user.getuEmail());
			pstmt.executeUpdate();
			result = 1;
		}catch(Exception e) {
			e.printStackTrace();
			result = 0;
		}finally {
			try {
				if(con != null && !con.isClosed()) {
					con.close();
				}
				if(pstmt != null && !pstmt.isClosed()) {
					pstmt.close();
				}
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	
	public int userLogin(String uId) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int result;
		try {
			con = ds.getConnection();
			String sql = "SELECT * FROM users2 WHERE uId = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, uId);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				result = 1;
			}else {
				result = 0;
			}
		}catch(Exception e) {
			e.printStackTrace();
			result = 0;
		}finally {
			try {
				if(con != null && !con.isClosed()) {
					con.close();
				}
				if(pstmt != null && !pstmt.isClosed()) {
					pstmt.close();
				}
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}
}
