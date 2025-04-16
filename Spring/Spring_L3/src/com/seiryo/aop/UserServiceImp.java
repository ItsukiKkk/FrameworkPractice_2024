/**
 * 
 */
package com.seiryo.aop;

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
	UserService userService;
	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	/* (non-Javadoc)
	 * @see com.seiryo.service.UserService#addUser()
	 */
	@Override
	public void addUser() {
		System.out.println("add");
		
	}

	/* (non-Javadoc)
	 * @see com.seiryo.service.UserService#updateUser()
	 */
	@Override
	public void updateUser() {
		System.out.println("update");
		
	}

	/* (non-Javadoc)
	 * @see com.seiryo.service.UserService#deleteUser()
	 */
	@Override
	public void deleteUser() {
		System.out.println("delete");
		
	}

}
