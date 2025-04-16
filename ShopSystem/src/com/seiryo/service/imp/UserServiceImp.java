/**
 * 
 */
package com.seiryo.service.imp;

import com.seiryo.dao.UserDao;
import com.seiryo.dao.imp.UserDaoImp;
import com.seiryo.service.UserService;

/**
 * @author       outianchang
 * @date         2024Äê5ÔÂ4ÈÕ
 * @project_name Game
 * @package_name com.edu.seiryo.dao
 * @file_name    GoodsDao.java
 * @classname    
 * @version      
 */
public class UserServiceImp implements UserService{
	UserDao dao = new UserDaoImp();
	/* (non-Javadoc)
	 * @see com.seiryo.service.UserService#login(java.lang.String, java.lang.String)
	 */
	public boolean login(String username, String password) {
		// TODO Auto-generated method stub
		return dao.login(username, password);
	}

}
