package com.collections.comparator;

public class Student {
	public int getRollNo() {
		return RollNo;
	}

	public String getName() {
		return Name;
	}

	public int getAge() {
		return age;
	}

	int RollNo;
	String Name;
	int age;

	public Student(int rollno, String name, int age) {
		this.age = age;
		this.RollNo = rollno;
		this.Name = name;
	}

}
