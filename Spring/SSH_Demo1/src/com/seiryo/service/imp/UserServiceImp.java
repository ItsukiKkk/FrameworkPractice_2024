/**
 * 
 */
package com.seiryo.service.imp;

import com.seiryo.dao.imp.UserDaoImp;
import com.seiryo.entity.User;
import com.seiryo.service.UserService;

/**
 * @author       outianchang
 * @date         2024Äê5ÔÂ4ÈÕ
 * @project_name Game
 * @package_name com.edu.seiryo.dao
 * @file_name    GoodsDao.java
 * @classname    
 * @version      
 */
public class UserServiceImp implements UserService{
    private UserDaoImp userDao;

    public void setUserDao(UserDaoImp userDao) {
        this.userDao = userDao;
    }

    public void save(User user) {
        userDao.save(user);
    }

}
