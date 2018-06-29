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
import java.util.stream.IntStream;
import java.util.stream.Stream;

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
				.mapToInt(i -> i)    
				.sum();              //Terminal Operation : Traverse the stream to produce a result. After traversal, the stream pipeline is considered consumed, and can no longer be used;    
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
		
		//1. IntStream - display numbers  1 - 99
		//IntStream.range(1, 100) .forEach(System.out :: println);
		
		//2. IntStream - display numbers  1 - 99, but skip from 22nd and then 66nd place.
		//IntStream.range(1, 100).skip(22).skip(66) .forEach(x -> System.out.println(x));
		
		//3. Return a sum of the integer.
		int i = IntStream.range(1, 100).sum();
		System.out.println("Sum = " + i);
		
		ArrayList<String> names = new ArrayList<>();
		names.add("Kishore");
		names.add("Supriya");
		names.add("Abhisekh");
		names.add("Basil");
		names.add("Basil");
		names.add("Balaji");
		
		//4. Using Stream with List - filter, sort easily
		//names.stream().filter(x -> x.startsWith("B")).sorted().forEach(System.out :: println);
				
		//5. Remove duplicates from the List and store it in another list.
		List<String> list = new ArrayList<>();		
		names.stream().distinct().forEach( e-> list.add(e));
		for (String string : list) {
			System.out.println(string);
		}
		
		
	}

}
