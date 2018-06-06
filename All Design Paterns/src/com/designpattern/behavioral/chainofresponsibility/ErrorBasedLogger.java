package com.designpattern.behavioral.chainofresponsibility;

public class ErrorBasedLogger extends Logger {

	public ErrorBasedLogger(int levels) {
		this.Levels = levels;
	}

	@Override
	protected void displayLogInfo(String Msg) {
		System.out.println("ERROR LOGGER INFO ("+ this.getClass().getName()+") :" +Msg);
	}

}
