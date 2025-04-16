/**
 * 
 */
package com.seiryo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.seiryo.entity.User;

/**
 * @author       outianchang
 * @date         2024Äê5ÔÂ4ÈÕ
 * @project_name Game
 * @package_name com.edu.seiryo.dao
 * @file_name    GoodsDao.java
 * @classname    
 * @version      
 */
public interface UserMapperImp {
	List<User> select1();
	User select(Integer ID);
	void update(Integer id,String userName,String pwd);
	void add1(String userName,String pwd);
	void add (@Param("userName")String name,@Param("pwd")String pwd);
	List<User> selectByOrder(@Param("order") String order);
}
