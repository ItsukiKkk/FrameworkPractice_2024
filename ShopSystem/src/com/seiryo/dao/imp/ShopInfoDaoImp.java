/**
 * 
 */
package com.seiryo.dao.imp;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.seiryo.util.DBUtil;
import com.seiryo.dao.ShopInfoDao;
import com.seiryo.entity.ShopInfo;

/**
 * @author       outianchang
 * @date         2024Äê5ÔÂ4ÈÕ
 * @project_name Game
 * @package_name com.edu.seiryo.dao.imp
 * @file_name    ShopInfoDaoImp.java
 * @classname    ShopInfoDaoImp
 * @version      
 */
public class ShopInfoDaoImp implements ShopInfoDao{
	private ResultSet rs = null;
	/* (non-Javadoc)
	 * @see com.seiryo.dao.ShopInfoDao#queryAllShopInfo()
	 */
	public List<ShopInfo> queryAllShopInfo() {
		List<ShopInfo> list = new ArrayList<ShopInfo>();
		ShopInfo shopInfo = null;
		String sql = "SELECT ID,shopId,shopName,price,oldPrice,descr,insertDtm FROM tb_shopInfo";
		try {
			rs = DBUtil.executeQuery(sql);
			while(rs.next()){
				shopInfo = new ShopInfo();
				shopInfo.setID(rs.getInt(1));
				shopInfo.setShopId(rs.getString(2));
				shopInfo.setShopName(rs.getString(3));
				shopInfo.setPrice(rs.getDouble(4));
				shopInfo.setOldPrice(rs.getDouble(5));
				shopInfo.setDescr(rs.getString(6));
				shopInfo.setInsertDtm(rs.getDate(7));
				list.add(shopInfo);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
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
	 * @see com.seiryo.dao.ShopInfoDao#queryShopInfoByNameAndDescr(java.lang.String, java.lang.String)
	 */
	public List<ShopInfo> queryShopInfoByNameAndDescr(String name, String descr) {
		List<ShopInfo> list = new ArrayList<ShopInfo>();
		ShopInfo shopInfo = null;
		String sql = "SELECT ID,shopId,shopName,price,oldPrice,descr,insertDtm FROM tb_shopInfo where 1=1";
		if(name != null){
			sql += " and shopName like '%"+ name +"%'";
		}
		
		try {
			if(descr != null){
				sql += " and descr = ?";
				rs = DBUtil.executeQuery(sql,descr);
			}else{
				rs = DBUtil.executeQuery(sql);
			}
			
			while(rs.next()){
				shopInfo = new ShopInfo();
				shopInfo.setID(rs.getInt(1));
				shopInfo.setShopId(rs.getString(2));
				shopInfo.setShopName(rs.getString(3));
				shopInfo.setPrice(rs.getDouble(4));
				shopInfo.setOldPrice(rs.getDouble(5));
				shopInfo.setDescr(rs.getString(6));
				shopInfo.setInsertDtm(rs.getDate(7));
				list.add(shopInfo);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
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
	 * @see com.seiryo.dao.ShopInfoDao#queryShopInfoByShopId(java.lang.String)
	 */
	public ShopInfo queryShopInfoByShopId(String shopId) {
		ShopInfo shopInfo = null;
		String sql = "SELECT ID,shopId,shopName,price,oldPrice,descr,insertDtm FROM tb_shopInfo where shopId = ?";
		try {
			rs = DBUtil.executeQuery(sql,shopId);
			while(rs.next()){
				shopInfo = new ShopInfo();
				shopInfo.setID(rs.getInt(1));
				shopInfo.setShopId(rs.getString(2));
				shopInfo.setShopName(rs.getString(3));
				shopInfo.setPrice(rs.getDouble(4));
				shopInfo.setOldPrice(rs.getDouble(5));
				shopInfo.setDescr(rs.getString(6));
				shopInfo.setInsertDtm(rs.getDate(7));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				DBUtil.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return shopInfo;
	}

}
