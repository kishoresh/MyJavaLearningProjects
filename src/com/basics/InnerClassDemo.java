package com.basics;
/*
 * Inner Class Demo :
 * 1. How to initialize with a static inner class.
 * 2. How to initialize with a non-static inner class.
 * 3. We cannot accesses the private variable from within the static inner class.
 */
class OuterClass{
	int num = 100;	
	static class NestedStaicClass{
		public void myMethod(){
			//System.out.println("This is my nested class method. Num = " + num); //Compile Error - Cannot refer non static member num within a static class
			System.out.println("This is my nested class method.");
		}
	}

	class NestedClass{
		public void myMethod(){
			System.out.println("This is my nested class method. Num = " + num);
		}
	} 
}

public class InnerClassDemo {

	public static void main(String[] args) {
		// Calling method from an inner class which is static.
		OuterClass.NestedStaicClass nested1 = new OuterClass.NestedStaicClass();
		nested1.myMethod();
		//Calling method from an inner class, and accessing the outer class private variable.
		OuterClass.NestedClass nested2 = new OuterClass().new NestedClass();
		nested2.myMethod();	
	}

}
