package com.designpattern.behavioral.chainofresponsibility;

public class DebugBasedLogger extends Logger {

	public DebugBasedLogger(int levels) {
		this.Levels = levels;
	}

	@Override
	protected void displayLogInfo(String Msg) {		
		System.out.println("DEBUG LOGGER INFO ("+ this.getClass().getName()+") :" +Msg);
	}

}
