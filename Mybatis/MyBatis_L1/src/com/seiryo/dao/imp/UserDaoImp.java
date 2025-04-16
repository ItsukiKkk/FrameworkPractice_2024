/**
 * 
 */
package com.seiryo.dao.imp;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.seiryo.entity.User;
import com.seiryo.util.MyBaitsUtil;

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
	public void add(){
		SqlSessionFactory sessionFactory = MyBaitsUtil.getSqlSessionFactory();
		SqlSession sqlSession = sessionFactory.openSession();
		sqlSession.insert("mynamespace.add");
		sqlSession.commit();
	}
	public void add1(){
		SqlSessionFactory sessionFactory = MyBaitsUtil.getSqlSessionFactory();
		SqlSession sqlSession = sessionFactory.openSession();
		User user = new User();
		user.setName("insert");
		user.setPwd("insert");
		sqlSession.insert("mynamespace.add1", user);
		sqlSession.commit();
	}
	public void delete(){
		SqlSessionFactory sessionFactory = MyBaitsUtil.getSqlSessionFactory();
		SqlSession sqlSession = sessionFactory.openSession();
		sqlSession.delete("mynamespace.delete",1018);
		sqlSession.commit();
	}
	public void update(){
		SqlSessionFactory sessionFactory = MyBaitsUtil.getSqlSessionFactory();
		SqlSession sqlSession = sessionFactory.openSession();
		User user = new User();
		user.setName("update");
		user.setPwd("update");
		user.setId(1020);
		sqlSession.update("mynamespace.update", user);
		sqlSession.commit();
	}
	public void queryOne(){
		SqlSessionFactory sessionFactory = MyBaitsUtil.getSqlSessionFactory();
		SqlSession sqlSession = sessionFactory.openSession();
		User user = sqlSession.selectOne("mynamespace.select",7);
		List<User> list = sqlSession.selectList("mynamespace.select1");
		System.out.println(list);
	}
	public static void main(String[] args) {
		UserDaoImp userDaoImp = new UserDaoImp();
//		userDaoImp.add1();
//		userDaoImp.update();
		userDaoImp.queryOne();
	}
}
