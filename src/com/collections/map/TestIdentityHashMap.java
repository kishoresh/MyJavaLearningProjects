package com.collections.map;
/*
 * Demonstrate the diff between HashMap & IdentityHashMap.
 * Same 2 entries made to both the Map and see the size.
 * In case of ihm, since it uses reference equality (==) instead of equals() it takes the key as two separate references.
 * Whereas in hm, since it uses equals() (String class already implemnets equals()) it finds the key existing and updates the same entry.
 */
import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.Map;

public class TestIdentityHashMap {

	public static void main(String[] args) {
		Map<String, String> hm = new HashMap();
		Map<String, String> ihm = new IdentityHashMap(5);
		hm.put("Kishore", "Kishore Sharma");
		hm.put(new String("Kishore"), "Milli Sharma");
		ihm.put("Kishore", "Kishore Sharma");
		ihm.put(new String("Kishore"), "Milli Sharma");

		System.out.println("Hash Map Entries : " + hm.size());
		for(Map.Entry<String, String> e : hm.entrySet()){
			System.out.println(e.getKey() + " = " + e.getValue());
		}
		
		System.out.println("Identity Hash Map Entries : " + ihm.size());
		for(Map.Entry<String, String> e : ihm.entrySet()){
			System.out.println(e.getKey() + " = " + e.getValue());
		}
		
	}

}
