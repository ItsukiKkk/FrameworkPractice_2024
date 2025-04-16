/**
 * 
 */
package com.edu.seiryo.entity;

/**
 * @author       outianchang
 * @date         2024年5月24日
 * @project_name L4
 * @package_name com.edu.seiryo.entity
 * @file_name    User.java
 * @classname    User
 * @version      
 */
public class User {
	/*
	 * 用户姓名
	 * 用户密码
	 */
	private String account,password;
	/*
	 * 用户编号
	 */
	private int id;
	/*
	 * 得到用户编号
	 */
	public int getId() {
		return id;
	}
	
	/*
	 * 设置用户编号
	 */
	public void setId(int id) {
		this.id = id;
	}
	/*
	 * 返回用户名
	 */
	public String getAccount() {
		return account;
	}
	/*
	 * 设置用户名
	 */
	public void setAccount(String account) {
		this.account = account;
	}
	/*
	 * 返回用密码
	 */
	public String getPassword() {
		return password;
	}
	/*
	 * 设置用户名
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	
}
