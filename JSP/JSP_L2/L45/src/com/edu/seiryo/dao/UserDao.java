/**
 * 
 */
package com.edu.seiryo.dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.edu.seiryo.entity.User;
import com.edu.seiryo.util.DBUtil;

/**
 * @author       outianchang
 * @date         2024年5月4日
 * @project_name L4
 * @package_name com.edu.seiryo.dao
 * @file_name    UserDao.java
 * @classname    UserDao
 * @version      
 */
public interface UserDao {
	public boolean saveRegister(User user);
	public boolean loginQuery(String userName,String userPwd);
	public List queryAll();
	public User queryById(int id) ;
	public boolean updateById(User user);
	public boolean deleteById(int id);
	public boolean deleteAll();
}
