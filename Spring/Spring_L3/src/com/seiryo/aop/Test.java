/**
 * 
 */
package com.seiryo.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.seiryo.aop.UserService;

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
	public void demo1(){
		String xmlPath = "com/seiryo/aop/aspectdemo1.xml";
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(xmlPath);
		UserService userService = (UserService)applicationContext.getBean("proxyServiceId");
		userService.addUser();
		userService.updateUser();
	}
	public static void main(String[] args) {
		Test test = new Test();
		test.demo1();
	}
}
