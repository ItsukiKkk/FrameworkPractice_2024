/**
 * 
 */
package com.seiryo.dao.imp;

import java.sql.ResultSet;

import com.seiryo.dao.UserDao;
import com.seiryo.util.DBUtil;

/**
 * @author       outianchang
 * @date         2024Äê5ÔÂ4ÈÕ
 * @project_name Game
 * @package_name com.edu.seiryo.dao
 * @file_name    GoodsDao.java
 * @classname    
 * @version      
 */
public class UserDaoImp implements UserDao{
	ResultSet rs = null;
	/* (non-Javadoc)
	 * @see com.seiryo.dao.UserDao#login(java.lang.String, java.lang.String)
	 */
	public boolean login(String username, String password) {
		boolean bo = false;
		String sql = "select ID from tb_userInfo where userName = ? and usePassword = ?";
		try {
			rs = DBUtil.executeQuery(sql, username,password);
			bo = rs.next();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return bo;
	}

}
