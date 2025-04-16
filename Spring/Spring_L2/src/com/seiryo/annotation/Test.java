/**
 * 
 */
package com.seiryo.annotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.seiryo.data.Data;

/**
 * @author       outianchang
 * @date         2024Äê5ÔÂ4ÈÕ
 * @project_name Game
 * @package_name com.edu.seiryo.dao
 * @file_name    GoodsDao.java
 * @classname    
 * @version      
 */
public class Test {
	UserService userService;
	UserDao userDao;
	public void constructor(){
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("com/seiryo/annotation/ademo.xml");
		userService =  (UserService) applicationContext.getBean("UserServiceImp");
		
	}
	public static void main(String[] args) {
		Test test = new Test();
		test.constructor();
	}
}
