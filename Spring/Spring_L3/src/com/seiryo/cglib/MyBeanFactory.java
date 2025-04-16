/**
 * 
 */
package com.seiryo.cglib;

import java.lang.reflect.Method;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;


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
	public static UserServiceImp createService(){
		final UserServiceImp userServiceImp = new UserServiceImp();
		final MyAspect myAspect = new MyAspect();
		Enhancer enhancer = new Enhancer();
		enhancer.setSuperclass(userServiceImp.getClass());
		enhancer.setCallback(new MethodInterceptor() {
			
			@Override
			public Object intercept(Object proxy, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
				myAspect.before();
				Object object = method.invoke(userServiceImp, args);
				myAspect.after();
				return object;
			}
		});
		UserServiceImp proxService = (UserServiceImp)enhancer.create();
		return proxService;
	}
}
