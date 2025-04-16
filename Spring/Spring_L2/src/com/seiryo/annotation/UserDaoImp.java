/**
 * 
 */
package com.seiryo.annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @author       outianchang
 * @date         2024Äê5ÔÂ4ÈÕ
 * @project_name Game
 * @package_name com.edu.seiryo.dao
 * @file_name    GoodsDao.java
 * @classname    
 * @version      
 */
@Repository
public class UserDaoImp implements UserDao{
@Autowired
	/* (non-Javadoc)
	 * @see com.seiryo.di.UserDao#print()
	 */
	@Override
	public void print() {
		System.out.println("print");
	}
	
}
