package com.exercises.datastructures;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

/*
 * You are given 2 data list of Vehicles & Drivers. Store them in memory using collection.
 * 
 * Solution : Store the Vehicle and the coressponding driver list as a key value pair using HashMap. Value is a list of drivers.
 * Then do the following :
 *  1. Usage of the Map :
 *  2. Iterate through the Map :
 */

public class StoreComplexDataIntoColl {
	
	public static String[] vehicles = {"Ambulance", "Helicopter", "Lifeboat", "Ambulance"};
	public static String[][] drivers = {
			{"Fred", "Sue", "Pete"},
			{"Sue", "Richard", "Bob", "Fred"},
			{"Pete", "Mary", "Bob"},
			{"Pete", "Mary", "Bob"}
	};

	public static void main(String[] args) {
		Map<String, Set<String>> personnel = new HashMap<>();
		
		for(int i=0; i<vehicles.length; i++){
			String vehicle = vehicles[i];
			String[] driverList = drivers[i];
			
			Set<String> driverSet = new LinkedHashSet<>();
			for(String driver : driverList){
				driverSet.add(driver);
			}
			personnel.put(vehicle, driverSet);
		}
		
		//Display the contents of the HashMap - Iterate through the whole HashMap using keySet.
//		for(String vehicle : personnel.keySet()){
//			System.out.println(vehicle + " : ");
//			
//			Set<String> driverList = personnel.get(vehicle);
//			for(String driver:driverList){
//				System.out.println(driver);
//			}			
//		}
		
		//Iterate through the whole HashMap using EntrySet
		for(Map.Entry me:personnel.entrySet()){
			System.out.println(me.getKey() + " : ");
			Set<String> driverList = (Set) me.getValue();
			for(String driver:driverList){
				System.out.println(driver);	
			}
		}

	}

}
