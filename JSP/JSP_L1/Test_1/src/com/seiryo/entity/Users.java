/**
 * 
 */
package com.seiryo.entity;

/**
 * @author       outianchang
 * @date         2024年5月4日
 * @project_name Game
 * @package_name com.edu.seiryo.dao
 * @file_name    GoodsDao.java
 * @classname    
 * @version      
 */
public class Users {
	private int userId;
	private String account;
	private String password;
	private String email;
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @param account
	 * @param password
	 * @param email
	 * @param captcha
	 * @param emailCode
	 */
	public Users(String account, String password, String email) {
		super();
		this.account = account;
		this.password = password;
		this.email = email;
	}
	/**
	 * 
	 */
	public Users() {
		super();
	}
	@Override
	public String toString() {
		return "Users [userId=" + userId + ", account=" + account + ", password=" + password + ", email=" + email + "]";
	}
}
