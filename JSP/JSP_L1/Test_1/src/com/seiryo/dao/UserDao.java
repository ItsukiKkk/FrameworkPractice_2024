/**
 * 
 */
package com.seiryo.dao;

import java.util.List;

import com.seiryo.entity.Users;

/**
 * @author       outianchang
 * @date         2024年5月4日
 * @project_name test
 * @package_name com.edu.seiryo.dao
 * @file_name    UserDao.java
 * @classname    UserDao
 * @version      
 */
public interface UserDao {
	public boolean queryUsername(String username);
	public boolean regist(String username, String password,String email);
	public boolean login(String username, String password);
	public List<Users> queryAllUserInfo();
	public List<Users> queryUserInfoByUsername(String username);
	List<Users> queryUserByPage(int startIndex, int pageSize);
	public int getTotalUserCount();
}
