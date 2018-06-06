package com.designpattern.creational.singleton;

import java.io.IOException;

public class JDBCSingletonDemo {

	public static void main(String[] args) {
		System.out.println("Starting JDBCSingletonDemo");
		JDBCSingleton jdbc = JDBCSingleton.getInstance();
		//Cannot Clone as JDBCSingleton have not implemented the interface Cloneable
		//JDBCSingleton jdbcClone = (JDBCSingleton) jdbc.clone();

		try
		{
			//jdbc.insertData(104, "Manoj", "manojj");
			jdbc.insertData(105, "Kiran", "kiran");
			System.out.println("View Data.");
			jdbc.viewData(104);
		}catch (Exception e){
			System.out.println(e);
		}


	}

}
