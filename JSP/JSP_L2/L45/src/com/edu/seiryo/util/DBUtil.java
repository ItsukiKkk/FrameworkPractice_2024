package com.edu.seiryo.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBUtil {
	private static final String DRIVER="com.microsoft.sqlserver.jdbc.SQLServerDriver";
	private static final String URL="jdbc:sqlserver://localhost:1433;DatabaseName=Hibernate";
	private static final String UID = "sa";
	private static final String PWD = "111";
	private static Connection con = null;
	private static PreparedStatement ps = null;
	private static ResultSet rs = null;

	// ��/ɾ/��
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

	// ��ѯ
	// DriverManager
	// Connection
	// PreparedStatement
	// ResultSet
	/**
	 * ��ѯ
	 * ע�⣺������ر�Connect PreparedStatement ResultSet����*/
	public static ResultSet executeQuery(String sql, Object... objects)
			throws Exception {
		ps = createPreparedStatement(sql, objects);
		rs = ps.executeQuery();
		
		return rs;
	}
	//����ִ��sql������
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
	 * �ر�Connect PreparedStatement ResultSet��
	 * רΪ����executeQuery(String sql, Object... objects)����֮��ʹ��*/
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
