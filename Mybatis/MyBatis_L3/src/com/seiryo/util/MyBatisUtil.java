/**
 * 
 */
package com.seiryo.util;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/**
 * @author       outianchang
 * @date         2024��5��4��
 * @project_name Game
 * @package_name com.edu.seiryo.dao
 * @file_name    GoodsDao.java
 * @classname    
 * @version      
 */
public class MyBatisUtil {
	private static SqlSessionFactory sessionFactory;
	static{
		try {
			Reader reader = Resources.getResourceAsReader("mybatis.xml");
			sessionFactory = new SqlSessionFactoryBuilder().build(reader);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static SqlSessionFactory getSqlSessionFactory(){
		return sessionFactory;
	}
}
