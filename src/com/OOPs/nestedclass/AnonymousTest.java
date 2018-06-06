package com.OOPs.nestedclass;
/* 
 * Anonymous class : Class without name.
 * 
 */
interface Animal{
	void type();
}

public class AnonymousTest {

	public static void main(String[] args) {
		
		Animal an = new Animal() {   //Anonymous class created.
			@Override
			public void type() {
				System.out.println("Anonymous animal.");				
			}
		};
			
		an.type();
	}

}
