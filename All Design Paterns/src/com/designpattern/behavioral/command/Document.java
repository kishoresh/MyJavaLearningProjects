package com.designpattern.behavioral.command;

/*
 * This class acts as a Receiver.
 * This class knows to perform the operation.
 *
 */

public class Document {

	public void Open(){
		System.out.println("Document is Opened");
	}

	public void Save(){
		System.out.println("Document is Saved");
	}

}
