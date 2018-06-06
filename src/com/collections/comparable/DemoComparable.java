package com.collections.comparable;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;

/*	Comparable Interface :
	Is used to order the objects of user-defined class.
	Is found in java.lang package
	Contains only one method named compareTo(Object).
	It provide only single sorting sequence

	URL : http://www.javatpoint.com/Comparable-interface-in-collection-framework

	Use the method of Collections class for sorting List elements :- Collections.sort(List)
	
	This Demo sorts the Student by the age.
 */

import com.sun.xml.internal.bind.v2.runtime.Name;

public class DemoComparable {

	public static void main(String[] args) {
		ArrayList al = new ArrayList<>();
		al.add(new Student(101,"Vijay", 43));
		al.add(new Student(104, "Kishore", 45));
		al.add(new Student(103, "Rajesh", 42));
		al.add(new Student(104, "Basil", 41));

		Collections.sort(al);   //Sort method is used to sort the list.

		Iterator it = al.iterator();
		while (it.hasNext()){
			Student st = (Student) it.next();
			System.out.println("Student : "+ st.Name +" Roll : " +st.RollNo+" Age : "+st.age);
		}

	}

}
