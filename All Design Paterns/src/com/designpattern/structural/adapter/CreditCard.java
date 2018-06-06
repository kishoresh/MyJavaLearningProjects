package com.designpattern.structural.adapter;
/*
 * An Adapter Pattern : URL : http://www.javatpoint.com/adapter-pattern
 * It says that just, Converts the interface of a class into another interface that a client wants.
 * In other words, to provide the interface according to client requirement while using the services of a class with a different interface.
 * Also known as Wrapper.
 *
 * Advantage of Adapter Pattern :
 * It allows two or more previously incompatible objects to interact.
 * It allows reusability of existing functionality.
 *
 * Usage :
 * When an object needs to utilize an existing class with an incompatible interface.
 * When you want to create a reusable class that cooperates with classes which don't have compatible interfaces.
 *
 * There are the following specifications for the adapter pattern :
 * Target Interface [CreditCard] : This is the desired interface class which will be used by the clients.
 * Adapter class [BankCustomer]  : This is a wrapper class which implements the desired target interface and modifies the specific request available from the Adaptee class.
 * Adaptee class [BankDetails]   : The class which is used by the Adapter class to reuse the existing functionality and modify them for desired use.
 * Client : This class will interact with the Adapter class.
 */

public interface CreditCard {   //Target Interface

	public void giveBankDetails();
	public String getCreditCard();
}
