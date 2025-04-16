/**
 * 
 */
package com.seiryo.service.imp;

import java.util.List;

import com.seiryo.dao.OrderDetailDao;
import com.seiryo.dao.imp.OrderDetailDaoImp;
import com.seiryo.entity.OrderDetail;
import com.seiryo.service.OrderDetailService;

/**
 * @author       outianchang
 * @date         2024Äê5ÔÂ4ÈÕ
 * @project_name Game
 * @package_name com.edu.seiryo.dao
 * @file_name    GoodsDao.java
 * @classname    
 * @version      
 */
public class OrderDetailServiceImp implements OrderDetailService{
	OrderDetailDao dao  = new OrderDetailDaoImp();
	/* (non-Javadoc)
	 * @see com.seiryo.service.imp.OrderDetailService#insertOrderDetail(java.lang.String, java.lang.String, java.lang.String)
	 */
	public boolean insertOrderDetail(String orderId, String shopId, String quantity) {
		// TODO Auto-generated method stub
		return dao.insertOrderDetail(orderId, shopId, quantity);
	}

	/* (non-Javadoc)
	 * @see com.seiryo.service.imp.OrderDetailService#queryOrderDetailByOrderId(java.lang.String)
	 */
	public List<OrderDetail> queryOrderDetailByOrderId(String orderId) {
		// TODO Auto-generated method stub
		return dao.queryAllOrderDetail();
	}

	/* (non-Javadoc)
	 * @see com.seiryo.service.imp.OrderDetailService#queryAllOrderDetail()
	 */
	public List<OrderDetail> queryAllOrderDetail() {
		// TODO Auto-generated method stub
		return dao.queryAllOrderDetail();
	}

	/* (non-Javadoc)
	 * @see com.seiryo.service.imp.OrderDetailService#deleteOrderDetailByOrderId(java.lang.String)
	 */
	public boolean deleteOrderDetailByOrderId(String orderId) {
		// TODO Auto-generated method stub
		return dao.deleteOrderDetailByOrderId(orderId);
	}

	/* (non-Javadoc)
	 * @see com.seiryo.service.imp.OrderDetailService#deleteAll()
	 */
	public boolean deleteAll() {
		// TODO Auto-generated method stub
		return dao.deleteAll();
	}

	/* (non-Javadoc)
	 * @see com.seiryo.service.imp.OrderDetailService#updateQuantityByOrderId(java.lang.String, java.lang.String)
	 */
	public boolean updateQuantityByOrderId(String orderId, String quantity) {
		// TODO Auto-generated method stub
		return dao.updateQuantityByOrderId(orderId, quantity);
	}

}
