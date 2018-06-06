package com.Threading.threadpool.forkjoinpool;

import java.util.concurrent.RecursiveTask;

public class ForkJoinTest {
	static int[] numbers = new int[100000000];
	static void populateNumbersArray(){
		for (int i=0; i < numbers.length; i++){
			numbers[i] = i;
		}
	}
	static long computeNumbersArray(){
		long sum = 0;
		for (int i=0; i < numbers.length; i++){
			sum +=numbers[i];
		}
		return sum;
	}
	
	public static void main(String[] args) {
		populateNumbersArray();
		
		//Try it manually first.
		long st = System.currentTimeMillis();
		System.out.println("Sum [Without Thread] = " + computeNumbersArray());
		long et = System.currentTimeMillis();
		System.out.println("Time taken : " + (et - st));
		
		long st1 = System.currentTimeMillis();
		System.out.println("Sum [With Thread] = " + computeNumbersArray());
		long et1 = System.currentTimeMillis();
		System.out.println("Time taken : " + (et - st));
	}

	//RecursiveTask to be called recursively..
	static class Sum extends RecursiveTask<Long>{
		int low;
		int high;
		int[] arr;
		
		public Sum(int[] ar, int l, int h) {
			this.low = l;
			this.high = h;
			this.arr = ar;
		}
		
		@Override
		protected Long compute() {
			//If there is less numbers to compute (<=10), no need to call recusively again.
			if (high - low <=10){
				long sum = 0;
				for(int i=low; i<high; i++)
					sum +=arr[i];
				return sum;
			}else { //There are more than 10 numbers, yet to be computed, so call them recursively.
				int mid = low + (high - low) / 2;    //e.g. 1 + (50-1) /2 = 25
				Sum left  = new Sum(arr, low, mid);
				Sum right = new Sum(arr, mid, high);
				left.fork();
				long rightresult = right.compute();
				long leftResult = left.join();
				return leftResult + rightresult;
			}			
		}
	}

}
