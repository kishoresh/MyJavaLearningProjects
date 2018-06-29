package com.designpattern.structural.proxy;
/*
 * Proxy design pattern :
 * Interface Image is implemneted by both RealImage & ProxyImage.
 * ProxyImage have RealImage inside it. 
 * As soon as we call display(), RealImage is created and its display method is called.
 * So on next display() RealImage.display() gets directly called. 
 */

public class ProxyDemo {

	public static void main(String[] args) {
		ProxyImage pi = new ProxyImage("myimage.jpg");
		pi.display();
		pi.display();   //Observe : Second time the file is not loaded.
	}

}
