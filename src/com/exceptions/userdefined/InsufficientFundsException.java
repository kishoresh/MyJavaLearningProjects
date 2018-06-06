package com.exceptions.userdefined;

/*
 * User defined Exception class InsufficientFundsException
 * This exception will be raised, if the Bank account have a low balance in his account and user tries to withdraw.
 */
public class InsufficientFundsException extends Exception {
	
	private double less_amount;
	
	public InsufficientFundsException(double less_amt) {
		this.less_amount = less_amt;
	}

	public double getLess_amount() {
		return less_amount;
	}

}
