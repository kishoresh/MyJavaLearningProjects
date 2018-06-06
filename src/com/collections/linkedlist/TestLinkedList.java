package com.collections.linkedlist;

import java.util.*;
import java.util.LinkedList;

import com.sun.xml.internal.bind.v2.runtime.reflect.ListIterator;

/* LinkedList Class :-      URL :- http://www.javatpoint.com/LinkedList-in-collection-framework
 * Uses doubly linked list to store the elements.
 * It extends the AbstractList class and implements List and Deque interfaces.
 * Can contain duplicate elements.
 * Maintains insertion order.
 * Is non synchronized.
 * Allows random access because array works at the index basis.
 * Manipulation is fast because because no shifting needs to be occurred.
 *
 */

public class TestLinkedList {

	public static void main(String[] args) {
		LinkedList<String> ll = new LinkedList<String>();

		ll.add("B");
		ll.add("D");
		ll.add("E");

		ll.addFirst("A");
		ll.add(2, "C");
		ll.add(3, "D1");
		ll.addLast("F");

		/*ListIterator<String> itr = ll.listIterator();
		while(itr.hasPrevious()){

		}
		*/

		System.out.println("Original Contents of the List : " + ll);

		ll.remove("D1");
		ll.remove(4);
		ll.removeLast();        //This method is not there in ArrayList.
		ll.removeFirst();      //This method is not there in ArrayList.
		System.out.println("Contents after remove : " + ll);

		Object val = ll.get(1);
		ll.set(1, (String) val + " Changed");
		System.out.println("Contents after get & set : " + ll);
	}

}
