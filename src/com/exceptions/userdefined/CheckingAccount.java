package com.exceptions.userdefined;

import com.exceptions.userdefined.*;

/*
 * This class uses the user defined exception to throw the exception using throws and throw keyword. 
 */

public class CheckingAccount {
	private int AccNumber;
	private double Balance;
	
	public CheckingAccount(int AccNo) {
		this.AccNumber = AccNo;
	}
	
	public void deposit(double Amt){
		this.Balance += Amt;
		System.out.println("Depositing Amnt = " + Amt);
	}
	
	public void withdrawl(double Amt) throws InsufficientFundsException{
		System.out.println("Withdrawing Amnt = " + Amt);
		if (Amt <= Balance){
			Balance -= Amt;			
		}else{
			double needs = Amt - Balance;
			throw new InsufficientFundsException(needs);
		}
	}

	public int getAccNumber() {
		return AccNumber;
	}

	public double getBalance() {
		return Balance;
	}

}
