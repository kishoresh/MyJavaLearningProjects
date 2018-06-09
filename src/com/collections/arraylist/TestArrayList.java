package com.collections.arraylist;

/* ArrayList Class :-      URL :- http://www.javatpoint.com/ArrayList-in-collection-framework
 * Uses a dynamic array for storing the elements.
 * It extends AbstractList class and implements List interface.
 * Can contain duplicate elements.
 * Maintains insertion order.
 * Is non synchronized.
 * Allows random access because array works at the index basis.
 * Manipulation is slow because a lot of shifting needs to be occurred if any element is removed from the array list.
 *
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class TestArrayList {

	public static void main(String[] args) {
		//Array testing cases.

		//int[] intArr = new int[10];  //One way to create an array.
		int[] intArr = {1,2,3,4,5,6,7,8,9,10};
		/*intArr[0] = 1;
		intArr[1] = 2;
		intArr[3] = 3; */

		for (int i=0; i<intArr.length; i++){
			System.out.println(intArr[i] +",");
		}
		int val = intArr[4];
		System.out.println("Value at 4 index = "+val);

		//Compiler error, as Arraylist cannot take primitive data type.
		//ArrayList <int> arrInt = new ArrayList<int>();        -- Compiler Error
		//ArrayList<Integer> arrInt = new ArrayList<Integer>(); --No Error
		
		ArrayList arrInt = new ArrayList();
		arrInt.add(23);
		arrInt.add(25);

		int j = (int) arrInt.get(0);        //Autoboxing
		System.out.println("Value at 0 index = "+j);

		//ArrayList testing
		class Student{
			int rollNo;
			String Name;
			int age;

			public Student(int rollNo, String Namme, int age) {
				this.rollNo = rollNo;
				this.Name = Namme;
				this.age = age;
			}
		}

		ArrayList<String> al = new ArrayList<String>();
		al.add("Ravi");
		al.add("Ravi");		
		al.add("Ganesh");
		al.add("Rajesh");
		al.add("Jignesh");
		al.add(1, "Kishore");     //This will insert Kishore in 2nd place and move Ravi to 3rd place
		
		//al.add(123);   //This will raise a compile time error. This is the benefit of using Generics

		//Two ways to Iterate :-
		Iterator itr = al.iterator();
		while(itr.hasNext()){
			System.out.println(itr.next());
		}

		for (String obj:al){
			System.out.println(obj);
		}

		//Eg of addAll(c), removeAll(c)
		ArrayList<String> al2 = new ArrayList<String>();
		al2.add("Kishore");
		al2.add("Rajesh");

		try
		{
			al.addAll(al2);
			//al.removeAll(al2);
			//al.retainAll(al2);
			String str = al.get(2);   //This will raise error in case of retainAll()
			System.out.println("String at index 2 is = "+str);
			Iterator itr3 = al.iterator();
			System.out.println("**** Display all the values after addAll(), removeAll() & retainAll() ******");
			while (itr3.hasNext()){
				System.out.println(itr3.next());
			}
			System.out.println("*********************************************************");
		}catch (Exception e){
			e.printStackTrace();
		}

		//Add user defined class object list (Student) to Arraylist and Iterate.
		ArrayList<Student> sl = new ArrayList<Student>();
		Student std1 = new Student(101, "Kishore1", 40);
		sl.add(std1);
		sl.add(new Student(102, "Kishore2", 41));
		sl.add(new Student(103, "Kishore3", 42));

		//Now what happens to the value in the arraylist ?
		//Here the obj std1 is not a candidate for GC. Becz an obj is garbage collected when there is no reference to the object. Here std1 also have another reference in the arraylist. 
		std1 = null;
	
		Iterator itr2 = sl.iterator();
		while(itr2.hasNext()){
			Student s = (Student)itr2.next();
			System.out.println("RollNo : "+s.rollNo+" Name : "+s.Name+" Age : "+s.age);
		}

		//Converting ArrayList to Array
		al.remove(2);     //Remove the third element.
		//al.clear();`   //This will clear the arraylist
		String[] simpleArray = al.toArray(new String[al.size()]);
		System.out.println("The array created after the conversion is : " + Arrays.toString(simpleArray));
		
		
		
	}

}
