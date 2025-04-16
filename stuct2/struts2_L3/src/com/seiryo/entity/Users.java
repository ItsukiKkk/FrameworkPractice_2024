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
private String name;
private Integer phone;
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public Integer getPhone() {
	return phone;
}
public void setPhone(Integer phone) {
	this.phone = phone;
}
@Override
public String toString() {
	return "Users [name=" + name + ", phone=" + phone + "]";
}
/**
 * @param name
 * @param phone
 */
public Users(String name, Integer phone) {
	super();
	this.name = name;
	this.phone = phone;
}
/**
 * 
 */
public Users() {
	super();
}

}
