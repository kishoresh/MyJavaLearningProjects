package com.designpattern.structural.flyweight;
/*
 * ShapeFactory has a HashMap of Circle having key as color of the Circle object. 
 * Whenever a request comes to create a circle of particular color to ShapeFactory, it checks the circle object in its HashMap. 
 * If object of Circle is found, that object is returned otherwise a new object is created, stored in hashmap for future use, 
 * and returned to client. 
 */
public class FlyweightPatternDemo {
	
	private static final String[] colors = {"Red","Blue","Yellow","Green","Black"};
	
	private static String getRandomColors(){
		return colors[(int)(Math.random()*colors.length)];	
	}
	
	public static void main(String[] args) {
		
		ShapeFactory sf = new ShapeFactory();
		
		for (int i=0; i < 20; i++){
	  		Circle circle = (Circle) sf.getCircle(getRandomColors());
	  		circle.setX(i*100);
	  		circle.setY(i*300);
	  		circle.setRadius(i*50);
	  		circle.draw();	
		}
		
		Integer i = new Integer(1000);
		i.valueOf(200);
		
		
	}

}
