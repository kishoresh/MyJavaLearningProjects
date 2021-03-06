package com.designpattern.behavioral.command;

/*
 * This class will act as a ConcreteCommand.
 * This class extends the Command interface and implements the execute method.
 * This class creates a binding between the action and the receiver.
 */

public class ActionSave implements ActionListenerCommand {
	private Document doc;

	public ActionSave(Document doc) {
		this.doc = doc;
	}

	@Override
	public void exceute() {
		doc.Save();
	}

}
