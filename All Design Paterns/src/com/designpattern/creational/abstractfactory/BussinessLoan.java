package com.designpattern.creational.abstractfactory;

public class BussinessLoan extends Loan {

	@Override
	void getInterestRate(double rt) {
		rate = rt;

	}

}
