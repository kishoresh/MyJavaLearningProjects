package com.designpattern.structural.facade;

public class BlackBerry implements MobileShop {

	@Override
	public void modelNo() {
		System.out.println("Black Berry Z10");
	}

	@Override
	public void price() {
		System.out.println("Price Rs 55,000/-");
	}

}
