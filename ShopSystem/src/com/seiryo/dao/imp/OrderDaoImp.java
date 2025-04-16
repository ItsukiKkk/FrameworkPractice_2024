/**
 * 
 */
package com.seiryo.dao.imp;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.seiryo.dao.OrderDao;
import com.seiryo.entity.Order;
import com.seiryo.util.DBUtil;

/**
 * @author       outianchang
 * @date         2024Äê5ÔÂ4ÈÕ
 * @project_name Game
 * @package_name com.edu.seiryo.dao.imp
 * @file_name    OrderDaoImp.java
 * @classname    OrderDaoImp
 * @version      
 */
public class OrderDaoImp implements OrderDao{
	private ResultSet rs = null;
	/* (non-Javadoc)
	 * @see com.seiryo.dao.OrderDao#queryAllOrder()
	 */
	public List<Order> queryAllOrder() {
		List<Order> list = new ArrayList<Order>();
		Order order = null;
		String sql = "SELECT ID,orderId,createDtm,state FROM tb_order";
		try {
			rs = DBUtil.executeQuery(sql);
			while(rs.next()){
				order = new Order();
				order.setID(rs.getInt(1));
				order.setOrderId(rs.getString(2));
				order.setCreateDtm(rs.getDate(3));
				order.setState(rs.getInt(4));
				list.add(order);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			try {
				DBUtil.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return list;
	}

	/* (non-Javadoc)
	 * @see com.seiryo.dao.OrderDao#queryOrderByOrderId()
	 */
	public Order queryOrderByOrderId(String orderId) {
		Order order = null;
		String sql = "SELECT ID,orderId,createDtm,state FROM tb_order where orderId = '%"+ orderId +"%'";
		try {
			rs = DBUtil.executeQuery(sql);
			while(rs.next()){
				order = new Order();
				order.setID(rs.getInt(1));
				order.setOrderId(rs.getString(2));
				order.setCreateDtm(rs.getDate(3));
				order.setState(rs.getInt(4));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			try {
				DBUtil.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return order;
	}

	/* (non-Javadoc)
	 * @see com.seiryo.dao.OrderDao#updateOrderState()
	 */
	public boolean updateOrderState(String orderId,String state) {
		boolean bo = false;
		String sql = "update tb_order set state = ? where orderId = ?";
		try {
			bo = DBUtil.executeUpdate(sql, state, orderId);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return bo;
	}

	/* (non-Javadoc)
	 * @see com.seiryo.dao.OrderDao#insertOrder(java.lang.String, java.lang.String, java.lang.String)
	 */
	public boolean insertOrder(String orderId, Date createDtm, int state) {
		boolean bo = false;
		String sql = "INSERT tb_order(orderId,createDtm,state) VALUES(?,?,?) ";
		try {
			bo = DBUtil.executeUpdate(sql, orderId, createDtm, state);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return bo;
	}

	/* (non-Javadoc)
	 * @see com.seiryo.dao.OrderDao#deleteOrderByID(java.lang.String)
	 */
	public boolean deleteOrderByID(String orderId) {
		boolean bo = false;
		String sql = "DELETE from tb_order where orderId = ?";
		try {
			bo = DBUtil.executeUpdate(sql, orderId);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return bo;
	}

	/* (non-Javadoc)
	 * @see com.seiryo.dao.OrderDao#deleteAll()
	 */
	public boolean deleteAll() {
		boolean bo = false;
		String sql = "DELETE from tb_order";
		try {
			bo = DBUtil.executeUpdate(sql);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return bo;
	}

}
