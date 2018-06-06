package com.generics;

//Creating generic Class. T & K can be any type.
public class MyGenericClass <T, K>{
	
	T obj1;
	K obj2;
	
	void add(T obj1, K obj2){
		this.obj1 = obj1;
		this.obj2 = obj2;
	}
	
	T getObj1(){
		return obj1;		
	}
	
	K getObj2(){
		return obj2;
	}
	

}
