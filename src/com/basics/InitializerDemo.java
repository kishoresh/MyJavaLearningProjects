package com.basics;
/*
 * Initializer Block :
 * Instance Initializer block : 
 *  - Used for initializing instance data members. 
 *  - Can access both instance & static data member. 
 *  - Called each time an instance is created.
 * Static Initializer block :
 * - Called  once when the class is loaded.
 * - Can access only staic data member.
 */
public class InitializerDemo {
	static int i =0;
	int j;
	
	{    //instance initializer
		System.out.println("instance initializer called.");
		i=10;
		j=5;		
	}
	static
	{
		System.out.println("Static initializer called.");
		i=12;
		//j=10;    //Compiler error, as only static method can be called.
	}
	public void AnyMethod(){
		System.out.println("Any Method");
	}

	
	public static void main(String[] args) {
		InitializerDemo id1 = new InitializerDemo();
		id1.AnyMethod();
		
		InitializerDemo id2 = new InitializerDemo();
		id2.AnyMethod();
		
	}

}
