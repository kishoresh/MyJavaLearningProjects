package com.Threading.thread;
/*
 * 2 Diff way to create Thread using Thread Class & Implementing Runnable interface.
 * Major diff here is - Instance of Thread class is created multiple times, whereas Implementation class of Runnable intf is created once.
 */

class MyThreadDemo extends Thread{
	@Override
	public void run() {
		System.out.println("Thread [Thread Class] " + Thread.currentThread().getId() + " is running.");
	}
}

class MyRunnableDemo implements Runnable{
	@Override
	public void run() {
		System.out.println("Thread [Ruunable interface] " + Thread.currentThread().getId() + " is running.");
	}
}

public class MultiThreadDemo {

	public static void main(String[] args) {
		//Thread : Here we are creating the Thread class multiple times, so basically here thread creates am unique instance and associate it with it. 
		for(int n=1; n<=10; n++){
			MyThreadDemo th = new MyThreadDemo();
			th.start();
		}
		
		//Ruunable interface : Observe here that we created the MyRunnableDemo only once and called the thread with it multiple times.
		MyRunnableDemo rth = new MyRunnableDemo();
		for(int n=1; n<=10;  n++){
			//MyRunnableDemo rth = new MyRunnableDemo();
			//Thread th = new Thread(new MyRunnableDemo());
			Thread th = new Thread(rth);
			th.start();
		}
	}
}
