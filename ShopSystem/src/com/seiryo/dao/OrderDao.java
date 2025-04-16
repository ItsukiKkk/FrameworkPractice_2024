/**
 * 
 */
package com.seiryo.dao;

import java.util.Date;
import java.util.List;

import com.seiryo.entity.Order;

/**
 * @author       outianchang
 * @date         2024年5月4日
 * @project_name Game
 * @package_name com.edu.seiryo.dao
 * @file_name    OrderDao.java
 * @classname    OrderDao
 * @version      
 */
public interface OrderDao {
	//查询
	List<Order> queryAllOrder();
	Order queryOrderByOrderId(String orderId);
	boolean updateOrderState(String ID,String state);
	//存入
	boolean insertOrder(String orderId,Date date,int state);
	//删除
	boolean deleteOrderByID(String orderId);
	boolean deleteAll();
}
