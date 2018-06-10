package com.exercises.hackerrank;
/*
 * Exception once catched does not flow to the last catch block.
 */
class Base{
	void exceptMethod(){
		System.out.println("I am in Base class.");
		throw new RuntimeException("Exception in base class.");
	}
}

class A extends Base{
    @Override
    void exceptMethod() {
    	try{
    	System.out.println("I am in class A");
    	super.exceptMethod();    
    	}catch (Exception e){
    		System.out.println(e.getMessage());
    	}finally{
    		System.out.println("Finally");
    	}
    }	
}

public class CatchExcptionTest {

	public static void main(String[] args) {
		A a = new A();
		try{
		a.exceptMethod();
		}catch (Exception e){
			System.out.println("Exception : " + e.getMessage());
		}

	}

}
