package com.designpattern.behavioral.command;

/*
 * This acts as an Invoker.
 * This class asks the command to carry out the request.
 */

public class MenuOptions {
	private ActionListenerCommand openCommand;
	private ActionListenerCommand savecommand;

	public MenuOptions(ActionListenerCommand open, ActionListenerCommand save) {
		this.openCommand = open;
		this.savecommand = save;
	}

	public void clickOpen(){
		openCommand.exceute();
	}

	public void clickSave(){
		savecommand.exceute();
	}

}
