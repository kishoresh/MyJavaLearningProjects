package com.designpattern.creational.abstractfactory;

public class HomeLoan extends Loan {

	@Override
	void getInterestRate(double rt) {
		rate = rt;

	}

}
