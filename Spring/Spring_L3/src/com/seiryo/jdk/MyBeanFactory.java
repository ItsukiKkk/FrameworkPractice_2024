/**
 * 
 */
package com.seiryo.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author       outianchang
 * @date         2024Äê5ÔÂ4ÈÕ
 * @project_name Game
 * @package_name com.edu.seiryo.dao
 * @file_name    GoodsDao.java
 * @classname    
 * @version      
 */
public class MyBeanFactory {
	public static UserService createService(){
		final UserService userService = new UserServiceImp();
		final MyAspect myAspect = new MyAspect();
		UserService proxService = (UserService)Proxy.newProxyInstance(
				MyBeanFactory.class.getClassLoader(), 
				userService.getClass().getInterfaces(), 
				new InvocationHandler() {
					
					@Override
					public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
						myAspect.before();
						Object obj = method.invoke(userService);
						myAspect.after();
						return obj;
					}
				});
		return proxService;
	}
}
