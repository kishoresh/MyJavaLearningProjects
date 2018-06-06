package com.collections.comparable;
/*
 * This class demonstrate the usage of the single method Comparable interface.
 * compareTo() - this method has to be overriden and return an int result (0=equal, +1 & -1
 */
public class Student implements Comparable{
	int RollNo;
	String Name;
	int age;

	public Student(int rollno, String name, int age) {
		this.age = age;
		this.RollNo = rollno;
		this.Name = name;
	}

	@Override
	public int compareTo(Object o) {
		Student st = (Student) o;
		if (age == st.age)
			return 0;
		else if (age > st.age)
			return 1;
		else
			return -1;
	}
}
