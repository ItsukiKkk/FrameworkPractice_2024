/**
 * 
 */
package com.seiryo.service.imp;

import java.util.Date;
import java.util.List;

import com.seiryo.dao.OrderDao;
import com.seiryo.dao.imp.OrderDaoImp;
import com.seiryo.entity.Order;
import com.seiryo.service.OrderService;

/**
 * @author       outianchang
 * @date         2024Äê5ÔÂ4ÈÕ
 * @project_name Game
 * @package_name com.edu.seiryo.dao
 * @file_name    GoodsDao.java
 * @classname    
 * @version      
 */
public class OrderServiceImp implements OrderService{
	OrderDao dao = new OrderDaoImp();
	/* (non-Javadoc)
	 * @see com.seiryo.service.OrderService#queryAllOrder()
	 */
	public List<Order> queryAllOrder() {
		// TODO Auto-generated method stub
		return dao.queryAllOrder();
	}

	/* (non-Javadoc)
	 * @see com.seiryo.service.OrderService#queryOrderByOrderId(java.lang.String)
	 */
	public Order queryOrderByOrderId(String orderId) {
		// TODO Auto-generated method stub
		return dao.queryOrderByOrderId(orderId);
	}

	/* (non-Javadoc)
	 * @see com.seiryo.service.OrderService#updateOrderState(java.lang.String, java.lang.String)
	 */
	public boolean updateOrderState(String ID, String state) {
		// TODO Auto-generated method stub
		return dao.updateOrderState(ID, state);
	}

	/* (non-Javadoc)
	 * @see com.seiryo.service.OrderService#insertOrder(java.lang.String, java.util.Date, int)
	 */
	public boolean insertOrder(String orderId, Date date, int state) {
		// TODO Auto-generated method stub
		return dao.insertOrder(orderId, date, state);
	}

	/* (non-Javadoc)
	 * @see com.seiryo.service.OrderService#deleteOrderByID(java.lang.String)
	 */
	public boolean deleteOrderByID(String orderId) {
		// TODO Auto-generated method stub
		return dao.deleteOrderByID(orderId);
	}

	/* (non-Javadoc)
	 * @see com.seiryo.service.OrderService#deleteAll()
	 */
	public boolean deleteAll() {
		// TODO Auto-generated method stub
		return dao.deleteAll();
	}

}
