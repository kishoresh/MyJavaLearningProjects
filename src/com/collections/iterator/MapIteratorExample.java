package com.collections.iterator;
/*
 * Iterate through the HashMap Using Iterator in Hashmap. See the diff between ConcurrentHashMap & HashMap while removing elements during iteration :
 * 1. For loop with the EntrySet<>
 * 2. Using While loop and Iterator-1
 * 3. Using While loop and Iterator-2 * 
 * Note : We are able to remove using iterator()
 * 
 * Removing elements while iterating :
 * Exception : ConcurrentModificationException when we try to add or remove elements in a hashmap.
 * Using Iterator : We are allowed to remove.
 */
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class MapIteratorExample {
	public static Map<Integer, String> hm = new HashMap<Integer, String>();
	//public static Map<Integer, String> hm = new ConcurrentHashMap<>();
	//1. Using For loop with the EntrySet<>
	public static void IterateUsingForLoopEntrySet(){		
		System.out.println("1. Using For Loop with the EntrySet<>");
		
		for(Map.Entry me : hm.entrySet()){
			System.out.println("Key = " + me.getKey() + "  Value = " + me.getValue());
			//hm.remove(1);  //ConcurrentModificationException Error - we cannot remove directly from the hm while iterating for HashMap. This is allowed in ConcurrentHashMap.
		}		
	}
	
	//2. Using While loop and Iterator-1
	public static void IterateUsingWhileLoopIterator1(){		
		System.out.println("2. While Loop and Iterator");
		Iterator<Map.Entry<Integer, String>> itr = hm.entrySet().iterator();
		while(itr.hasNext()){
			Map.Entry<Integer, String> e = itr.next();
			System.out.println("Key = " + e.getKey() + "  Value = " + e.getValue());
			itr.remove();              //No error we can remove, using the iterator.
			//hm.remove(e.getKey());   //ConcurrentModificationException error - we cannot remove while iterating. This is possible with ConcurrentHashMap
			//hm.put(5, "Pushpa");     //ConcurrentModificationException error - we cannot add while iterating.    This is possible with ConcurrentHashMap
		}
	}
	
	//3. Using While loop and Iterator-2
	public static void IterateUsingWhileLoopIterator2(){	
		//AddDataToHashMap();
		System.out.println("3. While Loop and Iterator");
		Iterator<Map.Entry<Integer, String>> itr2 = hm.entrySet().iterator();
		while(itr2.hasNext()){
			Map.Entry<Integer, String> e = itr2.next();
			System.out.println("Key = " + e.getKey() + "  Value = " + e.getValue());
			itr2.remove();
		}		
	}
	
	public static void AddDataToHashMap(){
		hm.put(1, "Kishore");
		hm.put(4, "Naresh");   //Observe the Key is 4. But surprisingly HM is maintaining the sorting order, see the o/p
		hm.put(2, "Balaji");
		hm.put(3, "Sharma");				
	}
	
	public static void main(String[] args) {		
		AddDataToHashMap();
		
		IterateUsingForLoopEntrySet();
		IterateUsingWhileLoopIterator1();
		IterateUsingWhileLoopIterator2();	
	}

}
