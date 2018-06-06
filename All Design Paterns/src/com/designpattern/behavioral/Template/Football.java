package com.designpattern.behavioral.Template;

public class Football extends Game {

	@Override
	protected void initialize() {
		System.out.println("Football game initialized.");
	}

	@Override
	protected void startPlay() {
		System.out.println("Football game : Started.");
	}

	@Override
	protected void endPlay() {
		System.out.println("Football game : End.");
	}

}
