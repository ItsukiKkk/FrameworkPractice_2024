/**
 * 
 */
package com.seiryo.cglib;

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
		UserServiceImp userServiceImp = MyBeanFactory.createService();
		userServiceImp.addUser();
	}
}
