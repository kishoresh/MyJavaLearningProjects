package com.java8;

import java.util.ArrayList;
import java.util.Random;

public class ParallelStreamDemo {
	public static int f(int n){
		for (int i=1; i < 1000; i++){
			n = (n^i) % i;
			if (n <= 0)
				n = 10;
		}
		return n;
	}
	public static void main(String[] args) {
		Random rnd = new Random();
		ArrayList<Integer> data = new ArrayList<>();
		for (int i=0; i < 100000; i++){
			data.add(rnd.nextInt());
		}
		long starttime = System.currentTimeMillis();
		System.out.println("Starting ");
		int result = 0;
		for (int i : data){
			result += f(i);
		}
		long endtime = System.currentTimeMillis();
		System.out.println("Result = " + result);
		System.out.println("Total time in millisecs = " + (endtime - starttime));
		long stime = System.currentTimeMillis();
		int res = data.parallelStream() .map(i -> f(i)).reduce(Integer ::sum).get();
		long etime = System.currentTimeMillis();
		System.out.println("Result = " + res);
		System.out.println("Total time in millisecs = " + (etime - stime));

	}

}
