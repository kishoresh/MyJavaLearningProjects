package com.Threading.deadlock;
/*
 * Simple deadlock demo :
 * Synchronize 2 strings str1 & str2 in 2 threads in opposite orders in the run() method and start the threads one after another.
 */
public class SimpleDeadlockDemo {
	String str1 = "Kishore";
	String str2 = "Milli";
	
	Thread trd1 = new Thread("Thread1"){
		public void run() {
			while(true){
				synchronized (str1) {
					synchronized (str2) {
						System.out.println(str1 + str2);
					}
				}
			}
		}
	};
	
	Thread trd2 = new Thread("Thread2"){
		public void run() {
			while(true){
				synchronized (str2) {
					synchronized (str1) {
						System.out.println(str1+str2);
					}
				}
			}
		}
	};

	public static void main(String[] args) {
		SimpleDeadlockDemo test = new SimpleDeadlockDemo();
		test.trd1.start();
		test.trd2.start();

	}

}
