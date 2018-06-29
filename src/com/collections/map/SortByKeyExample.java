package com.collections.map;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import com.sun.org.apache.bcel.internal.generic.RETURN;

import sun.reflect.generics.tree.Tree;

public class SortByKeyExample {

	public static void printMap(TreeMap<String, Integer> tmap){
		for(Map.Entry<String, Integer> e : tmap.entrySet()){
			System.out.println("Key = " + e.getKey() + " Value= "+e.getValue());
		}
	}
	
	public static void main(String[] args) {
		TreeMap<String, Integer> unsortedMap = new TreeMap<>(new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
		        return o2.compareTo(o1);
			}
		});
		
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
		
		printMap(unsortedMap);
	}

}
