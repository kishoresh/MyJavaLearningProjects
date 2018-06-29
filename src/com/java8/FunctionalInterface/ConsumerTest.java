package com.java8.FunctionalInterface;
/*
 * Demo of the Consumer Interface :
 * https://dzone.com/articles/supplier-and-consumer-interface-in-java8
 */
import java.util.function.Consumer;
import java.util.function.IntConsumer;

public class ConsumerTest {

	public static void main(String[] args) {
		Consumer<String> consumer1 = (arg) ->{
			System.out.println(arg + " Ok");
		};
		//consumer1.accept("Testing Consumer");
		
		Consumer<String> consumer2 = (arg) ->{
			System.out.println(arg + " Ok Baba.");
		};
		
		consumer1.andThen(consumer2).accept("Testing Consumer");	
		
	}
}
