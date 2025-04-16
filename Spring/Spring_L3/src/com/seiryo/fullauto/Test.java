/**
 * 
 */
package com.seiryo.fullauto;

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
	public static void main(String[] args) {
		String xmlPath = "com/seiryo/fullauto/aopdemo.xml";
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(xmlPath);
		UserService userService = (UserService)applicationContext.getBean("userSericeId");
		userService.addUser();
		userService.updateUser();
	}
}
