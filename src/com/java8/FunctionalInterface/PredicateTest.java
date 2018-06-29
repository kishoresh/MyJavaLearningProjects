package com.java8.FunctionalInterface;
/*
 * Test for the Predicates FI :
 * https://www.geeksforgeeks.org/java-8-predicate-with-examples/
 */
import java.util.function.Predicate;

public class PredicateTest {

	public static void main(String[] args) {
		Predicate<Integer> lesserNumber = i -> i <10;
		System.out.println(lesserNumber.test(12));

		Predicate<Integer> greaterThanTen = i -> i > 10;
		Predicate<Integer> lesserThanTwenty = i -> i < 20;
		
		System.out.println(greaterThanTen.and(lesserThanTwenty).test(15));
		System.out.println(greaterThanTen.and(lesserThanTwenty).test(25));
	}

}
