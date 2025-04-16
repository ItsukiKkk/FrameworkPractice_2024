/**
 * 
 */
package com.seiryo.dao.imp;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.seiryo.dao.UserDao;
import com.seiryo.entity.Users;
import com.seiryo.util.BaseDao;

/**
 * @author       outianchang
 * @date         2024年5月4日
 * @project_name Game
 * @package_name com.edu.seiryo.dao
 * @file_name    GoodsDao.java
 * @classname    
 * @version      
 */
public class UserDaoImp implements UserDao{
	BaseDao baseDao = new BaseDao();
	ResultSet rs = null;
	/* (non-Javadoc)
	 * @see com.seiryo.dao.UserDao#queryUsername(java.lang.String)
	 */
	public boolean queryUsername(String username) {
		boolean bo = false;
		String sql = "select userId from my_user where account = ?";
		try {
			rs = baseDao.executeQuery(sql, username);
			bo = rs.next();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return bo;
	}

	/* (non-Javadoc)
	 * @see com.seiryo.dao.UserDao#regist(java.lang.String, java.lang.String, java.lang.String)
	 */
	public boolean regist(String username, String password, String email) {
		boolean bo = false;
		String sql = "insert my_user(account,password,email) values(?,?,?) ";
		try {
			rs = baseDao.executeQuery(sql, username,password,email);
			bo = rs.next();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return bo;
	}

	/* (non-Javadoc)
	 * @see com.seiryo.dao.UserDao#login(java.lang.String, java.lang.String)
	 */
	public boolean login(String username, String password) {
		boolean bo = false;
		String sql = "select userId from my_user where account = ? and password = ?";
		try {
			rs = baseDao.executeQuery(sql, username,password);
			bo = rs.next();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return bo;
	}

	/* (non-Javadoc)
	 * @see com.seiryo.dao.UserDao#queryAllUserInfo()
	 */
	public List<Users> queryAllUserInfo() {
		List<Users> list = new ArrayList<Users>();
		Users user = null;
		String sql = "select userId,account,password,email from my_user";
		try {
			rs = baseDao.executeQuery(sql);
			while(rs.next()){
				user = new Users();
				user.setUserId(rs.getInt(1));
				user.setAccount(rs.getString(2));
				user.setPassword(rs.getString(3));
				user.setEmail(rs.getString(4));
				list.add(user);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	/* (non-Javadoc)
	 * @see com.seiryo.dao.UserDao#queryUserInfoByUsername()
	 */
	public List<Users> queryUserInfoByUsername(String username) {
		List<Users> list = new ArrayList<Users>();
		Users user = null;
		String sql = "select userId,account,password,email from my_user where account like '%"+username+"%'";
		try {
			rs = baseDao.executeQuery(sql);
			while(rs.next()){
				user = new Users();
				user.setUserId(rs.getInt(1));
				user.setAccount(rs.getString(2));
				user.setPassword(rs.getString(3));
				user.setEmail(rs.getString(4));
				list.add(user);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	/* (non-Javadoc)
	 * @see com.seiryo.dao.UserDao#queryUserByPage(int, int)
	 */
	public List<Users> queryUserByPage(int startIndex, int pageSize) {
		 List<Users> list = new ArrayList<Users>();
		 String sql = "SELECT * FROM my_user ORDER BY userId OFFSET ? ROWS FETCH NEXT ? ROWS ONLY";
		 Users user = null;
		 try {
				rs = baseDao.executeQuery(sql,startIndex,pageSize);
				while(rs.next()){
					user = new Users();
					user.setUserId(rs.getInt(1));
					user.setAccount(rs.getString(2));
					user.setPassword(rs.getString(3));
					user.setEmail(rs.getString(4));
					list.add(user);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		 return list;
	}

	/* (non-Javadoc)
	 * @see com.seiryo.dao.UserDao#getTotalUserCount()
	 */
	public int getTotalUserCount() {
		int count = 0;
		String sql = "SELECT COUNT(*) FROM my_user";
		try {
			rs = baseDao.executeQuery(sql);
			if (rs.next()) {
	            count = rs.getInt(1);
	        }
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return count;
	}
	
}
