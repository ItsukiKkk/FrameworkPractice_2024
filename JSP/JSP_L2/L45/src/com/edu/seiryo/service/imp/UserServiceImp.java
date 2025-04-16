/**
 * 
 */
package com.edu.seiryo.service.imp;

import java.util.List;

import com.edu.seiryo.dao.UserDao;
import com.edu.seiryo.dao.imp.UserDaoImp;
import com.edu.seiryo.entity.User;
import com.edu.seiryo.service.UserService;

/**
 * @author       outianchang
 * @date         2024年5月4日
 * @project_name L4
 * @package_name com.edu.seiryo.service.imp
 * @file_name    UserServiceImp.java
 * @classname    
 * @version      
 */
public class UserServiceImp implements UserService{
	UserDao dao = new UserDaoImp();
	/* (non-Javadoc)
	 * @see com.edu.seiryo.service.UserService#saveRegister(com.edu.seiryo.entity.User)
	 */
	public boolean saveRegister(User user) {
		return dao.saveRegister(user);
	}

	/* (non-Javadoc)
	 * @see com.edu.seiryo.service.UserService#loginQuery(java.lang.String, java.lang.String)
	 */
	public boolean loginQuery(String userName, String userPwd) {
		return dao.loginQuery(userName, userPwd);
	}

	/* (non-Javadoc)
	 * @see com.edu.seiryo.service.UserService#queryAll()
	 */
	public List queryAll() {
		return dao.queryAll();
	}

	/* (non-Javadoc)
	 * @see com.edu.seiryo.service.UserService#queryById(int)
	 */
	public User queryById(int id) {
		return dao.queryById(id);
	}

	/* (non-Javadoc)
	 * @see com.edu.seiryo.service.UserService#updateById(com.edu.seiryo.entity.User)
	 */
	public boolean updateById(User user) {
		return dao.updateById(user);
	}

	/* (non-Javadoc)
	 * @see com.edu.seiryo.service.UserService#deleteById(int)
	 */
	public boolean deleteById(int id) {
		return dao.deleteById(id);
	}

	/* (non-Javadoc)
	 * @see com.edu.seiryo.service.UserService#deleteAll()
	 */
	public boolean deleteAll() {
		return dao.deleteAll();
	}

}
