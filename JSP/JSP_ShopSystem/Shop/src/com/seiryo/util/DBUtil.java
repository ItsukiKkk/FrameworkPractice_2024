package com.seiryo.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBUtil {
	private static final String DRIVER="com.microsoft.sqlserver.jdbc.SQLServerDriver";
	private static final String URL="jdbc:sqlserver://localhost:1433;DatabaseName=test";
	private static final String UID = "sa";
	private static final String PWD = "111";
	private static Connection con = null;
	private static PreparedStatement ps = null;
	private static ResultSet rs = null;

	// 增/删/改
	// DriverManager
	// Connection
	// PreparedStatement
	public static boolean executeUpdate(String sql, Object... objects)
			throws Exception {
		boolean bo = false;
		ps = createPreparedStatement(sql, objects);
		bo = ps.executeUpdate() != 0 ? true : false;
		close();
		return bo;
	}

	// 查询
	// DriverManager
	// Connection
	// PreparedStatement
	// ResultSet
	/**
	 * 查询
	 * 注意：调用请关闭Connect PreparedStatement ResultSet对象*/
	public static ResultSet executeQuery(String sql, Object... objects)
			throws Exception {
		ps = createPreparedStatement(sql, objects);
		rs = ps.executeQuery();
		
		return rs;
	}
	//创建执行sql语句对象
	private static PreparedStatement createPreparedStatement(String sql,
			Object... objects) throws Exception {
		Class.forName(DRIVER);
		con = DriverManager.getConnection(URL, UID, PWD);
		ps = con.prepareStatement(sql);
		for (int i = 0; i < objects.length ; i++) {
			ps.setObject(i + 1, objects[i]);
		}
		return ps;
	}
	/**
	 * 关闭Connect PreparedStatement ResultSet，
	 * 专为调用executeQuery(String sql, Object... objects)方法之后使用*/
	public static void close()
			throws Exception {
		if (rs != null) {
			rs.close();
			rs = null;
		}
		if (ps != null) {
			ps.close();
			ps = null;
		}
		if (con != null) {
			con.close();
			con = null;
		}
	}

}
