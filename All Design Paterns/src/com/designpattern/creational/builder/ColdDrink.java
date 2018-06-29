package com.designpattern.creational.builder;

public abstract class ColdDrink implements Item{
	@Override
	public Packing packing() {
		return new Bottle();
	}
}

class Coke extends ColdDrink{
	@Override
	public String name() {
		return "Coke";
	}
	@Override
	public Float price() {		
		return 24.50F;
	}
}

class Pepsi extends ColdDrink{
	@Override
	public String name() {
		return "Pepsi";
	}
	@Override
	public Float price() {
		return 21.40F;
	}
}
