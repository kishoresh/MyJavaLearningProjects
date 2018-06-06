package com.xml.jaxb.marshalling;
/*
 * Employee class binded to generate an XML using the annotations :
 * @XMLRootElement  - specifies the root element for the XML document.
 * @XMLAttribute    - specifies the attribute for the root element.
 * @XMLElement		- specifies the sub element for the root element.
 */
import javax.xml.bind.annotation.XmlAnyAttribute;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Employee {
	private int id;
	private String Name;
	private float Salary;
	
	public Employee() {}
	public Employee(int id, String name, float sal){
		super();
		this.id = id;
		this.Name = name;
		this.Salary = sal;
	}
	
	@XmlAttribute
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	@XmlElement
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public float getSalary() {
		return Salary;
	}
	public void setSalary(float salary) {
		Salary = salary;
	}
	
	

}
