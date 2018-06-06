package com.exceptions.userdefined;

public class BankDemo {

	public static void main(String[] args) {
		CheckingAccount Acc = new CheckingAccount(101);
		Acc.deposit(1000);
		try {
			Acc.withdrawl(200);
			Acc.withdrawl(1000);
		} catch (InsufficientFundsException e) {
			System.out.println("Sorry, you are out of balance. You need = " + e.getLess_amount());
		}
	}

}
