package com.collections.ConcurrentHashMap;
/*
 * Testing Null value entry in ConcurrentHashMap, HashMap & HashTable
 * Result : While populating the CHM, we get a NullPointerException. We will also get error with HashTable.
 */
import java.text.Format;
import java.util.Formatter;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.sun.javafx.binding.StringFormatter;

public class TestNullKey {
	public static String cKeyValueString = "Key = %d Value = %s"; 
	
	public static HashMap<Integer, String> hm = new HashMap<>();
	//public static Map<Integer, String> hm = new Hashtable<>();
	public static ConcurrentHashMap<Integer, String> chm = new ConcurrentHashMap<>();
	
	public static void PopulateDataInHashMap(Map<Integer, String> map){
//		map.put(101, "One Hundred One");
//		map.put(103, "One Hundred Three");
//		map.put(104, "One Hundred Four");
//		map.put(102, "One Hundred two.");		
//		map.put(66, "Sixty Six");
		map.put(5, "A");
		map.put(11, "C");
        map.put(4, "Z");
        map.put(77, "Y");
        map.put(9, "P");
        map.put(66, "Q");
        map.put(0, "R");
		map.put(null, "Null ");	   //Comment this to remove the NullPointer exception.
	}

	public static void TestNullKeyInHashMap(){
		PopulateDataInHashMap(hm);		
//		for (Object o: hm.entrySet()){    //This is working. Just commented.
//			System.out.println(o);        //It will print like 101=One Hundred One
//		}
		for(Map.Entry me : hm.entrySet()){
			System.out.println(String.format(cKeyValueString, me.getKey(), me.getValue()));
		}
		System.out.println(hm);
	}
    
	public static void TestNullKeyInConcurrentHashMap(){
		PopulateDataInHashMap(chm);	    //Nullpointer error while populating itself.

		for(Map.Entry me : chm.entrySet()){
			System.out.println(String.format(cKeyValueString, me.getKey(), me.getValue()));
		}
		System.out.println(chm);
	}
	
	public static void main(String[] args) {
		TestNullKeyInHashMap();         //No error, just commented
		//TestNullKeyInConcurrentHashMap();   //Nullpointer error
		
		System.out.println(System.currentTimeMillis());
	}

}
