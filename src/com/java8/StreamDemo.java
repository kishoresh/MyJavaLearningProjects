package com.java8;
/*
 * Stream API (java.util.stream ) : introduce in 1.8 to support functional style of operations on stream of elements.
 * 1. Using Stream - Sum of all the integers > 10. See the diff using Collection Iterator & Stream
 * 2. Print 10 random numbers using limit
 */
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class StreamDemo {
	
	public static Integer sumUsingIterator(List<Integer> list){
		Iterator<Integer> itr = list.iterator();
		Integer sum = 0;
		while (itr.hasNext()){
			int num = itr.next();
			if (num > 10){
				sum += num;
			}
		}
		return sum;
	}
	
	public static Integer sumUsingStream(List<Integer> list){
		return list.stream()
				.filter(i -> i > 10) //Intermediate Operation : Returns a new stream. It does not actually perform any filtering, but instead creates a new stream that, when traversed, contains the elements of the initial stream that match the given predicate.
				.mapToInt(i -> i)    //Terminal Operation : Traverse the stream to produce a result. After traversal, the stream pipeline is considered consumed, and can no longer be used;
				.sum();
	}

	public static void main(String[] args) {
		//1. Using Stream - Sum of all the integers > 10. See the diff using Collection Iterator & Stream
		List<Integer> l = new ArrayList<>();
		for(int i=0; i<100; i++){
			l.add(i+1);
		}
		System.out.println("Sum of all the integers > 10 [Using Iterator] = " + sumUsingIterator(l));
		System.out.println("Sum of all the integers > 10 [Using Stream] = " + sumUsingStream(l));		

		//2. Print 10 random numbers using limit
		Random randomNums = new Random();
		randomNums.ints().limit(10).forEach(System.out :: println);
	}

}
