package com.designpattern.behavioral.strategy;
/*
 * Strategy Pattern Demo :
 * 1. Create objects which represents various strategies - OperationAdd & OperationSubstract
 * 2. Create a Context object whose behaviour varies as per the strategy obj passed.
 * context.ExecuteStrategy(n1, n2) - performs addition or substraction depending on the Strategy class passed in the constructor.
 */
import com.designpattern.behavioral.Template.Cricket;

public class StrategyPatternDemo {

	public static void main(String[] args) {
		//Context object behaves differently depending on the Strategy obj used to create it.
		Context context = new Context(new OperationAdd());          //Here OperationAdd is the strategy obj
		System.out.println("10 + 5 = " + context.ExecuteStrategy(10, 5));
		
		context = new Context(new OperationSubstract());
		System.out.println("10 - 5 = " + context.ExecuteStrategy(10, 5));	
	}

}
