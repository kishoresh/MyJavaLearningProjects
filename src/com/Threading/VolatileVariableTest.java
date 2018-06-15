package com.Threading;

import java.util.Scanner;

/*
 * Usage of Volatile variable :
 * Here the variable counting can be modified from outside the thread with stopCounting(). But the main thread may sometime may not take the main value, and instead carry on with the value with it. 
 */

class Counter extends Thread{
	private volatile Boolean counting = true;
	private int counter = 1;
	@Override
	public void run() {
		while(counting){
			System.out.println(counter);
			counter++;
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}		
	}
	
	public void stopCounting(){
		counting = false;
	}
}

public class VolatileVariableTest {

	public static void main(String[] args) {
		Counter c = new Counter();
		c.start();
		
		Scanner sc = new Scanner(System.in);
		sc.nextLine();
		
		c.stopCounting();  //This will update the local variable, but the Thread within the run() method may not get the changed value. To solve this make it volatile.
		//Once made volatile, the running thread, must always check the value of counting in the main thread i.e. outside the run method.
	}
}
