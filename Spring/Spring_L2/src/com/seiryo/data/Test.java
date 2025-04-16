/**
 * 
 */
package com.seiryo.data;

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
	Data data;
	public void constructor(){
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("com/seiryo/data/datademo.xml");
		data = (Data) applicationContext.getBean("data");
		System.out.println(data);
	}
	public static void main(String[] args) {
		Test test = new Test();
		test.constructor();
	}
}
