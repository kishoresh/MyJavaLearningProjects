package com.collections.comparator;

/*
 * This class provides comparison logic based on the name.
 * In such case, we are using the compareTo() method of String class, which internally provides the comparison logic.
 */
import java.util.Comparator;

public class NameComparator implements Comparator {
	@Override
	public int compare(Object o1, Object o2) {
		Student st1 = (Student) o1;
		Student st2 = (Student) o2;

		return st1.Name.compareTo(st2.Name);
	}

}
