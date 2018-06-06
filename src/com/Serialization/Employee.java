package com.Serialization;
/*
 * To make a class serializable, import java.io.Serializable and implement the interface Serializable.
 * Use the keyword transient for attributes not to serialize.
 * URL : http://www.tutorialspoint.com/java/java_serialization.htm
 */
import java.io.Serializable;

public class Employee implements Serializable {
	/**
	 * This is optional, but highly recommended that we provide the serialVersionUID. 
	 */
	private static final long serialVersionUID = -2455622812638841685L;
	
	public String name;
	public String address;
	public transient int SSN;
	public int empid;

	public void mailCheck(){
		System.out.println("Mailing a check to : %s "+ name +", Address : %s "+ address +", EmpID : %d "+ empid);
	}
}
