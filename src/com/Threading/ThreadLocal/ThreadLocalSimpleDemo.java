package com.Threading.ThreadLocal;


public class ThreadLocalSimpleDemo{
	
	public static class MyRunnable implements Runnable{
		private ThreadLocal<Double> threadLocal = new ThreadLocal<>();
		
		@Override
		public void run() {
			Double d = 0.0;
			System.out.println(Thread.currentThread() + "[Thread Local Value 1] - " + d); //threadLocal.get());
			threadLocal.set(Math.random() *100);
			d = Math.random() * 1000;			
			System.out.println(Thread.currentThread() + "[Thread Local Value 2] - " + d); //threadLocal.get());
			try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread() + "[Thread Local Value 3] - " + d); //threadLocal.get());
			//System.out.println(Thread.currentThread() + "[Non-Thread Local Value] - " + d);
		}
	}
	
	public static void main(String[] args) {
		MyRunnable myRunnable = new MyRunnable();
		
		Thread th1 = new Thread(myRunnable);
		Thread th2 = new Thread(myRunnable);
		Thread th3 = new Thread(myRunnable);
		
		th1.start();
		th2.start();
		th3.start();
		
//		try {
//			th1.join();
//			th2.join();
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}		
	}

}
