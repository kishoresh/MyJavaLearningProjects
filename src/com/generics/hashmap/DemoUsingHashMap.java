package com.generics.hashmap;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class DemoUsingHashMap {

	public static void main(String[] args) {
		Map<Integer, String> hm = new HashMap<Integer, String>();
		hm.put(1, "First String");
		hm.put(2,"Second String");
		hm.put(3, "Third String");
		
		//Now use Map.Entry to get the Set 
		Set<Map.Entry<Integer, String>> set = hm.entrySet();
		
		Iterator<Map.Entry<Integer, String>> itr = set.iterator();
		while(itr.hasNext()){
			Map.Entry<Integer, String> e = itr.next();
			System.out.println(e.getKey() + " = " + e.getValue());
		}
	}

}
