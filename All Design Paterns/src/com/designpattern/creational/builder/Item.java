package com.designpattern.creational.builder;

/*
 * Item name, price & type of packing.
 */
public interface Item {
	public String name();
	public Float price();
	public Packing packing();
}

/*
 * Packing maybe Bottle or Wrapper. 
 */
interface Packing{
	public String pack();
}

class Wrapper implements Packing{
	@Override
	public String pack() {
		return "Wrapper";
	}
}

class Bottle implements Packing{
	@Override
	public String pack() {
		return "Bottle";
	}
}

/*
 * Item can be 2 types - Burger & Cold drinks, so we create 2 abstract class 
*/





