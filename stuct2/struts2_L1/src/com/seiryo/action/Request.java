/**
 * 
 */
package com.seiryo.action;

import java.util.Arrays;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.util.ServletContextAware;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.seiryo.entity.Users;

/**
 * @author       outianchang
 * @date         2024Äê5ÔÂ4ÈÕ
 * @project_name Game
 * @package_name com.edu.seiryo.dao
 * @file_name    GoodsDao.java
 * @classname    
 * @version      
 */
public class Request implements ModelDriven<Users>{
//	 private ServletContext servletContext;
//	    private HttpServletRequest servletRequest;
//	    private HttpServletResponse servletResponse;

//	public String method(){
//		//1
//		ActionContext context = ActionContext.getContext();
//		Map<String, Object> map= context.getParameters();
//		Set<String> set = map.keySet();
//		for (String key : set) {
//			Object[] objects = (Object[]) map.get(key);
//			System.out.println(Arrays.toString(objects));
//		}
//		//2
//	        String name = servletRequest.getParameter("name");
//	        String phone = servletRequest.getParameter("phone");
//	        System.out.println(name+"/"+phone);
//		return "success";		
//	}  
//	/* (non-Javadoc)
//	 * @see org.apache.struts2.interceptor.ServletResponseAware#setServletResponse(javax.servlet.http.HttpServletResponse)
//	 */
//	public void setServletResponse(HttpServletResponse arg0) {
//		// TODO Auto-generated method stub
//		
//	}
//
//	/* (non-Javadoc)
//	 * @see org.apache.struts2.interceptor.ServletRequestAware#setServletRequest(javax.servlet.http.HttpServletRequest)
//	 */
//	public void setServletRequest(HttpServletRequest arg0) {
//		this.servletRequest = servletRequest;
//		
//	}
//
//	/* (non-Javadoc)
//	 * @see org.apache.struts2.util.ServletContextAware#setServletContext(javax.servlet.ServletContext)
//	 */
//	public void setServletContext(ServletContext arg0) {
//		 this.servletContext = servletContext;
//		
//	}
	
//	//3
//	private String name;
//    private String phone;
//
//    public String method() {
//        System.out.println("Name: " + name);
//        System.out.println("Phone: " + phone);
//        
//
//        return "success";
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public String getPhone() {
//        return phone;
//    }
//
//    public void setPhone(String phone) {
//        this.phone = phone;
//    }
	
	//4
	Users users = new Users();
	public Users getModel(){
		return users;
	}
	public String method() {
      System.out.println("Name: " + users.getName());
      System.out.println("Phone: " + users.getPhone());
      

      return "success";
  }
}
