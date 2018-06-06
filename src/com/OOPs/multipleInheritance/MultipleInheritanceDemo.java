package com.OOPs.multipleInheritance;

import com.sun.corba.se.impl.orb.ParserTable.TestORBInitializer1;

/*
 * Multiple Inheritance example.
 * 1. All methods are implicitly public and abstract, we do not have to declare it. 
 * 2. Methods must not be static. If static, body must be there. Cannot be final, as methods are abstract and meant to be overriden.
 * 3. All variables must be public, static and final, i.e. interface can declare only constants, no instance variables.
 * 
 */
interface I1{
	void test(int i);  
	void test(String s);
	static void test3(){
		//Body has to be defined
	}
	//final void test4();   //Compile error, as final is not allowed.
}

interface I2{
	int testInt = 23;    //Has to be initialized, otherwize error.
	void test(int j);                   //See this method is in both the interfaces
	void msg();	
}

public class MultipleInheritanceDemo implements I1, I2{
	int i = testInt;
	//testInt = 45;    //Error, cannot be initialized again.
	
	@Override
	public void test(int i) {
		System.out.println("In Multiple Inheritance - test(int)");		
	}
	
	@Override
	public void test(String s) {
		System.out.println("In Multiple Inheritance - test(string) " + s);		
	}
	
	@Override
	public void msg() {
		System.out.println("In Multiple Inheritance - msg()");			
	}
	
	public static void main(String[] args) {
		I1 mid = new MultipleInheritanceDemo();
		mid.test("Kishore");
		//mid.msg()    //compiler error, since it is not defined in I1

	}

}
