package com.designpattern.behavioral.strategy;

public class Context {
	private Strategy strategy;
	
	public Context(Strategy stg) {
		this.strategy = stg;
	}
	
	public int ExecuteStrategy(int n1, int n2){
		return strategy.doOperation(n1, n2);
	}
}
