package com.seiryo.action;

import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.seiryo.entity.Users;

/**
 * 
 */

/**
 * @author       outianchang
 * @date         2024Äê5ÔÂ4ÈÕ
 * @project_name Game
 * @package_name com.edu.seiryo.dao
 * @file_name    GoodsDao.java
 * @classname    
 * @version      
 */
public class FirstAction extends ActionSupport {
	private String msg;
	Users user;
	List<Users> list;
	
	public List<Users> getList() {
		return list;
	}

	public void setList(List<Users> list) {
		this.list = list;
	}

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String method(){
		list  = new ArrayList<Users>();
		user = new Users();
		user.setName("xx");
		user.setPhone(123);
		Users user1 = new Users();
		user1.setName("zz");
		user1.setPhone(111);
		list.add(user);
		list.add(user1);
		msg = "success";
		return "success";
	}
	public String show(){
		return "show";
	}
	static public String staticShow(){
		return "staticShow";
	}
}
