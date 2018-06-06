package com.designpattern.structural.adapter;

/*
 * This is the Adapter Class or the Wrapper, which implements the desired target interface and modifies the adaptee class.
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BankCustomer extends BankDetails implements CreditCard {     //Adapter Class

	@Override
	public void giveBankDetails() {
		try{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("Enter Acc Holder Name : ");
		String customerName = br.readLine();
		System.out.print("\n");

		System.out.print("Enter the Acc No : ");
		long accNo = Long.parseLong(br.readLine());
		System.out.print("\n");

		System.out.print("Enter the Bank Name : ");
		String bankName = br.readLine();

		setAccHolderName(customerName);
		setAccNo(accNo);
		setBankName(bankName);

		}catch (Exception e){
			e.printStackTrace();
		}

}

	@Override
	public String getCreditCard() {
		String accHolderNamme = getAccHolderName();
		String bankName = getBankName();
		long accno = getAccNo();

		return ("The Account No "+accno + " of "+accHolderNamme +" in bank " + bankName+" is valid and authenticate for using the credit card.");
	}

}
