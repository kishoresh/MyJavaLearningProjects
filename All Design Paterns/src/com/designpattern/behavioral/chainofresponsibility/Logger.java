package com.designpattern.behavioral.chainofresponsibility;

public abstract class Logger {

	public static int OUTPUTINFO = 1;
	public static int ERRORINFO = 2;
	public static int DEBUGINFO = 3;

	protected int Levels;
	protected Logger nextLevelLogger;

	public void setNextLevelLogger(Logger nextLevelLogger){
		this.nextLevelLogger = nextLevelLogger;
	}

	public void logMsg(int levels, String msg){
		if (this.Levels <= levels){
			displayLogInfo(msg);
		}

		if (nextLevelLogger != null){
			nextLevelLogger.logMsg(levels, msg);
		}
	}

	protected abstract void displayLogInfo(String Msg);
}
