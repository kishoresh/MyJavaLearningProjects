package com.generics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestGenerics {
	
	
	public static void main(String[] args) {
		class Animal{
			public Animal() {
				// TODO Auto-generated constructor stub
			}
		}
		
		class dog extends Animal{
			public dog() {
				// TODO Auto-generated constructor stub
			}
		}
	
		//It introduces strong type checking.
		MyGenericClass<Integer, String> mygen = new MyGenericClass<Integer, String>();  
	
		mygen.add(100, "Kishore");
		//mygen.add("Kishore", 10); //Compile error
		
		System.out.println(mygen.getObj2());
		
		Animal[] animalsArr = { new Animal(), new dog(), new Animal()};
		dog[] dogArr = {new dog(), new dog() };
		
		List<Object> dummy = new ArrayList<Object>();
		List<Animal> animalList = Arrays.asList(animalsArr);
		List<dog> dogList       = Arrays.asList(dogArr);
		
		//List< ? extends Animal> extendsList = dummy;  //Compile error, as dummy is the extension of Object list.
		//List< ? super Animal> superList = dogList;  //Compile error, as dogList is an extension of dog class which is a subclass of Animal.
		List < ? extends Animal> extendsList = animalList;   //dogList; Only the list of Animal and its subclass is allowed.
		List < ? super Animal> superList = animalList;  //dummy; Only the list of Animal and its super class are allowed.
	}

}
