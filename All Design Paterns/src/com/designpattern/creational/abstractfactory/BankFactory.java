package com.designpattern.creational.abstractfactory;

public class BankFactory extends AbstractFactory {

	@Override
	public Bank getBank(String bankName) {
		if (bankName == null)
			return null;
		if (bankName.equalsIgnoreCase("HDFC"))
			return new HDFCBank();
		else if (bankName.equalsIgnoreCase("ICICI"))
			return new ICICI();
		else if (bankName.equalsIgnoreCase("SBI"))
			return new SBI();
		return null;
	}

	@Override
	public Loan getLoan(String loanName) {
		return null;
	}

}
