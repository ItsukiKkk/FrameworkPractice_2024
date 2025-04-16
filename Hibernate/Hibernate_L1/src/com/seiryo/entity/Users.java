/**
 * 
 */
package com.seiryo.entity;

/**
 * @author       outianchang
 * @date         2024Äê5ÔÂ4ÈÕ
 * @project_name Game
 * @package_name com.edu.seiryo.dao
 * @file_name    GoodsDao.java
 * @classname    
 * @version      
 */
public class Users {
	private Integer id;
	private String account;
	private String password;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * @param account
	 * @param password
	 */
	public Users(String account, String password) {
		super();
		this.account = account;
		this.password = password;
	}
	/**
	 * 
	 */
	public Users() {
		super();
	}
	@Override
	public String toString() {
		return "Users [account=" + account + ", password=" + password + "]";
	}
	
}
