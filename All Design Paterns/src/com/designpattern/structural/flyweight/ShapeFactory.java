package com.designpattern.structural.flyweight;
/*
 * This is factory class for Shape's. 
 * getCircle method will first check the hashMap, if it finds, it return the Circle otherwise it will create a new one.
 * Color is the key of the hashMap.
 */
import java.util.HashMap;

public class ShapeFactory {
	//Stores all the unique Circle objects in this map.
	private final HashMap<String, Circle> cirleMap = new HashMap<>();
	
	public Circle getCircle(String color){
		Circle circle = cirleMap.get(color);
		if (circle == null){
		    circle = new Circle(color);
			cirleMap.put(color, circle);
			System.out.println("Creating Circle with color "+color);
		}
		return circle;
	}
}
