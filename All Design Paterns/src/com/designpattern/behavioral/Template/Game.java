package com.designpattern.behavioral.Template;

public abstract class Game {
	abstract protected void initialize();
	abstract protected void startPlay();
	abstract protected void endPlay();
	
	//Template method 
	public void play(){
		initialize();
		startPlay();
		endPlay();
	}
}
