package com.exceptions.userdefined;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestUserDefinedException {

//	@Test(expected= InsufficientFundsException.class)    //For expected exception, like in this case.
	@Test
	public void test() throws InsufficientFundsException{
		CheckingAccount Acc = new CheckingAccount(101);
		Acc.deposit(1000);
		assertEquals("Acc balance is correct.", 1000.00, Acc.getBalance(), 0);    //Here las place is the delta, i.e. the small decimal value mismatch that can happen and allowed.
//		try {
			Acc.withdrawl(200);
			assertEquals("Acc balance is correct ", 800.00, Acc.getBalance(), 0);
			//Acc.withdrawl(1000);    //Here the exception is raised, and @Test(expected= InsufficientFundsException.class) will bypass this as this is relevant error
			
			//assertEquals("Acc balance is correct ", 800.00, Acc.getBalance(), 0);
//		} catch (InsufficientFundsException e) {
//			e.printStackTrace();
//		}
		
	}

}
