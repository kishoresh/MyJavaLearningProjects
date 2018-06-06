package com.designpattern.behavioral.chainofresponsibility;

public class ChainResponsibilityClient {

	//Create all the Logger class by setting the individual Levels.
	//For each Logger obj, set the link with the next level Logger object.
	//Doing so we get the chain of Logger class obj in Return.
	private static Logger doChaining(){
		Logger consoleLogger = new ConsoleBasedLogger(Logger.OUTPUTINFO);

		Logger erroLogger = new ErrorBasedLogger(Logger.ERRORINFO);
		consoleLogger.setNextLevelLogger(erroLogger);

		Logger debugLogger = new DebugBasedLogger(Logger.DEBUGINFO);
		erroLogger.setNextLevelLogger(debugLogger);

		return consoleLogger;
	}

	public static void main(String[] args) {
		Logger chainLogger = doChaining();  //Get the chain obj.

		chainLogger.logMsg(Logger.OUTPUTINFO, "Enter the sequence of values.");
		chainLogger.logMsg(Logger.ERRORINFO,  "An error is occured now.");
		chainLogger.logMsg(Logger.DEBUGINFO, "This was the error now debugging is compeled.");
	}

}
