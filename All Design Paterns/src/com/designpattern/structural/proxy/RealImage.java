package com.designpattern.structural.proxy;

public class RealImage implements Image{
	private String fileName;
	
	public RealImage(String filename) {
		this.fileName = filename;
		loadFromDisk();
	}
	
	private void loadFromDisk(){
		System.out.println("Loading file " + fileName);	
	}
	
	@Override
	public void display() {
		System.out.println("Displaying Image from " + fileName);	
	}
}
