package com.seiryo.property;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.seiryo.property.User;

/**
 * @author       outianchang
 * @date         2024��5��4��
 * @project_name Game
 * @package_name com.edu.seiryo.dao
 * @file_name    GoodsDao.java
 * @classname    
 * @version      
 */
public class Test {
	User user;
	User user1;
	public void p(){
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("com/seiryo/property/pdemo.xml");
		user = (User) applicationContext.getBean("user");
		user1 = (User) applicationContext.getBean("user1");
		System.out.println(user);
		System.out.println(user1);
	}
	public static void main(String[] args) {
		Test test = new Test();
		test.p();
	}
}
