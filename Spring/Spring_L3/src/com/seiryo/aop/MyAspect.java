/**
 * 
 */
package com.seiryo.aop;

import javax.sound.midi.MidiChannel;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 * @author       outianchang
 * @date         2024��5��4��
 * @project_name Game
 * @package_name com.edu.seiryo.dao
 * @file_name    GoodsDao.java
 * @classname    
 * @version      
 */
public class MyAspect implements MethodInterceptor{

	/* (non-Javadoc)
	 * @see org.aopalliance.intercept.MethodInterceptor#invoke(org.aopalliance.intercept.MethodInvocation)
	 */
	@Override
	public Object invoke(MethodInvocation mi) throws Throwable {
		System.out.println("������ʼǰ");
		Object obj = mi.proceed();
		System.out.println("������ʼ��");
		return obj;
	}

}
