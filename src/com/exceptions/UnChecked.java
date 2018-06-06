package com.exceptions;

public class UnChecked {

	public static void main(String[] args) {
		try{
			int i[] = new int[2];
			System.out.println(i[3]);
			
		   //Trying to access an element which does not exist, we get an exception while running.	
		}catch (ArrayIndexOutOfBoundsException e){
			System.out.println(e.getStackTrace());
		}
		
		

	}

}
