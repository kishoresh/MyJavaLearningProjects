package com.designpattern.creational.abstractfactory;

public class LoanFactory extends AbstractFactory {

	@Override
	public Bank getBank(String bankName) {
		return null;
	}

	@Override
	public Loan getLoan(String loanName) {
		if (loanName == null)
		return null;
		if (loanName.equalsIgnoreCase("HomeLoan"))
			return new HomeLoan();
		if (loanName.equalsIgnoreCase("Educational"))
			return new EducationalLoan();
		if (loanName.equalsIgnoreCase("Bussiness"))
			return new BussinessLoan();
		return null;
	}

}
