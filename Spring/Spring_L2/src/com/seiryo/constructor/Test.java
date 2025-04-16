/**
 * 
 */
package com.seiryo.constructor;

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
	User user;
	User user1;
	public void constructor(){
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("com/seiryo/constructor/constructordemo.xml");
		user = (User) applicationContext.getBean("user");
		user1 = (User) applicationContext.getBean("user1");
		System.out.println(user);
		System.out.println(user1);
	}
	public static void main(String[] args) {
		Test test = new Test();
		test.constructor();
	}
}
