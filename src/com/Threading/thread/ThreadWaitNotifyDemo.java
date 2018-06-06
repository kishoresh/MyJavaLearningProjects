package com.Threading.thread;
/*
 * wait() & notify() demo :
 * Two threads calls the withdraw() & deposit() method of the same Customer obj.
 * T1 puts a wait() on the obj and T2 calls a notify() on the same obj.
 */

class Customer{
	int amount = 10000;

	synchronized void withdraw(int amt){
		System.out.println("Going to Withdraw...");
		if (amount < amt){
			System.out.println("Less balance. Will wait for deposit...");
			try {
				wait();   //Execution will wait at this point, unless this object gets a notify()
			} catch (InterruptedException e) {
				e.printStackTrace();
			}		
		}
		this.amount -= amt;
		System.out.println("Withdrawl completed. Balance = " + this.amount);			
	}
	
	synchronized void deposit(int amt){
		System.out.println("Going to Deposit...");
		this.amount += amt;
		System.out.println("Deposit completed..");
		notify();   //If some thread is waiting, this will wake up that thread. 
	}
}

public class ThreadWaitNotifyDemo {

	public static void main(String[] args) {
		Customer c = new Customer();  //Note the same obj is passed in both the threads.
		new Thread(){    //T-1
			public void run() {
				c.withdraw(15000);
			}
		}.start();
		
		new Thread(){    //T-2
			public void run() {
				c.deposit(10000);
			}
		}.start();
	}
}
