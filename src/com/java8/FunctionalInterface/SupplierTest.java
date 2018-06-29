package com.java8.FunctionalInterface;

import java.util.function.BooleanSupplier;
import java.util.function.IntSupplier;
import java.util.function.Supplier;

/*
 * 
 * Examples using the Supplier FI
 * https://dzone.com/articles/supplier-and-consumer-interface-in-java8
 */
class Person{
	String name;
	int age;
	String Address;
	
	public Person(String name, int age, String add) {
		this.name = name;
		this.age = age;
		this.Address = add;
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

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}
	@Override
	public String toString() {
		return getName() + " , " + getAge() + " , " + getAddress();
	}
}

public class SupplierTest {

	public static void main(String[] args) {
		Supplier<Person> supplier = () -> {
			return new Person("Kishore Sharma", 45, "Pimple Saudagar");
		};
		System.out.println(supplier.get().toString());
	}

}
