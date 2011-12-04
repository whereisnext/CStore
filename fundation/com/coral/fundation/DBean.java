/**
 * 
 */
package com.coral.fundation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author coral.ma
 *
 */
public class DBean {

	private Connection conn;
	private String sqlite = "sqlite";
	private String mysql = "mysql";
	private String connectType = sqlite;
	
	public Connection getConnection() throws Exception {
		if(connectType.equals(sqlite)) {
			return getSQLiteConnection();
		} else if(connectType.equals(mysql)) {
			return getMySQLConnection();
		}
		return null;
	}
	
	public Connection getMySQLConnection() throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		// Setup the connection with the DB
		Connection conn = DriverManager
				.getConnection("jdbc:mysql://localhost/cstore?user=coral&password=coralpw");
		return conn;
	}
	
	public Connection getSQLiteConnection() throws Exception {
		Class.forName("org.sqlite.JDBC");
	    Connection conn =DriverManager.getConnection("jdbc:sqlite:cstore.db");
		return conn;		
	}
	
	public void close() {
		if(conn == null) {
			return;
		}
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void closeAll(ResultSet rs, Statement stmt, DBean dBean) {
		try {
			if(rs != null) {
				rs.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			if(stmt != null) {
				stmt.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if(dBean != null) {
			dBean.close();
		}
	}
}
