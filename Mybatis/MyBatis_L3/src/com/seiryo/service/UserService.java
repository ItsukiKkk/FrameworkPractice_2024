/**
 * 
 */
package com.seiryo.service;

import java.util.List;

import com.seiryo.entity.User;

/**
 * @author       outianchang
 * @date         2024Äê5ÔÂ4ÈÕ
 * @project_name Game
 * @package_name com.edu.seiryo.dao
 * @file_name    GoodsDao.java
 * @classname    
 * @version      
 */
public interface UserService {
	int insert(String name, String pwd,String gender,String email);
	List<User> selectTrim(User user);
	int update(User user);
	int delete(int[] ids);
	List<User> selectById(int[] ids);
}
