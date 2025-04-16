/**
 * 
 */
package com.seiryo.jdk;

import org.springframework.context.ApplicationContext;
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
	public void demo0(){
		UserService userService = MyBeanFactory.createService();
		userService.addUser();
		userService.updateUser();
		userService.deleteUser();
		userService.deleteUser();
	}
	public static void main(String[] args) {
		Test test = new Test();
		test.demo0();
	}
}
