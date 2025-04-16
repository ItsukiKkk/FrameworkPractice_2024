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
public class User {
	private Integer id;
	private String userName;
	private String pwd;
	private String gender;
	private String email;
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return userName;
	}
	public void setName(String name) {
		this.userName = name;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
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
		return "User [id=" + id + ", userName=" + userName + ", pwd=" + pwd + ", gender=" + gender + ", email=" + email
				+ "]";
	}
	
	
	
}
