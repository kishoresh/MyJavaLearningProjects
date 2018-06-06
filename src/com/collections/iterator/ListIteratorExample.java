package com.collections.iterator;
/*
 * With ListIterator we can iterate both forward & backward.
 * We can iterate only List.
 *  
 */
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class ListIteratorExample {

	public static void main(String[] args) {
		List<String> names = new ArrayList<String>();
		names.add("Kishore");
		names.add("Supriya");
		names.add("Balaji");
		
		//Check for Arraylist with Iterator, whether we can remove items.
		Iterator<String> itr1 = names.iterator();
		while (itr1.hasNext()){
			System.out.println(itr1.next());
			//itr1.remove();       //No error
			//names.add("dsfds");  //ConcurrentModificationException error - we cannot add while iterating
		}
		
		ListIterator<String> itr = names.listIterator();
		while (itr.hasNext()){
			System.out.println(itr.next());
			//itr.remove();           //No error we can remove.
			//itr.add("XXXXXXXXX");   //No error we can add.
		}
		
		System.out.println("***** Reverse ********");
		while (itr.hasPrevious()){
			System.out.println(itr.previous());
		}
		

	}

}
