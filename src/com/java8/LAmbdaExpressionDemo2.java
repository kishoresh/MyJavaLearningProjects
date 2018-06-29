package com.java8;
/*
 * Testing Lambda expression interfaces 
 */
interface MyFunction{
	void apply(String s);
	default void display(String s){
		System.out.println("Testing default method " + s);
	}
	static void print(String s){
		System.out.println("Testing static method + " + s);
	}
}

public class LAmbdaExpressionDemo2 {

	public static void main(String[] args) {
		MyFunction func = s ->	System.out.println(s);
			
		func.apply("Kishore");
		func.display("Kishore");
		MyFunction.print("Sharma");
	}

}
