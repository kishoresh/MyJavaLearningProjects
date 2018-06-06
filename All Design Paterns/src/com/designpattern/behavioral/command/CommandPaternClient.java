package com.designpattern.behavioral.command;
/*
 * This acts as the Client
 * This class creates the ConcreteCommand class and associates it with the receiver.
 */
public class CommandPaternClient {

	public static void main(String[] args) {

		Document doc = new Document();
		
		// Create the ConcreteCommand class and associates it with the receiver.
		ActionListenerCommand clickOpen = new ActionOpen(doc);     
		ActionListenerCommand clickSave = new ActionSave(doc);

		MenuOptions menu = new MenuOptions(clickOpen, clickSave);

		menu.clickOpen();
		menu.clickSave();
	}

}
