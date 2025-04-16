/**
 * 
 */
package com.seiryo.annotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextException;
import org.springframework.context.annotation.ClassPathBeanDefinitionScanner;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

/**
 * @author       outianchang
 * @date         2024Äê5ÔÂ4ÈÕ
 * @project_name Game
 * @package_name com.edu.seiryo.dao
 * @file_name    GoodsDao.java
 * @classname    
 * @version      
 */
@Service("UserServiceImp")
public class UserServiceImp implements UserService{
	UserDao userDao;
	
	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	/* (non-Javadoc)
	 * @see com.seiryo.ioc.UserService#print()
	 */
	@Override
	public void print() {
		userDao.print();
	}
}
