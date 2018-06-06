package com.Threading.ExceptionHandling;
/*
 *  How to catch the exception from the child threads in the parent thread and handle it accordingly. 2 ways :
 *  1. Set the exception handler UncaughtExceptionHandler for the thread. 
 *     Or, set the default exception handler Thread.setDefaultUncaughtExceptionHandler for all threads.
 *  2. Use Callable instead of Run to Catch the exception through the get method of Future.
 */

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadFactory;

class ChildCallableThread implements Callable{
	@Override
	public Object call() throws Exception {
		System.out.println("do something 1.");
		exceptionMethod();
		System.out.println("do something 2.");
		return null;
	}
	
	//Dummy method to return an exception
	private void exceptionMethod(){
		throw new RuntimeException("Childthread exception");
	}
}

class ChildRunnableThread implements Runnable{
	public static ChildThreadExceptionHandler exceptionHandler;
	static{    //to initialize the static variables.
		exceptionHandler = new ChildThreadExceptionHandler();
	}
	
	@Override
	public void run() {
		Thread.currentThread().setUncaughtExceptionHandler(exceptionHandler);
		System.out.println("do something 1.");
		exceptionMethod();
		System.out.println("do something 2.");		
	}
	
	//Dummy method to return an exception
	private void exceptionMethod(){
		throw new RuntimeException("Childthread exception");
	}
	
	public static class ChildThreadExceptionHandler implements Thread.UncaughtExceptionHandler{
		@Override
		public void uncaughtException(Thread t, Throwable e) {
			System.out.println(String.format("Handled exception at child thread : %s", e));			
		}
	}
}

public class ChildThreadExceptionHandlingDemo {
	
	//2. Use Callable instead of Run to Catch the exception through the get method of Future.
	public static void CallableExceptionHandling(){
		ExecutorService executorService = Executors.newFixedThreadPool(8);
		Future future = executorService.submit(new ChildCallableThread());
		try{
			try {
				future.get();   //This will block the thread, unless we get a return value or exception
			} catch (InterruptedException | ExecutionException e) {
				System.out.println(String.format("Handled exception at child thread : %s", e));
			}
		}finally{
			if (executorService != null){
				executorService.shutdown();
			}
		}	
	}
	
	//1. Set the exception handler UncaughtExceptionHandler for the thread. 
	public static void RunnableExceptionHandling(){
		Thread runnableThread = new Thread(new ChildRunnableThread());
		runnableThread.start();		
	}
	
	public static void main(String[] args) {
		CallableExceptionHandling();
		//RunnableExceptionHandling();
	}

}
