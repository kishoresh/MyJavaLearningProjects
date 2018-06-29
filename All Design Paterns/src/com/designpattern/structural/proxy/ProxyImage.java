package com.designpattern.structural.proxy;

public class ProxyImage implements Image{
	RealImage realimage;
	private String fileName;
	
	public ProxyImage(String filename) {
		this.fileName = filename;
	}
	
	@Override
	public void display() {
		if (realimage == null){
			realimage = new RealImage(fileName);
		}
		realimage.display();		
	}
}
