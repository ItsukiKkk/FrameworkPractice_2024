/**
 * 
 */
package com.edu.seiryo.service;

import java.util.List;

import com.edu.seiryo.entity.User;

/**
 * @author       outianchang
 * @date         2024年5月4日
 * @project_name L4
 * @package_name com.edu.seiryo.service
 * @file_name    UserService.java
 * @classname    
 * @version      
 */
public interface UserService {
	public boolean saveRegister(User user);
	public boolean loginQuery(String userName,String userPwd);
	public List queryAll();
	public User queryById(int id) ;
	public boolean updateById(User user);
	public boolean deleteById(int id);
	public boolean deleteAll();
}
