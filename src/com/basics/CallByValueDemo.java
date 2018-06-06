package com.basics;
import java.awt.Point;
/*
 * Java does Call By Value not call by reference.
 * Arrays.toString() - to see the string values of an array.
 */
import java.util.Arrays;

public class CallByValueDemo {
    int intData;
    Integer integerData = 10;
    int [] arr = {1,2,3};
    
    void changeData(int intData){
    	intData = intData + 5;
    }

    void changeIntegerData(Integer integerData){
    	integerData = integerData + 5;
    }

    void changeArrayData(int ar[]){
    	ar[1] = 5;      //Array ar[] is referenced to arr[] so any change in ar[] will change the contents of arr[]
    }

    /*
	 * Java copies and passes the reference by value, not the object. 
	 * Thus, manipulation will alter the objects, since the references point to the original objects. 
	 * But since the references are copies, swaps will fail.
	 */
    public void tricky(Point arg1, Point arg2){
     	arg1.x = 10;
    	arg1.y = 20;
    	//Try to swap arg1 & arg2. It will 
    	Point temp = arg1;
    	arg1 = arg2;
    	arg2 = temp;
    }
    
	public static void main(String[] args) {
		CallByValueDemo cbv = new CallByValueDemo();
		System.out.println("Before : " + cbv.intData);
		cbv.changeData(5);
		System.out.println("After : " + cbv.intData);

		System.out.println("Before : " + cbv.integerData);
		cbv.changeIntegerData(cbv.integerData);
		System.out.println("After : " + cbv.integerData);

		System.out.println("Before : " + Arrays.toString(cbv.arr));
		cbv.changeArrayData(cbv.arr);
		System.out.println("After : " + Arrays.toString(cbv.arr));
		
		//Try to swap p1 & p2 by calling tricky(). Swap is not possible, but values will get assigned, 
		//Becz Java make a copy of the reference object and pass it to the method. Both the reference points to the same object.
		Point p1 = new Point(0,0);
		Point p2 = new Point(1,2);
		System.out.println("************** Test Array Swaaping in methods ***************");
		System.out.println("Point X :"+p1.x +" Point Y : " + p1.y);
		System.out.println("Point X :"+p2.x +" Point Y : " + p2.y);
		cbv.tricky(p1, p2);
		System.out.println("Point X :"+p1.x +" Point Y : " + p1.y);
		System.out.println("Point X :"+p2.x +" Point Y : " + p2.y);			
	}

}
