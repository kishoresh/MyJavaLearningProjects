package com.Threading.threadpool.executorService;
/*
 * Creating diff types of ThreadPool using ExecutorService. Thread pool internally uses BlockingQueue which picks up task's in a concurrent way.
 * Types of ThreadPool :
 * 1. FixedThreadPool     : Limit the number of concurrent threads and queue the additional tasks.
 * 2. CachedThreadPool    : Keeps a number of alive threads and creates new ones as needed. 
 * 3. ScheduledThreadPool : Schedule tasks to execute after a given delay, or to execute periodically.
 * 4. SingleThreadedExecutor : Keeps only one thread executing one task at a time. Ensures that tasks are running sequentially.
 */
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

//Runnable Task, to be run in threads.
class Task implements Runnable{
	String threadname;
	public Task(String name) {
		this.threadname = name;
	}
	
	public void run() {
		System.out.println("Thread Name : " + Thread.currentThread().getName() + " " + threadname);
		try{
			//fake computation time.
			Thread.sleep(1000);	
		}catch (InterruptedException ex){
			ex.printStackTrace();
		}		
	}
}

public class TestExecutorService {

	static public void createThreads(){
		for(int i=0; i < 100; i++){
			Thread th = new Thread(new Task("Task-"+i));
			th.start();
		}
	}
	
	/* Fixed Thread Pool : 
	 * This demonstrates how to create a FixedThreadPool executor to execute a Runnable task. 
	 * Key behavior : Limiting the number of concurrent threads and queuing the additional tasks.
	 */
	static public void createThreadsUsingFixedThreadPool(){
		ExecutorService execService = Executors.newFixedThreadPool(5);
		for(int i=0; i < 100; i++){
			execService.execute(new Task("Task-"+i));
		}		
		execService.shutdown();  //Destroys the executor. If this is not called, observe that the program is still running afterward.
	}
	
	/*
	 * SingleThreadExecutor : Only one thread is used to run the task's. Hence the tasks are executed in sequence.
	 */
	static public void createThreadUsingSingleThreadedExecutor(){
		ExecutorService execService = Executors.newSingleThreadExecutor();
		for(int i=0; i < 100; i++){
			execService.execute(new Task("Task-" + i));
		}
		execService.shutdown();
	}
	
	/*
	 * Schedule Thread Pool : Schedule tasks to execute after a given delay, or to execute periodically.
	 */
	static public void createSchudeledThreadPool(){
		ScheduledExecutorService execService = Executors.newScheduledThreadPool(10);
		//Schedule a task to run after 10 ses delay
		//execService.schedule(new Task("Task-"+1), 10, TimeUnit.SECONDS);
		
		//Schedule a task to run repeatedly after every 10 secs, after an initial delay of 5 secs
		execService.scheduleAtFixedRate(new Task("Task"), 5, 10, TimeUnit.SECONDS);		
		
		//execService.shutdown();
	}
	
	/*
	 * Cached Thread Pool : Keeps a number of alive threads and creates new ones as needed.
	 */
	static public void createCachedThreadPool(){
		ExecutorService execService = Executors.newCachedThreadPool();  //Note, pool size not required, as it can comprise of many thread, depending on the availability of thread.
		for(int i=0; i < 100; i++){
			execService.execute(new Task("Task-" + i));
		}
		execService.shutdown();
	}
	
	public static void main(String[] args) {
		//createThreads();
		//createThreadsUsingFixedThreadPool();
		//createThreadUsingSingleThreadedExecutor();
		//createSchudeledThreadPool();
		createCachedThreadPool();
	}

}
