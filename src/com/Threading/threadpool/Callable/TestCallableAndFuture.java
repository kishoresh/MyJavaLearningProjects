package com.Threading.threadpool.Callable;
/*
 * Callable & Future : Using Callable instead of Runnable to return a value.
 * A Callable task returns a value upon completion and we use the Future object to obtain the value. 
 * This is to demo, for a single and multiple tasks.
 */

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.swing.plaf.metal.MetalIconFactory.FolderIcon16;

import com.sun.corba.se.impl.orbutil.closure.Future;
import com.sun.corba.se.spi.orbutil.fsm.Guard.Result;

class Task implements Callable<Integer>{   //Callable is similar to Runnable interface with only one method call()
	String threadname;
	public Task(String name) {
		this.threadname = name;
	}
	
	@Override
	public Integer call() throws Exception {
		System.out.println("Thread Name : " + Thread.currentThread().getName() + " " + threadname);
		Thread.sleep(2000);
		return new Random().nextInt();
	}	
}

public class TestCallableAndFuture {
	/*
	 * Using Callable & Future for a single task.
	 */
	public static void createSingleCallableTask(){
		ExecutorService execService = Executors.newFixedThreadPool(5);
		java.util.concurrent.Future<Integer> future = execService.submit(new Task("Task-1"));
		
		try {
			Integer result = future.get();
			System.out.println("Result of Future value = " + result);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}	
		execService.shutdown();
	}

	/*
	 * Using Callable & Future for multiple tasks.
	 */
	public static void createMultipleCallableTask(){
		ExecutorService execService = Executors.newFixedThreadPool(5);
		List<java.util.concurrent.Future> allFutures = new ArrayList<>();
		for (int i = 0; i < 100; i++) {
			java.util.concurrent.Future<Integer> future = execService.submit(new Task("Task-" + i));
			allFutures.add(future);
		}
		//Do some operations
		
		for (int i = 0; i < 100; i++) {
			java.util.concurrent.Future<Integer> future = allFutures.get(i);
			Integer result;
			try {
				result = future.get();
				System.out.println("Result of Future value = " + result);
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (ExecutionException e) {
				e.printStackTrace();
			}		
		}
		execService.shutdown();
	}

	public static void main(String[] args) {
		//createSingleCallableTask();
		createMultipleCallableTask();

	}

}
