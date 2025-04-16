/**
 * 
 */
package com.seiryo.cglib;

/**
 * @author       outianchang
 * @date         2024年5月4日
 * @project_name Game
 * @package_name com.edu.seiryo.dao
 * @file_name    GoodsDao.java
 * @classname    
 * @version      
 */
public class MyAspect {
	public void before(){
		System.out.println("方法开始前");
	}
	public void after(){
		System.out.println("方法开始后");
	}
}
