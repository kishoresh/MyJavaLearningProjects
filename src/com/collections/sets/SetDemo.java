package com.collections.sets;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

/* Demo for HashSet, LinkedHashSet & TreeSet. All extends Set, so unique elelments only allowed.
 * HashSet elements are      : Unsorted and Order of insertion is not maintained. It uses hashing mechanism.
 * LinkedHashSet elements are: Unsorted, but maintains insertion order.
 * TreeSet                   : Sorted.
 * 
 */
public class SetDemo {

	public static void main(String[] args) {
		Set<String> hset = new HashSet<String>();
		hset.add("cat");
		hset.add("dog");
		hset.add("rat");
		hset.add("dog");   //Nte this is duplicate
		hset.add("bat");
		
		System.out.println(hset.toString());  //Output : [rat, bat, cat, dog]
	
		//We cannot find value by index. Have to iterate to get the value.
		Iterator<String> itr = hset.iterator();
		while (itr.hasNext()){			
			System.out.println(itr.next());
		}
		
		Set<String> lhset = new LinkedHashSet<>();
		lhset.add("cat");
		lhset.add("dog");
		lhset.add("rat");
		lhset.add("dog");
		lhset.add("bat");
		
		System.out.println(lhset.toString()); //Output : [cat, dog, rat, bat]
		
		//TreeSet is extedned from SortedSet & NavigableSet.
		TreeSet<String> tset = new TreeSet<>();
		tset.add("cat");
		tset.add("dog");
		tset.add("rat");
		tset.add("dog");
		tset.add("bat");
		
		String firstStr = tset.first();
		String endStr = tset.last();
		
		//String s = (String) tset.floor("dog");
		//System.out.println("Floog=r string : " + s);
				
		System.out.println(tset.toString()); //Output : [bat, cat, dog, rat]		
	}

}
