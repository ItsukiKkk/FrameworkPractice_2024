/**
 * 
 */
package com.seiryo.dao.imp;


import java.util.List;

import javax.persistence.Id;
import javax.persistence.criteria.From;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.hql.internal.ast.tree.SessionFactoryAwareNode;
import org.hibernate.query.Query;

import com.seiryo.entity.Users;
import com.seiryo.util.HibernateUtil;

/**
 * @author       outianchang
 * @date         2024Äê5ÔÂ4ÈÕ
 * @project_name Game
 * @package_name com.edu.seiryo.dao
 * @file_name    GoodsDao.java
 * @classname    
 * @version      
 */
public class UserDaoImp {
	public void insert(){
		Session session = HibernateUtil.getSession();
		Transaction transaction = session.beginTransaction();
		session.save(new Users("aaa","aaa"));
		transaction.commit();
		session.close();
	}
	public void delete(Integer id){
		Configuration configuration = new Configuration();
		configuration.configure();
		SessionFactory sessionFactory  = configuration.buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		Users users = session.get(Users.class, id);
		session.delete(users);
		transaction.commit();
		session.close();
		sessionFactory.close();
	}
	public void update(){
		Configuration configuration = new Configuration();
		configuration.configure();
		SessionFactory sessionFactory  = configuration.buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		session.update(new Users("111","111"));
		transaction.commit();
		session.close();
		sessionFactory.close();
	}
	public void query(){
		Configuration configuration = new Configuration().configure();
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		Session session = sessionFactory.openSession();
		Query query= session.createQuery("from Users");
		List<Users> list = query.list();
		for (Users users : list) {
			System.out.println(users);
		}
		
	}
	public static void main(String[] args) {
		UserDaoImp daoImp = new UserDaoImp();
		daoImp.insert();
	}
}
