package com.OOPs.inheritance;

class ParentClass{
	private int i;
	public ParentClass() {
		System.out.println("Parent Class constructor called.");
	}
	
	public ParentClass(int i){
		System.out.println("Parent Class constructor 2 called.");
		i = i;
	}
	
	public ParentClass(int i, int j){
		System.out.println("Parent Class constructor 3 called.");
	}
	
	public void disp(){     //This method can be overriden in the descendand class if it is in the same package.
		System.out.println("Parent Class disp() method called.");		
	}

}

class ChildClass extends ParentClass{
	public ChildClass() {
		//super(1);     //If this is not specified, Parent constructor is automatically called.
		super(1,2);
		System.out.println("Child Class constructor called.");
		
		//super();  Compiler error - Super() must me the first statement in a constructor.
	}	
	
	public void disp(){
		System.out.println("Child Class disp() method called.");
		super.disp();     //This is allowed. Only in case of Constructor super() has to be the 
	}
}

public class ConstructorDemo {
	
	public static void main(String[] args) {
		ChildClass child = new ChildClass();
		child.disp();

	}

}
