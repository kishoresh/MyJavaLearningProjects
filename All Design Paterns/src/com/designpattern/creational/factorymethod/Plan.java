package com.designpattern.creational.factorymethod;
/*
 * Factory Design Pattern or Factory Method Pattern :-  URL :-http://www.javatpoint.com/factory-method-design-pattern
 * Says that just define an interface or abstract class for creating an object but
 * let the subclasses decide which class to instantiate. In other words, subclasses are responsible to create the instance of the class.
 * Also known as Virtual Constructor.
 *
 * Advantages :-
 * Allows the sub-classes to choose the type of objects to create.
 * Promotes loose-coupling by eliminating the need to bind application-specific classes into the code.
 *
 * Usage :-
 * When a class doesn't know what sub-classes will be required to create
 * When a class wants that its sub-classes specify the objects to be created.
 * When the parent classes choose the creation of objects to its sub-classes.
 */

public abstract class Plan {
	protected double rate;
	abstract void setRate(double rt);

	public void calculateBill(int units){
		System.out.println("Total Bill = " + units * rate);
	}


}
