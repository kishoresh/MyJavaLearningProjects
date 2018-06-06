package com.collections.comparator;
/*
 * 	Comparator Interface : (java.util package)
	Is used to order the objects of user-defined class.
	Contains 2 methods compare(Object obj1,Object obj2) and equals(Object element).
	It provides multiple sorting sequence i.e. you can sort the elements based on any data member. 
	For instance it may be on rollno, name, age or anything else.

    URL : http://www.javatpoint.com/Comparator-interface-in-collection-framework
 */
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import com.collections.comparator.Student;

public class DemoComparator {

	public static void main(String[] args) {
		ArrayList al = new ArrayList<>();
		al.add(new Student(101,"Vijay", 43));
		al.add(new Student(104, "Kishore", 45));
		al.add(new Student(103, "Rajesh", 42));
		al.add(new Student(104, "Basil", 41));

		System.out.println("Sorting by Name");
		Collections.sort(al, new NameComparator());		

		Iterator itr = al.iterator();
		while (itr.hasNext()){
			Student st = (Student) itr.next();
			System.out.println("Student : "+ st.getName() +" Roll : " +st.getRollNo() +" Age : "+st.getAge());
		}

		System.out.println("Sorting by Age");
		Collections.sort(al, new AgeComparator());
		Iterator itr2 = al.iterator();
		while (itr2.hasNext()){
			Student st2 = (Student) itr2.next();
			System.out.println("Student : "+ st2.getName() +" Roll : " +st2.getRollNo() +" Age : "+st2.getAge());
		}
	}

}
