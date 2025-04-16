/**
 * 
 */
package com.seiryo.test;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.seiryo.entity.User;
import com.seiryo.service.imp.UserServiceImp;

/**
 * @author       outianchang
 * @date         2024Äê5ÔÂ4ÈÕ
 * @project_name Game
 * @package_name com.edu.seiryo.dao
 * @file_name    GoodsDao.java
 * @classname    
 * @version      
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:application.xml"})
public class TestUser {
	 @Autowired
	    private UserServiceImp userService;
	 	@org.junit.Test
	    public void testSaveUser() {
	        User user = new User();
	        user.setUserName("Test User");
	        userService.save(user);
	    }
}
