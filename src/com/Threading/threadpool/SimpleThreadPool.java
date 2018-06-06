package com.Threading.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class WorkerThread implements Runnable{
	private String command;
	public WorkerThread(String s){
		this.command=s;
	}

	public void run() {
		System.out.println(Thread.currentThread().getName()+" Start. Command =" + command);
		processCommand();
		System.out.println(Thread.currentThread().getName()+" End.");
	}

	private void processCommand(){
		try{
			Thread.sleep(5000);
		}catch (InterruptedException e){
			e.printStackTrace();
		}
	}
}

public class SimpleThreadPool {

	public static void main(String[] args) {
		ExecutorService executor = Executors.newFixedThreadPool(2);
		for(int i=0; i<10; i++){
			Runnable worker = new WorkerThread(" " + i);
			executor.execute(worker);
		}
		while(!executor.isTerminated()){
		}
		System.out.println("Finished all Threads");
	}

}
