package com.Threading.thread;
/*
 * Simple Thread demo
 */
class MyThreadClass extends Thread {
	private Thread t;
	private String threadname;

	public MyThreadClass(String name) {
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
		}catch (InterruptedException e){  //Without catching this error it will not compile.
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
		MyThreadClass T1 = new MyThreadClass("Thread-1");
		T1.start();

		MyThreadClass T2 = new MyThreadClass("Thread-2");
		T2.start();
	}

}
