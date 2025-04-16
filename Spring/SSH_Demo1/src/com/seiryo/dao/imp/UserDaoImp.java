/**
 * 
 */
package com.seiryo.dao.imp;

import org.springframework.orm.hibernate3.HibernateTemplate;

import com.seiryo.dao.UserDao;
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
public class UserDaoImp implements UserDao{
    private HibernateTemplate hibernateTemplate;

    public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
        this.hibernateTemplate = hibernateTemplate;
    }

    public void save(User user) {
        hibernateTemplate.save(user);
    }
}
