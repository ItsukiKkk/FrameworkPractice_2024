/**
 * 
 */
package com.seiryo.ioc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextException;
import org.springframework.context.annotation.ClassPathBeanDefinitionScanner;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author       outianchang
 * @date         2024��5��4��
 * @project_name Game
 * @package_name com.edu.seiryo.dao
 * @file_name    GoodsDao.java
 * @classname    
 * @version      
 */
public class UserServiceImp implements UserService{
	/* (non-Javadoc)
	 * @see com.seiryo.ioc.UserService#print()
	 */
	@Override
	public void print() {
		System.out.println("print");
	}
}
