/**
 * 
 */
package com.edu.seiryo.dao.imp;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.edu.seiryo.dao.UserDao;
import com.edu.seiryo.entity.User;
import com.edu.seiryo.util.DBUtil;

/**
 * @author       outianchang
 * @date         2024骞�5鏈�4鏃�
 * @project_name L4
 * @package_name com.edu.seiryo.dao
 * @file_name    UserDaoImp.java
 * @classname    
 * @version      
 */
public class UserDaoImp implements UserDao{
	private ResultSet rs = null;
	/*
	 * 娉ㄥ唽鍌ㄥ瓨鐢ㄦ埛淇℃伅
	 */
	public boolean saveRegister(User user){
		String sql = "insert into t_user(account,password) values(?,?)";
		boolean bo = false;
		try {
			bo = DBUtil.executeUpdate(sql, user.getAccount(),user.getPassword());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return bo;
	}
	/*
	 * 鐧诲綍鐢ㄦ埛淇℃伅
	 */
	public boolean loginQuery(String userName,String userPwd){
		boolean bo = false;
		String sql = "select account from t_user where account = ? and password = ?";
		try {
			rs = DBUtil.executeQuery(sql, userName, userPwd);
			bo = rs.next();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				DBUtil.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return bo;
	}
	public List queryAll() {
		List<User> list = new ArrayList<User>();
		String sql = "select id,account,password from t_user";
		User user = null;
		try {
			rs = DBUtil.executeQuery(sql);
			while(rs.next()){
				user = new User();
				user.setId(rs.getInt(1));
				user.setAccount(rs.getString(2));
				user.setPassword(rs.getString(3));
				list.add(user);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				DBUtil.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return list;
	}
	public User queryById(int id) {
		String sql = "select * from t_user where id = ?";
		User user = null;
		try {
			rs = DBUtil.executeQuery(sql,id);
			while(rs.next()){
				user = new User();
				user.setId(rs.getInt(1));
				user.setAccount(rs.getString(2));
				user.setPassword(rs.getString(3));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				DBUtil.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return user;
	}
	public boolean updateById(User user) {
		String sql = "update t_user set account = ?,password = ? where id = ? ";
		boolean bo = false;
		try {
			bo = DBUtil.executeUpdate(sql, user.getAccount(),user.getPassword(),user.getId());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return bo;
	}
	public boolean deleteById(int id) {
		String sql = "delete from t_user where id = ?";
		boolean bo = false;
		try {
			bo = DBUtil.executeUpdate(sql, id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return bo;
	}
	public boolean deleteAll() {
		String sql = "delete from t_user ";
		boolean bo = false;
		try {
			bo = DBUtil.executeUpdate(sql);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return bo;
	}
	public static void main(String[] args) {
		UserDaoImp daoImp = new UserDaoImp();
		User user = daoImp.queryById(7);
		System.out.println(user);
	}
}
