package com.jms.queue;

import java.io.Serializable;

public class Student implements Serializable{
	int id;
	String name;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return "ID : " +id +" Name : " + getName();
	}

}
