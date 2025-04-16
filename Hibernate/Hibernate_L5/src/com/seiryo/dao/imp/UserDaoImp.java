/**
 * 
 */
package com.seiryo.dao.imp;


import java.util.List;

import javax.persistence.Id;
import javax.persistence.criteria.From;

import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.SQLQuery;
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
 * @date         2024年5月4日
 * @project_name Game
 * @package_name com.edu.seiryo.dao
 * @file_name    GoodsDao.java
 * @classname    
 * @version      
 */
public class UserDaoImp {
	public void query(){
		Session session = HibernateUtil.getSession();
//		OID查询
		Users user = session.get(Users.class, 2);
		System.out.println(user);
////		HQL查询
////      查询所有
//		Query query = session.createQuery("from Users");
////		条件查询
//		Query query = session.createQuery("from Users where password = ?");
//		query.setParameter(0, "aaa");
////		排序查询
//		Query query = session.createQuery("from Users order by id desc");
////		分页查询
//		Query query = session.createQuery("from Users");
//		query.setFirstResult(0);
//		query.setMaxResults(2);
////		投影查询（部分字段查询）
//		Query query = session.createQuery("select id from Users");
//		List<Integer> list = query.list();
//		for (Integer i : list) {
//			System.out.println(i);
//		}
//		
//		聚合函数
//		Query<Object[]> query = session.createQuery("select count(*),max(id) from Users");
//		List<Object[]> list = query.list();
//		  for (Object[] row : list) {
//              Long count = (Long) row[0];
//              Integer maxId = (Integer) row[1];
//              System.out.println("Count: " + count + ", Max ID: " + maxId);
//          }
		//QBC查询
		//query查询
//		查询所有
//		SQLQuery sqlQuery= session.createSQLQuery("select * from t_user");
//		条件查询
//		SQLQuery sqlQuery= session.createSQLQuery("select * from t_user where name = ?");
//		sqlQuery.setParameter(0,"aaa");
////		排序查询
//		SQLQuery sqlQuery= session.createSQLQuery("select * from t_user order by id desc");
////		分页查询
//		SQLQuery sqlQuery= session.createSQLQuery("select top 2 * from t_user where id not in (select top 2 id from t_user)");
////		投影查询(部分字段查询)
//		SQLQuery sqlQuery = session.createSQLQuery("select name from t_user");
//		聚合函数
//		sqlQuery.addEntity(Users.class);
//		List<Users> list = sqlQuery.list();
//		for(Users user :list){
//			System.out.println(user);
//		}
	}
	public static void main(String[] args) {
		UserDaoImp daoImp = new UserDaoImp();
		daoImp.query();
	}
}
