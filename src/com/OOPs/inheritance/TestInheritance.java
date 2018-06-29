package com.OOPs.inheritance;
/*
 * Test miscellaneops :
 * 1. Abstract class cannot be instatiated. Compile time error.
 * 2. If there is an abstract method inside a class, the Class have to be declared as an abstract. Compile time error.
 * 3. Once an abstract class is sub-classed, the abstract method has to be implemented in the sub-class.
 */
interface A{
	abstract void draw();
	default void draw2(){
		System.out.println("Default draw2 method");
	}	
}

interface B{
	Integer i=10;
	Integer addable(int a, int b);
	Integer addable(int c, int d, int e);
}

abstract class ClassC{ //implements A,B{
	public ClassC() {
		System.out.println("Constructor classAB called");
	}
	
//	ClassC(String n){
//		System.out.println(n);		
//	}
	
	protected String myName(String name){
		return "My name is " + name;		
	}
	abstract String myName2(String n);
	abstract String myName3(String n);
	public Integer addable(int c, int d, int e){    
		return 1;
	}

}

class classD extends ClassC{
	public classD() {
		System.out.println("Constructor ClassD");
	}

	public classD(String a) {
		System.out.println("2nd Constructor ClassD");
	}
	
	@Override
	protected String myName(String name) {		
		name = name + "Inside " + this.getClass().getName();
		return super.myName(name);
	}
	@Override
	String myName2(String n) {		
		return "Returning from myName2(). ";
	}
	@Override
	String myName3(String n) {
		return "Returning from myName3(). ";
	}
}

public class TestInheritance {

	public static void main(String[] args) {
		ClassC c = new ClassC() {
			String s;
			@Override
			String myName3(String n) {				
				return null;
			}
			
			@Override
			String myName2(String n) {
				return null;
			}
		};
		c.myName3("Test");
	}

}
