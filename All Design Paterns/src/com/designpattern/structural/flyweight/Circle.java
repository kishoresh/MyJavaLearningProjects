package com.designpattern.structural.flyweight;

import java.util.function.Supplier;

interface Shape {	
	void draw();
}

public class Circle implements Shape {
	private String Color;
	private int x;
	private int y;
	private int radius;
	
	public Circle(String color) {
		this.Color = color;
	}
	
	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}

	public void setRadius(int radius) {
		this.radius = radius;
	}
	
	@Override
	public void draw() {
		System.out.println("Shape Draw() : Color["+Color+"]"+"Coordinates =["+x+","+y+"]");
	}

}
