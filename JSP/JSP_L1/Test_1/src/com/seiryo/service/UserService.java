/**
 * 
 */
package com.seiryo.service;

import java.util.List;

import com.seiryo.entity.Users;

/**
 * @author       outianchang
 * @date         2024年6月25日
 * @project_name test
 * @package_name com.edu.seiryo.service
 * @file_name    UserService.java
 * @classname    UserService
 * @version      
 */
public interface UserService {
	public boolean queryUsername(String username);
	public boolean regist(String username, String password,String email);
	public boolean login(String username, String password);
	public List<Users> queryAllUserInfo();
	public List<Users> queryUserInfoByUsername(String username);
	List<Users> queryUserByPage(int startIndex, int pageSize);
	public int getTotalUserCount();
}
