package com.designpattern.behavioral.Template;

public class Cricket extends Game {

	@Override
	protected void initialize() {
	  System.out.println("Cricket game initialized.");
	}

	@Override
	protected void startPlay() {
		System.out.println("Cricket game : Started.");
	}

	@Override
	protected void endPlay() {
		System.out.println("Cricket game : End.");
	}
}
