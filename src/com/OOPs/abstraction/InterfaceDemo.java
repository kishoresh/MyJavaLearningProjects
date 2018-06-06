package com.OOPs.abstraction;
/*
 * Simple Interface implementation.
 */
class SBIBank implements BankInterface{
	@Override
	public void deposit() {
		System.out.println("SBIBank.deposit() - BankInterface implemented.");		
	}
	
	@Override
	public void withdraw() {
		System.out.println("SBIBank.withdraw() - BankInterface implemented.");		
	}
	
	@Override
	public void calculateInterest() {
		System.out.println("SBIBank.calculateInterest() - BankInterface implemented.");		
	}
}

class YesBank implements BankInterface{
	@Override
	public void deposit() {
		System.out.println("YesBank.deposit() - BankInterface implemented.");		
	}
	@Override
	public void withdraw() {
		System.out.println("YesBank.withdraw() - BankInterface implemented.");		
	}
	@Override
	public void calculateInterest() {
		System.out.println("YesBank.calculateInterest() - BankInterface implemented.");		
	}
}

public class InterfaceDemo {

	public static void main(String[] args) {
		BankInterface SBI = new SBIBank();
		SBI.deposit();
		SBI.withdraw();
		SBI.calculateInterest();
		
		BankInterface YesBank = new YesBank();
		YesBank.deposit();
		YesBank.withdraw();
		YesBank.calculateInterest();
	}

}
