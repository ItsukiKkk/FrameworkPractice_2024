/**
 * 
 */
package com.seiryo.service.imp;

import java.util.List;

import com.seiryo.dao.ShopInfoDao;
import com.seiryo.dao.imp.ShopInfoDaoImp;
import com.seiryo.entity.ShopInfo;
import com.seiryo.service.ShopInfoService;

/**
 * @author       outianchang
 * @date         2024Äê5ÔÂ4ÈÕ
 * @project_name Game
 * @package_name com.edu.seiryo.dao
 * @file_name    GoodsDao.java
 * @classname    
 * @version      
 */
public class ShopInfoServiceImp implements ShopInfoService{
	ShopInfoDao dao = new ShopInfoDaoImp();
	/* (non-Javadoc)
	 * @see com.seiryo.service.ShopInfoService#queryAllShopInfo()
	 */
	public List<ShopInfo> queryAllShopInfo() {
		// TODO Auto-generated method stub
		return dao.queryAllShopInfo();
	}

	/* (non-Javadoc)
	 * @see com.seiryo.service.ShopInfoService#queryShopInfoByNameAndDescr(java.lang.String, java.lang.String)
	 */
	public List<ShopInfo> queryShopInfoByNameAndDescr(String name, String descri) {
		// TODO Auto-generated method stub
		return dao.queryShopInfoByNameAndDescr(name, descri);
	}

	/* (non-Javadoc)
	 * @see com.seiryo.service.ShopInfoService#queryShopInfoByShopId(java.lang.String)
	 */
	public ShopInfo queryShopInfoByShopId(String shopId) {
		// TODO Auto-generated method stub
		return dao.queryShopInfoByShopId(shopId);
	}

}
