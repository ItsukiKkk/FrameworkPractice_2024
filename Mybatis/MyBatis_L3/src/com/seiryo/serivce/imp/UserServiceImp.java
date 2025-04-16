/**
 * 
 */
package com.seiryo.serivce.imp;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.seiryo.entity.User;
import com.seiryo.mapper.UserMapper;
import com.seiryo.service.UserService;
import com.seiryo.util.MyBatisUtil;

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
	UserMapper userMapper;
	/* (non-Javadoc)
	 * @see com.seiryo.service.UserService#insert(java.lang.String, java.lang.String)
	 */
	@Override
	public int insert(String name, String pwd,String gender,String email) {
		SqlSessionFactory sqlSessionFactory = MyBatisUtil.getSqlSessionFactory();
		SqlSession sqlSession = sqlSessionFactory.openSession();
		userMapper = sqlSession.getMapper(UserMapper.class);
		int a = userMapper.insert(name, pwd, gender, email);
		sqlSession.commit();
		return a;
	}
	/* (non-Javadoc)
	 * @see com.seiryo.service.UserService#selectTrim(com.seiryo.entity.User)
	 */
	@Override
	public List<User> selectTrim(User user) {
		SqlSessionFactory sqlSessionFactory = MyBatisUtil.getSqlSessionFactory();
		SqlSession sqlSession = sqlSessionFactory.openSession();
		userMapper = sqlSession.getMapper(UserMapper.class);
		List<User> a = userMapper.selectTrim(user);
		sqlSession.commit();
		return a;
	}
	/* (non-Javadoc)
	 * @see com.seiryo.service.UserService#update(com.seiryo.entity.User)
	 */
	@Override
	public int update(User user) {
		SqlSessionFactory sqlSessionFactory = MyBatisUtil.getSqlSessionFactory();
		SqlSession sqlSession = sqlSessionFactory.openSession();
		userMapper = sqlSession.getMapper(UserMapper.class);
		int a = userMapper.update(user);
		sqlSession.commit();
		return a;
	}
	/* (non-Javadoc)
	 * @see com.seiryo.service.UserService#delete(int)
	 */
	@Override
	public int delete(int[] ids) {
		SqlSessionFactory sqlSessionFactory = MyBatisUtil.getSqlSessionFactory();
		SqlSession sqlSession = sqlSessionFactory.openSession();
		userMapper = sqlSession.getMapper(UserMapper.class);
		int a = userMapper.delete(ids);
		sqlSession.commit();
		return a;
	}
	/* (non-Javadoc)
	 * @see com.seiryo.service.UserService#selectById(int[])
	 */
	@Override
	public List<User> selectById(int[] ids) {
		SqlSessionFactory sqlSessionFactory = MyBatisUtil.getSqlSessionFactory();
		SqlSession sqlSession = sqlSessionFactory.openSession();
		userMapper = sqlSession.getMapper(UserMapper.class);
		List<User> a = userMapper.selectById(ids);
		sqlSession.commit();
		return a;
	}
}
