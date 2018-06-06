package com.designpattern.structural.facade;
/*
 * Structural Design patterns :-  URL : http://www.javatpoint.com/facade-pattern
 * Are concerned with how classes and objects can be composed, to form larger structures.
 *
 * 1. Facade Pattern :
 * Just provide a unified and simplified interface to a set of interfaces in a subsystem, therefore it hides the complexities of the subsystem from the client.
 * It describes a higher-level interface that makes the sub-system easier to use.
 * Practically, every Abstract Factory is a type of Facade.
 *
 * Advantage of Facade Pattern :
 * It shields the clients from the complexities of the sub-system components.
 * It promotes loose coupling between subsystems and its clients.
 *
 * Usage of Facade Pattern:
 * It is used:
 * When you want to provide simple interface to a complex sub-system.
 * When several dependencies exist between clients and the implementation classes of an abstraction.
 *
 */
public interface MobileShop {
	public void modelNo();
	public void price();
}
