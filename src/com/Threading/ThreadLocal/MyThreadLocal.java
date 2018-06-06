package com.Threading.ThreadLocal;
/*
 * This class acts as a container to our thread local variables.
 */
public class MyThreadLocal {
	
	public static ThreadLocal userThreadLocal = new ThreadLocal<>();
	
	public static void set(Context user){
		userThreadLocal.set(user);
	}
	
	public static void unSet(){
		userThreadLocal.remove();
	}
	
	public static Context get(){
		return (Context) userThreadLocal.get();
	}
	
	
}
