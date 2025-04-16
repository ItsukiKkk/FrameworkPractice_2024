/**
 * 
 */
package com.seiryo.service.imp;

import java.util.List;

import com.seiryo.dao.UserDao;
import com.seiryo.dao.imp.UserDaoImp;
import com.seiryo.entity.Users;
import com.seiryo.service.UserService;

/**
 * @author       outianchang
 * @date         2024年6月25日
 * @project_name Game
 * @package_name com.edu.seiryo.service.imp
 * @file_name    UserServiceImp.java
 * @classname    UserServiceImp
 * @version      
 */
public class UserServiceImp implements UserService{
	private UserDao dao = new UserDaoImp();
	/* (non-Javadoc)
	 * @see com.seiryo.service.UserService#queryUsername(java.lang.String)
	 */
	public boolean queryUsername(String username) {
		return dao.queryUsername(username);
	}

	/* (non-Javadoc)
	 * @see com.seiryo.service.UserService#regist(java.lang.String, java.lang.String, java.lang.String)
	 */
	public boolean regist(String username, String password, String email) {
		return dao.regist(username, password, email);
	}

	/* (non-Javadoc)
	 * @see com.seiryo.service.UserService#login(java.lang.String, java.lang.String)
	 */
	public boolean login(String username, String password) {
		return dao.login(username, password);
	}

	/* (non-Javadoc)
	 * @see com.seiryo.service.UserService#queryAllUserInfo()
	 */
	public List<Users> queryAllUserInfo() {
		return dao.queryAllUserInfo();
	}

	/* (non-Javadoc)
	 * @see com.seiryo.service.UserService#queryUserInfoByUsername(java.lang.String)
	 */
	public List<Users> queryUserInfoByUsername(String username) {
		return dao.queryUserInfoByUsername(username);
	}

	/* (non-Javadoc)
	 * @see com.seiryo.service.UserService#queryUserByPage(int, int)
	 */
	public List<Users> queryUserByPage(int startIndex, int pageSize) {
		return dao.queryUserByPage(startIndex, pageSize);
	}

	/* (non-Javadoc)
	 * @see com.seiryo.service.UserService#getTotalUserCount()
	 */
	public int getTotalUserCount() {
		return dao.getTotalUserCount();
	}
	
}
