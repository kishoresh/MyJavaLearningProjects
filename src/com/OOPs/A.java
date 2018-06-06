package com.OOPs;
/*
 * Testing Constructors.
 */

abstract class C{    //No Error without any abstract method.
	 void MyMethod1(){
		System.out.println("Test abstract method 1."); 
	 }	 
	 
//	 abstract void MyMethod2(){     //Compile Error - abstract method cannot have body.
//		 System.out.println("Test abstract method 2");
//	 }
	 
	// abstract void MyMethod2();   //Why we cannot override in inner class
	 void MyMethod2(){     //Compile Error - abstract method cannot have body.
		 System.out.println("Test abstract method 2");
	 }
	 
 }
 
 class B{	
	 private B(){
		 
	 }
	 
	 int B(){
		System.out.println("Testing B");
		return 5;
	}
}

public class A {
	protected A(){
		System.out.println("Test Constructor..");
		//super();    //Error : "Constructor call must be the first statement in a constructor"
	}
	
	int A(){    //Observe, the same name as constructor with return type. This is not considered as constructor.
		System.out.println("Ä method called.");
		return 2;
	}
	
	public static void main(String[] args) {
		A a = new A();
		System.out.println("A class called.");
		int i = a.A();
		
		//C c = new C();               //Compile error, as C is abstract.
		C innerClass = new C() {       //Anonymous Inner class.so innerClass is an instance of a anonymous inner child class of parent class C.
			//void MyMethod2()        //?????????
		};
		innerClass.MyMethod2();
	}
}

