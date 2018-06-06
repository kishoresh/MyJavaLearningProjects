package com.designpattern.creational.abstractfactory;

/*
 * Factory class to get the objects for Bank & Loan.
 */
public abstract class AbstractFactory {

	public abstract Bank getBank(String bankName);
	public abstract Loan getLoan(String loanName);


}
