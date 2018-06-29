package com.collections.map;
/*
 * Demo to sort a Map by its value, not by the key.
 * 1. Convert Map to List of Map - List<Map.Entry<String,Integer>>
 * 2. Sort List with Collections.sort(), provide a custom Comparator
 * 3. Loop the sorted List and put it into a new insertion order Map - LinkedHashMap
 * 4. Extra check : Sort the value() in descending order and also see that if 2 or more values are same, sort the key() value in descending order.
 * URL : https://www.mkyong.com/java/how-to-sort-a-map-in-java/
 */
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public class SortByValueExample {

	public static void printMap(Map<String, Integer> map){
		for(Map.Entry<String, Integer> entryset : map.entrySet()){
			System.out.println("Key = " + entryset.getKey() + " Value = "+entryset.getValue());
		}		
	}	
	
//	private static Map<String, Integer> sortByValueUsingStream(Map<String, Integer> unsortMap){
//		Map<String, Integer> result = unsortMap.entrySet().stream()
//				.sorted(Map.Entry.comparingByValue().reversed())
//		
//	}
//	
	private static Map<String, Integer> sortByValue(Map<String, Integer> unsortMap){
		//1. Convert Map to List of Map
		List<Map.Entry<String, Integer>> list = new LinkedList<>(unsortMap.entrySet());
		
		//2. Sort List with Collections.sort(), provide a custom Comparator
		Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
			@Override    //Simply sort the value in ascending order 1,2,3,4..
			public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2) {
				return o1.getValue().compareTo(o2.getValue());
			}			
			/*@Override   //Sort the value() in descending order and also see that if 2 or more values are same, sort the key() value in descending order.  
			public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2) {
				int ret = 0;
				ret = (o2.getValue().compareTo(o1.getValue()));
				if (ret == 0){
					ret = (o2.getKey().compareTo(o1.getKey()));
				}
				return ret;
			}*/
		});
		
		//3. Loop the sorted List and put it into a new insertion order Map - LinkedHashMap
		Map<String, Integer> sortedMap = new LinkedHashMap<>();
		for(Map.Entry<String, Integer> e : list){
			sortedMap.put(e.getKey(), e.getValue());
		}
		
		return sortedMap;
	}
	
	public static void main(String[] args) {
		Map<String, Integer> unsortedMap = new HashMap<>();
		unsortedMap.put("z", 10);
		unsortedMap.put("b", 5);
		unsortedMap.put("a", 6);
		unsortedMap.put("c", 20);
		unsortedMap.put("d", 1);
		unsortedMap.put("e", 7);
		unsortedMap.put("y", 8);
		unsortedMap.put("n", 99);
		unsortedMap.put("j", 50);
		unsortedMap.put("m", 2);
		unsortedMap.put("f", 99);
		
		//TreeMap<String, Integer> tmap = new TreeMap<>(unsortedMap);
		//System.out.println("Sorted Map using TreeMap.....");		
		//printMap(tmap);
		
		System.out.println("Unsorted Map.....");		
		printMap(unsortedMap);
		
		System.out.println("Sorted Map.....");
		printMap(sortByValue(unsortedMap));		
	}
	


}
