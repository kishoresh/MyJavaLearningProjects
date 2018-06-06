package com.designpattern.structural.decorator;

public class DecoratorPatternDemo {

	public static void main(String[] args) {
		Circle circle = new Circle();
		
		RedShapeDecorator redBorderCircle = new RedShapeDecorator(new Circle());
		RedShapeDecorator redBorderTriangle = new RedShapeDecorator(new Triangle());
		
		System.out.println("Circle with normal border");
		circle.draw();
		
		System.out.println("\nCircle/Triangle with Red Border.");
		redBorderCircle.draw();
		redBorderTriangle.draw();		
	}

}