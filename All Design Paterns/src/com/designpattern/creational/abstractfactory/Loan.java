package com.designpattern.creational.abstractfactory;

public abstract class Loan {
	protected double rate;
	abstract void getInterestRate(double rt);

	public void calculateLoanPayment(double loanAmt, int Years){
		double EMI;
		int n;  //no of monthly installments.
		n = Years * 12;
		rate = rate/1200;
		EMI= ((rate*Math.pow((1+rate),n))/((Math.pow((1+rate),n))-1))*loanAmt;
		System.out.println("your monthly EMI is "+ EMI +" for the amount"+loanAmt+" you have borrowed");
	}


}
