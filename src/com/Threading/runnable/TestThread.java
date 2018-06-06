package com.Threading.runnable;
/*
 * Creating a Thread by Implementing Runnable Interface :
	Step 1: Implement the run() method provided by Runnable interface.
	Step 2: Instantiate a Thread object using the constructor:
		Thread(Runnable threadObj); Or
		Thread(Runnable threadObj, String threadName);
	Step 3: Start the Thread object by calling start( ) method, which executes a call to run( ) method.
 *
 * URL : http://www.tutorialspoint.com/java/java_multithreading.htm
 */

class MyRunnableClass implements Runnable {
	private Thread t;
	private String threadname;

	public MyRunnableClass(String name) {
		threadname = name;
		System.out.println("Creating Thread : "+threadname);
	}

	//This method provides entry point for the thread and you will put your complete business logic inside this method.
	public void run() {
		System.out.println("Running "+threadname);
		try{
			for(int i=4; i>0; i--){
				System.out.println("Thread : "+threadname +" , "+i);
				Thread.sleep(50);      //making artificial slow down or waiting.
			}
		}catch (InterruptedException e){
			System.out.println("Thread "+threadname + " interrupted.");
		}
		System.out.println("Thread "+threadname + " exiting.");
	}

	//Once Thread object is created, you can start the thread by calling start( ) method, which executes a call to run( ) method.
	public void start(){
		System.out.println("Starting "+ threadname);
		if (t==null){
			t = new Thread(this, threadname);
			t.start();
		}
	}
}

public class TestThread {

	public static void main(String[] args) {

		MyRunnableClass R1 = new MyRunnableClass("Thread-1");
		R1.start();

		MyRunnableClass R2 = new MyRunnableClass("Thread-2");
		R2.start();
	}

}
