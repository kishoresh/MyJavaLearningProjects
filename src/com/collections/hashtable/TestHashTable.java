package com.collections.hashtable;

import java.util.HashMap;
import java.util.*;

class Student{
	public int getRollNo() {
		return rollNo;
	}

	public void setRollNo(int rollNo) {
		this.rollNo = rollNo;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	int rollNo;
	String Name;
	int age;

	public void addStudent(int rollNo, String Namme, int age) {
		this.rollNo = rollNo;
		this.Name = Namme;
		this.age = age;
	}
}

public class TestHashTable {

	public static void main(String[] args) {
		//HashMap
		HashMap<Integer, Student> hm = new HashMap<Integer, Student>();

		Student student = new Student();
		student.addStudent(101, "Kishore", 42);
		hm.put(1, student);

		student.addStudent(102, "Ranveer", 43);
		hm.put(2, student);

		student.addStudent(103, "Krishna", 41);
		hm.put(3, student);

		student.addStudent(104, "Rajesh", 44);
		hm.put(4, student);

		Student st;
		//Get an entry set
		Set set = hm.entrySet();
		//Get an Iterator
		Iterator i = set.iterator();
		while(i.hasNext()){
			Map.Entry me = (Map.Entry) i.next();
			System.out.println("Key ="+ me.getKey());
			st =  (Student) me.getValue();
			System.out.println("Value ="+ st.getRollNo());
			//break;
		}



	}

}
