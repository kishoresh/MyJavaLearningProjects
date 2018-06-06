package com.Threading.ThreadLocal;

public class ThreadLocalDemo extends Thread{
	
	@Override
	public void run() {
		Context context = new Context();
		context.setTransactionId(getName());
		context.setUserId("Kishore Sharma");
		
		MyThreadLocal.set(context);
		
		
	}
	

	public static void main(String[] args) {
		ThreadLocalDemo th1 = new ThreadLocalDemo();
		th1.start();
		
		ThreadLocalDemo th2 = new ThreadLocalDemo();
		th2.start();

	}

}
