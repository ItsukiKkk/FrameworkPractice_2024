/**
 * 
 */
package com.seiryo.dao;

import java.util.List;

import com.seiryo.entity.OrderDetail;

/**
 * @author       outianchang
 * @date         2024��5��4��
 * @project_name Game
 * @package_name com.edu.seiryo.dao
 * @file_name    OrderDetailDao.java
 * @classname    OrderDetailDao
 * @version      
 */

	      
public interface OrderDetailDao {
	boolean insertOrderDetail(String orderId ,String shopId,String quantity);
	List<OrderDetail> queryOrderDetailByOrderId(String orderId);
	List<OrderDetail> queryAllOrderDetail();
	boolean deleteOrderDetailByOrderId(String orderId);
	boolean deleteAll();
	boolean updateQuantityByOrderId(String orderId,String quantity);
}
