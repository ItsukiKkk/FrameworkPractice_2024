/**
 * 
 */
package com.seiryo.dao;

import java.util.Date;
import java.util.List;

import com.seiryo.entity.Order;

/**
 * @author       outianchang
 * @date         2024��5��4��
 * @project_name Game
 * @package_name com.edu.seiryo.dao
 * @file_name    OrderDao.java
 * @classname    OrderDao
 * @version      
 */
public interface OrderDao {
	//��ѯ
	List<Order> queryAllOrder();
	Order queryOrderByOrderId(String orderId);
	boolean updateOrderState(String ID,String state);
	//����
	boolean insertOrder(String orderId,Date date,int state);
	//ɾ��
	boolean deleteOrderByID(String orderId);
	boolean deleteAll();
}
