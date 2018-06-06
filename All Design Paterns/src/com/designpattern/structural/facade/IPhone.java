package com.designpattern.structural.facade;

public class IPhone implements MobileShop {

	@Override
	public void modelNo() {
		System.out.println("IPhone 6");
	}

	@Override
	public void price() {
		System.out.println("Price Rs 65,000/-");
	}

}
