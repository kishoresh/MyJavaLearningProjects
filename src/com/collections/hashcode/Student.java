package com.collections.hashcode;

public class Student {
	private int regID;
	private String name;
	private int age;
	private String year;
	
	public Student(int fid, String fname, int fage){
		this.regID = fid;
		this.name = fname;
		this.age = fage;
		
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj != null && obj instanceof Student){
			int regId = ((Student) obj).getId();
			if (regId != 0 && regId == this.regID){
				return true;
			}
		}
		return false;
	}
	
	@Override
	public int hashCode() {
		return 1;   //this.regID;
	}
	
	public int getId() {
		return regID;
	}
	public void setId(int id) {
		this.regID = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}	
}
