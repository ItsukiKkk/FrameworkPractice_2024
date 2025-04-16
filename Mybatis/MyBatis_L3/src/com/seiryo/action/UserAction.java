/**
 * 
 */
package com.seiryo.action;

import java.util.List;

import com.seiryo.entity.User;
import com.seiryo.serivce.imp.UserServiceImp;
import com.seiryo.service.UserService;

/**
 * @author       outianchang
 * @date         2024年5月4日
 * @project_name Game
 * @package_name com.edu.seiryo.dao
 * @file_name    GoodsDao.java
 * @classname    
 * @version      
 */
public class UserAction {
	
	public static void main(String[] args) {
		UserService userService = new UserServiceImp();
//		int a = userService.insert("service", "service","service", "service");
//		System.out.println(a);
		User user = new User();
//		user.setEmail("service");
//		List<User> list = userService.selectTrim(user);
//		System.out.println(list);
		
//		user.setId(1);
//		user.setGender("女");
//		user.setName("好");
//		int a = userService.update(user);
//		System.out.println(a);
		
		int[] ids = {5,6};
//		int a = userService.delete(ids);
//		System.out.println(a);
		List<User> list = userService.selectById(ids);
		for(User user2: list){
			System.out.println(user2);
		}
		
		
	}
}
