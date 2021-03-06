package com.yqw.java.proxy.jdkDynamicProxy.demo2;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 
 * 模拟开发简单的Dubbo
 */
public class Test { 

	public static void main(String[] args) {
		System.out.println(UserDao.class.getInterfaces().length);
		System.out.println(UserDao.class.getClasses().length);
		//System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
		UserDao userDao = (UserDao) remote(UserDao.class);
		System.out.println(userDao.getUserName());
	}

	private static Object remote(Class<?> clazz) {
		return Proxy.newProxyInstance(clazz.getClassLoader(), new Class<?>[] { clazz }, new InvocationHandler() {
			@Override
			public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
				System.out.println("被代理了");
				return "通过RPC调用远程函数返回的结果";
			}
		});
	}
}
