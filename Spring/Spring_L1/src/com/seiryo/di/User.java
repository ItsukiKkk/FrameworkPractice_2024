/**
 * 
 */
package com.seiryo.di;

/**
 * @author       outianchang
 * @date         2024Äê5ÔÂ4ÈÕ
 * @project_name Game
 * @package_name com.edu.seiryo.dao
 * @file_name    GoodsDao.java
 * @classname    
 * @version      
 */
public class User {
	private Integer id;
	private String userName;
	private String pwd;
	private UserDetail userDetail;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	
	public UserDetail getUserDetail() {
		return userDetail;
	}
	public void setUserDetail(UserDetail userDetail) {
		this.userDetail = userDetail;
	}
	/**
	 * @param id
	 * @param name
	 * @param pwd
	 */
	public User(Integer id, String name, String pwd) {
		super();
		this.id = id;
		this.userName = name;
		this.pwd = pwd;
	}
	/**
	 * 
	 */
	public User() {
		super();
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + userName + ", pwd=" + pwd + "]";
	}
	
	
}
