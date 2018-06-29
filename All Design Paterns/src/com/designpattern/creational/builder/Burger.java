package com.designpattern.creational.builder;

//Point to be noted, in the abstract class we are not forced to implement all the methods of the Interface Item.
//But when we derived this abstract class, we are forced to override the other methods.
public abstract class Burger implements Item{
	//Burger will always be wrapped, so we overide packing and initiate Wrapper.
	@Override
	public Packing packing() {
		return new Wrapper();
	}
}

class VegBurger extends Burger{
	@Override
	public String name() {
		return "Veg Burger";
	}
	@Override
	public Float price() {
		return 45.00F;
	}
}

class ChickenBurger extends Burger{
	@Override
	public String name() {
		return "Chicken Burger";
	}
	@Override
	public Float price() {
		return 80.00F;
	}
}
