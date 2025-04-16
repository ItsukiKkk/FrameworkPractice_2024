/**
 * 
 */
package com.seiryo.property;

/**
 * @author       outianchang
 * @date         2024Äê5ÔÂ4ÈÕ
 * @project_name Game
 * @package_name com.edu.seiryo.dao
 * @file_name    GoodsDao.java
 * @classname    
 * @version      
 */
public class UserDetail {
	private String email;
	private String sex;
	private Integer age;
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "UserDetail [email=" + email + ", sex=" + sex + ", age=" + age + "]";
	}
	/**
	 * @param email
	 * @param sex
	 * @param age
	 */
	public UserDetail(String email, String sex, Integer age) {
		super();
		this.email = email;
		this.sex = sex;
		this.age = age;
	}
	/**
	 * 
	 */
	public UserDetail() {
		super();
	}
	
}
