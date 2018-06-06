package com.collections.properties;

import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

/*
 * Get all the system properties and display
 */
public class SysProperties {

	public static void main(String[] args) {
		Properties p = System.getProperties();
		Set set = p.entrySet();
		Iterator itr = set.iterator();
		while (itr.hasNext()){
			Map.Entry entry = (Map.Entry)itr.next();
			System.out.println(entry.getKey() + " = " + entry.getValue());
		}		

	}

}
