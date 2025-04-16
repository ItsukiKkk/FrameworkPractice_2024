/**
 * 
 */
package com.seiryo.ioc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.EnableLoadTimeWeaving;
import org.springframework.context.support.ClassPathXmlApplicationContext;

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
	private UserService userService;
	public void print(){
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("com/seiryo/ioc/iocdemo.xml");
		userService =  (UserServiceImp) applicationContext.getBean("userServiceImp");
		userService.print();
	}
	public static void main(String[] args) {
		Test test = new Test();
		test.print();
	}
}
