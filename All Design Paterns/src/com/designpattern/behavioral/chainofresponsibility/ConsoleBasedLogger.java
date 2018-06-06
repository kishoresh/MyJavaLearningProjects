package com.designpattern.behavioral.chainofresponsibility;

public class ConsoleBasedLogger extends Logger {

	public ConsoleBasedLogger(int levels) {
		this.Levels = levels;
	}

	@Override
	protected void displayLogInfo(String Msg) {
		System.out.println("CONSOLE LOGGER INFO ("+ this.getClass().getName()+") :" +Msg);
	}

}
