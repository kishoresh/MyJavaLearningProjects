package com.Threading.threadpool.exercise;
/*
 * There are 6 tasks - Task1...Task6. Task6 needs to be executed after completion of Task5 only.
 * 1. Only 5 task's - Task5 have to run only when Task4 is complete.
 * 2. 100 Task's - Group of 5 Task's with the 5th one dependent on 4th task.
 */
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

class RunnableTask implements Runnable{
	String threadname;
	public RunnableTask(String tn) {
		this.threadname = tn;
	}
	
	@Override
	public void run() {
		System.out.println("Thread Name : " + Thread.currentThread().getName() + " " + threadname);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}	
	}
}

class CallableTask implements Callable<Boolean>{
	String threadname;
	public CallableTask(String tn) {
		this.threadname = tn;
	}

	@Override
	public Boolean call() throws Exception {
		System.out.println("Thread Name : " + Thread.currentThread().getName() + " " + threadname);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}	
		return true;
	}	
}

public class TestCallable {
	//Task1..Task3 is run sequentially and then the Callable Task is run which returns True/False.
	//Depending on the future value, the Dependent task is executed.
	public static void executeFewTaskSequentially(){
		ExecutorService execService = Executors.newFixedThreadPool(5);
		execService.execute(new RunnableTask("RunnableTask-1"));
		execService.execute(new RunnableTask("RunnableTask-2"));
		execService.execute(new RunnableTask("RunnableTask-3"));
		//Return value of the Callable task is stored
		Future<Boolean> future = execService.submit(new CallableTask("CallableTask-4"));
		try {
			//if future returns TRUE, call the Dependent task.
			if (future.get()){ 
					execService.execute(new RunnableTask("DependentTask-5"));
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (ExecutionException e) {
				e.printStackTrace();
			}
		execService.shutdown();
	}

	//Here, if more than 5 task comes, i.e. a group of 5 task, we run Task1..Tas3 sequentially and then the 4th Task as a Callable task which returns future value.
	//All the Future values are stored in an ArrayList. Later reading the future value we call the dependent task's.
	public static void executeMultipleTaskSequentially(){
		int n = 20;
		ExecutorService execService = Executors.newFixedThreadPool(5);
		//Store Futures of all the Callable task's
		List<Future<Boolean>> futureList = new ArrayList<>();
		for (int i = 1; i < n; i++) {
			execService.execute(new RunnableTask("RunnableTask-" + i));
			i++;
			execService.execute(new RunnableTask("RunnableTask-" + i));
			i++;
			execService.execute(new RunnableTask("RunnableTask-" + i));
			i++;
			Future<Boolean> future = execService.submit(new CallableTask("CallableTask-" + i));
			i++;
		
			futureList.add(future);
		}
		
		//Now, run all the dependent task by reading the future value from the arraylist.
		for (int i = 0,j=1; i < n/5; i++,j++) {
			try {
				if (futureList.get(i).get()){ 
					execService.execute(new RunnableTask("DependentTask-" + j*5));
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (ExecutionException e) {
				e.printStackTrace();
			}
		}
		execService.shutdown();
	}
	
	public static void main(String[] args) {
		
		//executeFewTaskSequentially();
		executeMultipleTaskSequentially();
	}

}
