/**
 * 
 */
package com.seiryo.dao.imp;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * @author       outianchang
 * @date         2024Äê5ÔÂ4ÈÕ
 * @project_name Game
 * @package_name com.edu.seiryo.dao
 * @file_name    GoodsDao.java
 * @classname    
 * @version      
 */
public class TestDatabaseConnection {
	public static void main(String[] args) {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection conn = DriverManager.getConnection(
                "jdbc:sqlserver://localhost:1433;DatabaseName=Hibernate;encrypt=false", "sa", "111");
            System.out.println("success");
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
