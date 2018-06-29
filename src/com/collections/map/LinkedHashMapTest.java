package com.collections.map;
/*
 * LRU (Least Recently Used) implementation using LinkedHashMap()
 * LinkedHashMap can be used as fixed size LRU cache where one needs to remove eldest entry when Cache is full. 
 * It provides a method called removeEldestEntry() which is called by put() and putAll() and can be used to instruct to remove eldest entry.
 * 
 * URL : https://gist.github.com/zeroed/4bba3e57273d1bbf0337
 */
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class LinkedHashMapTest {
	static int num = 0;
	static LinkedHashMap<String, String> lhmap;
	static void displayLinkedHashMapValues(LinkedHashMap<String, String> lhmap){
        for(Map.Entry<String, String> entryset : lhmap.entrySet()){
        	System.out.println(entryset.getKey() + " = " + entryset.getValue());
        }
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		num = sc.nextInt();		
		//LinkedHashMap<String, String>
		lhmap = new LinkedHashMap<String, String>(){
			@Override
			protected boolean removeEldestEntry(java.util.Map.Entry<String, String> eldest) {
				return size() > num;                         //This is the condition, when the eldest entry will be removed.
			}
		};
		
		lhmap.put("Kishore", "coMakIT");
		lhmap.put("Basil", "TPT");
		lhmap.put("Rajesh", "Tech Mahindra");
		displayLinkedHashMapValues(lhmap);
		
        String ch = "Y";
        while(ch.equalsIgnoreCase("Y")){
        	lhmap.put(sc.next(), sc.next());
        	displayLinkedHashMapValues(lhmap);
        	ch = sc.next();
        }
        displayLinkedHashMapValues(lhmap);
        System.out.println("Out of program..");
				
	}    //main()

	
}
