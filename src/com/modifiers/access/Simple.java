package com.modifiers.access;

class A{
	private int data=40;
	protected void msg(){
		System.out.println("Testing Simple Access Modifiers");
	}
}

public class Simple extends A{

	protected void msg(){   //The default modifier is more restrictive than protected. That is why there is compile time error. Add protected or public, it would work
		System.out.println("Testing Simple Access Modifiers");
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		A objA = new A();
		//System.out.println(objA.data);  //Compile time error, as trying to access private member.
		objA.msg();
		int i = 10;
		int j = i;
		System.out.println();

	}

}
