/**
 * 
 */
package com.seiryo.service;

import java.util.Date;
import java.util.List;

import com.seiryo.entity.Order;

/**
 * @author       outianchang
 * @date         2024��5��4��
 * @project_name Game
 * @package_name com.edu.seiryo.dao
 * @file_name    GoodsDao.java
 * @classname    
 * @version      
 */
public interface OrderService {
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
