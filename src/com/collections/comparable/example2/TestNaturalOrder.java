package com.collections.comparable.example2;
/*
 * Demo of implementing Comparable Interface to get Natural Ordering.
 * Test the Natural order of Set, by implementing the Comparable class.
 * List : To get a sorted list we have to explicitly call Collections.sort()
 * Set (Only TreeSet) : With only the implementation of Comparable interface the TreeSet becomes naturally sorted. 
 * This is not applicable for HashSet or LinkedHashSet
 */
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

class Person implements Comparable<Person>{
	@Override
	public String toString() {
		return "Person [name=" + name + ", id=" + id + "]";
	}

	private String name;
	private Integer id;
	
	public Person(int id, String s) {
		this.id = id;
		this.name = s;
	}

	@Override
	public int compareTo(Person o) {
		if (o.id == id){
			return 0;
		}else if (id > o.id){
			return 1;
		}else{
			return -1;	
		}		
//		return name.compareTo(o.name);
	}
}

public class TestNaturalOrder {

	public static void main(String[] args) {
		List<Person> list = new ArrayList<>();
		SortedSet<Person> set = new TreeSet<>();
		//Set<Person> set = new HashSet<>();
		
		addElements(list);
		addElements(set);   //Set will not allow the duplicate record.
		
		//Collections.sort(list);   //In case of List, we have to explicitly call this to sort.
		
		showElements(list);
		System.out.println("/n****** The Set is Naturally ordered now ***** ");
		showElements(set);		
	}

	private static void addElements(Collection<Person> cols){
		cols.add(new Person(101, "Kishore"));
		cols.add(new Person(102, "Jyotirmoy"));
		cols.add(new Person(103, "Priyakshi"));
		cols.add(new Person(104, "Utkarsha"));
		cols.add(new Person(105, "Utkarsha"));
	}
	
	private static void showElements(Collection<Person> cols){
		for(Person p:cols){
			System.out.println(p.toString());
		}
	}
}
