package com.collections.comparator;

/*
 * This class defines comparison logic based on the age.
 * Implement the Comparator interface and have to override the compare method.
 */

import java.util.Comparator;

public class AgeComparator implements Comparator {

	@Override
	public int compare(Object o1, Object o2) {
		Student st1 = (Student) o1;
		Student st2 = (Student) o2;
		if (st1.age == st2.age)
		   return 0;
		else if (st1.age > st1.age)
			return 1;
		else
			return -1;
	}
}
