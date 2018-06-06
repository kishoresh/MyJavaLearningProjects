package com.Threading.deadlock;

class SyncThread implements Runnable{
	Object obj1;
	Object obj2;
	
	public SyncThread(Object obj1, Object obj2) {
		this.obj1 = obj1;
		this.obj2 = obj2;
	}
	
	@Override
	public void run() {
		String name = Thread.currentThread().getName();
		System.out.println(name + " acquiring lock on " + obj1);
		
		synchronized (obj1) {       //Synchronized Block-1 : Here obj1 goes to a BLOCKED state after work()
			System.out.println(name + " acquired lock on " + obj1);
			work();
			
			System.out.println(name + " acquiring lock on " + obj2);
			synchronized (obj2) {  //Synchronized Block-2
				System.out.println(name + " acquired lock on " + obj2);
				work();
			}
			System.out.println(name + " released lock on " + obj2);
		}
		System.out.println(name + " released lock on " + obj1);
		System.out.println(name + " finished execution.");		
	}
	
	private void work(){
		try{
			Thread.sleep(30000);
			System.out.println("Woke up from sleep.");
		}catch (InterruptedException e){
			e.printStackTrace();
		}
	}
}

public class ThreadDeadlock {

	public static void main(String[] args) {
		try{
			Object obj1 = new Object();
			Object obj2 = new Object();
			Object obj3 = new Object();

			Thread t1 = new Thread(new SyncThread(obj1, obj2), "t1");
			Thread t2 = new Thread(new SyncThread(obj2, obj3), "t2");
			Thread t3 = new Thread(new SyncThread(obj3, obj1), "t3");

			t1.start();
			Thread.sleep(5000);
			t2.start();
			Thread.sleep(5000);
			t3.start();		
		}catch (InterruptedException e){
			e.printStackTrace();
		}
	}

}
