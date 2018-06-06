package com.OOPs.abstraction;

import java.sql.SQLException;

/*
 * Abstract class Demo :
 * Define an abstract class Bank and extend it to 2 subclass.
 */
abstract class Bank{
	private int IFCCode;
	public void deposit(){
		System.out.println("Common Deposit method implementation.");
	}
	public void withdraw(){
		System.out.println("Common Withdraw method implementation.");
	}
	
	public abstract int calculateInterest();  //This method has to be implemented in the subclass as it is abstract
	protected void setIFCCode(int code){      //Optional, may not be implemented in the subclass as it is not abstract.
		IFCCode =  code;
	}
	//protected abstract void setIFCCode();
	
	//Testing Exception with overriding method
	protected void dummyMethod() throws SQLException{
		System.out.println("Calling dummy method with SQLException");
	}
}

class HDFCBank extends Bank{
	@Override
	public int calculateInterest() {                    //If this is not overriden, compiler error.
	    System.out.println("Calculate interest in HDFC Bank.");
		return 0;
	}

/*	@Override
	protected void dummyMethod(){     //if throws SQLException is excluded, we need to catch the exception
	 try{
		super.dummyMethod();
		System.out.println("Calling overrident method dummyMethod");
	 }catch (SQLException e){
		 e.printStackTrace();
	 }  
	 	 
	} */
}

class ICICIBank extends Bank{
    @Override                                          //If this is not overriden, compiler error.
	public int calculateInterest() {
	   System.out.println("Calculate interest in ICICI Bank.");
		return 0;
	}	
}

public class AbstractDemo {
	public static void main(String[] args) {
		HDFCBank hdfcBank = new HDFCBank();
		hdfcBank.deposit();
		hdfcBank.withdraw();
		hdfcBank.calculateInterest();

		ICICIBank iciciBank = new ICICIBank();
		iciciBank.deposit();
		iciciBank.withdraw();
		iciciBank.calculateInterest();
	}

}
