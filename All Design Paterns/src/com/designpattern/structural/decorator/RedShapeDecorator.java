package com.designpattern.structural.decorator;

public class RedShapeDecorator extends ShapeDecorator {
	
	public RedShapeDecorator(Shape decoratedShape) {
		super(decoratedShape);
	}
	
	@Override
	public void draw() {
		decoratedShape.draw();
		setRedBorder();
	}
	
	private void setRedBorder(){
		System.out.println("Red border set for shape : " + decoratedShape.getClass().getName() + "\n");
	}
	
}
