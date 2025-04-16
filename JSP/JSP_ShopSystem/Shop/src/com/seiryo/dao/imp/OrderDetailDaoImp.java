/**
 * 
 */
package com.seiryo.dao.imp;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.seiryo.dao.OrderDetailDao;
import com.seiryo.entity.Order;
import com.seiryo.entity.OrderDetail;
import com.seiryo.entity.ShopInfo;
import com.seiryo.util.DBUtil;

/**
 * @author       outianchang
 * @date         2024Äê5ÔÂ4ÈÕ
 * @project_name Game
 * @package_name com.edu.seiryo.dao.imp
 * @file_name    OrderDetailDaoImp.java
 * @classname    OrderDetailDaoImp
 * @version      
 */
public class OrderDetailDaoImp implements OrderDetailDao{
	private ResultSet rs = null;
	/* (non-Javadoc)
	 * @see com.seiryo.dao.OrderDetailDao#insertOrderDetail(java.lang.String, java.lang.String, java.lang.String)
	 */
	public boolean insertOrderDetail(String orderId, String shopId, String quantity) {
		boolean bo = false;
		String sql = "INSERT tb_orderDetail(orderId,shopId,quantity) VALUES(?,?,?) ";
		try {
			bo = DBUtil.executeUpdate(sql, orderId, shopId, quantity);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return bo;
	}

	/* (non-Javadoc)
	 * @see com.seiryo.dao.OrderDetailDao#queryOrderDetailByOrderId(java.lang.String)
	 */
	public List<OrderDetail> queryOrderDetailByOrderId(String orderId) {
		OrderDetail orderDetail = null;
		String sql = "SELECT tb_orderDetail.orderId,tb_orderDetail.shopId,quantity,tb_shopInfo.shopName,tb_shopInfo.price,tb_shopInfo.price*tb_orderDetail.quantity,createDtm, state"
				+" FROM tb_orderDetail, tb_shopInfo, tb_order"
				+" where tb_orderDetail.shopId = tb_shopInfo.shopId and tb_order.orderId = tb_orderDetail.orderId"
				+" and tb_orderDetail.orderId = ?";;
		List<OrderDetail> list = new ArrayList<OrderDetail>();
		try {
			rs = DBUtil.executeQuery(sql,orderId);
			while(rs.next()){
				orderDetail = new OrderDetail();
				orderDetail.setOrderId(rs.getString(1));
				orderDetail.setShopId(rs.getString(2));
				orderDetail.setQuantity(rs.getInt(3));
				orderDetail.setTotalPrice(rs.getDouble(6));
				ShopInfo shopInfo = new ShopInfo();
				shopInfo.setShopName(rs.getString(4));
				shopInfo.setPrice(rs.getDouble(5));
				orderDetail.setShopInfo(shopInfo);
				Order order = new Order();
				order.setCreateDtm(rs.getDate(7));
				order.setState(rs.getInt(8));
				orderDetail.setOrder(order);
				list.add(orderDetail);
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
	 * @see com.seiryo.dao.OrderDetailDao#deleteOrderDetailByOrderId(java.lang.String)
	 */
	public boolean deleteOrderDetailByOrderId(String orderId) {
		boolean bo = false;
		String sql = "delete from tb_orderDetail where orderId = ?";
		try {
			bo = DBUtil.executeUpdate(sql, orderId);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return bo;
	}

	/* (non-Javadoc)
	 * @see com.seiryo.dao.OrderDetailDao#deleteAll()
	 */
	public boolean deleteAll() {
		boolean bo = false;
		String sql = "delete from tb_orderDetail";
		try {
			bo = DBUtil.executeUpdate(sql);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return bo;
	}

	/* (non-Javadoc)
	 * @see com.seiryo.dao.OrderDetailDao#updateQuantityByOrderId(java.lang.String, java.lang.String)
	 */
	public boolean updateQuantityByOrderId(String orderId, String quantity) {
		boolean bo = false;
		String sql = "update tb_orderDetail set quantity = ? where orderId = ?";
		try {
			bo = DBUtil.executeUpdate(sql,quantity,orderId);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return bo;
	}

	/* (non-Javadoc)
	 * @see com.seiryo.dao.OrderDetailDao#queryAllOrderDetail()
	 */
	public List<OrderDetail> queryAllOrderDetail() {
		OrderDetail orderDetail = null;
		List<OrderDetail> list = new ArrayList<OrderDetail>();
		String sql = "SELECT tb_orderDetail.orderId,tb_orderDetail.shopId,quantity,tb_shopInfo.shopName,tb_shopInfo.price,tb_shopInfo.price*tb_orderDetail.quantity,createDtm, state"
				+" FROM tb_orderDetail, tb_shopInfo, tb_order"
				+" where tb_orderDetail.shopId = tb_shopInfo.shopId and tb_order.orderId = tb_orderDetail.orderId";
		try {
			rs = DBUtil.executeQuery(sql);
			while(rs.next()){
				orderDetail = new OrderDetail();
				orderDetail.setOrderId(rs.getString(1));
				orderDetail.setShopId(rs.getString(2));
				orderDetail.setQuantity(rs.getInt(3));
				orderDetail.setTotalPrice(rs.getDouble(6));
				ShopInfo shopInfo = new ShopInfo();
				shopInfo.setShopName(rs.getString(4));
				shopInfo.setPrice(rs.getDouble(5));
				orderDetail.setShopInfo(shopInfo);
				Order order = new Order();
				order.setCreateDtm(rs.getDate(7));
				order.setState(rs.getInt(8));
				orderDetail.setOrder(order);
				list.add(orderDetail);
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

}
