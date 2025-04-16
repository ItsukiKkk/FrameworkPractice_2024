/**
 * 
 */
package com.seiryo.service;

import java.util.List;

import com.seiryo.entity.ShopInfo;

/**
 * @author       outianchang
 * @date         2024Äê5ÔÂ4ÈÕ
 * @project_name Game
 * @package_name com.edu.seiryo.dao
 * @file_name    GoodsDao.java
 * @classname    
 * @version      
 */
public interface ShopInfoService {
	List<ShopInfo> queryAllShopInfo();
	List<ShopInfo> queryShopInfoByNameAndDescr(String name,String descri);
	ShopInfo queryShopInfoByShopId(String shopId);
}
